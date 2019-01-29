package geekbang.wz.sort;

/**
 * <pre>类名: ShellSort</pre>
 * <pre>描述: 希尔排序</pre>
 * <pre>日期: 2019/1/29 15:17</pre>
 * <pre>作者: xueshun</pre>
 */
public class ShellSort {

    /**
     * @param array 需要排序的数组
     * @return
     * @Description: 希尔排序
     * @author xueshun
     * @date 2019/1/29 15:18
     */
    public void shellSort(int[] array) {
        int number = array.length / 2;
        int i;
        int j;
        int temp;
        while (number >= 1) {
            for (i = number; i < array.length; i++) {
                temp = array[i];
                j = i - number;
                while (j >= 0 && array[i] < temp) {
                    array[j + number] = array[j];
                    j = j - number;
                }
                array[j + number] = temp;
            }
            number = number / 2;
        }
    }
}
