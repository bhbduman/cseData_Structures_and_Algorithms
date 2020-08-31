import java.util.Scanner;
import java.util.Stack;

public class Test {
    public static void main (String[] args){
        MyRecursiveClass use = new MyRecursiveClass();
    String reverseStr="HEY HOY YOU";
       use.reversedString(reverseStr);
       System.out.println();
       reverseStr= "NEW YORK CALIFORNIA LOSANGALES        ARKANSAS";
       use.reversedString(reverseStr);
        System.out.println();
       reverseStr= "1 2 3 4 5 6 7 8 9";
       use.reversedString(reverseStr);
        System.out.println();

    String checkElfish="whiteleaf";
        System.out.println("For whiteleaf  "+use.isElfish(checkElfish));
        checkElfish="tasteful";
        System.out.println("For tasteful   "+use.isElfish(checkElfish));
        checkElfish="unfriendly";
        System.out.println("For unfriendly "+use.isElfish(checkElfish));
        checkElfish= "waffles";
        System.out.println("For waffles    "+use.isElfish(checkElfish));
        checkElfish= "wafflEs";
        System.out.println("For wafflEs    "+use.isElfish(checkElfish));
        checkElfish= "wXYZDASDeF";
        System.out.println("For wXYZDASDeF "+use.isElfish(checkElfish));
        checkElfish= "wXYZlDASD";
        System.out.println("For wXYZlDASD  "+use.isElfish(checkElfish));

        int[] unsortedArr1={10, 20, 80, 30, 60, 50, 110, 100, 130, 170};
        int[] unsortedArr2={0, 0, 0, 0, 0};
        int[] unsortedArr3={0, 3, 1, -2, 4, -1, 2, 5, 6, 7};
        int[] unsortedArr4={10, 14, 28, 11, 7, 16, 30, 50, 25, 18};
        int[] unsortedArr5={15, 4, 9 ,3 ,2, 12, 11, 14, 21, 24, 1, 1};
        use.sort(unsortedArr1);
        for(int i=0; i<unsortedArr1.length; i++){
                 System.out.print(unsortedArr1[i]+" ");
        }
        System.out.println();
        use.sort(unsortedArr2);
        for(int i=0; i<unsortedArr2.length; i++){
            System.out.print(unsortedArr2[i]+" ");
        }
        System.out.println();
        use.sort(unsortedArr3);
        for(int i=0; i<unsortedArr3.length; i++){
            System.out.print(unsortedArr3[i]+" ");
        }
        System.out.println();
        use.sort(unsortedArr4);
        for(int i=0; i<unsortedArr4.length; i++){
            System.out.print(unsortedArr4[i]+" ");
        }
        System.out.println();
        use.sort(unsortedArr5);
        for(int i=0; i<unsortedArr5.length; i++){
            System.out.print(unsortedArr5[i]+" ");
        }
        System.out.println();

    String prefix="-+8/632";
        System.out.println("Given prefix is "+prefix+" and output must be 8 ===>"+use.evaluatePrefix(prefix));
        prefix="-+7*45+20";
        System.out.println("Given prefix is "+prefix+" and output must be 25 ===>"+use.evaluatePrefix(prefix));
        prefix="-/*2*5+3652";
        System.out.println("Given prefix is "+prefix+" and output must be 16 ===>"+use.evaluatePrefix(prefix));
        prefix="+54";
        System.out.println("Given prefix is "+prefix+" and output must be 9 ===>"+use.evaluatePrefix(prefix));


    String postfix="231*+9-";
        System.out.println("Given postfix is "+postfix+" and output must be -4 ===>"+use.evaluatePostfix(postfix));
        postfix="53+82-*";
        System.out.println("Given postfix is "+postfix+" and output must be 48 ===>"+use.evaluatePostfix(postfix));
        postfix="53+62/*35*+";
        System.out.println("Given postfix is "+postfix+" and output must be 39 ===>"+use.evaluatePostfix(postfix));
        postfix="12345*+*+";
        System.out.println("Given postfix is "+postfix+" and output must be 47 ===>"+use.evaluatePostfix(postfix));

    int[][] fiveOfive= {{1 ,2 ,3 ,4 ,5 },
                         {16,17,18,19,6 },
                         {15,24,25,20,7 },
                         {14,23,22,21,8 },
                         {13,12,11,10,9 }};
    int[][] sevenOfive= {{1 ,2 ,3 ,4 ,5 },
                        {20,21,22,23,6 },
                        {19,32,33,24,7 },
                        {18,31,34,25,8 },
                        {17,30,35,26,9 },
                        {16,29,28,27,10 },
                        {15,14,13,12,11 }};
    int [][] fiveOfour = {{0,1,2,3},
                         {13,14,15,4},
                         {12,19,16,5},
                         {11,18,17,6},
                         {10,9,8,7}};
    int [][] fourOfour={    {0,1,2,3},
                            {11,12,13,4},
                            {10,15,14,5},
                            {9,8,7,6}};
    int [][] fourOfive= {{1 ,2 ,3 ,4 ,5 },
                        {14,15,16,17,6 },
                        {13,20,19,18,7 },
                        {12,11,10,9,8 }};
    int [][] sixOthree = {{1,2,3},
                        {20,21,4},
                        {13,14,5},
                        {12,15,6},
                        {11,16,7},
                        {10,9,8}};
       System.out.println("Print for the fiveXfive last one must be 25");
        use.print(fiveOfive);
        System.out.println();
        System.out.println("Print for the sevenXfive last one must be 35");
        use.print(sevenOfive);
        System.out.println();
        System.out.println("Print for the fiveXfour last one must be 19");
        use.print(fiveOfour);
        System.out.println();
        System.out.println("Print for the fourXfour last one must be 15");
        use.print(fourOfour);
        System.out.println();
        System.out.println("Print for the fourXfive last one must be 20 ");
        use.print(fourOfive);
        System.out.println();
        System.out.println("Print for the sixXthree last one must be 16");
        use.print(sixOthree);
        System.out.println();
    }
}
