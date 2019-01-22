package LeetCode.easy;
//����ȥ��
public class RemoveDuplicates {
	public static int removeDuplicates(int[] nums) {	       
	        int len = nums.length;
	        int res = len;	       
	        if(len <= 1)
	        	return len;	        
	        int i = 1;
	        res = 0;
	        while(i < len){
	        	if(nums[res] != nums[i]){
	        		res ++;
	        		nums[res] = nums[i];	        		
	        	}
	        	i ++;
	        }
	        System.out.println(res+1);
	        for(i = 0; i <= res; i++)
	        	 System.out.print(nums[i]+" ");
	        return res+1;
	}
	
	public static void main(String[] args) {
		int[] nums = {0,2,3,4,4};
		removeDuplicates(nums);
	}
}
