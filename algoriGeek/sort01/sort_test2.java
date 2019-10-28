import java.util.Random;

/**
 * 性能测试
 */
public class sort_test2 {
    public static void main(String[] args) {

        // 冒泡排序
        sort_bubble s = new sort_bubble();
        // 插入排序：
        sort_insert s1 = new sort_insert();
        
        
        // 准备要排序的数组。随机生成10000个数组，每个数组包含200个元素。分别测试冒泡和插入排序算法的时间。
        int num = 10000;
        int count = 200;
        int seed = 2000;
        Random random = new Random();
        int[][] src = new int[num][count];
        for (int i = 0; i < num; i++) {
            int[] arr = new int[count];
            for (int j = 0; j <count; j++){
                arr[j] = random.nextInt(seed);
            }
            src[i] = arr;
        }

         //拷贝一份数组
         int[][] cha = new int[num][count];
         for(int i=0;i<num;i++){
             int[]arr = new int[count];
             for(int j=0;j<count;j++){
                 arr[j] = src[i][j];
             }
             cha[i] = arr;
         }
         //插入排序
         long startCha = System.currentTimeMillis();
         for(int i=0;i<num;i++){
             s1.sort(cha[i], count);
         }
         long endCha = System.currentTimeMillis();
         //计算时间
         long dtimec = endCha - startCha;
         System.out.println("插入时间:"+dtimec);

       
        //拷贝一份数组
        int[][] mao = new int[num][count];
        for(int i=0;i<num;i++){
            int[]arr = new int[count];
            for(int j=0;j<count;j++){
                arr[j] = src[i][j];
            }
            mao[i] = arr;
        }
        //冒泡排序
        long startMao = System.currentTimeMillis();
        for(int i=0;i<num;i++){
            s.sort_final(mao[i], count);    
        }
        long endMao = System.currentTimeMillis();
        //计算时间
        long dtime = endMao - startMao;
        System.out.println("冒泡时间:"+dtime);
        
        
       


    }

}