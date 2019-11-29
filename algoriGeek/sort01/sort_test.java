import java.util.Random;

public class sort_test {
    public static void main(String[] args) {
        int[] array = { 2, 0, 4, 1, 6 };

        // 冒泡排序
        sort_bubble s = new sort_bubble();
        int[] re = s.sort(array, 5);
        int[] re2 = s.sort_final(array, 5);

        for (int a : re) {
            System.out.println(a);
        }
        for (int a : re2) {
            System.out.println(a);
        }

        // 插入排序：
        sort_insert s1 = new sort_insert();
        int[] re3 = s1.sort(array, 5);
        System.out.println("插入排序：");
        for (int a : re3) {
            System.out.println(a);
        }

        // 选择排序
        int[] aaa = { 2, 0, 4, 1, 6 };
        s1.xuanze_sort(aaa, 5);
        System.out.println("选择排序：");
        for (int a : aaa) {
            System.out.println(a);
        }
    }

}