import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
       int[] nums = {3,5,1,4,-8};
       int target = 5;
    }

    public static int[] twoSum(int[] nums, int target){
        //O(n) time complexity
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
