package LeetCode.medium;

/**
 * Created by chen on 2019/1/17.
 */
//NO.55 给定数组，数组元素代表当前下标能前行的最大长度，判断能不能走到数组最后一个位置
public class CanJump {
    //动态规划从前向后
    public static boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 0; //默认值为0但还是赋值更安全
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1], nums[i-1])-1;
            if(dp[i] < 0)
                return false;
        }
        return true;
    }

    //贪心算法，遍历每个数字判断当前位置能到达的最远位置
    public static boolean canJump2(int[] nums) {
        int n = nums.length, reach = 0;
        for(int i = 0; i < n; i++){
            if(i > reach || reach > n-1) break;
            reach = Math.max(reach, i+nums[i]);
        }
        return reach >= n-1;
    }

    // 从后向前
    public static boolean canJump3(int[] nums) {
        int lastPos = nums.length-1;
        for(int i = nums.length-2; i >= 0; i--){
            if(i+nums[i] >= lastPos)
                lastPos = i;
        }

        return lastPos == 0;
    }

    public static boolean canJump4(int[] nums) {
        if(nums.length == 1) return true;
        if(nums[0] == 0) return false;
        int next = nums[0];
        for(int i = 0; i < nums.length-1; i++){
            if(i == next){
                if(nums[i] == 0) return false;
                next++;
            }
            if(i+nums[i] > next) next = i+nums[i];
        }

        return true;
    }

    public static void main(String[] args) {
        //int[] nums = {3,2,1,0,4};
        int[] nums = {2,3,1,1,4};
        System.out.println(canJump2(nums));
    }
}
