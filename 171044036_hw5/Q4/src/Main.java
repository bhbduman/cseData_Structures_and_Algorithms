public class Main {
    public static void main(String[] args){
        MaxHeap<AgeData> heap = new MaxHeap<AgeData>();
        String heapStr;

        heap.add(new AgeData(10));
        heap.add(new AgeData(5));
        heap.add(new AgeData(70));
        heap.add(new AgeData(15));
        heapStr= heap.toString();
        System.out.println(heapStr);


        heap.add(new AgeData(70));
        heap.add(new AgeData(70));
        heap.add(new AgeData(5));
        heap.add(new AgeData(10));
        heap.add(new AgeData(15));
        heapStr= heap.toString();
        System.out.println(heapStr);


        heap.remove(new AgeData(5));
        heapStr= heap.toString();
        System.out.println(heapStr);

        heap.remove(new AgeData(5));
        heapStr= heap.toString();
        System.out.println(heapStr);

        heap.remove(new AgeData(73));
        heapStr= heap.toString();
        System.out.println(heapStr);


        heap.add(new AgeData(5));
        heap.add(new AgeData(5));
        heap.add(new AgeData(5));
        heap.add(new AgeData(15));
        heap.add(new AgeData(23));
        heap.add(new AgeData(45));
        heap.add(new AgeData(11));
        heapStr= heap.toString();
        System.out.println(heapStr);

        System.out.println(heap.find(new AgeData(70)).toString());

        System.out.println(heap.find(new AgeData(10)).toString());

        System.out.println(heap.find(new AgeData(11)).toString());

        System.out.println(heap.find(new AgeData(99)).toString());

        System.out.println(heap.youngerThan(5));
        System.out.println(heap.youngerThan(45));
        System.out.println(heap.youngerThan(13));

        System.out.println(heap.olderThan(70));
        System.out.println(heap.olderThan(45));
        System.out.println(heap.olderThan(44));
        System.out.println();


    }
}
