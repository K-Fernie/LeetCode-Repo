import java.util.Arrays;

public class RunningSum {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(runningSum(nums)));
    }

    public static int[] runningSum(int[] nums){
        int[] returnSum = new int[nums.length];
        returnSum[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            returnSum[i] = nums[i] + returnSum[i-1];
        }
        return returnSum;
    }
}
