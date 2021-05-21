package edu.umb.cs681.hw09.APFS;

import edu.umb.cs681.hw09.FSFoundation.FSElement;
import java.time.LocalDateTime;
import java.util.LinkedList;

public abstract class ApfsElement extends FSElement {
    protected ApfsDirectory parent;
    private LinkedList<ApfsElement> ApfsChildren = new LinkedList<ApfsElement>();
    public ApfsElement(ApfsDirectory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);
     this.parent = parent;
    }
    public ApfsDirectory getParent() {
        lock.lock();
        try {
            return this.parent;
        }
        finally {
                lock.unlock();
            }
    }
    public void setParent(ApfsDirectory parent) {
        lock.lock();
        try {
        this.parent = parent; }
        finally {
            lock.unlock();
        }
    }
    public LinkedList<ApfsElement> getChildren() {
        return this.ApfsChildren;
    }

    public void appendChild(FSElement child) {
        this.ApfsChildren.add((ApfsElement) child);
    }
    public String getName() {
            lock.lock();
            try {
        return this.name; }
            finally {
                lock.unlock();
            }
    }
    public int getSize() {
                lock.lock();
                try {
        return this.size; }
                finally {
                    lock.unlock();
                }
    }
    public LocalDateTime getCreationTime() {
                    lock.lock();
                    try {
        return this.creationTime; }
                    finally {
                        lock.unlock();
                    }
    }
    public abstract boolean isDirectory();
    public abstract boolean isFile();
    public abstract boolean isLink();


}
