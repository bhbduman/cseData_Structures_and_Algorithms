package bhb;


/**
 *
 * MyContainer class behaves like a coontainer it manuplates the array operations
 * @author  Baran Hasan BOZDUMAN
 * @version 1.0
 * @since   2020-02-23
 */
public class MyContainer<T> {
    protected Object[] myArray;
    private int size;
    private int capacity;


    /**
     * default constructor method to initialize new container
     * keeps size to used part of array
     * and capacity to real placed array
     */
    public MyContainer() {
        size=0;
        capacity=10;
        myArray =new Object[capacity];
    }
    /**
     *
     * @return size of container as integer
     */
    public int getSize() {
        return size;
    }
    /**
     * gets object array to look up especially one of object information
     * @return array
     */
    public Object getterArray (int i) {
        return myArray[i];
    }
    /**
     * It adds element and increase the size field if the capacity is not enough it multiplies capacity by ten
     * and takes the old elements to new array
     * @param data its genetic but usually takes object type
     * @return boolean true if the addition is successful
     */
    public boolean add (T data) {
        int change=size;
        if (myArray == null)
            myArray = new Object[capacity];
        if (size >= this.capacity) {
            capacity*=10;
            Object [] bigger = new Object[capacity];

            for(int i =0; i<size; i++)
                bigger[i] = myArray[i];

            myArray= (Object[]) bigger;
        }
        myArray[size]=data;
        size++;
        if(change < size)
            return true;
        return false;
    }
    /**
     *
     * @param data takes object of type usually it delete an object by using array shifting
     * @return returns the deleted object
     */
    @SuppressWarnings("unchecked")
    public  T delete (T data) {
        int delete=size+1;
        for(int i=0; i<size; i++)
            if(data== (T)myArray[i])
                delete=i;
        @SuppressWarnings("unused")
        T  deleted = (T) myArray[delete] ;
        for ( int j = delete; j!=size; j++)
            myArray[j]=myArray[j+1];

        --size;

        return data;
    }
    /**
     * it takes string and compare with to string methods of objects
     * @param search takes string as parameter
     * @return returns the object if it finds otherwise it returns null
     */
    @SuppressWarnings("unchecked")
    public T find (String search) {
        for(int i=0; i<size; i++) {
            if(search.equalsIgnoreCase((String)myArray[i].toString()))
                return (T)myArray[i];
        }
        return null;


    }
    /**
     * takes object as a parameter and retrns the object if there is an object like the method searched
     * @param search takes object as parameter
     * @return returns the object if it finds otherwise it returns null
     */
    @SuppressWarnings("unchecked")
    public T find (T search) {
        for(int i=0; i<size; i++) {
            if(search.toString().equalsIgnoreCase((String)myArray[i].toString()))
                return (T)myArray[i];
        }
        return null;


    }
    /**
     * overided string method returns the tostring methods of object in the containers
     */
    @SuppressWarnings("unchecked")
    @Override
    public String toString() {
        String mystr="";

        for(int i=0; i<size; i++)
            mystr+= " "+((T)myArray[i]);
        return mystr;
    }

}
