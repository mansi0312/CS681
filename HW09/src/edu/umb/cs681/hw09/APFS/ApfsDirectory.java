package edu.umb.cs681.hw09.APFS;



import java.time.LocalDateTime;
import java.util.LinkedList;
public class ApfsDirectory extends ApfsElement{
    private LinkedList<ApfsElement> children = new LinkedList<ApfsElement>();
    private LinkedList<ApfsElement> allchildren = new LinkedList<ApfsElement>();
    private LinkedList<ApfsFile> files = new LinkedList<ApfsFile>();
    private APFS fileSystem;

    public ApfsDirectory(ApfsDirectory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);

    }

    public LinkedList<ApfsElement> getChildren() {

        return this.children;
    }
    public void appendChild(ApfsElement child) {

        this.children.add(child);
        child.setParent(this);

    }
    public int countChildren() {

        return this.children.size();
    }
    public LinkedList<ApfsDirectory> getSubDirectories() {
        LinkedList<ApfsDirectory> subdirectories = new LinkedList<ApfsDirectory>();
        for(ApfsElement e : children) {
            if (e.isDirectory()) {
                subdirectories.add((ApfsDirectory) e);
            }
        }
        return subdirectories;
    }
    public LinkedList<ApfsFile> getFiles() {
        for(ApfsElement e : children) {
            if(!e.isDirectory()) {
                files.add((ApfsFile) e);
            }
        }
        return this.files;
    }
    public int getTotalSize() {
        int totalsize = 0;

        for(ApfsElement e : children) {
            if (e.isDirectory())
                totalsize += ((ApfsDirectory) e).getTotalSize();

            else
                totalsize += e.getSize();

        }

        return totalsize;
    }

    public LinkedList<ApfsElement> getAllChildren() {


        for(ApfsElement e : children) {
            if (e.isDirectory()) {
                allchildren.add(e);
                for (ApfsElement f : ((ApfsDirectory) e).getAllChildren())
                    allchildren.add(f);
            }
            else
                allchildren.add(e);

        }
return allchildren;

    }

    public boolean isDirectory() {

        return true;
    }
    public boolean isFile() {

        return false;
    }
    public boolean isLink() {

        return false;
    }
}
