
public class sort_insert {

    /**
     * 插入排序： 已经排好的集合中，是有序的，所以从后往前对比。
     * 
     * @param arr
     * @param n
     * @return
     */
    public int[] sort(int[] arr, int n) {

        for (int i = 1; i < arr.length; ++i) {
            int value = arr[i];
            int j = i - 1;
            // 查找位置
            for (; j >= 0; --j) {
                if (arr[j] > value) {
                    // 移动数据
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            // 插入
            arr[j + 1] = value;
        }
        return arr;
    }

    /**
     * 选择排序: 思想也是分为已排区间和未排区间，只是每次都在未排区间中选择最大的值，直接放在已排区间的尾部
     * 
     * @param a
     * @param n
     */
    public void xuanze_sort(int[] a, int n) {
        if (n < 1)
            return;

        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; ++j) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            // 交换
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }

}