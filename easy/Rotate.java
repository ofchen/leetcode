package LeetCode.easy;

public class Rotate {
	public static void rotate(int[] nums, int k) {
        int len = nums.length;
        int rt = k % len;
        if(rt > 0){
        	
        	for(int i = 0; i < len/2; i ++){
        		int temp = nums[i];
        		nums[i] = nums[len-1-i];
        		nums[len-1-i] = temp;
        	}
        	for(int i = 0; i < rt/2; i ++){
        		int temp = nums[i];
        		nums[i] = nums[rt-1-i];
        		nums[rt-1-i] = temp;
        	}
        	for(int i = 0; i < (len-rt)/2; i ++){
        		int temp = nums[rt+i];
        		nums[rt+i] = nums[len-1-i];
        		nums[len-1-i] = temp;
        	}
        }
        
        for(int i = 0; i < len; i ++)
        	System.out.print(nums[i]+" ");
     }
	
	public static void main(String[] args){
		int[] nums ={1, 2, 3, 4, 5, 6, 7, 8};
		int k = 8;
		rotate(nums,k);
	}
}
