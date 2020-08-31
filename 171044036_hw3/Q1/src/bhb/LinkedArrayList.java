package bhb;
import java.util.*;
import  java.lang.NullPointerException;
import  java.lang.IndexOutOfBoundsException;
import  java.lang.UnsupportedOperationException;
/**
 * My Linked List array class it keeps the data in arrays ...
 *  These arrays linked each other.
 *  Generally I used the iterator methods which implemented by me.
 *  To use advantages of iterator such as time efficient.
 * @author  Baran Hasan BOZDUMAN
 * @version 1.0
 * @since   2020-04-02
 */
public class LinkedArrayList<E> extends AbstractList<E> implements List<E>, Collection<E> {
    private MyNode<E> head= null;
    private MyNode<E> tail= null;
    int sizeList=0;
    private int sizeTotalElem=0;

    @Override
    public void clear() {
        this.tail=null;
        this.head=null;
        sizeTotalElem=0;
        sizeList=0;
    }

    /**
     * My class constructor
     * which calls parent class constructor
     * @see AbstractList
     */
    public LinkedArrayList(){
        super();
    }

    /**
     * It adds the given item end of the list .
     * @param item type is generic. it is added end of the list.
     * @return returns boolean value which is true confirms the process is successfull.
     */
    @Override
    public boolean add(E item) {
        MyNode<E> nodeRef;
        int innerIndex;
        if(head != null) {
             nodeRef = tail;
             innerIndex=-1;
        }else {
            nodeRef=head;
            innerIndex=0;
        }
        int index=sizeTotalElem;
        ListIterator myIter= new MyListIterator(nodeRef,index,innerIndex);
        myIter.add(item);
        return true;
    }

    /**
     *Gets the variable of given index.
     * @param i It gets an index as integer.
     * @return Returns the value of the given index.
     * @throws IndexOutOfBoundsException if the given index is not valid.
     */
    @Override
    public E get(int i) {
        if (i < 0 || i >=sizeTotalElem) throw new IndexOutOfBoundsException();
        ListIterator myIter= this.listIterator(i);
        return (E) myIter.next();
    }

    /**
     * Changes the variable of given index.
     * @param i Takes index as an integer.
     * @param e Takes the value to put in index.
     * @return Returns the deleted value.
     * @throws IndexOutOfBoundsException if the given index is not valid.
     * @throws NullPointerException if the given value is null.
     */
    @Override
    public E set(int i, E e) {
        if (i < 0 || i >=sizeTotalElem) throw new IndexOutOfBoundsException();
        if (e==null) throw  new NullPointerException();
        E willChange = this.get(i);
        ListIterator myIter= this.listIterator(i);
        myIter.set(e);
        return willChange;
    }

    /**
     * Takes an index and insert the given value in a specific index.
     * @param i Index parameter as integer.
     * @param e Takes the value to add.
     *@throws IndexOutOfBoundsException if the given index is not valid.
     */
    @Override
    public void add(int i, E e) {
        if (i < 0 || i >=sizeTotalElem) throw new IndexOutOfBoundsException();
        ListIterator myIter= this.listIterator(i);
        myIter.add(e);
    }

    /**
     * Takes an index to remove that index.
     * @param i Takes index as integer
     * @return Returns the deleted value.
     * @throws IndexOutOfBoundsException if the given index is not valid.
     * @throws UnsupportedOperationException if there will be a problem with remove
     */
    @Override
    public E remove(int i) {
        ListIterator deletedVar = this.listIterator(i);
        ListIterator delete = this.listIterator(i);
        delete.remove();
        if (i < 0 || i >=sizeTotalElem){
            throw new IndexOutOfBoundsException();
        }
        if (deletedVar.hasNext()) {
            return (E) deletedVar.next();
        }
        else{
            System.err.println("There might be a problem");
            throw new UnsupportedOperationException();
        }
    }

