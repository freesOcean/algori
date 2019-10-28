
public class find {

    public static void main(String[] args) {
        int[] a = new int[] { 2, 2, 2, 4, 5, 23 };

        int n = 6;

        find f = new find();
        int re = f.find_1(a, 6, 6);
        int re2 = f.find_2(a, 0, 5,5);
        System.out.println(re);
        System.out.println(re2);

        int re3 = f.find_first_e(a,6,2);
        System.out.println(re3);
        int re4 = f.find_last_e(a,6,2);
        System.out.println(re4);

        int re5 = f.find_first_more(a, n, 2);
        System.out.println(re5);


        int re6 = f.find_last_less(a, n, 2);
        System.out.println(re6);
    }

    /**
     * 快速排序
     * 
     * @return
     */
    public int find_1(int[] a, int n, int t) {

        int low = 0;
        int heigh = n - 1;
        int mid = 0;
        while (low <= heigh) {
            mid = low + ((heigh - low) >> 1);
            if (a[mid] == t) {
                return mid;
            } else if (t > a[mid]) {
                low = mid + 1;
            } else {
                heigh = mid - 1;
            }

        }
        return -1;

    }

    /**
     * 
     * 快速排序：递归写法
     * @param a
     * @param low
     * @param heigh
     * @param t
     * @return
     */
    public int find_2(int[] a, int low, int heigh, int t) {

        if (low > heigh)
            return -1;

        int mid = low + ((heigh - low) >> 1);

        if (a[mid] == t)
            return mid;

        if (t < a[mid]) {
            return find_2(a, low, mid - 1, t);
        } else {
            return find_2(a, mid + 1, heigh, t);
        }
    }


    /**
     * 查找数组第一个和要查找值相等的元素
     * 先利用二分法查找到该元素，找到后，查看左侧是否有。
     * 如果没有，说明当前就是第一个。否则继续向左寻找。
     * @return
     */
    public int find_first_e(int[]a,int n,int t){
        //先找到该值
        int index = find_1(a, n, t);
        if(index==-1) return -1;

        //判断左侧
        
        for(int i= index-1;i>=0;--i){
            if(a[i] == a[index]){
                index = i;
            }
        }

        return index;
    }

    public int find_first_e_final(int[]a,int n,int t){
        int low = 0;
        int heigh = n-1;
        while(low<=heigh){
            int mid = low +((heigh-low)>>1);
            if(t<a[mid]){
                heigh = mid-1;
            }else if(t>a[mid]){
                low = mid +1;
            }else{
                if(mid==0 && a[mid-1]!=t) return mid;
                else heigh = mid-1;
            }
        }

        return -1;

    }

    /**
     * 查找最后一个等于要查找值得位置
     * @param a
     * @param n
     * @param t
     * @return
     */
    public int find_last_e(int[]a,int n,int t){
        //先找到该值
        int index = find_1(a, n, t);
        if(index==-1)return -1;

        //判断右侧

        for(int i=index+1;i<n;++i){
            if(a[i]==a[index]){
                index = i;
            }
        }

        return index;
    }

    public int find_last_e_final(int[]a,int n,int t){
        int low = 0;
        int heigh = n-1;
        
        while(low<=heigh){
            int mid = low+((hei-heigh)>>1);
            if(t>a[mid]){
                low = mid+1 ;
            }else if(t<a[mid]){
                heigh = mid -1;
            }else{
                if(mid==n-1||a[mid+1]!=t) return mid;
                else low = mid +1;
            }
        }
    }

    /**
     * 查找第一个大于等于要查找的值得位置
     * @param a
     * @param n
     * @param t
     * @return
     */
    public int find_first_more(int[]a,int n,int t){
        int index = find_first_e(a, n, t);
        if(index!=-1)return index;

        //二分法查找
        int low = 0;
        int heigh = n-1;
        int more = -1;
        while(low<=heigh){
            int mid = low + ((heigh-low)>>1);
            if(t>a[mid]){
                low = mid+1;
            }else{
                heigh = mid-1;
                more = mid;
            }
        }
        return more;
    }

    /**
     * 查找最后一个小于等于要查找的值得位置
     * @param a
     * @param n
     * @param t
     * @return
     */
    public int find_last_less(int[]a,int n,int t){

        int index = find_last_e(a, n, t);
        if(index!=-1) return index;

        //二分法查找
        int low = 0;
        int heigh = n-1;
        int less = -1;
        while(low<=heigh){
            int mid = low + ((heigh-low)>>1);
            if(t>a[mid]){
                low = mid + 1;
                less = mid;
            }else{
                heigh = mid -1;
            }
        }

        return less;

    }


}