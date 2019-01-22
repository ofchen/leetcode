package LeetCode.easy;

import java.util.Arrays;


public class ArrayPairSum {
	public static int arrayPairSum(int[] nums) {
		int sum = 0;
		int len = nums.length;
		Arrays.sort(nums);
		
		int i = 0;
		while(i<len){
			sum += nums[i];
			i += 2;		
		}		
		
		return sum;
    }
	
	public static void main(String[] args) {
		//int[] num = {1, 4, 3, 2};
		int[] num = {-1, 4, -2, 5, -3, 6};
		System.out.println(arrayPairSum(num));		
	}
}
