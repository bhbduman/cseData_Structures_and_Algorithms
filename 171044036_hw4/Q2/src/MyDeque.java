import java.util.AbstractCollection;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyDeque<E> extends AbstractCollection<E> implements Deque<E>{
    /**
     * head of list
     */
    private MyNode<E> front;
    /**
     * tail of list
     */
    private MyNode<E> rear;
    /**
     * head of removeds list
     */
    private MyNode<E> removed =null;
    /**
     * tail of removeds lsit
     */
    private MyNode<E> removedRear =null;
    /**
     * removed sizes
     */
    private int sizeR=0;
    /**
     * deque size
     */
    private int sizeD=0;

    /**
     * constructor of my deque
     */
    public MyDeque(){
        front=null;rear=null;removed=null;
        sizeD=0;
    }

    /**
     *Returns an iterator over the elements in this deque in proper sequence. The elements will be returned in order from first (head) to last (tail).
     * @return an iterator over the elements in this deque in proper sequence
     */
    @Override
    public Iterator iterator() {
        return new MyIterAsc();
    }

    /**
     *Returns an iterator over the elements in this deque in reverse sequential order. The elements will be returned in order from last (tail) to first (head).
     * @return an iterator over the elements in this deque in reverse sequence
     */
    @Override
    public Iterator descendingIterator() {
        return new MyIterDsc();
    }

    /**
     * Inserts the specified element at the front of this deque
     * @param item takes to add deque as firs element
     * @throws NullPointerException if the given value is null
     */
    @Override
    public void addFirst(E item) {
        if (item == null){
            throw new NullPointerException();
        }
        else{

            if (front == null ) {
                MyNode<E> newItem = new MyNode<E>(null, null, item);
                front=newItem;rear=newItem;
            }else if(sizeD >= 1 && sizeR == 0){
                MyNode<E> newItem = new MyNode<E>(null,front, item);
                front.setPrev(newItem);
                front=newItem;
            }else if(sizeR != 0){
                MyNode<E> tmp = removedRear;
                removedRear=removedRear.prev;
                sizeR--;
                tmp.next=front;
                tmp.data=item;
                front.setPrev(tmp);
                front=front.prev;
                front.prev=null;
            }
            sizeD++;
        }
    }

    /**
     * Inserts the specified element at the front of this deque its same as addLast()
     * @param item the element to add
     * @return true if it added successfully.
     * @throws NullPointerException if the given value is null
     */
    @Override
    public boolean add(E item) {
        addLast(item);
        return true;
    }

    /**
     * Inserts the specified element at the end of this deque
     * @param item the element to add
     * @throws NullPointerException if the given value is null
     */
    @Override
    public void addLast(E item) {
        if (item == null){
            throw new NullPointerException();
        }
        else {
            if (front == null ) {
                MyNode<E> newItem = new MyNode<E>(null, null, item);
                front = newItem;
                rear = newItem;
            }else if(sizeD >= 1 && sizeR == 0){
                MyNode<E> newItem = new MyNode<E>(rear,null, item);
                rear.setNext(newItem);
                rear=newItem;
            }
            else if(sizeR != 0){
                MyNode<E> tmp = removedRear;
                removedRear=removedRear.prev;
                sizeR--;
                tmp.prev=rear;
                tmp.data=item;
                rear.setNext(tmp);
                rear=rear.next;
                rear.next=null;
            }
        }
        sizeD++;
    }

    /**
     *Inserts the specified element at the front of this deque
     * @param item the element to add
     * @return true if the add operation is successful
     * @throws NullPointerException if the given value is null
     */
    @Override
    public boolean offerFirst(E item) {
            addFirst(item);
        return true;
    }

    /**
     * Inserts the specified element at the end of this deque unless it would violate capacity restrictions. When using a capacity-restricted deque, this method is generally preferable to the addLast(E) method, which can fail to insert an element only by throwing an exception.
     * @param item  the element to add.
     * @return true if the element was added to this deque, else false.
     * @throws NullPointerException  if the specified element is null and this deque does not permit null elements.
     */
    @Override
    public boolean offerLast(E item) {
        addLast(item);
        return true;
    }

    /**
     *takes the removed node and connect it to removed nodes
     * @param nodeRef takes the removed node referance
     */
    public void generalRemove(MyNode<E> nodeRef){
        if (removed == null){
            removed= nodeRef;
            removedRear=removed;
            nodeRef.next=null;
            nodeRef.prev=null;
        }else{
            MyNode<E> tmp2=removed;
            while(tmp2.next != null){
                tmp2=tmp2.next;
            }
            tmp2.next=nodeRef;
            nodeRef.prev=tmp2;
            removedRear=nodeRef;
            nodeRef.next=null;
        }
        sizeD--;
        sizeR++;
    }

    /**
     *Retrieves and removes the first element of this deque. This method differs from pollFirst only in that it throws an exception if this deque is empty.
     * @return the head of deque.
     * @throws NoSuchElementException
     */
    @Override
    public E removeFirst() {
        if(sizeD == 0){
            throw new NoSuchElementException();
        }else {
            MyNode<E> tmp=front;
            front = front.next;
            generalRemove(tmp);
            front.prev=null;
            if(sizeD == 0) {
                return null;
            }
            return tmp.data;

        }
    }

    /**
     *Retrieves and removes the last element of this deque. This method differs from pollLast only in that it throws an exception if this deque is empty.
     *
     * @return the tail of this deque
     * @throws NoSuchElementException
     */
    @Override
    public E removeLast() {
        if(sizeD == 0){
            throw new NoSuchElementException();
        }else {
            MyNode<E> tmp=rear;
            rear = rear.prev;
            generalRemove(tmp);
            rear.next=null;


        }
        return rear.data;
    }

    /**
     *Retrieves and removes the head of the queue represented by this deque (in other words, the first element of this deque), or returns null if this deque is empty.
     * This method is equivalent to pollFirst().
     * @return the first element of this deque, or null if this deque is empty
     */
    @Override
    public E poll() {
        return removeFirst();
    }

    /**
     *Retrieves and removes the first element of this deque, or returns null if this deque is empty.
     * @return the head of this deque, or null if this deque is empty
     */
    @Override
    public E pollFirst() {
        if(sizeD == 0){
           return null;
        }
        return poll();
    }

    /**
     *Retrieves and removes the last element of this deque, or returns null if this deque is empty.
     * @return the tail of this deque, or null if this deque is empty
     */
    @Override
    public E pollLast() {
        if(sizeD == 0){
            return null;
        }
        return removeLast();
    }

    /**
     * Retrieves, but does not remove, the first element of this deque. This method differs from peekFirst only in that it throws an exception if this deque is empty.
     * @return the head of this deque
     * @throws java.util.NoSuchElementException
     */
    @Override
    public E getFirst() {
        if (sizeD != 0){
            return front.data;
        }else{
            throw new NoSuchElementException();
        }
    }

    /**
     *Retrieves, but does not remove, the last element of this deque. This method differs from peekLast only in that it throws an exception if this deque is empty.
     * @return the tail of this deque
     * @throws java.util.NoSuchElementException
     */
    @Override
    public E getLast() {
        if (sizeD != 0){
            return rear.data;
        }else{
            throw new NoSuchElementException();
        }
    }

    /**
     * Retrieves, but does not remove, the first element of this deque, or returns null if this deque is empty.
     * @return the head of this deque, or null if this deque is empty
     */
    @Override
    public E peekFirst() {
        if (sizeD != 0){
            return front.data;
        }else{
            return null;
        }
    }

    /**
     * Retrieves, but does not remove, the last element of this deque, or returns null if this deque is empty.
     * @return the tail of this deque, or null if this deque is empty
     */
    @Override
    public E peekLast() {
        if (sizeD != 0){
            return rear.data;
        }else{
            return null;
        }
    }

    /**
     *Removes the first occurrence of the specified element from this deque. If the deque does not contain the element, it is unchanged. More formally, removes the first element e such that (o==null ? e==null : o.equals(e)) (if such an element exists). Returns true if this deque contained the specified element (or equivalently, if this deque changed as a result of the call).
     * @param item element to be removed from this deque, if present
     * @return true if an element was removed as a result of this call
     * @throws NullPointerException he specified element is null and this deque does not permit null elements (optional)
     */
    @Override
    public boolean removeFirstOccurrence(Object item) {
        if (item == null){
            throw new NullPointerException();
        }
        int flag =0;
        if(item == getFirst()){
            removeFirst();
            return true;
        }else{
            MyNode<E> tmp =front;
            MyNode<E> delete;
            while(item != tmp.data && tmp.next != null){
                tmp=tmp.next;
            }
            if(item == tmp.data && tmp.next!=null){
                tmp.prev.next=tmp.next;
                tmp.next.prev=tmp.prev;
                generalRemove(tmp);
                flag=1;
                return true;
            }
            if(flag!=1 && tmp.next==null && item == getLast()){
                removeLast();
                return true;
            }
        }
        return false;
    }

    /**
     *Removes the last occurrence of the specified element from this deque. If the deque does not contain the element, it is unchanged. More formally, removes the last element e such that (o==null ? e==null : o.equals(e)) (if such an element exists). Returns true if this deque contained the specified element (or equivalently, if this deque changed as a result of the call).
     * @param item  element to be removed from this deque, if present
     * @return true if an element was removed as a result of this call
     * @throws NullPointerException he specified element is null and this deque does not permit null elements (optional)
     */
    @Override
    public boolean removeLastOccurrence(Object item) {
        if (item == null){
            throw new NullPointerException();
        }
        int flag =0;
        if(item == getLast()){
            removeLast();
            return true;
        }else{
            MyNode<E> tmp =rear;
            while(item != tmp.data && tmp.prev != null){
                tmp=tmp.prev;
            }
            if(item == tmp.data && tmp.prev!=null){
                tmp.prev.next=tmp.next;
                tmp.next.prev=tmp.prev;
                generalRemove(tmp);
                flag=1;
                return true;
            }
            if(flag!=1 && tmp.prev==null && item == getFirst()){
                removeFirst();
                return true;
            }
        }
        return false;
    }

    /**
     * Inserts the specified element into the queue represented by this deque (in other words, at the tail of this deque) if it is possible to do so immediately without violating capacity restrictions, returning true upon success and false if no space is currently available. When using a capacity-restricted deque, this method is generally preferable to the add(E) method, which can fail to insert an element only by throwing an exception.
     * This method is equivalent to offerLast(E).
     * @param item the element to add
     * @return true if the element was added to this deque, else false
     * @throws NullPointerException if the given value is null
     */
    @Override
    public boolean offer(E item) {
        return offerLast(item);
    }

    /**
     *Retrieves and removes the head of the queue represented by this deque (in other words, the first element of this deque). This method differs from poll only in that it throws an exception if this deque is empty.
     * @return the head of the queue represented by this deque
     * @throws  NoSuchElementException - if this deque is empty
     */
    @Override
    public E remove() {
        return removeFirst();
    }

    @Override
    public boolean isEmpty() {
        return sizeD==0 ? true:false;
    }

    @Override
    public boolean contains(Object o) {
        return super.contains(o);
    }

    /**
     * Removes the first occurrence of the specified element from this deque. If the deque does not contain the element, it is unchanged. More formally, removes the first element e such that (o==null ? e==null : o.equals(e)) (if such an element exists). Returns true if this deque contained the specified element (or equivalently, if this deque changed as a result of the call).
     * @param o  element to be removed from this deque, if present
     * @return true if an element was removed as a result of this call
     * @throws NullPointerException - if the specified element is null and this deque does not permit null elements (optional)
     */
    @Override
    public boolean remove(Object o) {
        return removeFirstOccurrence(o);
    }

    /**
     * Retrieves, but does not remove, the head of the queue represented by this deque (in other words, the first element of this deque). This method differs from peek only in that it throws an exception if this deque is empty.
     * @return the head of the queue represented by this deque
     * @throws NoSuchElementException if this deque is empty
     */
    @Override
    public E element() {
        if(sizeD == 0){
            throw new NoSuchElementException();
        }
        return front.data;
    }

    /**
     * Retrieves, but does not remove, the head of the queue represented by this deque (in other words, the first element of this deque), or returns null if this deque is empty.
     *This method is equivalent to peekFirst()
     *  @return the head of the queue represented by this deque, or null if this deque is empty
     */
    @Override
    public E peek() {
        if(sizeD == 0){
            return null;
        }
        return front.data;
    }

    /**
     *Pushes an element onto the stack represented by this deque (in other words, at the head of this deque) if it is possible to do so immediately without violating capacity restrictions, returning true upon success and throwing an IllegalStateException if no space is currently available.
     * This method is equivalent to addFirst(E).
     * @param o the element to push
     * @throws NullPointerException - if the specified element is null and this deque does not permit null elements
     */
    @Override
    public void push(E o) {
        if(o == null){
            throw new NullPointerException();
        }
        addFirst(o);
    }

    /**
     *Pops an element from the stack represented by this deque. In other words, removes and returns the first element of this deque.
     * This method is equivalent to removeFirst().
     * @return the element at the front of this deque (which is the top of the stack represented by this deque)
     * @throws NoSuchElementException - if this deque is empty
     */
    @Override
    public E pop() {
        return removeFirst();
    }

    /**
     *to print list
     * @return the list as a string
     */
    @Override
    public String toString() {
        String print= " ";
        MyNode<E> tmp=front;
        print+="\nDequeList";
        for (int i=0; i<sizeD; i++){
            print+="=>"+ tmp.getData();
            tmp=tmp.next;
        }
        print+="\nRemoved";
        MyNode<E> tmp2=removed;
        for (int i=0; i<sizeR; i++){
            print+="=>"+ tmp2.getData();
            tmp2=tmp2.next;
        }
        return print;
    }

    /**
     * Returns the number of elements in this deque.
     * @return the number of elements in this deque
     */
    @Override
    public int size() {
        return sizeD;
    }
    private class MyIterDsc<E> implements Iterator<E> {
        private MyNode<E> nodeRef =(MyNode) rear;

        /**
         *Returns true if the iteration has more elements. (In other words, returns true if next() would return an element rather than throwing an exception.)
         * @return true if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            if(nodeRef != null){
                return true;
            }
            return false;
        }

        /**
         *Returns the prev element in the iteration.
         * @return the prev node
         */
        @Override
        public E next() {
            E variable =  nodeRef.data;
            nodeRef=nodeRef.prev;
            return variable;
        }

        /**
         *Removes from the underlying collection the last element returned by this iterator (optional operation). This method can be called only once per call to next(). The behavior of an iterator is unspecified if the underlying collection is modified while the iteration is in progress in any way other than by calling this method.
         */
        @Override
        public void remove() {
            if (nodeRef.prev == null){
                removeFirst();
            }else if (nodeRef.next == null){
                removeLast();
            }else{
                nodeRef.prev.next=nodeRef.next;
                nodeRef.next.prev=nodeRef.prev;
                if (removed == null){
                    removed = (MyNode) nodeRef;
                    removedRear=removed;
                    nodeRef.next=null;
                    nodeRef.prev=null;
                }else{
                    removedRear.next= (MyNode)nodeRef;
                    removedRear.next.prev=removedRear;
                    removedRear=removedRear.next;
                    removedRear.next=null;
                }
                sizeD--;
                sizeR++;
            }
        }
        /**
         *to get data of node
         * @return the data as string
         */
        @Override
        public String toString() {
            String print= String.valueOf(nodeRef.data);
            return print;
        }
    }
    private class MyIterAsc<E> implements Iterator<E> {
        private MyNode nodeRef =front;

        /**
         *Returns true if the iteration has more elements. (In other words, returns true if next() would return an element rather than throwing an exception.)
         * @return true if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            if(nodeRef != null){
                return true;
            }
            return false;
        }

        /**
         *Returns the next element in the iteration.
         * @return the next element in the iteration
         */
        @Override
        public E next() {
            E variable = (E) nodeRef.data;
            nodeRef=nodeRef.next;
            return variable;
        }

        /**
         *Removes from the underlying collection the last element returned by this iterator (optional operation). This method can be called only once per call to next(). The behavior of an iterator is unspecified if the underlying collection is modified while the iteration is in progress in any way other than by calling this method.
         */
        @Override
        public void remove() {
            if (nodeRef.prev == null){
                removeFirst();
            }else if (nodeRef.next == null){
                removeLast();
            }else{
                nodeRef.prev.next=nodeRef.next;
                nodeRef.next.prev=nodeRef.prev;
                if (removed == null){
                    removed = (MyNode) nodeRef;
                    removedRear=removed;
                    nodeRef.next=null;
                    nodeRef.prev=null;
                }else{
                    removedRear.next= (MyNode)nodeRef;
                    removedRear.next.prev=removedRear;
                    removedRear=removedRear.next;
                    removedRear.next=null;
                }
                sizeD--;
                sizeR++;

            }
        }

        /**
         *to get data of node
         * @return the data as string
         */
        @Override
        public String toString() {
            String print= String.valueOf(nodeRef.data);
            return print;
        }
    }

    private class MyNode<E> {
        private E data;
        private MyNode<E> next;
        private MyNode<E> prev ;

        /**
         *it consstruct new node and assign the  nextprevious
         * it is a double linkedlist
         * @param prevRef previous node
         * @param nextRef next node
         * @param data data of node
         */
        private MyNode( MyNode<E> prevRef,MyNode<E> nextRef, E data){
            this.data=data;
            next =nextRef;
            prev =prevRef;
        }
        public E getData() {
            return data;
        }
        public void setData(E data) {
            this.data = data;
        }
        public MyNode<E> getNext() {
            return next;
        }
        public void setNext(MyNode<E> next) {
            this.next = next;
        }
        public MyNode<E> getPrev() {
            return prev;
        }
        public void setPrev(MyNode<E> prev) {
            this.prev = prev;
        }
    }
}
