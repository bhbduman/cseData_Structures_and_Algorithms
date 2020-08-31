package bhb;
/**
 * It extedns from abstract base editor which has the all methods
 * @see bhb.BaseEditor
 * This class just incluude constructor
 */

import java.io.*;
import java.util.ArrayList;

public class ArrayListEditor extends BaseEditor  {
    /**
     * It takes the file name and creates Arraylist for the file
     * @param file_name the given filename
     */
    public ArrayListEditor(String file_name){
        myText =new ArrayList<Character>();
        fpoint=new File(file_name);

    }

}
