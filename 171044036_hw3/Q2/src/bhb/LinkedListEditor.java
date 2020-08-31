package bhb;
/**
 * It extedns from abstract base editor which has the all methods
 * @see bhb.BaseEditor
 * This class just incluude constructor
 */
import java.io.*;
import java.util.AbstractList;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListEditor extends BaseEditor {
    /**
     * Itcreates Linkedlist
     * @param file_name takes the name of the file and creates File
     */
    public LinkedListEditor(String file_name){
        myText =new LinkedList<Character>();
        fpoint=new File(file_name);

    }
}
