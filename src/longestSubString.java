

/**
 * Created by equation on 17-8-29.
 */
public class longestSubString {
    public static int longestSubString(String s){
        char[] chars = s.toCharArray();
        int head=0;
        int end=1;
        int length=0;
        int length_temp=0;
        if(chars.length<=1) return chars.length;
        for(;end<chars.length;end++){
            for(int j=head;j<end;j++){
                if(chars[j]==chars[end]){
                    length_temp = end-head;
                    length = Math.max(length,length_temp);
                    head = j+1;
                    break;
                }
            }
        }
        length_temp = end-head;
        length = Math.max(length,length_temp);
        return length;
    }
}
