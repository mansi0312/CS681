package edu.umb.cs681.hw09.FSFoundation;

import java.util.LinkedList;

public abstract class FileSystem {

    protected String name;
    protected int capacity;
    int id;
    private LinkedList<FSElement> rootDirs = new LinkedList<FSElement>();

    public FSElement initFileSystem(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        FSElement root = createDefaultRoot();
        if (root.isDirectory() && capacity >= root.getSize()) {
            setRoot(root);
            this.id = root.hashCode();
            return root;
        } else
        {
            return null;
        }
    }
    protected abstract FSElement createDefaultRoot();
    protected void setRoot(FSElement root) {
        this.rootDirs.add(root);
    }
    protected int getCapacity() {
        return this.capacity;
    }


    public LinkedList<FSElement> getRootDirs() {

        return this.rootDirs;
    }

}
