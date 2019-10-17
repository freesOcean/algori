
public class sort_insert {

    /**
     * 插入排序：
     * 已经排好的集合中，是有序的，所以从后往前对比。
     * @param arr
     * @param n
     * @return
     */
    public int[] sort(int[] arr, int n) {

        for (int i = 1; i < arr.length; ++i) {
            int value = arr[i];
            int j = i - 1;
            //查找位置
            for (; j >= 0; --j) {
                if (arr[j] > value) {
                    //移动数据
                    arr[j+1] = arr[j];
                }else{
                    break;
                }
            }
            //插入
            arr[j+1] = value;
        }
        return arr;
    }

}