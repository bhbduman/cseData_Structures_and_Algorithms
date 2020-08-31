
package bhb;
/**
 * Since the all method are the same for arraylist and linked list
 * I keep the functions in BaseEditor class
 * @author  Baran Hasan BOZDUMAN
 * @version 1.0
 * @since   2020-04-01
 */
import java.io.*;
import java.util.AbstractList;
import java.util.ListIterator;

public abstract class BaseEditor {

    protected AbstractList<Character> myText = null;
    protected File fpoint;
    
    @Override
    public String toString(){
        String print= " ";
        ListIterator<Character> iter =myText.listIterator();
        while(iter.hasNext()){
            print+=iter.next();
        }
        return print;
    }
    
    /**
     *my rreadFile method reads the file using by
     * @see BufferedReader
     * It reads character by character
     * @throws IOException if the method can not find file
     */
    public void readFile() throws IOException {
        FileReader file=new FileReader(fpoint);
        BufferedReader buf=new BufferedReader(file);
        int c = 0;
        c = buf.read();
        while(c != -1){
            myText.add ((char) c);
            c = buf.read();
        }
       int i=0;
        for(int j =0; j< myText.size(); j++){
            System.out.print(myText.get(i));
            i++;
        }
        buf.close();
        file.close();

    }

    /**
     *It adds a string the start by given index
     * @param getStr The string which will be added
     * @param index  in what index that the user want to ad
     * @throws IOException error handling for file operation
     */
    public void add(String getStr, int index) throws IOException {
        for (int i= 0; i<getStr.length(); i++) {
            myText.add(index, getStr.charAt(i) );
            index++;
        }
        int i=0;
        FileWriter writeToFile =new FileWriter(fpoint);
        for (i=0; i<myText.size(); i++){
            writeToFile.write(myText.get(i));
        }
        writeToFile.close();
    }

    /**
     *It finds the begin of the given string index in text file
     * @param givenStr the string will be searched
     * @return returns the begin of the given string otherwise returns false
     */
    public int findIndex(String givenStr){
        int flag=0;
        int index=-1;
        for (int j =0,k=0; j<myText.size(); j++) {
            if (myText.get(j) == givenStr.charAt(k)) {
                for (int i = 1; i < givenStr.length() && flag == 0; i++) {
                    if (myText.get(j + i) != givenStr.charAt(i)) {
                        flag = 1;
                    }
                }
                if (flag != 1) {
                    return j;
                } else {
                    flag = 0;
                }
            }
        }
        return -1;
    }

    /**
     *It changes a specific character with the given character
     * @param willChange the character will be changed
     * @param given the character instead of the old one
     * @throws IOException erorhandling for file operations
     */
    public void changeChar(char willChange, char given) throws IOException {
        for (int i=0; i<myText.size(); i++){
            if(myText.get(i) == willChange){
                myText.set(i,given);
            }
        }
        FileWriter writeToFile =new FileWriter(fpoint);
        for (int i=0; i<myText.size(); i++){
            writeToFile.write(myText.get(i));
        }
        writeToFile.close();
    }

    /**
     *my rreadFile method reads the file with iterator using by
     * @see BufferedReader
     * It reads character by character
     * it uses iterator when add the nodes
     * @throws IOException if the method can not find file
     */
    public void iteratorReadFile() throws IOException {
        FileReader file=new FileReader(fpoint);
        BufferedReader buf=new BufferedReader(file);
        ListIterator<Character> iter = myText.listIterator();
        int c = 0;
        c = buf.read();
        while(c != -1){
            iter.add ((char) c);
            c = buf.read();
        }
        iter= myText.listIterator();
        while (iter.hasNext()){
            System.out.print(iter.next());
        }
        buf.close();
        file.close();
    }

    /**
     *It adds a string by using iterator the start by given index
     * @param getStr The string which will be added
     * @param index  in what index that the user want to ad
     * @throws IOException error handling for file operation
     */
    public void iteratorAdd(String getStr, int index) throws IOException {
        ListIterator<Character> iter = myText.listIterator(index);
        int i;
        for ( i= 0; i<getStr.length(); i++) {
            ///myText.listIterator(index).add(getStr.charAt(i));
            // index++;
            iter.add(getStr.charAt(i));

        }
        i=0;
        FileWriter writeToFile =new FileWriter(fpoint);
        for (i=0; i<myText.size(); i++){
            writeToFile.write(myText.get(i));
        }
        writeToFile.close();
    }

    /**
     *It finds the begin of the given string index in text file by using iterator
     * @param givenStr the string will be searched
     * @return returns the begin of the given string otherwise returns false
     */
    public int iteratorFindIndex(String givenStr){
        ListIterator<Character> iter = myText.listIterator();
        int flag=0;
        int index=-1;
        char ch;
        for (int j =0,k=0; j<myText.size() && flag==0; j++) {
            if (!iter.hasNext()){
                flag=1;
            }else{
                ch =iter.next();
                if (ch == givenStr.charAt(k)) {
                    for (int i = 1; i < givenStr.length()-1 && flag == 0; i++) {
                        ch=iter.next();
                        if (ch != givenStr.charAt(i)) {
                            flag = 1;
                        }
                    }
                    if (flag != 1) {
                        return j;
                    } else {
                        flag = 0;
                    }
                }
            }

        }
        return -1;
    }

    /**
     *It changes a specific character with the given character by using iterator
     * @param willChange the character will be changed
     * @param given the character instead of the old one
     * @throws IOException erorhandling for file operations
     */
    public void iteratorChangeChar(char willChange, char given) throws IOException {
        ListIterator<Character> iter= myText.listIterator();;
        while(iter.hasNext()){
            if(iter.next() == willChange){
                iter.set(given);
            }
        }
        iter=myText.listIterator();
        FileWriter writeToFile =new FileWriter(fpoint);
        while(iter.hasNext()){
            writeToFile.write(iter.next());
        }
        writeToFile.close();
    }
}
