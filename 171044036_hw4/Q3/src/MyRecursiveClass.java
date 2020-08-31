import java.util.Stack;

public class MyRecursiveClass {
    /*************************************REVERSING A STRING***********************************************************/
    /**
     *I use the substring method to print untill white spaca
     * and after I call method i print it so
     * when it reach end of the string it will start print in reverse order
     * @param str takes the srting as parameter
     */
    public void reversedString(String str){
        int index=str.indexOf(" ");
        if(index ==-1){
            System.out.print(str.substring(0)+" ");
            return ;
        }
        else{
          reversedString(str.substring(index+1));
            System.out.print(str.substring(0,index)+" ");
        }
    }

    /***************************************CHECK WORD IS ELFISH*******************************************************/
    /**
     *my iselfish wrapper method
     * @param str takes the given string
     * @return true returns true if it provides each letter
     */
    public boolean isElfish(String str){
            return (helperFind('e',str) || helperFind('E',str)) && (helperFind('l',str) || helperFind('L',str)  ) && ( helperFind('F',str) || helperFind('f',str));

    }

    /**
     *my helper method to check wor has a specific letter
     * @param c searching letter
     * @param str string to search letter
     * @return returns true if the word includes the letter
     */
    private boolean helperFind(char c, String str){
        if(str == null || str.equals("")){
            return false;
        }else{
            return c == str.charAt(0) || helperFind(c,str.substring(1));
        }
    }

    /****************************************SELECTION SORT************************************************************/
    /**
     *My sort wrapper takes only the array
     * @param arr takes the array
     */
    public void sort(int[] arr){
        wrapSort(arr,0);
    }

    /**
     * It starts from first index and take value checks until end
     * of the array if there is a smaller method and swap them
     * @param arr given array
     * @param index starting index
     */
    private void wrapSort(int[] arr, int index){
        if(index >= arr.length){
            return ;
        }else{
            int tmpInd=helperSort(arr,index,index);
            if (arr[index]>arr[tmpInd]){
                swap(arr,index,tmpInd);
            }
            wrapSort(arr,++index);
        }
    }
    /**
     *My swap method it changes the place of two number
     * @param arr the array to change
     * @param bigINdex which index have bigger number
     * @param smallIndex which index has smaller number
     */
    private void swap(int[] arr, int bigINdex, int smallIndex){
        int temp= arr[bigINdex];
        arr[bigINdex]= arr[smallIndex];
        arr[smallIndex]=temp;
    }

    /**
     *My helper it compares a number with others and keeps the smaller numbers index so it can change with each other
     * @param arr given array
     * @param smallIndex the index of which has smaller number
     * @param index it increases each time so it checks all array
     * @return returns the index of smaller number
     */
    private int helperSort(int[] arr,int smallIndex,int index){
        if(index >= arr.length){
            return smallIndex;
        }else if(arr[smallIndex] >arr[index]){
            smallIndex = index;
        }
        return helperSort(arr,smallIndex,++index);
    }

    /****************************************EVALUATE POST/PRE-FIX*****************************************************/
    /**
     *my postfix evaluator method takes str and
     * @param str takes the given string expressopn
     * @return returns the result of expression by using helper evaluate method
     */
    public int evaluatePostfix(String str){
        Stack<Integer> stack =new Stack<Integer>();
        return evaluate(str,stack,true);
    }

    /**
     *my prefix evaluator kaes string and send it to helper method
     * it uses same method with postfix so i need to reverse string to use it
     * @param str takes the string expression as parameter
     * @return returns the expression by using helper method
     */
    public int evaluatePrefix(String str){
        StringBuilder sb = new StringBuilder(str);
        Stack<Integer> stack =new Stack<Integer>();
        return evaluate(sb.reverse().toString(),stack,false);
    }

    /**
     *My pre/postfix helper method it takes the parameters and if it is post fix it also sends the true
     * because of the order of operand, it changes for division adn substraction
     * @param str takes the expression
     * @param stack the given stack to push numbers
     * @param isPostfix send true to determine it will use for post fix method
     * @return returns the result of expression
     */
    private int evaluate(String str, Stack<Integer> stack,boolean isPostfix){
        if(str == null || str.equals("") ){
            return stack.pop();
        }else{
            if (Character.isDigit(str.charAt(0))){
                stack.push(Character.getNumericValue(str.charAt(0)));
            }
            else{
                int operand1 =stack.pop();
                int operand2 = stack.pop();
                if (isPostfix){
                    stack.push(operation(operand1,operand2,str.charAt(0)));
                }else{
                    stack.push(operation(operand2,operand1,str.charAt(0)));
                }
            }
            return evaluate(str.substring(1),stack,isPostfix);
        }

    }

