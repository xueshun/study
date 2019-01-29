package geekbang.wz.sort;

/**
 * <pre>类名: InsertionSort</pre>
 * <pre>描述: 插入排序</pre>
 * <pre>日期: 2019/1/29 14:30</pre>
 * <pre>作者: xueshun</pre>
 */
public class InsertionSort {


    /**
     * @param a 需要排序的数组
     * @param n 需要排序的数组的长度
     * @return
     * @Description: 插入排序
     * @author xueshun
     * @date 2019/1/29 14:32
     */
    public void insertionSort(int[] a, int n) {
        // [1] 判断数组的长度是否合法
        if (n <= 1) {
            return;
        }

        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            // [2] 查找插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    // [3] 数据移动
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            //[4] 插入数据
            a[j + 1] = value;
        }
    }
}
