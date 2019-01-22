package LeetCode.medium;


public class Search {
	//�м�ֵ��������ֵʱ��Ŀ��ֵ�ȿ���������ֿ������ұߣ������������ֻҪ������ֵ����һλ���ɼ���ѭ�����������ͬ������ƣ�ֱ���Ƶ���ֵͬΪֹ 
	public static boolean search(int[] nums, int target) {
        if(nums.length == 0) return false;
        int l = 0, h = nums.length-1;
        while(l <= h){
            int m = (h-l)/2+l;
            if(nums[m] == target) return true;
            else if(nums[m] < nums[h]){            	
	                 if(nums[m] < target && nums[h] >= target) l = m+1;
	                 else h = m-1;
	            }
            else if(nums[m] > nums[h]){
                if(nums[l] <= target && nums[m] > target) h = m-1;
                else l = m+1;
            }
            else {
            	h--;
            }
        }
        return false;
    }
	 
	public static void main(String[] args) {
		int[] nums = {0,0,0,5,6,7,0,0};
		int t = 6;
		System.out.println(search(nums, t));
	}

}
