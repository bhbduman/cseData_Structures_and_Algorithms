import bhb.ArrayListEditor;
import bhb.BaseEditor;
import bhb.LinkedListEditor;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Test {
    public static void main(String[] args){

        LinkedListEditor openText30L =new LinkedListEditor("text30L.txt");
        LinkedListEditor openText300L =new LinkedListEditor("text300L.txt");
        LinkedListEditor openText3000L =new LinkedListEditor("text3000L.txt");
        LinkedListEditor openText6000L =new LinkedListEditor("text6000L.txt");
        LinkedListEditor testLLmethods =new LinkedListEditor("isLinkedlistFunctionsWorks.txt");

        ArrayListEditor openText30A =new ArrayListEditor("text30A.txt");
        ArrayListEditor openText300A =new ArrayListEditor("text300A.txt");
        ArrayListEditor openText3000A =new ArrayListEditor("text3000A.txt");
        ArrayListEditor openText6000A =new ArrayListEditor("text6000A.txt");
        ArrayListEditor testALmethods =new ArrayListEditor("isArraylistFunctionsWorks.txt");

        Logger logger = Logger.getLogger("TextEditorLogs");
        FileHandler fh;


        try {
            /*************************LINKEDLIST******************************************/
            ///Without iterator
            System.out.println();
            System.out.println();
            System.out.println("read method has called\n\n");
            System.out.println();
            testLLmethods.readFile();
            System.out.println(testLLmethods);
            System.out.println("add method has called i inserted 3rd elementh XXX and read file called\n\n");
            System.out.println();
            testLLmethods.add("XXX",3);
            System.out.println();
            System.out.println(testLLmethods);
            System.out.println();
            System.out.println("find method has called i looked for XXX\n\n");
            System.out.println(testLLmethods.findIndex("XXX")+"<==It must be 3");
            System.out.println();
            System.out.println("Change character method has called I will change the A INSTEAD X s and read method will be called\n\n");
            System.out.println();
            testLLmethods.changeChar('X','A');
            System.out.println(testLLmethods);
            System.out.println();
            ///with iterator
            System.out.println();
            System.out.println("read method has called\n\n");
            System.out.println(testLLmethods);
            System.out.println();
            System.out.println("add method has called i inserted 3rd elementh XXX and read file called\n\n");
            System.out.println();
            testLLmethods.iteratorAdd("XXX",3);
            System.out.println(testLLmethods);
            System.out.println();
            System.out.println("find method has called i looked for XXX\n\n");
            System.out.println(testLLmethods.iteratorFindIndex("XXX")+"<==It must be 3");
            System.out.println();
            System.out.println("Change character method has called I will change the A INSTEAD X s and read method will be called\n\n");
            System.out.println();
            testLLmethods.iteratorChangeChar('X','A');
            System.out.println();
            System.out.println(testLLmethods);
            System.out.println();

            /*************************ARRAYLIST******************************************/
            ///Without iterator
            System.out.println();
            System.out.println("read method has called\n\n");
            System.out.println();
            testALmethods.readFile();
            System.out.println();
            System.out.println("add method has called i inserted 3rd elementh XXX and read file called\n\n");
            System.out.println();
            testALmethods.add("XXX",3);
            System.out.println(testALmethods);
            System.out.println();
            System.out.println("find method has called i looked for XXX\n\n");
            System.out.println(testALmethods.findIndex("XXX")+"<==It must be 3");
            System.out.println("Change character method has called I will change the A INSTEAD X s and read method will be called\n\n");
            System.out.println();
            testALmethods.changeChar('X','A');
            System.out.println(testALmethods);
            ///with iterator
            System.out.println();
            System.out.println("read method has called\n\n");
            testALmethods.iteratorReadFile();
            System.out.println();
            System.out.println("add method has called i inserted 3rd elementh XXX and read file called\n\n");
            System.out.println();
            testALmethods.iteratorAdd("XXX",3);
            System.out.println(testALmethods);
            System.out.println();
            System.out.println("find method has called i looked for XXX\n\n");
            System.out.println(testALmethods.iteratorFindIndex("XXX")+"<==It must be 3");
            System.out.println("Change character method has called I will change the A INSTEAD X s and read method will be called\n\n");
            System.out.println();
            testALmethods.iteratorChangeChar('X','A');
            System.out.println(testALmethods);
            System.out.println();

            /*************************CREATING LOG FILLE******************************************/
            fh = new FileHandler("LogFile.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            long time;
            int textSize;
            String listType, iteratorListType;
            listType="List is an ArrayList and iterator  is not used: ";
            iteratorListType="List is LinkedList and iterator used:           ";

            System.out.println("Program started. Maybe the test take a while\n");

            System.out.println("If there is a program which is using memory too much please close it\n");

            logger.info("\nRead Method has called\n");

            time=testReadFile(openText30A);
            createLog(30,time,logger,listType);
            time=testIteratorReadFile(openText30A);
            createLog(30,time,logger,iteratorListType);

            time=testReadFile(openText300A);
            createLog(300,time,logger,listType);
            time=testIteratorReadFile(openText300A);
            createLog(300,time,logger,iteratorListType);

            time=testReadFile(openText3000A);
            createLog(3000,time,logger,listType);
            time=testIteratorReadFile(openText3000A);
            createLog(3000,time,logger,iteratorListType);

            System.out.println("If there is a program which is using memory too much please close it\n");

            time=testReadFile(openText6000A);
            createLog(6000,time,logger,listType);
            time=testIteratorReadFile(openText6000A);
            createLog(6000,time,logger,iteratorListType);


            logger.info("\nAdd Method has called\n");

            time=testAdd(openText30A,15);
            createLog(30,time,logger,listType);
            time=testIteratorAdd(openText30A, 15);
            createLog(30,time,logger,iteratorListType);

            time=testAdd(openText300A,150);
            createLog(300,time,logger,listType);
            time=testIteratorAdd(openText300A, 150);
            createLog(300,time,logger,iteratorListType);

            time=testAdd(openText3000A,1500);
            createLog(3000,time,logger,listType);
            time=testIteratorAdd(openText3000A, 1500);
            createLog(3000,time,logger,iteratorListType);

            System.out.println("If there is a program which is using memory too much please close it\n");

            time=testAdd(openText6000A,3000);
            createLog(6000,time,logger,listType);
            time=testIteratorAdd(openText6000A, 3000);
            createLog(6000,time,logger,iteratorListType);

            logger.info("\nFind Method has called\n");

            time=testFind(openText30A,"zxc");
            createLog(30,time,logger,listType);
            time=testIteratorFind(openText30A, "zxc");
            createLog(30,time,logger,iteratorListType);

            time=testFind(openText300A,"armour");
            createLog(300,time,logger,listType);
            time=testIteratorFind(openText300A, "armour");
            createLog(300,time,logger,iteratorListType);

            time=testFind(openText3000A,"hundred");
            createLog(3000,time,logger,listType);
            time=testIteratorFind(openText3000A, "hundred");
            createLog(3000,time,logger,iteratorListType);

            System.out.println("If there is a program which is using memory too much please close it\n");

            time=testFind(openText6000A,"kicked");
            createLog(6000,time,logger,listType);
            time=testIteratorFind(openText6000A, "kicked");
            createLog(6000,time,logger,iteratorListType);


            logger.info("\nChange Character Method has called\n");

            time=testChangeChar(openText30A);
            createLog(30,time,logger,listType);
            time=testIteratorChangeChar(openText30A);
            createLog(30,time,logger,iteratorListType);

            time=testChangeChar(openText300A);
            createLog(300,time,logger,listType);
            time=testIteratorChangeChar(openText300A);
            createLog(300,time,logger,iteratorListType);

            time=testChangeChar(openText3000A);
            createLog(3000,time,logger,listType);
            time=testIteratorChangeChar(openText3000A);
            createLog(3000,time,logger,iteratorListType);

            System.out.println("If there is a program which is using memory too much please close it\n");

            time=testChangeChar(openText6000A);
            createLog(6000,time,logger,listType);
            time=testIteratorChangeChar(openText6000A);
            createLog(6000,time,logger,iteratorListType);




            listType="List is an LinkedList and iterator is not used: ";
            iteratorListType="List is LinkedList and iterator used:           ";

            logger.info("\nRead Method has called\n");

            time=testReadFile(openText30L);
            createLog(30,time,logger,listType);
            time=testIteratorReadFile(openText30L);
            createLog(30,time,logger,iteratorListType);

            time=testReadFile(openText300L);
            createLog(300,time,logger,listType);
            time=testIteratorReadFile(openText300L);
            createLog(300,time,logger,iteratorListType);

            time=testReadFile(openText3000L);
            createLog(3000,time,logger,listType);
            time=testIteratorReadFile(openText3000L);
            createLog(3000,time,logger,iteratorListType);

            System.out.println("If there is a program which is using memory too much please close it\n");

            time=testReadFile(openText6000L);
            createLog(6000,time,logger,listType);
            time=testIteratorReadFile(openText6000L);
            createLog(6000,time,logger,iteratorListType);


            logger.info("\nAdd Method has called\n");

            time=testAdd(openText30L,15);
            createLog(30,time,logger,listType);
            time=testIteratorAdd(openText30L, 15);
            createLog(30,time,logger,iteratorListType);

            time=testAdd(openText300L,150);
            createLog(300,time,logger,listType);
            time=testIteratorAdd(openText300L, 150);
            createLog(300,time,logger,iteratorListType);

            time=testAdd(openText3000L,1500);
            createLog(3000,time,logger,listType);
            time=testIteratorAdd(openText3000L, 1500);
            createLog(3000,time,logger,iteratorListType);

            System.out.println("If there is a program which is using memory too much please close it\n");

            time=testAdd(openText6000L,3000);
            createLog(6000,time,logger,listType);
            time=testIteratorAdd(openText6000L, 3000);
            createLog(6000,time,logger,iteratorListType);

            logger.info("\nFind Method has called\n");

            time=testFind(openText30L,"zxc");
            createLog(30,time,logger,listType);
            time=testIteratorFind(openText30L, "zxc");
            createLog(30,time,logger,iteratorListType);

            time=testFind(openText300L,"armour");
            createLog(300,time,logger,listType);
            time=testIteratorFind(openText300L, "armour");
            createLog(300,time,logger,iteratorListType);

            time=testFind(openText3000L,"hundred");
            createLog(3000,time,logger,listType);
            time=testIteratorFind(openText3000L, "hundred");
            createLog(3000,time,logger,iteratorListType);

            System.out.println("If there is a program which is using memory too much please close it\n");

            time=testFind(openText6000L,"kicked");
            createLog(6000,time,logger,listType);
            time=testIteratorFind(openText6000L, "kicked");
            createLog(6000,time,logger,iteratorListType);


            logger.info("\nChange Character Method has called\n");

            time=testChangeChar(openText30L);
            createLog(30,time,logger,listType);
            time=testIteratorChangeChar(openText30L);
            createLog(30,time,logger,iteratorListType);

            time=testChangeChar(openText300L);
            createLog(300,time,logger,listType);
            time=testIteratorChangeChar(openText300L);
            createLog(300,time,logger,iteratorListType);

            time=testChangeChar(openText3000L);
            createLog(3000,time,logger,listType);
            time=testIteratorChangeChar(openText3000L);
            createLog(3000,time,logger,iteratorListType);

            System.out.println("If there is a program which is using memory too much please close it\n");

            time=testChangeChar(openText6000L);
            createLog(6000,time,logger,listType);
            time=testIteratorChangeChar(openText3000L);
            createLog(6000,time,logger,iteratorListType);


            System.out.println("Log file has been created");


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private static void createLog(int textSize,long time,Logger logger,String listType){
        int x=1;
        if(listType.equalsIgnoreCase("List is LinkedList and iterator used:           ")){
            x=2;
        }
        logger.info(listType+textSize+"Character=>  "+time/10000+ " ns/10000");
    }
    private static long testReadFile(BaseEditor textFile) throws IOException {
        long startTime= System.nanoTime();
        textFile.readFile();
        long time= System.nanoTime() - startTime;
        return time;
    }
    private static long testIteratorReadFile(BaseEditor textFile) throws IOException {
        long startTime= System.nanoTime();
        textFile.iteratorReadFile();
        long time= System.nanoTime() - startTime;
        return time;
    }
    private static long testAdd(BaseEditor textFile,int index) throws IOException {
        String str="XXX";
        long startTime= System.nanoTime();
        textFile.add("str",index);
        long time= System.nanoTime() - startTime;
        return time;
    }
    private static long testIteratorAdd(BaseEditor textFile, int index) throws IOException {
        String str="XXX";
        long startTime= System.nanoTime();
        textFile.iteratorAdd("str",index);
        long time= System.nanoTime() - startTime;
        return time;
    }
    private static long testFind(BaseEditor textFile, String search) throws IOException {
        long startTime= System.nanoTime();
        textFile.findIndex(search);
        long time= System.nanoTime() - startTime;
        return time;
    }
    private static long testIteratorFind(BaseEditor textFile, String search) throws IOException {
        long startTime= System.nanoTime();
        textFile.iteratorFindIndex(search);
        long time= System.nanoTime() - startTime;
        return time;
    }
    private static long testChangeChar(BaseEditor textFile) throws IOException {
        long startTime= System.nanoTime();
        textFile.changeChar('A','Z');
        long time= System.nanoTime() - startTime;
        return time;
    }
    private static long testIteratorChangeChar(BaseEditor textFile) throws IOException {
        long startTime= System.nanoTime();
        textFile.iteratorChangeChar('A','Z');
        long time= System.nanoTime() - startTime;
        return time;
    }

}
