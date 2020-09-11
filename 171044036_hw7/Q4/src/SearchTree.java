public interface SearchTree<E> {
    /**
     *Insertion method
     * @param item item will be addes
     * @return returns true if the insertion is successful
     */
    boolean add(E item);

    /**
     *To decide given element contains or not
     * @param target given element to search
     * @return return true if the tree contains it
     */
    boolean contains(E target);

    /**
     * Find given element
     * @param target to find element
     * @return the given node as element
     */
    E find(E target);

    /**
     * Deletes given item
     * @param target the element will be deleted
     * @return the deleted element
     */
    E delete(E target);

    /**
     * works like delete but returns true if the deletion successfull
     * @param target the element will be deleted
     * @return returns true if the deletion is successful  returns false otherwise
     */
    boolean remove(E target);

}
