import java.util.ArrayList;
import java.util.Collections;

public class MaxHeap<E>{
    private ArrayList<AgeData> list;


    /**
     * Default constructor for maxheap
     */
    public MaxHeap(){
        list = new ArrayList<AgeData>();
    }

    /**
     * it returns the index of data in arraylist
     * @param newNode takes object to compare it
     * @return returns the index of object
     */
    public int getIndex(AgeData newNode) {
        for (int i = 0; i<list.size(); i++){
            if (newNode.equals(list.get(i))){
                return i;
            }
        }
        return -1;
    }

    /**
     * find the object
     * @param target given agedata target objects
     * @return returns the object which is searched
     */
    public AgeData find(AgeData target){
        int index= getIndex(target);
        if (index > -1) {
            return list.get(index);
        }else
            System.out.println("There is no such element");
            return new AgeData(0);
    }

    /**
     * returns the number of younger peoples from given age
     * @param age given age to compare
     * @return the number of younger people from given age
     */
    public int youngerThan(int age){
        int total=0;
        for (AgeData ageData : list) {
            if (ageData.age < age) {
                total += ageData.numberOfPeople;
            }
        }
        return total;
    }

    /**
     * returns the number of older peoples from given age
     * @param age given age to compare
     * @return returns the number of older people from given age
     */
    public int olderThan(int age){
        int total=0;
        for (AgeData ageData : list) {
            if (ageData.age > age) {
                total += ageData.numberOfPeople;
            }
        }
        return total;
    }

    /**
     * adds the new age if there is an age the given age it increases it or
     * adds new age and then checks the is it appropriate order after given age
     * I also write compareto method for it
     */
    public void add(AgeData newNode){
        int index= getIndex(newNode);
        int parent = 0;
        int leftChild, rightChild=0, maxChild;
        boolean flag = true;
        if(index > -1){
            list.get(index).numberOfPeople++;
        }else {
            list.add(newNode);
        }
        while (flag) {
            leftChild = (2 * parent) + 1;
            rightChild = leftChild + 1;
            if (leftChild >= list.size()){
                flag = false;
            }
            maxChild = leftChild;
            if (flag == true && rightChild < list.size() && list.get(rightChild).compareTo(list.get(leftChild))==1) {
                maxChild = rightChild;
            }
            if (flag == true && list.get(parent).compareTo(list.get(maxChild))==-1 ) {
                Collections.swap(list, parent, maxChild);
                parent = maxChild;

            } else {
                flag = false;
            }


        }
    }

    /**
     * remocves a node then checks the order of list
     * @param node takes the node to remove it and it uses compare method
     * @return returns the removed node
     */
    public AgeData remove(AgeData node){

        int index = getIndex(node);
        int parent = 0;
        int leftChild, rightChild=0, maxChild;
        boolean flag = true;
        if(index<= -1){
         System.out.println("The element is not in the list");
         return null;
        }else if(index> -1 && list.get(index).numberOfPeople > 1){
            list.get(index).numberOfPeople--;

        }else {
            AgeData last = new AgeData();
            list.get(index).age = last.age;
            list.get(index).numberOfPeople = last.numberOfPeople;
            last = list.remove(list.size() - 1);
        }
            parent = index;
            while (flag) {
                leftChild = (2 * parent) + 1;
                rightChild = leftChild + 1;
                if (leftChild >= list.size()){
                    flag = false;
                }
                maxChild = leftChild;
                if (flag == true && rightChild < list.size() &&  list.get(rightChild).compareTo(list.get(leftChild))==1) {
                    maxChild = rightChild;
                }
                if (flag == true &&  list.get(parent).compareTo(list.get(maxChild))==-1 ) {
                    Collections.swap(list, parent, maxChild);
                    parent = maxChild;
                } else {
                    flag = false;
                }


            }
        return node;
    }

    /**
     * it prints the age and number of people
     * @return returns a string
     */
    public String toString(){
        StringBuilder print= new StringBuilder();
        for (AgeData ageData : list) {
            print.append(ageData.toString()).append("\n");
        }
        return print.toString();
    }
}
