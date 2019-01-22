package LeetCode.medium;

public class NumSubarrayProductLessThanK {
	//NO.713  �������������飬��ӡ���������л�С��K����ϵ�и���
	
	public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k == 0) return 0;//rightһֱ���ƣ����Է���һ��forѭ����
        if(nums.length == 1) return nums[0] < k ? 1 : 0;
        int left = 0, right = 0, res = 0, temp = nums[0], pre = 0;
        while(right < nums.length){
            if(temp < k && right != nums.length-1){
                temp *= nums[++right];                
                System.out.println("in1 right="+right+",temp="+temp);
            }
            else{
            	System.out.println("in2 res="+res);   //�������ڵ�right==nums.lenth-1&&temp<kʱres��������            
            	res += (right-left+1)*(right-left)/2;
                res -= (pre-left)*(pre-left+1)/2;
                pre = right;                
                System.out.println("in2 left="+left+",right="+right);
                temp /= nums[left++]; 
                System.out.println("in2 temp="+temp+",res="+res);
                if(right == nums.length-1)
                	break;
            }
        }
       if(temp < k)
    	   ++right;
       System.out.println("out left="+left+",right="+right+",temp="+temp+",pre="+pre);
       int plus = (right-left)*(right-left+1)/2, minus = (pre-left)*(pre-left+1)/2;
       System.out.println("plus ="+plus+",minus="+minus);
       System.out.println("res0="+res);
       res += (right-left)*(right-left+1)/2;
       System.out.println("res1="+res);
       res -= (pre-left)*(pre-left+1)/2;
       return res;
    }
	
	public static void main(String[] args){
		int[] nums = {10,5,2,6};//,2 //8
		int k = 100;
		System.out.println(numSubarrayProductLessThanK(nums, k));
	}
}
