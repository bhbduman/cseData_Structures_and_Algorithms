import java.io.Serializable;
import java.util.Scanner;

/**Class for a binary tree that stores type E objects*/
public class BinaryTree implements Serializable{
    /**Class to encapsulate a tree node*/
    protected static class Node implements Serializable{
        //Data Fields
        /**The information Stored in this node*/
        protected String data;
        /**Reference to the left child*/
        protected Node left;
        /**Reference to the right child*/
        protected Node right;

        //Constructors
        /**
         * Construct a node with given data and no children
         * @param data The data to store in this node
         */
        public Node(String data){
            this.data = data;
            left = null;
            right = null;
        }


        //Methods
        /**
         * Return a string representation of the node
         * @return A string representation of the data fields
         */
        public String toString(){
            return data;
        }


    }

    //Data Field
    /**The root of the binary tree*/
    protected Node root;

    //Constructors

    /** The no-parameter constructor sets the data field null*/
    public BinaryTree(){
        root = null;
    }

    /**
     * The constructor that takes a node as a parameter is a protected constructor. THis is because client classes do not know about
     * the Node class. This constructor can be used only by methods internal to the BinaryTree class and its subclasses
     * @param root The node to define first node
     */
    protected BinaryTree(Node root){
        this.root =  root;
    }

    /**
     * Constructor a new binary tree with data in its root leftTree as its left subtree and rightTree as its right subtree
     * @param data THe data will be added root of the tree
     * @param leftTree root of left subtree
     * @param rightTree root of right subtree
     */
    public BinaryTree(String data, BinaryTree leftTree, BinaryTree rightTree){
        root = new Node(data);
        if (leftTree != null){
            root.left = leftTree.root;
        }else{
            root.left = null;
        }
        if (rightTree != null){
            root.right = rightTree.root;
        }else{
            root.right = null;
        }
    }

    /**
     * Return the left subtree
     * @return The left subtree or null if either the root or the left subtree is null
     */
    public BinaryTree getLeftSubtree(){
        if(root != null && root.left != null){
            return new BinaryTree(root.left);
        }else {
            return null;
        }
    }

    /**
     * Return the right subtree
     * @return The right subtree or null if either the root or the right subtree is null
     */
    public BinaryTree getrightSubtree(){
        if(root != null && root.right != null){
            return new BinaryTree(root.right);
        }else {
            return null;
        }
    }

    /**
     * Determine whether this tree is a leaf
     * @return true if the root has no children
     */
    public boolean  isLeaf(){
        return (root.left == null && root.right ==null);
    }

    /**
     * Creates a string builder and then calls the recursive preOrderTraverse method passing
     * the root and (depth of root node) as arguments
     * @return Returns stringbuilder variable as string.
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        preOrderTraverse(root, sb);
        return sb.toString();
    }

    /**
     * Perform preOrderTraversal
     * @param node The local root
     * @param sb The string buffer to save the output
     */
    private void preOrderTraverse (Node node, StringBuilder sb){
        if (node == null){
        }else{
            sb.append(node.toString());
            sb.append(" ");
            preOrderTraverse(node.left, sb);
            preOrderTraverse(node.right, sb);
        }
    }
    /**
     * Creates a string builder and then calls the recursive postOrderTraverse method passing
     * the root and (depth of root node) as arguments
     * @return Returns stringbuilder variable as string.
     */
    public String toString2(){
        StringBuilder sb = new StringBuilder();
        postOrderTraverse(root, sb);
        return sb.toString();
    }
    /**
     * Perform postOrderTraversal
     * @param node The local root
     * @param sb The string buffer to save the output
     */
    private void postOrderTraverse (Node node, StringBuilder sb){
        if (node == null){
        }else{
            postOrderTraverse(node.left, sb);
            postOrderTraverse(node.right, sb);
            sb.append(node.toString());
            sb.append(" ");
        }
    }
    /**
     * Creates a string builder and then calls the recursive inOrderTraverse method passing
     * the root and (depth of root node) as arguments
     * @return Returns string builder variable as string.
     */
    public String toString3(){
        StringBuilder sb = new StringBuilder();
        orderTraverse(root, sb);
        return sb.toString();
    }
    /**
     * Perform inOrderTraversal
     * @param node The local root
     * @param sb The string buffer to save the output
     */
    private void orderTraverse (Node node, StringBuilder sb){
        if (node == null){
        }else{

            preOrderTraverse(node.left, sb);
            sb.append(node.toString());
            sb.append(" ");
            preOrderTraverse(node.right, sb);
        }
    }

    /**
     * Method to read a binary tree
     * @param scan the scanner
     * @return the binary tree
     */
    public  BinaryTree readBinaryTree(Scanner scan){
        //Read line and trim leading and trailing spaces
        String data = scan.next();
        if (data.equals("null")){
            return null;
        }else{

            BinaryTree rightTree = readBinaryTree(scan);
            BinaryTree leftTree = readBinaryTree(scan);
            return new BinaryTree(data,leftTree,rightTree);
        }
    }




}
