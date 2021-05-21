package edu.umb.cs681.hw09.FSFoundation;

import edu.umb.cs681.hw09.APFS.ApfsElement;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;

public abstract class FSElement {
    protected FSElement parent;
    protected String name;
    protected int size;
    protected LocalDateTime creationTime;
    protected FSElement rootDir = null;
    protected ReentrantLock lock = new ReentrantLock();

    public FSElement(FSElement parent, String name, int size, LocalDateTime creationTime) {
        this.parent = parent;
        this.name = name;
        this.size = size;
        this.creationTime = creationTime;

    }
    public FSElement getRoot() {
        return this.rootDir;
    }

    protected void setRoot(FSElement root) {
        rootDir = root;
    }
    public FSElement getParent() {
            lock.lock();
            try {
                return this.parent;
            } finally {
                lock.unlock();
            }
    }
    public void setParent(FSElement parent) {
        lock.lock();
        try {
        this.parent = parent;
        } finally {
            lock.unlock();
        }
    }
    public String getName() {
        lock.lock();
        try {
        return this.name;
        } finally {
            lock.unlock();
        }
    }
    public int getSize() {

        lock.lock();
        try {
            return this.size;
        } finally {
            lock.unlock();
        }
    }
    public LocalDateTime getCreationTime() {

        return this.creationTime;


    }
    public abstract boolean isDirectory();
    public abstract boolean isFile();
    public abstract boolean isLink();


    public abstract LinkedList<ApfsElement> getChildren();
}
