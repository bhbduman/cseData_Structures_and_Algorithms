import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        FileSystemTree mySystem = new FileSystemTree("root");

        mySystem.addDir("root/Folder1");
        mySystem.addDir("root/Folder2");
        mySystem.addDir("root/Folder3");
        mySystem.addDir("root/Folder2/Folder3");
        mySystem.addFile("root/File1");
        mySystem.addFile("root/Folder1/File2");
        System.out.println(mySystem.printFileSystem());


        mySystem.addFile("root/Folder1");
        mySystem.addDir("root/File1");
        System.out.println();
        mySystem.addDir("root/Folder1");
        mySystem.addFile("root/File1");

        System.out.println(mySystem.printFileSystem());

        mySystem.addFile("root/File1/filenew");

        mySystem.addFile("root/Folder2/Folder3/File3");
        mySystem.addDir("root/Folder2/Folder3/Folder5");
        mySystem.addFile("root/Folder2/Folder3/File4");
        mySystem.addFile("root/Folder2/Folder3/Folder5/File5");
        mySystem.addDir("root/Folder2/Folder3/Folder5/Folder6");
        mySystem.addFile("root/Folder2/Folder3/Folder5/File6");
        mySystem.addFile("root/Folder2/Folder3/Folder5/File7");
        mySystem.addFile("root/Folder2/Folder3/Folder5/File9");
        mySystem.addDir("root/Folder2/Folder3/Folder5/Folder6/Folder7");
        mySystem.addDir("root/Folder2/Folder3/Folder5/Folder6/Folder7/File8");
        System.out.println(mySystem.printFileSystem());

        mySystem.remove("root/Folder1");
        mySystem.remove("root/File1");
        System.out.println(mySystem.printFileSystem());

        mySystem.remove("root/Folder2/Folder3/Folder5/File6");
        mySystem.remove("root/Folder2/Folder3/Folder5/Folder6/Folder7");
        System.out.println(mySystem.printFileSystem());

        mySystem.remove("root/sadasd/asdasd");


        mySystem.remove("root");
        System.out.println(mySystem.printFileSystem());

    }
}
