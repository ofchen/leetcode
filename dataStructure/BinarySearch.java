package LeetCode.DataStructure;

public class BinarySearch {
	public static int search(int[] nums, int target) {
        int len = nums.length, l = 0, h = len-1;
        if(target > nums[h] || target < nums[0]) return -1;
        
        while(l <= h && l <= len-1 && h >= 0){
            int m =(h-l)/2+l;
            if(nums[m] < target) l = m+1;
            else if(nums[m] == target) return m;
            else h = m-1;
        }        
        return -1;
    }
	public static void main(String[] args) {
		int[] nums = {-1};
		int target = -1;
		System.out.println(search(nums, target));
	}
}
