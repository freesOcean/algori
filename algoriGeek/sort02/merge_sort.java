
public class merge_sort{

    /**
     * 传入数组和数组长度
     * @param a
     * @param n
     */
    public void mergeSort(int[]a,int n){
        mergeSortInternal(a,0,n-1);
    }

    public void mergeSortInternal(int[]a,int p,int r){
        //基线条件
        if(p>=r) return;

        //计算中间位置
        int q = p+(r-p)/2;

        mergeSortInternal(a, p, q);
        mergeSortInternal(a, q+1, r);

        // merge(a,p,q,r);
        mergeGuad(a, p, q, r);

    }

    public void merge(int[]a,int p,int q,int r){
        //申请一个和a相同大小的数组
        int[] tmp = new int[r-p+1];
        //合并数组
        int i = p;
        int j = q+1;
        int k = 0;
        while(i<=q && j<=r){
            if(a[i]<=a[j]){
                tmp[k++] = a[i++];
            }else{
                tmp[k++] = a[j++];
            }
        }

        //判断哪个数组还有剩余
        int start = i;
        int end = q;
        if(j<=r){
            start = j;
            end = r;
        }
        while(start<=end){
            tmp[k++] = a[start++];
        }

        //将合并的数组拷贝到数组a
        for(i=p;i<=r;++i){
            a[i] = tmp[i-p];
        }

    }


    public void mergeGuad(int[]a,int p,int q,int r){
        
        int[] leftArr = new int[q-p+2];
        int[] rightArr = new int[r-q+1];

        //给要合并的两个数组分别添加哨兵节点
        for(int i=p;i<=q-p;++i){
            leftArr[i-p] = a[i];
        }

        leftArr[q-p+1] = Integer.MAX_VALUE;

        for(int j=q+1;j<=r;++j){
            rightArr[j-q-1] = a[j];
        }

        rightArr[r-q] = Integer.MAX_VALUE;

        int k = p;
        int i=0;
        int j =0;
        while(k<=r){
            if(leftArr[i]<=rightArr[j]){
                a[k++] = leftArr[i++];
            }else{
                a[k++] = rightArr[j++];
            }
        }


    }




    public static void main(String[] args) {
        int[] a = { 2, 1, 8, 11, 6,7 };
        merge_sort s = new merge_sort();
        s.mergeSort(a, 6);

        for(int x:a){
            System.out.println(x);
        }

    }

}