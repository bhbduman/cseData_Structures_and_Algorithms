import java.io.Serializable;
import java.util.Scanner;
/**Class for a binary tree that stores type E objects*/
public class SearchTree<E> implements BinaryTree{
    /**Class to encapsulate a tree node*/

    //Data Field
    /**The root of the binary tree*/
    protected AgeData root;

    //Constructors

    /** The no-parameter constructor sets the data field null*/
    public SearchTree(){
        root = null;
    }

    /**
     * The constructor that takes a node as a parameter is a protected constructor. THis is because client classes do not nknow about
     * the Node class. This constructor can be used only by methods internal to the BinaryTree class and its subclasses
     * @param root The node to define first node
     */
    protected SearchTree(AgeData root){
        this.root =  root;
    }

    /**
     * Constructor a new binary tree with data in its root leftTree as its left subtree and rightTree as its right subtree
     * @param data THe data will be added root of the tree
     * @param leftTree root of left subtree
     * @param rightTree root of right subtree
     */
    public SearchTree(int data, SearchTree leftTree, SearchTree rightTree){
        root = new AgeData(data);
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
    public SearchTree getLeftSubtree(){
        if(root != null && root.left != null){
            return new SearchTree(root.left);
        }else {
            return null;
        }
    }

    /**
     * Return the right subtree
     * @return The right subtree or null if either the root or the right subtree is null
     */
    public SearchTree getrightSubtree(){
        if(root != null && root.right != null){
            return new SearchTree(root.right);
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
     * Creates a string builder and then calls the recursive preOrderTravese method passing
     * the root and (depth of root node) as arguments
     * @return Returns stringbuilder variable as string.
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        preOrderTraverse(root, 1, sb);
        return sb.toString();
    }

    /**
     * Perform preOrderTraversal
     * @param node The local root
     * @param depth The depth
     * @param sb The string buffer to save the output
     */
    private void preOrderTraverse (AgeData node, int depth, StringBuilder sb){
        for(int i= 1; i<depth; i++){
            sb.append(" ");
        }
        if (node == null){
            sb.append("null\n");
        }else{
            sb.append(node.toString());
            sb.append("\n");
            preOrderTraverse(node.left, depth++, sb);
            preOrderTraverse(node.right, depth++, sb);
        }
    }


    /**
     * Method to read a binary tree
     * @param scan the scanner
     * @return the binary tree
     */
    public SearchTree readBinaryTree(Scanner scan, String[] exps){
        //Read line and trim leading and trailing spaces
        String datum = scan.next();
        int data = Integer.parseInt(datum);
        if (datum.equals("null")){
            return null;
        }else{
            SearchTree leftTree = readBinaryTree(scan,exps);
            SearchTree rightTree = readBinaryTree(scan,exps);
            return new SearchTree(data,leftTree,rightTree);
        }
    }

    /**
     * add method from bst since we dont use it i did not implement it
     * @param node takes node which is age data
     * @return returns false
     */
    public boolean add(AgeData node){
        return false;
    }



}
