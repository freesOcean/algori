//sort

public class sort_bubble {

    /**
     * 冒泡排序：顺序排。 思路：取第一个数和第二个比较，如果大于第二个，交换位置，否则拿第二数继续和后边的数比较如此重复。
     * 重复一遍就完成了一次冒泡。然后再取第一个数，进行冒泡，进行n次冒泡就会完全有序。
     * 
     * @param array
     * @param n
     * @return
     */
    public int[] sort(int[] array, int n) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("第" + (i + 1) + "次冒泡");
            int x = array[0];

            for (int j = 1; j < array.length; j++) {
                int y = array[j];
                if (x > y) {
                    array[j] = x;
                    array[j - 1] = y;
                }
                x = array[j];
            }
        }

        return array;

    }

    /**
     * 改进算法：在原先基础上添加判断。因为如果经过数次冒泡，已经完全有序，而后边的冒泡是完全没有必要的。
     * 要判断当前是否已经有序，只需要判断上一次冒泡是否发生了数据交换，如果没有发生，说明目前已经完全有序，就可以停止循环。
     * 
     * @param arr
     * @param n
     * @return
     */
    public int[] sort_e(int[] array, int n) {
        int flag = n - 1;
        for (int i = 0; i < array.length; i++) {
            System.out.println("第" + (i + 1) + "次冒泡");
            if (flag == 0) {
                return array;
            }
            int x = array[0];

            for (int j = 1; j < array.length; j++) {
                int y = array[j];
                if (x > y) {
                    array[j] = x;
                    array[j - 1] = y;
                    flag = n - 1;
                }
                x = array[j];
                --flag;
            }
        }

        return array;

    }

    /**
     * 继续改进： 本质：做n次冒泡。加上判断。 一次冒泡一次循环。因为前一次冒泡已经过滤出了最大值，所以下一次冒泡比较，次数就需要减少。
     * 
     */

    public int[] sort_final(int[] a, int n) {

        if(n<=1){
            return a;
        }
        // 外层循环用于控制冒泡次数
        for (int i = 0; i < n; ++i) {
            boolean flag = false;
            // 内层循环用于冒泡比较
            for (int j = 0; j < n - i - 1; ++j) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        return a;
    }
}