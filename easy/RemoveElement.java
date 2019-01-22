package LeetCode.easy;
//����ɾ��ָ��Ԫ��
public class RemoveElement {

	 public static int removeElement(int[] nums, int val) {
		 	int len = nums.length;	       
	        if(len == 0 || (len == 1 && nums[0] == val))
	        	return 0;
	        
	        int i = 0, res = 0;
	        while(i < len){
	        	if(nums[i] == val){	        	
	        		for(;i < len && nums[i] == val; i++);	        			        		
	        	}
	        	if(i == len)
	        		break;
	        	nums[res] = nums[i];
	        	res ++;
	        	i ++;
	        }
	        for(i = 0; i < res; i++)
	        	 System.out.print(nums[i]+" ");
	        return res;
	    }
	
	public static void main(String[] args) {
		int[] nums = {3,4,4,4,4,3};
		System.out.println(" res ="+removeElement(nums,4));
	}
}