    /**
     * It is override method which extends the iterable class.
     * @return a iterator by using my iterator class.
     * @see MyListIterator
     * @see AbstractList
     * @see List
     */
    @Override
    public Iterator<E> iterator() {
        return listIterator(0);
    }

    /**
     * @return It returns an iterator from beginning of the list.
     */
    @Override
    public ListIterator listIterator() {
        MyNode<E> nodeRef =head;
        return new MyListIterator(nodeRef,0,0);
    }
    /**
     *Creates an iterator.
     * @param i Take an index of list as integer.
     * @return  Returns the given index as iterator
     * @throws IndexOutOfBoundsException if the given index is not valid.
     */
    @Override
    public ListIterator listIterator(int i) {
        if(i < 0 || i >= sizeTotalElem){
            throw new IndexOutOfBoundsException();
        }
        else if(i==0){
            MyNode<E> nodeRef =head;
            return new MyListIterator(nodeRef,i,0);
        }
        else{
            int flag=0;
            int index=i;
            MyNode<E> nodeRef =head;
            int innerIndex=nodeRef.sizeNode-1;
            while (nodeRef != null && flag ==0){
                for (int j=0; j<nodeRef.sizeNode && flag == 0 ;j++){
                    if(i == 0){
                        innerIndex= j;
                        flag=1;
                    }
                    i--;
                }
                if (flag==0) {
                    nodeRef = nodeRef.next;
                }
            }
            //assert nodeRef != null;

            return new MyListIterator(nodeRef,index,innerIndex);
        }
    }

    /**
     * @return Returns the size of the list
     */
    @Override
    public int size() {

        return sizeTotalElem;
    }

    /**
     * Override the toString method to print list on the screen.
     * To works for our array list.
     * @return returns all the liit as string.
     */
    @Override
    public String toString(){
        String print= " ";
        MyNode<E> tmp = head;
        for (int i=0; i<sizeList && tmp!=null; i++){
            for (int j=0; j<tmp.sizeNode ; j++){
                print+=tmp.data[j]+", ";
            }
            tmp= tmp.next;
        }
        print+="\n Total element=====>"+sizeTotalElem+"\nList size======>"+sizeList;
        return print;
    }

    /**
     * My custom node:
     * next prev => for the creating double linked list.
     * size node to know how many element are there in a node of array.
     * capacity for the array max capacity.
     * @param <E> Generic type
     */
    private static class MyNode<E> {
        private E[] data;
        private MyNode<E> next;
        private MyNode<E> prev ;
        private int sizeNode=0;
        private  final int CAPACITY=3;

        private MyNode(MyNode<E> nextRef, MyNode<E> prevRef){
            data = (E[]) new Object[CAPACITY];
            next =nextRef;
            prev =prevRef;
            sizeNode=0;
        }
        public int getSizeNode() {
            return sizeNode;
        }
        public int getCapacity() {
            return CAPACITY;
        }
    }

    /**
     *Normally the array index and current node is enough,
     *  but I need the index to manipulate other operations such as next previous methods.
     *
     */
    public class MyListIterator implements ListIterator<E>{
        private MyNode<E> nodeRef ;
        private int innerIndex;
        private int index;

        /**
         * My constructor takes the given values and make operations on them.
         * @param nodeRef Takes the current node the nth index node.
         * @param index The index to keep general struct of list to manuple it easily.
         * @param innerIndex The inner index indicates the nth element of node.
         */
        private MyListIterator(MyNode<E> nodeRef,int index,int innerIndex){
            this.nodeRef=nodeRef;
            this.index=index;
            this.innerIndex=innerIndex;
        }

        /**
         * tostring method to print my node.
         * @return string of the node values.
         */
        @Override
        public String toString() {
            String print = " ";
            for (int i=0; i<nodeRef.sizeNode; i++){
                System.out.println(nodeRef.data[i]);
            }
            return print;
        }

        /**
         * Checks whether there are more element or not.
         * @return Returns boolean by comparing the number of element and index
         */
        @Override
        public boolean hasNext() {
            return sizeTotalElem > index;
        }

