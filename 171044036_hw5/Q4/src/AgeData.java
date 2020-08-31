public class AgeData{
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
        if(data == 0){
            numberOfPeople = 0;
        }else
            numberOfPeople = 1;
        left = null;
        right = null;
    }

    /**
     * Default no parameter constructor
     */
    public AgeData(){
        this.age =0;
        numberOfPeople = 0;
        left = null;
        right = null;
    }

    /**
     * Constructor to construct from a Agedata object
     * @param node
     */
    public AgeData(AgeData node){
        this.age =node.age;
        numberOfPeople = node.numberOfPeople;
        left = node.left;
        right = node.right;
    }
    //Methods
    /**
     * Return a string representation of the node
     * @return Astring representation of the data fields
     */
    public String toString(){
        return this.age +"-" +this.numberOfPeople;
    }
    public int compareTo(AgeData node){
        if (this.numberOfPeople>node.numberOfPeople){
            return 1;
        }else if(this.numberOfPeople < node.numberOfPeople){
            return -1;
        }else{
            return 0;
        }
    }

    /**
     * equals method to use index of meyhod i override it to compare ages
     * @param o the object to find index number
     * @return returns true if the objects are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        AgeData other = (AgeData) o;
        if (this.age != other.age)
            return false;
        if (this.age != other.age)
            return false;
        return true;
    }

}