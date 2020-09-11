import java.io.Serializable;

    /**
     * Class for a binary tree that stores type E objects.
     * @author Koffman and Wolfgang
     **/
    public class BinaryTree<E> implements Serializable {

        /*<listing chapter="6" number="1">*/
        /** Class to encapsulate a tree node. */
        protected static class Node<E> implements Serializable {
            // Data Fields

            /** The information stored in this node. */
            public E data;
            /** Reference to the left child. */
            public Node<E> left;
            /** Reference to the right child. */
            public Node<E> right;

            // Constructors
            /**
             * Construct a node with given data and no children.
             * @param data The data to store in this node
             */
            public Node(E data) {
                this.data = data;
                left = null;
                right = null;
            }

            // Methods
            /**
             * Returns a string representation of the node.
             * @return A string representation of the data fields
             */
            @Override
            public String toString() {
                return data.toString();
            }
        }
        /*</listing>*/
        // Data Field
        /** The root of the binary tree */
        protected Node<E> root;

        /** Construct an empty BinaryTree */
        public BinaryTree() {
            root = null;
        }

        /**
         * Construct a BinaryTree with a specified root.
         * Should only be used by subclasses.
         * @param root The node that is the root of the tree.
         */
        protected BinaryTree(Node<E> root) {
            this.root = root;
        }


        /**
         * Return the left subtree.
         * @return The left subtree or null if either the root or
         * the left subtree is null
         */
        public BinaryTree<E> getLeftSubtree() {
            if (root != null && root.left != null) {
                return new BinaryTree<E>(root.left);
            } else {
                return null;
            }
        }

        /**
         * Return the right sub-tree
         * @return the right sub-tree or
         *         null if either the root or the
         *         right subtree is null.
         */
        public BinaryTree<E> getRightSubtree() {
            if (root != null && root.right != null) {
                return new BinaryTree<E>(root.right);
            } else {
                return null;
            }
        }

        /**
         * Return the data field of the root
         * @return the data field of the root
         *         or null if the root is null
         */
        public E getData() {
            if (root != null) {
                return root.data;
            } else {
                return null;
            }
        }

        /**
         * Determine whether this tree is a leaf.
         * @return true if the root has no children
         */
        public boolean isLeaf() {
            return (root == null || (root.left == null && root.right == null));
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            preOrderTraverse(root, 1, sb);
            return sb.toString();
        }

        /**
         * * Constructs a new binary tree with data in its root,leftTree
         * as its left subtree and rightTree as its right subtree
         * @param data given node
         * @param leftTree left subtree
         * @param rightTree right subtree
         */
    public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
        root = new Node<E>(data);
        if (leftTree != null) {
            root.left = leftTree.root;
        } else {
            root.left = null;
        }
        if (rightTree != null) {
            root.right = rightTree.root;
        } else {
            root.right = null;
        }
    }


        /**
         * Perform a preorder traversal.
         * @param node The local root
         * @param depth The depth
         * @param sb The string buffer to save the output
         */

        private void preOrderTraverse(
            Node<E> node,
            int depth,
            StringBuilder sb) {
        if (node == null) {
            sb.append("\n");
        } else {
            sb.append(node.toString());
            preOrderTraverse(node.left, depth + 1, sb);
            preOrderTraverse(node.right, depth + 1, sb);
        }
    }
}

