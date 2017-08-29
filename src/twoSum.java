import java.util.HashMap;

/**
 * Created by equation on 17-8-29.
 */
public class twoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] result = new int[2];
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }

        for(int i=0;i<nums.length;i++){
            int temp = target - nums[i];
            if(map.containsKey(temp)&&map.get(temp)!=i){
                int j = map.get(temp);
                if(i<j){
                    result[0] = i;
                    result[1] = j;
                }else{
                    result[0] = j;
                    result[1] = i;
                }
                break;
            }
        }
        return result;
    }
}
