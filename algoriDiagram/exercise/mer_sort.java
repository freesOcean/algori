
public class mer_sort {

    public void doit(int[] a, int n) {

    }

    /**
     * 对数组的下标p - r 进行排序 递归条件：merge(p~a) = merge(merge(p~q) ~ merge(q~a));
     */
    public void merge_sort(int[] a, int p, int r) {
        if (p >= r)
            return;

        // 找到中间点，分成两部分，分别排序，最后合并
        int q = p + ((r - p) >> 1);
        // 分别排序
        merge_sort(a, p, q);
        merge_sort(a, q, r);

        // 合并
        merge(a, p, q, r);
    }

    public void merge(int[] a, int p, int q, int r) {
        // 创建一个临时数组
        int[] temp = new int[r - p + 1];

        int k = 0;
        int i = p;
        int j = q + 1;
        while (i <= q && j <= r) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }

        // 将剩余元素放入temp
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }

        while (start <= end) {
            temp[k++] = a[start++];
        }

        // 复制数组到a
        for (i = 0; i < r - p; ++i) {
            a[p + i] = temp[i];
        }
    }

    /**
     * 哨兵模式
     * 
     * @param a
     * @param p
     * @param q
     * @param r
     */
    public void merge_guard(int[] a, int p, int q, int r) {

        int[] left = new int[q - p + 2];
        int[] right = new int[r - q + 1];

        for (int i = 0; i < q - p + 1; ++i) {
            left[i] = a[p + i];
        }
        left[q - p + 1] = Integer.Max_VALUE;

        for (int j = 0; j < r - q; ++j) {
            right[j] = a[q + j + 1];
        }
        right[r - q] = Integer.MAX_VALUE;

        int k = 0;
        int i = 0;
        int j = 0;
        while (k <= r) {
            if (left[i] <= right[j]) {
                a[k++] = left[i++];
            } else {
                a[k++] = right[j++];
            }
        }

    }

    public void quick_sort(int[] a, int p, int r) {

        if (p >= r)
            return;

        int pivot = getPivot(q, p, r);
        quick_sort(a, p, povit - 1);
        quick_sort(a, pivort + 1, r);

    }

    /**
     * 找一个pivot，然后将大于的放在右边，小于的放在左边，最后返回该pivot
     * 
     * @param a
     * @param p
     * @param r
     * @return
     */
    public int getPivot(int[] a, int p, int r) {

        // 方案1：不考虑空间消耗,建立left和right两个数组，遍历，left中存放
        // 小于pivot的值，right中存放大于pivot的值，最后按顺序拷贝到数组a，完成排序

        // 方案二：原地排序。取最后一个元素作为pivot，思想是用一个游标，将区间A[p,r-1]分为 A[p,i-1] 已处理区间和
        // A[i,r-1]未处理区间，每次都从未处理区间取一个元素，和pivot对比，如果小于pivot，则将该元素放入已处理区间的尾部。
        // 最后将pivot放在未排和已排的中间，结束。
        int i = 0;
        int pivot = a[r];
        for (int j = 0; j < r; ++j) {
            if (a[j] < pivot) {
                if (i == j) {
                    ++i;
                } else {
                    // 交换
                    int temp = a[i];
                    a[i++] = a[j];
                    a[j] = temp;
                }
            }
        }

        // 将pivot和中间位置调换
        int temp = pivot;
        a[r] = a[i];
        a[i] = temp;

        return i;
    }

}