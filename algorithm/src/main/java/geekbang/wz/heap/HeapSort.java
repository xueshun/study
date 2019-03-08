package geekbang.wz.heap;

/**
 * <pre>类名: HeapSort</pre>
 * <pre>描述: 堆排序 - 大顶堆</pre>
 * <pre>日期: 2019/3/7 13:59</pre>
 * <pre>作者: xueshun</pre>
 */
public class HeapSort {

    /**
     * 建立大顶堆
     * 从数组后往前插入 （从下往上堆化）
     *
     * @param a
     * @return
     */
    public void buildMaxHeap(int[] a) {
        for (int i = (a.length - 2) / 2; i >= 0; i--) {
            adjustDownToUp(a, i, a.length);
        }
    }

    private void adjustDownToUp(int[] array, int k, int length) {
        int temp = array[k];
        for (int i = 2 * k + 1; i < length - 1; i = 2 * i + 1) {    //i为初始化为节点k的左孩子，沿节点较大的子节点向下调整
            if (i < length && array[i] < array[i + 1]) {  //取节点较大的子节点的下标
                i++;   //如果节点的右孩子>左孩子，则取右孩子节点的下标
            }
            if (temp >= array[i]) {  //根节点 >=左右子女中关键字较大者，调整结束
                break;
            } else {   //根节点 <左右子女中关键字较大者
                array[k] = array[i];  //将左右子结点中较大值array[i]调整到双亲节点上
                k = i; //【关键】修改k值，以便继续向下调整
            }
        }
        array[k] = temp;  //被调整的结点的值放人最终位置
    }

    /**
     * 排序
     *
     * @param array
     */
    public void sort(int[] array) {
        buildMaxHeap(array);
        for (int i = array.length - 1; i > 1; i--) {
            int temp = array[0];  //将堆顶元素和堆低元素交换，即得到当前最大元素正确的排序位置
            array[0] = array[i];
            array[i] = temp;
            adjustDownToUp(array, 0, i);  //整理，将剩余的元素整理成堆
        }
    }
}
