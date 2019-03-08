package geekbang.wz.heap;

/**
 * <pre>类名: Heap</pre>
 * <pre>描述: 堆</pre>
 * <pre>日期: 2019/3/8 13:33</pre>
 * <pre>作者: xueshun</pre>
 */
public class Heap {
    /**
     * 数组，从下标1开始存储数据
     */
    private int[] array;

    /**
     * 堆可以存储数据的最大数据个数
     */
    private int capacity;

    /**
     * 堆中已经存储的数据个数
     */
    private int stored;

    public Heap(int capacity) {
        array = new int[capacity + 1];
        this.capacity = capacity;
        stored = 0;
    }


    /**
     * 向堆中插入数据
     *
     * @param data
     */
    public void insert(int data) {
        //[1] 判断堆是否已经存满
        if (stored >= capacity) {
            return;
        }

        ++stored;
        array[stored] = data;
        int i = stored;
        // 判断新插入的数据是否大于其父节点
        while (i / 2 > 0 && array[i] > array[i / 2]) {
            // 从下往上堆化
            swap(array, i, i / 2);
            i = i / 2;
        }
    }

    /**
     * 删除堆顶数据
     */
    public void removeMax() {
        if (stored == 0) {
            return;
        }
        array[1] = array[stored];
        --stored;
        heapify(array, stored, 1);
    }

    /**
     * 从上往下堆化
     */
    private void heapify(int[] array, int endIndex, int beginIndex) {
        while (true) {
            int maxPox = beginIndex;
            if (beginIndex * 2 <= endIndex && array[beginIndex] < array[beginIndex * 2]) maxPox = beginIndex * 2;
            if (beginIndex * 2 + 1 <= endIndex && array[maxPox] < array[beginIndex * 2 + 1])
                maxPox = beginIndex * 2 + 1;
            if (maxPox == beginIndex) break;
            swap(array, beginIndex, maxPox);
            beginIndex = maxPox;
        }
    }

    /**
     * 交换下标为i和i/2的两个数据
     *
     * @param array
     * @param beginIndex
     * @param endIndex
     */
    private void swap(int[] array, int beginIndex, int endIndex) {
        int temp = array[beginIndex];
        array[beginIndex] = array[endIndex];
        array[endIndex] = temp;
    }

    public void forEach() {
        for (int i = 0; i < array.length; i++) {
            System.out.println(i + " : " + array[i]);
        }
    }
}
