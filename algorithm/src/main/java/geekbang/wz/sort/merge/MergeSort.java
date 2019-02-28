package geekbang.wz.sort.merge;

/**
 * <pre>类名: MergeSort</pre>
 * <pre>描述: 归并排序算法</pre>
 * <pre>日期: 2019/2/13 10:22</pre>
 * <pre>作者: xueshun</pre>
 */
public class MergeSort {

    /**
     * @param a 需要排序的数组
     * @param n 数组大小
     */
    public static void mergeSort(int[] a, int n) {
        mergeSortInternally(a, 0, n - 1);
    }

    /**
     * 递归调用函数
     *
     * @param a 需要排序的数组
     * @param p 数组排序的起始位置
     * @param r 数组排序的终止位置
     */
    private static void mergeSortInternally(int[] a, int p, int r) {
        // [1] 终止条件
        if (p >= r) {
            return;
        }

        // [2] 取p -> r的中间位置q,防止（p+r）的和超过int类型最大值
        int q = p + (r - p) / 2;

        // [3] 分治递归
        mergeSortInternally(a, p, q);
        mergeSortInternally(a, q + 1, r);

        // [4] 将A[p...q]和A[q+1...r]合并为A[p...r]
        merge(a, p, q, r);
    }

    /**
     * 将排序好的子数组合并
     *
     * @param a 需要排序的数组
     * @param p 数组排序的起始位置
     * @param q 数组排序的中间位置
     * @param r 数组排序的终止位置
     */
    private static void merge(int[] a, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int k = 0;
        // [1] 申请一个大小跟a[p...r]一样的临时数组
        int[] temp = new int[r - p + 1];

        while (i <= q && j <= r) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }

        // [2] 判断哪个子数组中有剩余的数据
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }

        // [3] 将剩余的数据拷贝到临时数组temp
        while (start <= end) {
            temp[k++] = a[start++];
        }

        // [4] 将temp中的数组拷贝到a[p....r]
        for (i = 0; i <= r - p; ++i) {
            a[p + i] = temp[i];
        }

    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] a = {1, 3, 7, 2, 4, 8, 5};
        mergeSort(a, a.length);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ";");
        }
    }
}
