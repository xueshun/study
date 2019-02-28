package geekbang.wz.serch.binary;

/**
 * <pre>类名: BinarySearchRepetition</pre>
 * <pre>描述: 含有重复数据的二分查找</pre>
 * <pre>日期: 2019/2/28 10:46</pre>
 * <pre>作者: xueshun</pre>
 */
public class BinarySearchRepetition {

    /**
     * 二分查找
     *
     * @param a     数组
     * @param n     数组长度
     * @param value 需要查找的值
     * @return
     */
    public static int binarySearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] >= value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (low < n && a[low] == value) {
            return low;
        } else {
            return -1;
        }
    }

    /**
     * 查找最后一个等于给定的值的元素
     *
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int binarySearchLastValue(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 2);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                if ((mid == n - 1) || (a[mid + 1] != value)) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找第一个等于给定的值的元素
     *
     * @param a
     * @param value
     * @return
     */
    public static int binarySearchFirstValue(int[] a, int value) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                if ((mid == 0) || (a[mid - 1] != value)) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }


    /**
     * 查找第一个大于等于给定值的元素
     *
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int binarySearchFirstEqualOrGreaterValue(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] >= value) {
                if ((mid == 0) || (a[mid - 1] < value)) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个小于等于给定值的元素
     *
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int binarySearchLastEqualOrLessValue(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else {
                if ((mid == n - 1) || a[mid + 1] > value) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] a = {1, 3, 7, 9, 15, 15, 15, 23, 35};
        System.out.println(binarySearchFirstValue(a, 15));
        System.out.println(binarySearchLastValue(a, a.length, 15));
        System.out.println(binarySearchFirstEqualOrGreaterValue(a, a.length, 8));
        System.out.println(binarySearchLastEqualOrLessValue(a, a.length, 8));
    }
}
