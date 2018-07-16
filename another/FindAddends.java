package another;

import java.util.Arrays;

public class FindAddends {

	//递归方式
	public static boolean findAddends(int[] arr, int target, int index){
		if(target == 0)
			return true;
		else if(index == 0)
			return arr[index] == target;
		else if(arr[index] > target)  //减少判断的分支数量，保证target>0
			return  findAddends(arr, target, index-1);
		else {
			boolean A = findAddends(arr, target-arr[index], index-1); //选择arr[index]
			boolean B = findAddends(arr, target, index-1); //不选arr[index]
			return (A | B);
		}
		
	}
	
	//非递归方式
	public static boolean findAddendsArray(int[] arr, int target){
		int al = arr.length;		 
		boolean[][] result = new boolean[al][target+1];
		int i = 0;
		for (; i < al; i ++){
			result[i][0] = true;
		}
		for (i = 0; i < target+1; i ++){
			result[0][i] = false;
		}
		
		result[0][target] = true;
		
		for (i = 1; i < al; i ++){
			for (int j = 1; j < target+1; j ++){
				if(arr[i] > j)
					result[i][j] = result[i-1][j];
				//
				else
					result[i][j] = result[i-1][j-arr[i]] | result[i-1][j];
				//result[i-1][j-arr[i]]如果选择该元素，看前一个的结果是否达到要求，即j-arr[i]
				//result[i-1][j]如果不选该元素，也看前一个的结果是否达到要求，即i-1
			}
		}
		
		return result[al-1][target];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3, 34, 4, 12, 5, 2};
		int target = 10;
		//long startTime = System.currentTimeMillis();
		//Arrays.sort(nums);
		//nums = Arrays.copyOf(nums, nums.length);
		//System.out.println(nums.toString());
		boolean result = findAddends(nums, target, nums.length-1);
		//long endTime = System.currentTimeMillis();
		
		System.out.println("result="+ findAddendsArray(nums,target));
	}

}
