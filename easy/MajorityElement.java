package LeetCode.easy;

public class MajorityElement {
	public static int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 0;
        for(int i = 0; i < nums.length; i ++){
        	if(count == 0)
        		candidate = nums[i];
        	if(candidate == nums[i])
        		count ++;
        	else
        		count --;
        	
        }
        return candidate;
    }	
	
	public static void main(String[] args) {
		int[] nums = {3, 2, 3};
		System.out.print(majorityElement(nums));		
	}

}
