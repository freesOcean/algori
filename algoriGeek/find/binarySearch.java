

public class binarySearch{

    public static void main(String[]args){
        int[]a = new int[]{1,2,4,4,4,5,6,8};
        binarySearch b = new binarySearch();
        int n = 8;
        int t = 3;
        int re = b.search_first_more(a, n, t);
        System.out.println(re);

    }


    /**
     * 二分法查找：
     * 有序无重复数组，查找给定的值的索引
     * @param a
     * @param n
     * @param t
     * @return
     */
    public int search(int[]a,int n,int t){

        if(n<1) return -1;

        int low = 0;
        int heigh = n-1;

        while(low<=heigh){
            int mid = low + ((heigh-low)>>1);
            if(t==mid){
                return mid;
            }else if(t>a[mid]){
                low = mid +1;
            }else{
                heigh = mid -1;
            }
        }

        return -1;
    }

    /**
     * 基于递归的二分法查找
     * @param a
     * @param n
     * @param t
     * @return
     */
    public int search_1(int[]a,int low,int heigh,int t){
        if(low<heigh) return -1;

        int mid = low + ((heigh-low)>>1);
        if(t==a[mid]) {
            return mid;
        }else if(t>a[mid]){
            return search_1(a, mid+1, heigh, t);
        }else{
            return search_1(a, low,mid-1, t);
        }
    }


    /**
     * 有序可重复数组：查找第一个等于要查找的值
     * @param a
     * @param n
     * @param t
     * @return
     */
    public int search_first(int[]a,int n,int t){
        int low = 0;
        int heigh = n-1;

        while(low<=heigh){
            int mid = low + ((heigh-low)>>1);
            if(t>a[mid]){
                low = mid +1; 
            }else if(t<a[mid]){
                heigh = mid -1;
            }else {
                if(mid == 0 || a[mid-1]!=t){
                    return mid;
                }else{
                    heigh = mid -1;
                }
            }
        }
        return -1;
    }

    public int search_last(int[]a,int n,int t){
        int low = 0;
        int heigh = n-1;
        while(low<=heigh){
            int mid = low + ((heigh -low)>>1);
            if(t>a[mid]){
                low = mid +1 ;
            }else if(t<a[mid]){
                heigh = mid -1;
            }else{
                if(mid == n -1 || a[mid+1]!=t){
                    return mid ;
                }else {
                    low = mid +1;
                }
            }
        }
        return -1;
    }

    public int search_first_more(int[]a,int n,int t){
        int low = 0;
        int heigh = n-1;
        while(low<=heigh){
            int mid = low +((heigh-low)>>1);
            if(t>a[mid]){
                low = mid +1;
            }else if(t<=a[mid]){
                if(mid ==0 || t>a[mid-1]){
                    return mid;
                }else {
                    heigh = mid -1;
                }
            }
        }
        return -1;
    }

}