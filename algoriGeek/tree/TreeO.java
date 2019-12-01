
public class TreeO{
    public static void main(String[] args) {
        TreeO t = new TreeO();
        int re = t.fbnq(12);
        System.out.println(re);

        int []a = {1,2,3,4,5};
        int n = 5;

        t.quanpailie(a, n, n);
    }


    /**
     * 斐波那契数列
     * @param n
     * @return
     */
    public int fbnq(int n){
        if(n==1){
            return 1;
        }else if(n==2){
            return 1;
        }

        return fbnq(n-1)+fbnq(n-2);

    }

    /**
     * 全排列：
     * 如果有n项:1,2,3,...,n，如果确定了最后一个数，则转换为f(n-1)的全排列问题，最后一个数有n个选择。所以转换为如下：
     * {1,f(n-1)},{2,f(n-1)....}
     * 
     * @param a 要全排列的数据集合
     * @param n 数组的长度
     * @param k 要排列的元素个数，例如确定了一位，则剩余n-1个要进行排列。确定了n-1位，则只有一位要进行确认。
     */
    public void quanpailie(int[]a,int n,int k){
        if(k==1){//已经全部确认位置
            for(int i=0;i<n;++i){
                System.out.print(a[i]);
            }
            System.out.println();
        }

        //从最后取一位，转为求f(k-1)
        for(int j = 0;j<k;++j){
            int temp = a[j];
            a[j] = a[k-1];
            a[k-1] = temp;

            quanpailie(a, n, k-1);

            temp = a[j];
            a[j] = a[k-1];
            a[k-1] = temp;

        }

    }
}