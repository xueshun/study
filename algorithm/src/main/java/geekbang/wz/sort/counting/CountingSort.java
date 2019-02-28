package geekbang.wz.sort.counting;

/**
 * <pre>类名: CountingSort</pre>
 * <pre>描述: 计数排序</pre>
 * <pre>日期: 2019/2/16 14:32</pre>
 * <pre>作者: xueshun</pre>
 */
public class CountingSort {

    /**
     * 计数排序，假设数组中存储的都是非负整数
     *
     * @param a 数组
     * @param n 数组大小
     */
    public static void countingSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }

        // [1] 查找数组中数据的范围
        int max = a[0];
        for (int i = 1; i < n; i++) {
            if (max < a[i]) {
                max = a[i];
            }
        }

        // [2] 申请一个计数数组c，下标大小[0,max]
        int[] c = new int[max + 1];
        for (int i = 0; i < max + 1; i++) {
            c[i] = 0;
        }


    }
}
