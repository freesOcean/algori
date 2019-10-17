
/**
 * 快速排序利用了递归来实现，是归纳证明得来。
 * 
 * 核心思想：如果选取一个povit，把大于它的放在右边，小于的放在左边。 如果左右有序则 左+povit+右 就是完整的有序数组。
 * 而如果是三个元素，利用这种方式两侧必然是有序的。既然三个元素可以得出。
 * 四个元素，分隔成一个元素和3个元素，对三个元素快排。以此类推，任意个数，经过分隔迭代，都可以最终排成有序的。
 */
public class quick_sort {

    public void quickSort(int[] a, int p, int r) {
        if (p >= r)
            return;
        int q = partition(a, p, r);
        quickSort(a, p, q - 1);
        quickSort(a, q + 1, r);
    }

    public int partition(int[] a, int start, int end) {
        int povit = a[end];
        int i = start;
        // 循环，将大于povit的放在i的一侧
        for (int j = start; j < end; ++j) {
            if (a[j] < povit) {
                if (i == j) {
                    ++i;
                } else {
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                    i++;
                }
            }
        }

        int tmp = a[i];
        a[i] = povit;
        a[end] = tmp;
        return i;
    }

}