import java.util.Scanner;

/**
 * interface of the binary search tree
 * @param <E> TO implement with different datas
 */
public interface BinaryTree<E> {
    boolean add(AgeData node);
    SearchTree readBinaryTree(Scanner scan, String[] exps);
    SearchTree getLeftSubtree();
    SearchTree getrightSubtree();
    boolean  isLeaf();

}
