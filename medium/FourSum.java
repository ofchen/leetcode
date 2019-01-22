package LeetCode.medium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
public class FourSum {
		public static List<List<Integer>> fourSum(int[] nums) {
	        List<List<Integer>> res = new ArrayList<List<Integer>>();
	        if(nums == null || nums.length < 4)
	            return res;
	        int len = nums.length;	        
	        Arrays.sort(nums);
	      
	        
	        

	        return res;
	    }
		
		public static void main(String[] args) {
			int[] num = {1, 0, -1, 0, -2, 2};
			System.out.println(fourSum(num));
			Stack<Integer> stack = new Stack<Integer>();
			stack.push(1);
			stack.pop();
		}
	}
