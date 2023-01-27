import java.util.Arrays;

public class PivotIndex {
    public static void main(String[] args) {
        int[] nums = {-1,-1,0,1,1,0};
        System.out.println(getPivotIndex(nums));
    }

    public static int getPivotIndex(int[] nums){
        //come back to this solution. while it works it times out for large sets of numbers
        for(int i = 0; i < nums.length; i++ ){
            int[] left = Arrays.copyOfRange(nums, 0, i);
            int[] right = Arrays.copyOfRange(nums, i + 1, nums.length);
            if(Arrays.stream(left).sum() == Arrays.stream(right).sum()
                    || (Arrays.stream(left).sum() == 0 && i == nums.length-1)){
                return i;
            }
        }
        return -1;
    }
}
