package edu.umb.cs681.hw09.APFS;


import edu.umb.cs681.hw09.FSFoundation.FSElement;
import edu.umb.cs681.hw09.FSFoundation.FileSystem;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class APFS extends FileSystem implements Runnable {
    private static APFS instance = null;
    private static ApfsDirectory root;
    private LocalDateTime dateTime = LocalDateTime.now();
    private LinkedList<ApfsDirectory> rootDirs = new LinkedList<ApfsDirectory>();

    private APFS() {

    }

    public static APFS getInstance() {
        if (instance == null) {
            instance = new APFS();
        }
        return instance;
    }
    public FSElement getRoot(){
        return this.root;
    }

    protected FSElement createDefaultRoot() {

       this.root = new ApfsDirectory(null, "root", 0, dateTime);
        return root;
    }

    public void addRootDir(ApfsDirectory rootDir) {

        this.rootDirs.add(rootDir);
    }

    public void run() {

//        LinkedList<ApfsElement> rootChildren = getRoot().getChildren();
//        for (ApfsElement child : rootChildren) {
//            System.out.println("\n-->"+child.getName());
//            LinkedList<ApfsElement> child1Children = child.getChildren();
//            for (ApfsElement child1 : child1Children) {
//                System.out.println("------>"+child1.getName());
//                LinkedList<ApfsElement> child2Children = child1.getChildren();
//                for (ApfsElement child2 : child2Children) {
//                    System.out.println("------>"+child2.getName());
//                }
//            }
//        }
        LinkedList<ApfsElement> tree = root.getAllChildren();


        for(ApfsElement f : tree) {
            System.out.print("Name: " + f.getName());
            if(f.isDirectory())

                System.out.println(" is a Directory. ");
            if(f.isFile())

                System.out.println(" is a File. ");

            if(f.isLink()) {

                System.out.print(" is a Link. ");
                System.out.println(" Target to  " + ((ApfsLink)f).getTarget().getName());
            }
        }
    }
    public static void main(String args[]) {
        LocalDateTime dateTime1 = LocalDateTime.now();
        APFS apfs = APFS.getInstance();
        apfs.initFileSystem("FFileSys", 2000);
        ApfsDirectory root = (ApfsDirectory) apfs.createDefaultRoot();
        ApfsDirectory home = new ApfsDirectory(null, "home", 0,dateTime1);
        root.appendChild(home);

        Thread thread1 = new Thread(apfs);
        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        ApfsFile a = new ApfsFile(null, "a", 10,dateTime1);
        home.appendChild(a);
        ApfsLink x = new ApfsLink(null,"x",0, dateTime1, a);
        home.appendChild(x);





        Thread thread2 = new Thread(apfs);
        thread2.start();
        try {
            thread2.join();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }


    }
}
