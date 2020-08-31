import bhb.LinkedArrayList;

import java.util.Iterator;
import java.util.ListIterator;

public class Test {
    @SuppressWarnings("unchecked")
    public static void main(String[] args){

        LinkedArrayList<Integer> myList =new LinkedArrayList<Integer>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        myList.add(6);
        myList.add(7);
        System.out.println(myList);
        ListIterator<Integer> iter = myList.listIterator();
        iter.add(11);
        iter.add(12);
        iter.add(13);
        iter.add(14);
        iter.add(15);
        iter.add(16);
        iter.add(17);
        System.out.println(myList);
        myList.add(2,9);
        System.out.println(myList);
        iter= myList.listIterator(5);
        System.out.println(iter.next());
        System.out.println(myList.get(9));
        myList.set(5,999);
        System.out.println(myList.get(5));
        myList.remove(6);
        System.out.println(myList);
        System.out.println(myList.size());
        iter= myList.listIterator();
        while(iter.hasNext()){
            System.out.print("=>"+iter.next());
        }
        System.out.println();
        iter= myList.listIterator(12);
        while(iter.hasPrevious()){
            System.out.print("=>"+iter.previous());
        }
        System.out.println();
        iter= myList.listIterator(8);
        System.out.println("Previous index=>"+iter.previousIndex());
        System.out.println("Next index=>"+iter.nextIndex());
        iter.remove();
        System.out.println(myList);
        System.out.println(myList.get(8));
        iter.set(1001);
        System.out.println(myList);
        iter= myList.listIterator(4);
        iter.add(111);
        iter.add(222);
        iter.add(333);
        iter.add(444);
        iter.add(555);
        System.out.println(myList);
        iter= myList.listIterator(7);
        iter.next();
        iter.set(2002);
        System.out.println(myList);
        iter.previous();
        iter.previous();
        iter.set(3003);
        System.out.println(myList);
        System.out.println(iter.previousIndex());
        LinkedArrayList<Character> myListC =new LinkedArrayList<Character>();
        ListIterator<Character> iterC = myListC.listIterator();
        myListC.add('A');
        myListC.add('B');
        myListC.add('C');
        myListC.add('D');
        myListC.add('E');myListC.add('F');
        myListC.add('G');
        myListC.add('H');myListC.add('X');
        myListC.add('Z');
        System.out.println(myListC);
        LinkedArrayList<String> myListS =new LinkedArrayList<String>();
        ListIterator<String> iterS = myListS.listIterator();
        myListS.add("ADANA");
        myListS.add("BOLU");
        myListS.add("CEYHAN");
        myListS.add("DENIZLI");
        myListS.add("EDIRNE");myListS.add("FETHIYE");
        myListS.add("GAZIANTEP");
        myListS.add("MALATYA");myListS.add("URFA");
        myListS.add("ADIYAMAN");
        System.out.println(myListS);
        myList.clear();
        myListC.clear();
        myListS.clear();

        System.out.println("integer"+myList.size());
        System.out.println("character"+myListC.size());
        System.out.println("string"+myListS.size());

        /////////////******if you want to try my methods i created for you these below*****///////////////////////
        LinkedArrayList<Integer> tryMethods =new LinkedArrayList<Integer>();
        ListIterator<Integer> tryIterMethods = myList.listIterator();






    }


}
