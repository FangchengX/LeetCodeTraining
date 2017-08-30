import java.util.Arrays;

/**
 * Created by equation on 17-8-30.
 */
public class longestPalindromic {
    public static String findLongestPalindromic(String s){
        char[] chars = s.toCharArray();
        int n = chars.length;
        int head=0,end=0,head_temp=0,end_temp=0;
        for(int i=0;i<n;i++){
            head_temp=i;
            end_temp=i;
            while(chars[head_temp]==chars[end_temp]){
                head_temp--;
                end_temp++;
                if(head_temp==-1||end_temp==n) break;
            }
            if(end-head<end_temp-head_temp){
                end=end_temp;
                head=head_temp;
            }
            head_temp=i;
            end_temp=i+1;
            while(end_temp!=n&&chars[head_temp]==chars[end_temp]){
                head_temp--;
                end_temp++;
                if(head_temp==-1) break;
            }
            if(end-head<end_temp-head_temp){
                end=end_temp;
                head=head_temp;
            }
        }
        String result="";
        for(int i=head+1;i<end;i++){
            result = result+chars[i];
        }
        return result;
    }

    public static String findPalindromic(String s){
        String T=preprocess(s);
        int n = T.length();
        int[] P = new int[n];
        int center = 0;
        int right = 0;
        for(int i=1;i<n;i++){
            int mirror_i = 2*center-i;
            P[i] = right>i?Math.min(P[mirror_i],right-i):0;

            while(i+P[i]<n-1&&i-P[i]>0&&T.charAt(i+P[i]+1)==T.charAt(i-P[i]-1)){
                P[i]++;
            }

            if(P[i]<P[center]){
                center = i;
                right = i+P[i];
            }
        }

        int length=0;
        for(int i=0;i<n;i++){
            if(P[i]>length){
                length = P[i];
                center = i;
            }
        }

        String result="";
        for(int i=center-P[center];i<center+P[center]+1;i++){
            char ch = T.charAt(i);
            if(ch!='#'){
                result = result+ch;
            }
        }

        return result;
    }

    private static String preprocess(String s){
        int n = s.length();
        if(n==0) return "^$";
        String t = "^";
        for(int i=0;i<n;i++){
            t = t+"#"+s.charAt(i);
        }
        t = t+"#$";
        return t;
    }
}
