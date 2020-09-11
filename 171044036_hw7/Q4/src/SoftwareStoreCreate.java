/**
 * My classs to create new stroe
 */
public class SoftwareStoreCreate<T>implements SearchTree<SoftwarePackage> {
    /**
     * my data field to use appropriate methods of given type
     */
    private SearchTree<T> dataS;

    /**
     * constructor
     * @param dataStructure sending a data structure which is type SearchTree
     */
    public  SoftwareStoreCreate(SearchTree<T> dataStructure) {
        dataS=dataStructure;
    }
    /**
     * Insertion method
     *
     * @param item item will be addes
     * @return returns true if the insertion is successful
     */
    @Override
    public boolean add(SoftwarePackage item) {
        return dataS.add((T) item);
    }

    /**
     * To decide given element contains or not
     *
     * @param target given element to search
     * @return return true if the tree contains it
     */
    @Override
    public boolean contains(SoftwarePackage target) {
        return dataS.contains((T) target);
    }

    /**
     * Find given element
     *
     * @param target to find element
     * @return the given node as element
     */
    @Override
    public SoftwarePackage find(SoftwarePackage target) {
        return (SoftwarePackage) dataS.find((T) target);
    }

    /**
     * Deletes given item
     *
     * @param target the element will be deleted
     * @return the deleted element
     */
    @Override
    public SoftwarePackage delete(SoftwarePackage target) {
        return (SoftwarePackage) dataS.delete((T) target);
    }

    /**
     * works like delete but returns true if the deletion successfull
     *
     * @param target the element will be deleted
     * @return returns true if the deletion is successful  returns false otherwise
     */
    @Override
    public boolean remove(SoftwarePackage target) {
        return dataS.remove((T) target);
    }

    /**
     * to print the store
     * @return returns all elements in stroe
     */
    @Override
    public String toString() {
        return dataS.toString();
    }
}
