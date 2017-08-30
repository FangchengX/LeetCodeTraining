/**
 * Created by equation on 17-8-30.
 */
public class ZigZag {
    public static String ZigZagConversion(String s, int numRows){
        if(numRows==1) return s;
        String[] strs = new String[numRows];
        for(int i=0;i<numRows;i++){
            strs[i] = "";
        }

        for(int i=0;i<s.length();i++){
            if(i%(2*numRows-2)<numRows){
                strs[i%(2*numRows-2)] += s.charAt(i);
            }else{
                strs[2*numRows-2-i%(2*numRows-2)] += s.charAt(i);
            }
        }

        String result = "";
        for(int i=0;i<numRows;i++){
            result += strs[i];
        }
        return result;
    }
}
