/**
 * Created by equation on 17-8-30.
 */
public class reverse {
    public static int reverse(int n){
        int[] a = new int[7];
        int i=0;
        int k=1;
        if(n<0) {
            k=-1;
            n = -1*n;
        }
        for(;i<7;i++){
            if(n/10!=0){
                a[i] = n%10;
                n = n/10;
            }else{
                a[i] = n;
                break;
            }
        }

        int result = 0;
        for(int j=0;j<=i;j++){
            System.out.println(a[j]);
            result += a[j]*Math.pow(10,i-j);
        }

        return k*result;

    }

    public static int reverse1(int x){
        int INT_MAX = 2147483647;
        int INT_MIN = -2147483648;
        long result=0;
        while(x!=0){
            result = result*10 + x%10;
            x = x/10;
        }

        if(result>INT_MAX||result<INT_MIN) return 0;

        return (int)result;
    }
}
