package geekbang.wz.sort.radix;

/**
 * <pre>类名: RadixSort</pre>
 * <pre>描述: 基数排序</pre>
 * <pre>日期: 2019/2/22 16:40</pre>
 * <pre>作者: xueshun</pre>
 */
public class RadixSort {

    /**
     * @param a 需要排序的数组
     * @return
     * @Description: 基数排序
     * @author xueshun
     * @date 2019/2/22 16:41
     */
    public static void radixSort(int[] a) {
        int exp;
        int max = getMax(a);
        for (exp = 1; max / exp > 0; exp *= 10) {
            countSort(a, exp);
        }
        if (a.length < 0) {
            return;
        }

    }

    /**
     * @param a 数组
     * @return int
     * @Description: 获取数组中最大值
     * @author xueshun
     * @date 2019/2/22 16:49
     */
    private static int getMax(int[] a) {
        int max;
        max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }

    private static void countSort(int[] a, int exp) {
        int[] output = new int[a.length];
        int[] buckets = new int[10];

        for (int i = 0; i < a.length; i++) {
            buckets[(a[i] / exp) % 10]++;
        }

        // 更改buckets[i]。目的是让更改后的buckets[i]的值，是该数据在output[]中的位置。
        for (int i = 1; i < 10; i++) {
            buckets[i] += buckets[i - 1];
        }
        // 将数据存储到临时数组output[]中
        for (int i = a.length - 1; i >= 0; i--) {
            output[buckets[(a[i] / exp) % 10] - 1] = a[i];
            buckets[(a[i] / exp) % 10]--;
        }
        // 将排序好的数据赋值给a[]
        for (int i = 0; i < a.length; i++) {
            a[i] = output[i];
        }
        output = null;
        buckets = null;
    }

    public static void main(String[] args) {
        int i;
        int a[] = {53, 3, 542, 748, 14, 214, 154, 63, 616};

        System.out.printf("before sort:");
        for (i = 0; i < a.length; i++) {
            System.out.printf("%d ", a[i]);
        }
        System.out.printf("\n");

        // 基数排序
        radixSort(a);

        System.out.printf("after  sort:");
        for (i = 0; i < a.length; i++) {
            System.out.printf("%d ", a[i]);
        }

        System.out.printf("\n");
    }
}
