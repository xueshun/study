package geekbang.wz.serch.binary;

/**
 * <pre>类名: BinarySerach</pre>
 * <pre>描述: 二分查询</pre>
 * <pre>日期: 2019/2/28 9:36</pre>
 * <pre>作者: xueshun</pre>
 */
public class BinarySerach {

    /**
     * @param a     需要查询的数组
     * @param value 需要查询的数据
     * @return int
     * @Description: 二分查找[非递归]
     * @author xueshun
     * @date 2019/2/28 9:40
     */
    public static int binarySerach(int[] a, int value) {
        if (a.length < 0) {
            return 0;
        }
        int low = 0;
        int high = a.length - 1;
        // [1] 循环退出条件 不是low<high
        while (low <= high) {
            // [2] 如果low和high比较大时，可以更改为low+(high-low)/2, low + ((high-low)>>1)
            int mid = (low + high) / 2;
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] < value) {
                // [3] low = mid+1;high = mid-1 ;如果直接写成high=mid;low=mid,容易造成死循环
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * @param a     需要查找的数组
     * @param n     需要查找的数组长度
     * @param value 需要查找的值
     * @return int  需要查找值的下标
     * @Description: 二分查找[递归实现]
     * @author xueshun
     * @date 2019/2/28 9:53
     */
    public static int binarySerach(int[] a, int n, int value) {
        return binarySerachInternally(a, 0, n - 1, value);
    }


    /**
     * @param a
     * @param low
     * @param high
     * @param value
     * @return
     */
    private static int binarySerachInternally(int[] a, int low, int high, int value) {
        if (low > high) {
            return -1;
        }
        int mid = low + ((high - low) >> 1);
        if (a[mid] == value) {
            return mid;
        } else if (a[mid] < value) {
            return binarySerachInternally(a, mid + 1, high, value);
        } else {
            return binarySerachInternally(a, low, mid - 1, value);
        }
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] a = {1, 3, 7, 9, 15, 23, 35};
        System.out.println(binarySerach(a, 15));
        System.out.println(binarySerach(a, a.length, 15));
    }
}
