package LeetCode.another;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
	public static List<List<Integer>> combinationSum2(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		helper(nums, target, res, new ArrayList<Integer>(), 0);
		
		for(int i = 0; i < res.size(); i++)
			System.out.println(res.get(i));
		return res;
	}
	
	static void helper(int[] nums, int target, List<List<Integer>> res, List<Integer> temp, int idx){
		if(target < 0)
			return;
		else if(target == 0)
			res.add(new ArrayList<Integer>(temp));
		else{
			for(int i = idx; i < nums.length; i++){
				temp.add(nums[i]);
				helper(nums, target-nums[i], res, temp, i+1);
				temp.remove(temp.size()-1);
				while(i < nums.length-1 && nums[i] == nums[i+1]) i++; //ȥ��
			}
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {10,1,2,7,6,1,5};
		int target = 8;
		System.out.println(combinationSum2(nums, target));
	}

}
