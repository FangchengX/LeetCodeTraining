/**
 * @author fangcheng
 * @since 2020-03-20 23:37
 */
public class CommonPre {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].equals("")) {
                return "";
            }
            int j = 0;
            for (; j < strs[i].length() && j < res.length(); j++) {
                if (res.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            res = res.substring(0, j);
            if (res.length() == 0) {
                break;
            }
        }
        return res;
    }
}
