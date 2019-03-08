package geekbang.wz.heap;

public class Run {

    public static void main(String[] args) {
        int[] a = {7, 5, 19, 8, 4, 1, 20, 13, 16};
        HeapSort heapSort = new HeapSort();
        heapSort.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

        System.out.println("--------------------------");
        Heap heap = new Heap(9);
        heap.insert(7);
        heap.insert(5);
        heap.insert(19);
        heap.insert(8);
        heap.insert(4);
        heap.insert(1);
        heap.insert(20);
        heap.insert(13);
        heap.insert(16);
        heap.forEach();

        System.out.println("--------------------------");
        heap.removeMax();
        heap.forEach();
    }
}
