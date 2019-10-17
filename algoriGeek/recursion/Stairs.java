
public class Stairs{

    /**
     * 爬楼梯：每次可以选择1步或者两步往上爬。n阶台阶，有多少种爬法。
     * 
     * 如果第一步走1步，则问题转换为求剩余 n-1阶的走法
     * 如果第一步走2步，则问题转换为求剩余 n-2阶的走法
     * 所以求解f(n) = f(n-1)+f(n-2)
     * 
     * 边界条件：n=1 时，或者n=2时 终止。
     * 
     * @param n
     * @return
     */
    public int f(int n){
        if(n<=0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }

        return f(n-1)+f(n-2);

    }

    /**
     * 非递归求法
     */
    public int ways(int n){
        if(n<=0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }

        int pre = 2;
        int presion = 1;
        int ret = 0;

        for(int i=3;i<=n;i++){
            ret = pre+presion;
            pre = presion;
            presion = ret;
        }
        return ret;
    }

    public int fei(int n){
        if(n==1||n==2){
            return 1;
        }

        return fei(n-1)+fei(n-2);
    }

    public static void main(String[] args) {
        Stairs t = new Stairs();

        int re = t.f(19);
        int re2 = t.fei(20);
        System.out.println(re);
    }
}