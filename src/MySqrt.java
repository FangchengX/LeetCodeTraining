/**
 * @author fangcheng
 * @since 2020-03-21 00:12
 */
public class MySqrt {
    public static int mySqrt(int x) {
        if (x<=1) return x;
        int left = 0;
        int right = x/2+1;
        int mid;
        while (true) {
            mid = (right+left)/2;
            if (x/mid==mid) {
                return mid;
            }
            if (x/mid<mid) {
                right = mid;
            } else {
                left = mid;
            }
            if (left+1==right) {
                return left;
            }
        }
    }
}
