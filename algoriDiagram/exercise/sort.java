
public class sort {
    public static void main(String[] args) {

    }

    /**
     * 冒泡排序: 时间复杂度是O（n2) 最好：O(n) 最坏：O(n2) n-1,n-2....求和
     * 平均：根据逆序度计算。最坏的无序度：n-1,n-2,...求和 n^2/2 平均 逆序则是 n^2/4 ,
     * 移动次数大于比较次数。而上限是O(n2),平均也是O(n2)
     * 
     * 和插入排序比，交换的逻辑过于复杂，代码较多。
     * 
     * 
     * 稳定排序。 原地排序：空间复杂度O(1)
     * 
     * @param a
     */
    public void sort_1(int[] a, int n) {
        if (n < 1)
            return;
        for (int i = 0; i < n; ++i) {
            boolean flag = true;

            for (int j = 0; j < n - 1 - i; ++j) {
                if (a[j] > a[j + 1]) {
                    // 交换
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    flag = false;
                }
            }

            if (flag) {
                break;
            }
        }
    }

    /**
     * 插入排序：
     * 
     * @param a
     * @param n
     */
    public void sort_2(int[] a, int n) {

        if (n < 1)
            return;

        for (int i = 1; i < n; ++i) {
            int value = a[i];
            for (int j = i - 1; j >= 0; --j) {
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = value;
        }

    }

    /**
     * 选择排序
     * 
     * @param a
     * @param n
     * 
     */
    public void sort_3(int[] a, int n) {
        if (n < 1)
            return;

        for (int i = 0; i < n; ++i) {

            int min_index = i;
            for (int j = i + 1; j < n; ++j) {
                if (a[j] < a[min_index]) {
                    min_index = j;
                }
            }
            int temp = a[i];
            a[i] = a[min_index];
            a[min_index] = temp;

        }
    }
}
