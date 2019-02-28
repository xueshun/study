package geekbang.wz.sort.quick;

/**
 * <pre>类名: QuickSort</pre>
 * <pre>描述: 快速排序</pre>
 * <pre>日期: 2019/2/14 9:40</pre>
 * <pre>作者: xueshun</pre>
 */
public class QuickSort {

    /**
     * 快速排序
     *
     * @param a
     * @param n
     */
    public static void quickSort(int[] a, int n) {
        quickSortInternally(a, 0, n - 1);
    }

    /**
     * 快速排序递归函数
     *
     * @param a 需要排序的数组
     * @param p 下标
     * @param r 下标
     */
    private static void quickSortInternally(int[] a, int p, int r) {
        // [1] 终止条件
        if (p >= r) {
            return;
        }

        // [2] 获取分区点
        int q = partition(a, p, r);
        quickSortInternally(a, p, q - 1);
        quickSortInternally(a, q + 1, r);
    }

    /**
     * 获取分区点
     *
     * @param a 需要排序的数组
     * @param p 起始下标
     * @param r 终止下标
     * @return
     */
    private static int partition(int[] a, int p, int r) {
        // [1] 默认取数组的尾部做为对比的标准
        int pivot = a[r];
        int i = p;
        for (int j = p; j < r; j++) {
            if (a[j] < pivot) {
                if (i == j) {
                    ++i;
                } else {
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }
        }

        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;

        System.out.println("i=" + i);
        return i;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 7, 2, 4, 8, 5};
        quickSort(a, a.length);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ";");
        }
    }
}