        /**
         * @throws NoSuchElementException HasNext method gives false.
         * @see MyListIterator hasNext method
         * @return Returns the current index of node and moves forward the next element.
         */
        @Override
        public E next() {
            if (!hasNext()){
                throw  new NoSuchElementException();
            }
            else{
                E variable= nodeRef.data[innerIndex];
                innerIndex++;
                if (innerIndex==nodeRef.sizeNode && nodeRef.next != null){
                    innerIndex=0;
                    nodeRef=nodeRef.next;
                }
                index++;
                return variable;
            }
        }
        /**
         * Checks whether there are more element or not in back of the list.
         * @return Returns boolean by comparing first index which is zero and current index.
         */
        @Override
        public boolean hasPrevious() {
            return index >= 0;
        }
        /**
         * @throws NoSuchElementException Hasprevious method gives false.
         * @see MyListIterator hasprevious method
         * @return Returns the current index of node and moves back forward the next element.
         */
        @Override
        public E previous() {
            if (!hasPrevious()){
                throw  new NoSuchElementException();
            }
            else{
                index--;
                E variable= nodeRef.data[innerIndex];
                innerIndex--;
                if (innerIndex==-1 && nodeRef.prev != null){
                    innerIndex=nodeRef.prev.sizeNode-1;
                    nodeRef=nodeRef.prev;
                }
                if (innerIndex<0){
                    innerIndex=0;
                }
                return variable;
            }
        }

        /**
         * @return Returns the index of next element if there is not any next element it returns -1.
         */
        @Override
        public int nextIndex() {
            ++index;
            int nextIndex=index;
            index--;
            if (nextIndex>=sizeTotalElem){
                return -1;
            }else {
                return nextIndex;
            }

        }
        /**
         * @return Returns the index of next element if there is not any next element it returns -1.
         */
        @Override
        public int previousIndex() {
            --index;
            int prevIndex=index;
            index++;
            if (prevIndex<0){
                return -1;
            }else {
                return prevIndex;
            }
        }

        /**
         * The remove operation makes by shifting the array.
         *
         * If there is not any element after remove operation the node have to be also removed, so
         * I examine four situations:
         * 1-If it removed from a list which a has one node
         * 2-If it removed from head of the list.
         * 3-If it removed from middle of the list.
         * 4If it removed from tail of the list.
         */
        @Override
        public void remove() {
            for (int i= 0; innerIndex+i != nodeRef.getCapacity()-1; i++){
                nodeRef.data[innerIndex+i]=nodeRef.data[innerIndex+1+i];
            }
            nodeRef.sizeNode--;
            sizeTotalElem--;
            if (nodeRef.sizeNode==0 && nodeRef.next==null && nodeRef.prev==null){
                head=null;
                tail=null;
                sizeList--;
                innerIndex=0;
            }else if(nodeRef.sizeNode==0 &&nodeRef.next!=null && nodeRef.prev==null){
                head=nodeRef.next;
                head.prev=null;
                nodeRef=head;
                innerIndex=0;
                sizeList--;
            }else if(nodeRef.sizeNode==0 &&nodeRef.next!=null && nodeRef.prev!=null){
                nodeRef.prev.next=nodeRef.next;
                nodeRef.next.prev=nodeRef.prev;
                nodeRef=nodeRef.next;
                innerIndex=0;
                sizeList--;
            }else if(nodeRef.sizeNode==0 &&nodeRef.next==null && nodeRef.prev!=null){
                tail= nodeRef.prev;
                nodeRef=nodeRef.prev;
                nodeRef.next=null;
                innerIndex=nodeRef.sizeNode-1;
                sizeList--;
            }

        }

        /**
         * It changes the index of iterator by given value.
         * @param e the given value which will be set.
         * @throws NullPointerException if the given value is null
         */
        @Override
        public void set(E e) {
            if(e==null) throw new NullPointerException();
            nodeRef.data[innerIndex]=e;
        }

