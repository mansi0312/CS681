package edu.umb.cs681.hw09.APFS;


import java.time.LocalDateTime;

public class ApfsLink extends ApfsElement{
    private ApfsElement target = null;
    public ApfsLink(ApfsDirectory parent, String name, int size,
                LocalDateTime createTime, ApfsElement target) {
        super(parent, name, size, createTime);
        this.target = target;
    }
    public ApfsElement getTarget() {
        lock.lock();
        try {
            return this.target;
        } finally {
            lock.unlock();
        }
    }

    public void setTarget(ApfsElement target) {
        lock.lock();
        try {
            this.target = target;
        } finally {
            lock.unlock();
        }

    }
    public boolean isDirectory() {

        return false;
    }
    public boolean isFile() {

        return false;
    }
    public boolean isLink() {

        return true;
    }

}
