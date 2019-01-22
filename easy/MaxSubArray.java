package LeetCode.easy;
//�����������±������
public class MaxSubArray {
	public static int maxSubArray(int[] nums) {
        int len = nums.length;
        int res = nums[0];
        if(len == 1)
        	return res;
        int i = 0, min = res;

        for(; i < len && nums[i] < 0; i ++){
        	min = Math.max(nums[i], min);
        }
        if(i != len)
        	res = nums[i];
        else
        	res = min; //ȫΪ��
        int temp = res;
        ++ i;
        while(i<len){
            if((res+nums[i]) > 0)
                res += nums[i];
            else                
                res = 0;            
            temp = Math.max(res,temp);
            i++;
        }
        return temp;
    }
	
	public static void main(String[] args) {
		int[] num = {2,1,3,-3,7};//,-3,4,-1,2,1,-5,4
		System.out.println(maxSubArray(num));
	}
}
