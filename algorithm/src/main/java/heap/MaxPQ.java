package heap;


import java.util.ArrayList;
import java.util.List;

/**
 * 堆是一种基本的数据结构，这里用数组来实现
 * 12                 2
 * 8      10          3     6
 * 6  4   7    9      6  4  7   9
 * <p>
 * 堆的优先排序
 *
 * @author xueshun
 */
public class MaxPQ {

    /**
     * 定义一个数组
     */
    private List<Integer> arr;

    /**
     * 定义队列中的元素个数
     */
    private int N;


    public MaxPQ() {
        this.arr = new ArrayList<>();
        arr.add(1);
        N = 0;
    }

    /**
     * 返回队列是否为空
     *
     * @return empty ? true : false
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * 队列中元素的个数
     *
     * @return
     */
    public int size() {
        return N;
    }


    /**
     * 添加元素
     * 结合末尾，并使用上浮方法到指定的位置
     *
     * @param number
     */
    public void inSert(int number) {
        arr.add(number);
        swim(++N);
    }

    /**
     * 删除方法
     * 删除最大元素并把最小的元素放到第一个，然后使用下浮方法
     * @return
     */
    public int deleteMax() {
        int max = arr.get(1);
        int min  = arr.get(N);
        arr.set(1, min);
        arr.remove(N--);
        sink(1);
        return max;
    }

    /**
     * 上浮方法
     *
     * @param N 数组长度
     */
    public void swim(int N) {
        while (N > 1 && (arr.get(N / 2) < arr.get(N))) {
            int max = arr.get(N);
            int min = arr.get(N / 2);
            arr.set(N, min);
            arr.set(N / 2, max);
            N = N / 2;
        }
    }


    /**
     * 下浮方法
     * @param number
     */
    public void sink(int number) {
        while (number * 2 <= N) {
            int index = number * 2;
            if (index < N && (arr.get(index) < arr.get(index + 1))) {
                index++;
            }
            if (!(arr.get(number) < arr.get(index))) {
                break;
            }

            int max = arr.get(index);
            int min = arr.get(number);
            arr.set(number,max);
            arr.set(index,min);
            number = index;
        }
    }

    @Override
    public String toString() {
        return "MaxPQ [arr=" + arr + ", N=" + N + "]";
    }
}
