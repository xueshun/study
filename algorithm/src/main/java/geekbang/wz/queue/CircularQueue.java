package geekbang.wz.queue;

/**
 * <pre>类名: CircularQueue</pre>
 * <pre>描述: 环形队列 - 基于数组</pre>
 * <pre>日期: 2019/1/28 15:05</pre>
 * <pre>作者: xueshun</pre>
 */
public class CircularQueue {
    private String[] items;
    private int n = 0;
    private int head = 0;
    private int tail = 0;

    public CircularQueue(int capcity) {
        items = new String[capcity];
        this.n = capcity;
    }

    /**
     * @param item 需要入队的数据
     * @return 入队是否成功
     * @Description: 入队
     * @author xueshun
     * @date 2019/1/28 15:10
     */
    public boolean enqueue(String item) {
        // [1] 判断队列是否满了
        if ((tail + 1) % n == head) {
            return false;
        }
        // [2] 添加数据
        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }

    /**
     * @return 队列取出的数据
     * @Description: 出队
     * @author xueshun
     * @date 2019/1/28 15:15
     */
    public String dequeue() {
        // [1] 判断队列中是否存在数据
        if (head == tail) {
            return null;
        }

        // [2] 取出数据
        String ret = items[head];
        head = (head + 1) % n;
        return ret;
    }

    /**
     * @Description: 打印当前队列中数据
     * @author xueshun
     * @date 2019/1/28 15:19
     * @return
     */
    public void printAll() {
        if (0 == n) {
            return;
        }
        for (int i = head; i % n != tail; ++i) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

}