        /**
         * I already keep the values of index current given node and array index.
         * I manage my operations on array index I find the values of them before it comes the iterator class.
         *
         * I take the array index and examine it.
         * Basically I examine from four steps:
         * 1-Firstly if the user try to send my iterator a null node to add me something I take it arrays of index as -1.
         * 2-Secondly if the user wants to add beginning of array I manipulate the nodes or array shifting.
         * 3-Thirdly if the user wants to add middle of an array again I create new nodes to shift or if its enough I just shift an index.
         * 4-If the user wants to add end of the array again if I need a space I create a new node and connect them or just shifting if its enough.
         * 5-It is a hard condition to occur but even I notify to user O add last else condition to brief the user.
         *
         * @param item the item will be added.
         */
        @Override
        public void add(E item) {
            if (innerIndex == -1){
                if(nodeRef.sizeNode != nodeRef.getCapacity()){
                    nodeRef.data[nodeRef.sizeNode]=item;
                    innerIndex=nodeRef.sizeNode-1;
                }else{
                    nodeRef.next= new MyNode<E>(null,nodeRef);
                    nodeRef=nodeRef.next;
                    nodeRef.data[0]=item;
                    tail=nodeRef;
                    innerIndex=0;
                    sizeList++;
                }
                nodeRef.sizeNode++;
                sizeTotalElem++;
            }
            else if(innerIndex==0){
                if (nodeRef==null){
                    nodeRef= new MyNode<E>(null,null);
                    head=nodeRef;
                    tail=nodeRef;
                    nodeRef.data[innerIndex]=item;
                    sizeTotalElem++;
                    sizeList++;
                    nodeRef.sizeNode++;
                    innerIndex++;
                    index++;
                }
                else if ( nodeRef.sizeNode != nodeRef.getCapacity()){
                    for (int i =nodeRef.getSizeNode(); i>0; i--){
                        nodeRef.data[i]=nodeRef.data[i-1];
                    }
                    nodeRef.data[innerIndex]=item;
                    sizeTotalElem++;
                    nodeRef.sizeNode++;
                    innerIndex++;
                    index++;
                }
                else if(nodeRef.sizeNode == nodeRef.getCapacity()){
                    if (nodeRef.prev != null && nodeRef.prev.sizeNode != nodeRef.prev.getCapacity()){
                        nodeRef.prev.data[nodeRef.prev.sizeNode]=item;
                        nodeRef.prev.sizeNode++;
                        sizeTotalElem++;
                    }else if(nodeRef.prev == null){
                            nodeRef.prev= new MyNode<E>(nodeRef,null);
                            nodeRef.prev.data[0]=item;
                            head= nodeRef.prev;
                            nodeRef.prev.sizeNode++;
                            sizeList++;
                            sizeTotalElem++;
                    }else if (nodeRef.prev!=null){
                            MyNode<E> insert = new MyNode<E>(nodeRef, nodeRef.prev);
                            nodeRef.prev.next = insert;
                            nodeRef.prev = insert;
                            insert.data[0] = item;
                            sizeTotalElem++;
                            sizeList++;
                            insert.sizeNode++;
                    }
                }
            }else if (innerIndex>0 && innerIndex < nodeRef.getCapacity()-1){
               int k;
                if(nodeRef.getCapacity() != nodeRef.sizeNode){
                    k=nodeRef.sizeNode-innerIndex+1;
                    for (int i =nodeRef.getSizeNode(); i>0 && k>0; i--){
                        nodeRef.data[i]=nodeRef.data[i-1];
                        k--;
                    }
                    nodeRef.data[innerIndex]=item;
                    sizeTotalElem++;
                    nodeRef.sizeNode++;
                    innerIndex++;
                    index++;
                }else if (nodeRef.getCapacity() == nodeRef.sizeNode && nodeRef.next==null){
                    nodeRef.next = new MyNode<E>(null, nodeRef);
                    tail = nodeRef.next;
                    nodeRef.next.data[0] = nodeRef.data[nodeRef.sizeNode-1];
                    k=nodeRef.sizeNode-innerIndex+1;
                    for (int i =nodeRef.getSizeNode()-1; i>0 && k>0; i--){
                        nodeRef.data[i]=nodeRef.data[i-1];
                        k--;
                    }
                    nodeRef.data[innerIndex] = item;
                    innerIndex = 0;
                    nodeRef.next.sizeNode = 1;
                    nodeRef=nodeRef.next;
                    index++;
                    sizeTotalElem++;
                    sizeList++;
                }else if (nodeRef.getCapacity() == nodeRef.sizeNode && nodeRef.next!=null){
                    E[] variables =  (E[]) new Object[nodeRef.getCapacity()];
                    int loop1,loop2;
                    int tempinIndex=innerIndex;
                    loop1= loop2 = nodeRef.sizeNode-innerIndex;
                    for (int i=0;loop1 != 0; i++) {
                        variables[i] = nodeRef.data[tempinIndex];
                        loop1--;
                        tempinIndex++;
                    }
                    nodeRef.sizeNode-=(loop2-1);
                    nodeRef.data[innerIndex]=item;
                    MyNode<E> insert =new MyNode<E>(nodeRef.next,nodeRef);
                    for (int i=0; loop2 != 0; i++){
                        insert.data[i]=variables[i];
                        loop2--;
                        insert.sizeNode++;
                    }
                    nodeRef.next.prev=insert;
                    nodeRef.next=insert;
                    sizeTotalElem++;
                    sizeList++;
                    index++;
                    nodeRef= nodeRef.next;
                    innerIndex=0;
                }
            }else if (innerIndex == nodeRef.getCapacity()-1){
                if (innerIndex>nodeRef.sizeNode-1){

                    nodeRef.data[nodeRef.sizeNode] = item;
                    sizeTotalElem++;
                    nodeRef.sizeNode++;
                    if (nodeRef.next != null){
                        System.out.println("OK");
                        nodeRef=nodeRef.next;
                    }else{
                        nodeRef.next=new MyNode<E>(null,nodeRef);
                        nodeRef=nodeRef.next;
                        sizeList++;
                    }
                    tail=nodeRef;
                    innerIndex=0;
                    index++;
                }else if (nodeRef.sizeNode != nodeRef.getCapacity()){
                    nodeRef.data[nodeRef.sizeNode]=nodeRef.data[nodeRef.sizeNode-1];
                    nodeRef.data[nodeRef.sizeNode-1] = item;
                    sizeTotalElem++;
                    nodeRef.sizeNode++;
                    innerIndex++;
                    index++;
                }else if (nodeRef.sizeNode == nodeRef.getCapacity() && nodeRef.next ==null){
                    nodeRef.next = new MyNode<E>(null, nodeRef);
                    nodeRef.next.data[0]=nodeRef.data[nodeRef.sizeNode-1];
                    nodeRef.data[nodeRef.sizeNode-1]=item;
                    nodeRef=nodeRef.next;
                    tail=nodeRef;
                    sizeTotalElem++;
                    nodeRef.sizeNode++;
                    innerIndex=0;
                    index++;
                    sizeList++;
                }else if (nodeRef.sizeNode == nodeRef.getCapacity() && nodeRef.next !=null){
                    MyNode<E> insert =new MyNode<E>(nodeRef.next,nodeRef);
                    nodeRef.next.prev=insert;
                    nodeRef.next=insert;
                    insert.data[0]=nodeRef.data[nodeRef.sizeNode-1];
                    insert.sizeNode++;
                    nodeRef.data[nodeRef.sizeNode-1]= item;
                    nodeRef=nodeRef.next;
                    innerIndex=0;
                    sizeTotalElem++;
                    sizeList++;
                    index++;
                }
            }else {
                System.out.println("There is a problem with add method");
            }
        }
    }
}

