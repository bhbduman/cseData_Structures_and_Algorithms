import java.util.Iterator;
import java.util.NoSuchElementException;

public class Test {

    public static void main(String[] args){
        MyDeque<Integer> myDeque = new MyDeque<Integer>();
        System.out.println("1,2,3,4,5,6,7 are added with addFirst method: ");
        myDeque.addFirst(5);
        myDeque.addFirst(4);
        myDeque.addFirst(3);
        myDeque.addFirst(2);
        myDeque.addFirst(1);
        System.out.println(myDeque);

        System.out.println("6,7,8,9,10 are added with add method: ");
        myDeque.add(6);
        myDeque.add(7);
        myDeque.add(8);
        myDeque.add(9);
        myDeque.add(10);
        System.out.println(myDeque);

        System.out.println("11,9,3,12,13,14,15,10001 are added with addLast method: ");
        myDeque.addLast(11);
        myDeque.addLast(9);
        myDeque.addLast(3);
        myDeque.addLast(12);
        myDeque.addLast(13);
        myDeque.addLast(14);
        myDeque.addLast(15);
        myDeque.addLast(10001);
        System.out.println(myDeque);

        System.out.println("0,-1,-2,-3,-4 are added with offerFirst method: ");
        System.out.println( myDeque.offerFirst(0));
        System.out.println( myDeque.offerFirst(-1));
        System.out.println( myDeque.offerFirst(-2));
        System.out.println( myDeque.offerFirst(-3));
        System.out.println( myDeque.offerFirst(-4));
        System.out.println(myDeque);

        System.out.println("Remove first function has called three times");
        myDeque.removeFirst();
        System.out.println(myDeque);
        myDeque.removeFirst();
        System.out.println(myDeque);
        myDeque.removeFirst();
        System.out.println("poll last function has called once");
        myDeque.pollLast();
        System.out.println(myDeque);

        System.out.println("poll function has called twice in poll first functioncalled once");
        myDeque.poll();
        myDeque.poll();
        myDeque.pollFirst();
        System.out.println(myDeque);

        System.out.println("for removing 15 with removeFirst occurrence returns "+myDeque.removeFirstOccurrence(15));
        System.out.println("for removing 14 with removeFirst occurrence returns "+myDeque.removeFirstOccurrence(14));
        System.out.println("for removing 12 with removeFirst occurrence returns "+myDeque.removeFirstOccurrence(12));
        System.out.println("for removing 2 with removeFirst occurrence returns "+myDeque.removeFirstOccurrence(2));
        System.out.println("for removing 5 with removeFirst occurrence returns "+myDeque.removeFirstOccurrence(5));
        System.out.println("for removing 9(list has two 9) with removeFirst occurrence returns "+myDeque.removeFirstOccurrence(9));
        System.out.println("for removing 0 (in removed) with removeFirst occurrence returns "+myDeque.removeFirstOccurrence(0));
        System.out.println(myDeque);

        System.out.println("for removing 3(list has two) with removeLast occurrence returns "+myDeque.removeLastOccurrence(3));
        System.out.println("for removing 4 with removeLast occurrence returns "+myDeque.removeLastOccurrence(4));
        System.out.println("for removing 8 with removeLast occurrence returns "+myDeque.removeLastOccurrence(8));
        System.out.println("for removing 11 with removeLast occurrence returns "+myDeque.removeLastOccurrence(11));
        System.out.println("for removing 11 with removeLast occurrence returns "+myDeque.removeLastOccurrence(11));
        System.out.println("for removing 0 (in removed) with removeLast occurrence returns "+myDeque.removeLastOccurrence(0));
        System.out.println(myDeque);

        System.out.println("after the removed elements offer last and offer method called");
        System.out.println(myDeque.offerLast(999));
        System.out.println(myDeque.offer(1000));
        System.out.println(myDeque);

        System.out.println("after the removed elements offerfirst method called twice");
        System.out.println(myDeque.offerFirst(666));
        System.out.println(myDeque.offerFirst(333));
        System.out.println(myDeque);

        System.out.println("iterator ascending called it prints with iterator until end");
       @SuppressWarnings("unchecked") 
       Iterator<Integer> iter =myDeque.iterator();
        while (iter.hasNext()){
            System.out.print("<->"+iter.next());
        }

        System.out.println("\niterator descending called it prints with iterator until begin");
       @SuppressWarnings("unchecked") 
       Iterator<Integer> iterD =myDeque.descendingIterator();
        while (iterD.hasNext()){
            System.out.print("<->"+iterD.next());
        }

        System.out.println("\niterator ascend the remove called after four next operation");
        @SuppressWarnings("unchecked") 
        Iterator<Integer> newTiter= myDeque.iterator();
        newTiter.next();newTiter.next();
        newTiter.next();newTiter.next();
        newTiter.remove();
        System.out.println(myDeque);

        System.out.println("\niterator descending remove called after five next operation");
        @SuppressWarnings("unchecked") 
        Iterator<Integer> newTiterD= myDeque.descendingIterator();
        newTiterD.next();newTiterD.next();
        newTiterD.next();newTiterD.next();
        newTiterD.next();
        newTiterD.remove();
        System.out.println(myDeque);

        System.out.println("Is deque contains 10             =>"+myDeque.contains(10));
        System.out.println("Is deque contains 1000           =>"+myDeque.contains(1000));
        System.out.println("Is deque contains 333            =>"+myDeque.contains(333));
        System.out.println("Is deque contains 15(in removed) =>"+myDeque.contains(15));
        System.out.println("Is deque contains 202(there is no such elem) =>"+myDeque.contains(202));

        System.out.println(myDeque);
        System.out.println("peek      method has called =>"+myDeque.peek());
        System.out.println("peekFirst method has called =>"+myDeque.peekFirst());
        System.out.println("peekLast  method has called =>"+myDeque.peekLast());
        System.out.println("getFirst  method has called =>"+myDeque.getFirst());
        System.out.println("getLast   method has called =>"+myDeque.getLast());

        System.out.println("Check deque is empty =>"+myDeque.isEmpty());

        try {
            System.out.println("If we try the remove 9 element which has 8 element it throws exceptions and prints the deque is empty");
            myDeque.removeFirst();            myDeque.removeFirst();
            myDeque.removeFirst();            myDeque.removeFirst();
            myDeque.removeFirst();            myDeque.removeFirst();
            myDeque.removeFirst();            myDeque.removeFirst();
            myDeque.removeFirst();
        }catch (NullPointerException e){
            System.out.println("Check deque is empty =>"+myDeque.isEmpty()+" nullptr exception");
            System.out.println("Since the otther remove methods almost same the all of them gives same behaviour");
        }
        try {
            System.out.println("peek      method has called =>"+myDeque.peek());
            System.out.println("peekFirst method has called =>"+myDeque.peekFirst());
            System.out.println("peekLast  method has called =>"+myDeque.peekLast());
            System.out.println("getFirst  method has called =>"+myDeque.getFirst());
            System.out.println("getLast   method has called =>"+myDeque.getLast());
        }
        catch (NoSuchElementException e){
            System.out.println("Check deque is empty =>"+myDeque.isEmpty()+" no elementh exception");
        }
        System.out.println(myDeque.isEmpty());

    }
}
