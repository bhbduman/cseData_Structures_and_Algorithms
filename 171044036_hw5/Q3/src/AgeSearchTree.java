

public class AgeSearchTree<E> extends SearchTree<E> {
    /**
     *to set the add is false or true
     */
    protected boolean addReturn=false;
    /**
     *to return deleted node
     */
    private AgeData deleteReturn ;

    /**
     *Constructor of AgeSearch tree
     */
    public AgeSearchTree(){
        root= null;
    }

    /**
     *wrapper method to find a target
     * @param target the age data type the target node
     * @return retuns the node of it
     */
    public AgeData find(AgeData target){
            return find(root,target);
    }

    /**
     *Tofind a target age it uses compare to method
     * it works recursively by check left or right if it can not find returns null
     * @param curNode node changes for each call starts from root
     * @param target the target age
     * @return returns the node if it finds else returns null
     */
    private AgeData find(AgeData curNode, AgeData target){
        if (curNode == null){
            return null;
        }
        int comparingResult= curNode.compareTo(target);
        if(comparingResult == 0){
            return curNode;
        }
        else if (comparingResult == -1){
            return find(curNode.right,target);
        }else{
            return find(curNode.left,target);
        }
    }

    /**
     *First checks if is there any same age
     * else just call add methode returns if the adding operation successful or not
     * @param node takes node which is age data
     * @return if its successfull it returns true else returns true
     */
    public boolean add(AgeData node){
        if(find(node) != null){
            find(node).numberOfPeople++;
            addReturn=true;
        }else {
            root = add(root, node);
        }
        return addReturn;
    }

    /**
     *add helper methode it takes root and goes untill necessary node and adds thenode accordig to it size
     * than checks if it in a proper order
     * @param currNode takes root to start to find proper position
     * @param node the given node which will be add
     * @return returns the root node
     */
    private AgeData add(AgeData currNode,AgeData node){
        if(currNode == null){
            return new AgeData(node.age);
        }else if(currNode.compareTo(node) > 0){
            currNode.left = add(currNode.left,node);
            addReturn = true;
            return currNode;
        }else{
            currNode.right = add(currNode.right, node);
            addReturn = true;
            return currNode;
        }
    }

    /**
     *to string method uses in order traverse
     * @return returns string  of the age datas
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        inOrderTraverse(root, sb);
        return sb.toString();
    }

    /**
     *Visit left root and right
     * @param node starts from root
     * @param sb takes string builder to construct datas
     */
    private void inOrderTraverse (AgeData node, StringBuilder sb){
        if (node == null){
            return;
        }else{

            inOrderTraverse(node.left, sb);
            sb.append(node.toString());
            sb.append("\n");
            inOrderTraverse(node.right, sb);
        }
    }

    /**
     *removes element from heap first checks is the age is in there and if itsnot throws Nullpointer exception
     * @param node which will be delete
     * @return returns the removed node
     */
    public AgeData remove(AgeData node) {
       try{
           if (find(node) == null){
               throw new NullPointerException();
           }

            if(root == null){
                return null;
            }else if(find(node).numberOfPeople > 1){
                find(node).numberOfPeople--;
                return find(node);
            }else {
                root = remove(root, node);
            }
       }catch (NullPointerException x){
           System.out.println("there is no such element");
       }
        return deleteReturn;

    }

    /**
     * then the checks number of people with that age so it can be decrease it if the heap has only one it takes the leaf and put it in paren
     * and then it checks is there any necessary swap operation because heap must be
     * @param curNode stats from root
     * @param node the node wanted to be deleted
     * @return returns the root with new heap
     */
    private AgeData remove(AgeData curNode, AgeData node){
        if (curNode == null){
            deleteReturn = null;
        }
        int compareTo = curNode.compareTo(node);
        if (compareTo >0 ){
            curNode.left = remove(curNode.left,node);
            return curNode;
        }else if (compareTo <0 ){
            curNode.right = remove(curNode.right,node);
            return curNode;
        }else{
            if (curNode.left == null){
                return curNode.right;
            }else if (curNode.right == null){
                return curNode.left;
            }else{
                if (curNode.left.right == null){
                    curNode.age = curNode.left.age;
                    curNode.numberOfPeople = curNode.left.numberOfPeople;

                    curNode.left = curNode.left.left;
                    return curNode;
                }else{
                    AgeData tmpNode = findLargestChild(curNode.left);
                    curNode.numberOfPeople = tmpNode.numberOfPeople;
                    curNode.age = tmpNode.age;
                    return curNode;
                }
            }
        }
    }

    /**
     *finds the largest child to use largest child to put heap in order again after remove operation
     * @param parent  the node of given parent
     * @return returns largest child from bottom of heap
     */
    private AgeData findLargestChild(AgeData parent){
        if (parent.right.right == null){
            AgeData tmpNode = parent.right;
            parent.right = parent.right.left;
            return tmpNode;
        }else{
            return findLargestChild(parent.right);
        }
    }

    /**
     *my younger tahnmethod wrapper
     * @param age takes age to compare
     * @return returns the number of elements
     */
    public int youngerThan(int age){
        int counter=0;
        counter = youngerThanHelper(root,age);
        return counter;
    }

    /**
     *my older than method wrapper
     * @param age takes age to compare
     * @return returns the number of elements
     */

    public int olderThan(int age){
        int counter=0;
        AgeData thebigger =olderThanHelperFindsmallestN(root, age);
        if (thebigger == null){
            return 0;
        }
        counter = olderThanHelper(thebigger,age);
        return counter;
    }

    /**
     *
     * @param start it starts from small element which is bigger than given age so
     * @param age age to compare
     * @return returns total number of people
     */
    private int olderThanHelper(AgeData start, int age){
        if (start == null || start.age < age ){
            return 0;
        }else {
            if ((!(start.age > age) ||( start.left !=null && start.left.age <= age ))&& start.right != null )
                start= start.right;
            return start.numberOfPeople +olderThanHelper(start.left,age)+ olderThanHelper(start.right,age);
        }
    }

    /**
     *to find smallest element after the given age
     * @param node starts fro root to look it up
     * @param age age to compare
     * @return returns the node whic is defined by definition of method
     */
    private AgeData olderThanHelperFindsmallestN(AgeData node, int age){
        if(node == null){
            return null;
        }if (node.age == age){
            if (node.right != null){
                return node.right;
            }else{
                return null;
            }
        }
        else if (node.age > age){
            return node;
        }else if (node.age < age){
            return olderThanHelperFindsmallestN(node.right,age);
        }
        return null;
    }

    /**
     *It goes recursively until encounter bigger element in node
     * @param node starts fro root
     * @param age age to compare
     * @return returns the number of people if it null or bigger than the given age it returns 0
     */
    private int youngerThanHelper(AgeData node, int age){
        if(node == null){
            return 0;
        }else if (node.age >= age){
            return 0;
        }
            return node.numberOfPeople +youngerThanHelper(node.right,age)+youngerThanHelper(node.left,age);
    }
}