    /**
     *It to calculate operation after pop get an operator
     * @param val1 takes the pop value1
     * @param val2 takes the pop value2
     * @param operator takes the operator
     * @return returns the operation result
     */
    private int operation(int val1,int val2, char operator){
        int result=0;
        switch (operator){
            case '+':
                result=val1 + val2;
                break;
            case '-':
                result=val2 - val1;
                break;
            case '*':
                result=val1 * val2;
                break;
            case '/':
                result=val2 / val1;
                break;
            default:
                System.err.println(operator+"<=Operator is not valid");
        }
        return result;
    }

    /********************************************PRINT MATRIX IN SPIRALL FORMAT****************************************/
    /**
     *It is my wrapper method for printin in spirall pattern
     * @param arr takes the given array
     */
    public void print(int[][] arr){
        int size =arr.length*arr[0].length;
        helperPrint(arr,0,0,arr.length-1,arr[0].length-1,0,0,size);
    }

    /**
     *I send the given parameters my helper method
     * @param arr given array
     * @param r it determines the row number for each time like starting point
     * @param c it determines the row number for each time like starting point
     * @param rLength row length of array it determines it prints untill the length of row and decreases each time
     * @param cLength column length of array to determine it stops in which column
     * @param rlimit when we print south to north it stops the determined limit for row
     * @param climit when we print east to west it stops the determined limit for column
     * @param size to determine base case and after a direction I check it because we don t know when it stops
     */
    private void helperPrint(int[][] arr,int r,int c,int rLength,int cLength,int rlimit,int climit, int size ){
        if(size <= 0) {
            return;
        }
            size= north(arr, r, c, cLength,size);
        if(size <= 0) {
            return;
        }
            size= east(arr, ++r, cLength, rLength,size);
        if(size <= 0) {
            return;
        }
            size= south(arr, rLength, --cLength, climit,size);
        if(size <= 0) {
            return;
        }
            size= west(arr, --rLength, climit, rlimit,size);
        if(size <= 0) {
            return;
        }
            helperPrint(arr, r, ++c, rLength, cLength, ++rlimit, ++climit,size);

    }

    /**
     *it prints left of the matrix
     * @param arr given array
     * @param r it determines the row number for each time like starting point
     * @param c it determines the row number for each time like starting point
     * @param rlimit when we print south to north it stops the determined limit for row
     * @param size i decreases it for every call
     * @return returns the number of size
     */
    private int west(int[][] arr,int r,int c,int rlimit,int size){
        if(r <= rlimit){
            return size;
        }else{
            --size;
            System.out.print(arr[r][c] +" ");
            return west(arr,--r,c,rlimit,size);
        }
    }

    /**
     *it prints bottom of the matrix.
     * @param arr given array
     * @param r it determines the row number for each time like starting point
     * @param c it determines the row number for each time like starting point
     * @param climit when we print east to west it stops the determined limit for column
     * @param size i decreases it for every call
     * @return returns the number of size
     */
    private int south(int[][] arr,int r,int c,int climit,int size){
        if(c < climit){
            return size;
        }else{
            --size;
            System.out.print(arr[r][c] +" ");
          return south(arr,r,--c,climit,size);
        }
    }

    /**
     *It prints rigth of the matrix
     * @param arr given array
     * @param r it determines the row number for each time like starting point
     * @param c it determines the row number for each time like starting point
     * @param rLength row length of array it determines it prints until where
     * @param size i decreases it for every call
     * @return returns the number of size
     */
    private int east(int[][] arr,int r,int c, int rLength,int size){
        if(r > rLength){
            return size;
        }else{
            --size;
            System.out.print(arr[r][c] +" ");
            return east(arr,++r,c,rLength,size);
        }
    }

    /**
     *It prints up of the matrix
     * @param arr given array
     * @param r it determines the row number for each time like starting point
     * @param c it determines the row number for each time like starting point
     * @param cLength column length of array to determine it stops in which column
     * @param size i decreases it for every call
     * @return returns the number of size
     */
    private int north(int[][] arr,int r,int c,int cLength,int size){
        if(c > cLength){
            return size;
        }else{
            --size;
            System.out.print(arr[r][c] +" ");
            return north(arr,r,++c,cLength,size);
        }
    }



}
