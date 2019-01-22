package LeetCode.easy;
//�����ֲ��뵽��������ĺ���λ��
public class SearchInsert {
	public static int searchInsert(int[] nums, int target) {        
        int len = nums.length;
        int i = 0;
        
        for(; i < len && nums[i] < target; i ++);
        return i;                
        
    }
	
	public static void main(String[] args) {
		int[] nums = {1,3,5,6};
		int num = 0;
		System.out.println(searchInsert(nums, num));
	}
}
