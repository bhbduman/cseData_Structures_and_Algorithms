public class AgeData implements Comparable {
    //Data Fields
    /**The information Stored in this node*/
    protected int age;
    /**Reference to the left child*/
    protected AgeData left;
    /**Reference to the right child*/
    protected AgeData right;
    /**the number of people in this age*/
    protected int numberOfPeople=0;
    //Constructors
    /**
     * Construct a node with given data and no children
     * @param data The data to store in this node
     */
    public AgeData(int data){
        this.age = data;
        if (data == 0){
            numberOfPeople= 0;
        }else
            numberOfPeople = 1;

        left = null;
        right = null;
    }

    //Methods
    /**
     * Return a string representation of the node
     * @return Astring representation of the data fields
     */
    public String toString(){
        return this.age +"-" +this.numberOfPeople;
    }

    /**
     * CompareTo method to compare ages
     * @param o takes object which is agedata
     * @return returns 1 if bigger than o,returns -1 if smaller than or returns 0 if it equals each other
     */
    @Override
    public int compareTo(Object o) {
        AgeData node = (AgeData)o;
        if (this.age>node.age){
            return 1;
        }else if(this.age < node.age){
            return -1;
        }else{
            return 0;
        }
    }
}