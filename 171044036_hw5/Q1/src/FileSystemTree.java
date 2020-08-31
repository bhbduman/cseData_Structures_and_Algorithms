

import java.nio.file.NotDirectoryException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class FileSystemTree {
    /**
     *root datafield
     */
    FileNode root;

    /**
     *getter for root
     * @return returns file node type root
     */
    public FileNode getRoot() {
        return root;
    }

    /**
     *Constructor for filesystem
     * @param rootName the name of root file
     */
    FileSystemTree(String rootName){
        root = new FileNode(rootName,true);
    }

    /**
     *search wrapper takes string as parameter
     * @param target takkes character sequence to search as string
     */
        public void search(String target){

        StringBuilder sb = new StringBuilder(" ");
        sb.append(root.name+"/");
        searcHelper(sb,root,target);
    }

    /**
     *Search helper method
     * @param sb takes string builder
     * @param node takes the node as file
     * @param target the character sequence which is looking for
     */
    public void searcHelper(StringBuilder sb, FileNode node,String target){/*I
        System.out.println(node.getAbsoluteFile());

        if(node.isDirectory()){
            String[] subNote = node.list();
            for(String filename : subNote){
                searcHelper(sb,new FileNode());
            }
        }*/
    }

    /**
     *prints the file system method wrapper
     * @return returns string
     */
    public String printFileSystem(){
        StringBuilder sb = new StringBuilder();
        print(root, sb,0);
        return sb.toString();

    }

    /**
     *Print file system helper method
     * it goes ever sub folder recursively prints it and looks if it has subfolder too it goes and prints recursively
     * @param node takes node which is root
     * @param sb sb to build filesysyrem hieararchy
     * @param depth depth for the create depth when print the file system for every sub folder  i increase it 3 times which means it adds  three '-' character beginning of the row
     */
    private void print(FileNode node, StringBuilder sb, int depth){
        for (int i=0; i<depth; i++){
            sb.append("-");
        }
        sb.append(">"+node.name+"\n");
        if(node.isDirectory){
            Iterator<FileNode> iter = node.hasSubDir.listIterator();
            while(iter.hasNext()){
                print(iter.next(),sb,3+depth);
            }
        }

    }

    /**
     *Adds element and if there is already a name with the directory it doesnt add
     * @param path path of the adding directory
     * @return returns true if it adds successfully
     *  NotDirectoryException if the folder is not directory or doesnt exist
     */
    public boolean addDir(String path){
        try {
            FileNode nodeRef = findNode(path);
            String[] piece = path.split("/");
            if (nodeRef.hasSubDir != null && nodeRef.hasSubDir.contains(new FileNode(piece[piece.length-1],false))){
                System.out.println(piece[piece.length-1]+ " :There might be a file or directory with this name");
                return false;
            }
            if (nodeRef.hasSubDir == null) {
                if(nodeRef.isDirectory == false){
                    throw new NotDirectoryException(piece[piece.length-2]);
                }
                    nodeRef.hasSubDir.add(new FileNode(piece[piece.length - 1], true));
                return true;

            }else{
                if(nodeRef.isDirectory == false){
                    throw new NotDirectoryException(piece[piece.length-2]);
                }
                nodeRef.hasSubDir.add(new FileNode(piece[piece.length - 1], true));
                return true;
            }
        }catch (NotDirectoryException folderName){
            System.out.print("There is no such directory or ");
            System.out.println( folderName +" is not a directory");
        }
        return false;

    }

    /**
     *Adds element and if there is already a name with the directory it doesnt add
     * @param path path of the adding file
     * @return true iff athe add operation is successfully
     * @throws NullPointerException If it can not find the file but i catch it and print it as it is not a directory
     */
    public boolean addFile(String path){
        try {
            FileNode nodeRef = findNode(path);
            String[] piece = path.split("/");
            if (nodeRef.hasSubDir.contains(new FileNode(piece[piece.length-1],false))){
                System.out.println(piece[piece.length-1]+ " :There might be a file or directory with this name");
                return false;
            }
            if (nodeRef.hasSubDir == null) {
                if(nodeRef.isDirectory == false){
                    throw new NullPointerException(piece[piece.length-1]);
                }
                nodeRef.hasSubDir.add(new FileNode(piece[piece.length - 1], false));
                return true;

            }else{
                if(nodeRef.isDirectory == false){
                    throw new NullPointerException(piece[piece.length-1]);
                }
                nodeRef.hasSubDir.add(new FileNode(piece[piece.length - 1], false));
                return true;
            }
        }catch (NullPointerException folderName){
            System.out.println( path +": Not a directory");
        }
        return false;


    }

    /**
     *Toreturn a specific nodes list
     * @param path the given path of node
     * @return returns list of the file or folder if there exist the file or folder
     */
    public LinkedList findList(String path){
        FileNode nodeRef= root;
        LinkedList list=null;
        String[] piece = path.split("/");

        int index= -1;
        if(piece.length == 2 && piece[0].equalsIgnoreCase(root.name)){
            list =root.hasSubDir;
            return list;
        }
        else if(nodeRef != null && piece[0].equalsIgnoreCase(root.name) ){
            for (int i=1; i<piece.length; i++){
                if(nodeRef.hasSubDir != null){
                    for (int j = 0; j<nodeRef.hasSubDir.size(); j++){
                        if (nodeRef.hasSubDir.get(j).name.equalsIgnoreCase(piece[i])) {
                            index= j;
                        }
                    }
                    if (index <= -1){
                        System.out.println("There is no such element");
                    }else{
                            list= nodeRef.hasSubDir;
                    }
                }
            }
            return list;
        }
        else{
            System.out.println("There is a problem with findList method");
        }

        return root.hasSubDir;

    }

    /**
     *finds the node of given path
     * @param path path of node
     * @return returns the node of the given node
     */
    public FileNode findNode(String path){
        FileNode nodeRef= root;
        String[] piece = path.split("/");
        int index= -1;
        if(nodeRef != null && piece[0].equalsIgnoreCase(root.name) ){
            for (int i=1; i<piece.length-1; i++){
                if(nodeRef.hasSubDir != null){
                    for (int j = 0; j<nodeRef.hasSubDir.size(); j++){
                        if (nodeRef.hasSubDir.get(j).name.equalsIgnoreCase(piece[i]))
                        index= j;
                    }
                    if (index <= -1 || index>= nodeRef.hasSubDir.size()){
                        System.out.println("There is no such element");
                    }else{
                        nodeRef= nodeRef.hasSubDir.get(index);
                    }
                }
            }
            return nodeRef;
        }
        else{
            System.out.println("There is a problem with findNode method");
        }
        return root;
    }

    /**
     *removes the given path my method ass each time does user wants to remove file or folder if it foldar and also have sub files it prints it and ask them to
     * @param path takes the path of node
     * @return returns true if remove operation has completed successfully
     */
    public boolean remove(String path){
        String[] pieces = path.split("/");
        if (pieces.length==1 && path.equalsIgnoreCase(root.name)) {
            System.out.println("Also all files below root will be deleted");
            System.out.println("To continue press 'y'");
            Scanner sc = new Scanner(System.in);
            String get = sc.next();
            if (get.equalsIgnoreCase("y")) {
                root.hasSubDir.clear();
                return true;
            }
            return false;
        }

        FileNode nodeRef = findNode(path);
        LinkedList list =nodeRef.hasSubDir;
        if(list == null){
            System.out.println("There is no element in FileSystem");
            return false;
        }
       int index= list.indexOf(new FileNode(pieces[pieces.length-1],false));
        if (index<= -1){
            System.out.println(path+": There is no such element");
            return false;
        }
        if(list != null){
            System.out.println("Also the below files will be deleted");
           StringBuilder sb= new StringBuilder();
            print((FileNode) list.get(index),sb ,0);
            System.out.println(sb.toString());
            System.out.println("To continue press 'y'");
            Scanner sc = new Scanner(System.in);
            String get =sc.next();
            if (get.equalsIgnoreCase("y")){
                list.remove(index);
                return true;
            }
            return false;
        }else{
            list.remove(index);
        }

        return true;
    }

    /**
     *File node class to keep file features
     */
    public  class FileNode{
        /**
         *Name of file or folder
         */
        String name;
        /**
         *it keeps a sub folder if it is a directory which type is linkedlist
         */
        private LinkedList<FileNode> hasSubDir;

        /**
         *getter for name
         * @return returns the name of folder or file as string
         */
        public String getName() {
            return name;
        }

        /**
         *if it is a directory boolean field equals true
         */
        boolean isDirectory;

        /**
         *TO create a file or folder
         * @param name name of file
         * @param isDirectory to determine the given is directory or file
         */
        FileNode(String name, Boolean isDirectory ){
            this.name= name;
            this.isDirectory=isDirectory;
            if(isDirectory == false){
                hasSubDir =null;
            }else
                hasSubDir = new LinkedList<FileNode>();
        }

        /**
         *getter for sub folder directory
         * @return returns list the directory of the node
         */
        public LinkedList getSub(){
            return this.hasSubDir;
        }

        /**
         *To checks the name of the files and folders
         * and also to work indexof method we need to override this method
         * @param o takes object
         * @return returns true if the given ofile node names are equal
         */
        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null)
                return false;
            if (getClass() != o.getClass())
                return false;
            FileNode other = (FileNode) o;
            if (!this.name.equalsIgnoreCase(other.name))
                return false;
            return true;
        }

        /**
         *to string method for file node it returns the name of the file
         * @return returns file name as string
         */
        public String toString(){
            StringBuilder sb= new StringBuilder();
            sb.append(this.name);
            return sb.toString();
        }
    }
}
