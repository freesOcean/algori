import java.util.Random;


/**
 * 归并排序和快速排序
 */
public class sort_test3 {
    public static void main(String[] args) {
        int[] a = { 2, 1, 8, 11, 6,7 };
        int n = a.length;
        //快速
        quick_sort quick = new quick_sort();
        quick.quickSort(a, 0, n-1);

        for (int x : a) {
            System.out.println(x);
        }
        
    }

}