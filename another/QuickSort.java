package LeetCode.another;

public class QuickSort {
	public static void quickSort(int[] nums){
		QSort(nums, 0, nums.length-1);
		for(int i = 0; i < nums.length; i ++)
			System.out.print(nums[i]+" ");
	}

	private static void QSort(int[] nums, int low, int high) {
		if(low < high){
			int p = Partition(nums, low, high);
			QSort(nums, low, p-1);
			QSort(nums, p+1, high);
		}
	}

	private static int Partition(int[] nums, int low, int high) {
		 int pi = nums[low];
		 while(low < high){
			 while(low < high && nums[high] >= pi) --high;
			 nums[low] = nums[high];
			 while(low < high && nums[low] <= pi) ++low;
			 nums[high] = nums[low];
		 }
		 nums[low] = pi;
		 return low;
	}
	
	public static void main(String args[]){
		int[] nums = {2, 7, 11, 16, 20, 4};		
		quickSort(nums);		
	}
}
