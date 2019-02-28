package geekbang.wz.sort1;

/**
 * <pre>类名: SelectionSort</pre>
 * <pre>描述: 选择排序</pre>
 * <pre>日期: 2019/1/29 15:59</pre>
 * <pre>作者: xueshun</pre>
 */
public class SelectionSort {

    /**
     * @param array 需要排序的数组
     * @return
     * @Description: 选择排序
     * @author xueshun
     * @date 2019/1/29 16:00
     */
    public static void selectionSort(int[] array) {
        int n = array.length;

        // [1] 判断数组的合理性
        if (n <= 1) {
            return;
        }

        for (int i = 0; i < n - 1; ++i) {
            // [2] 查找最小值
            int minIndex = i;
            for (int j = i + 1; j < n; ++j) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            // [3] 交换
            int tmp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] array = {13, 14, 94, 33, 82, 25, 59, 94, 65, 23};
        selectionSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
