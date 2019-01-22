package LeetCode.medium;

import java.util.Arrays;

public class ThreeSumClosest {
	public static int threeSumClosest(int[] nums, int target) {
        int res = 0;
        if(nums.length == 3)
            return nums[0]+nums[1]+nums[2];
        
        int len = nums.length;        
        Arrays.sort(nums);
        for(int i = 0; i < len; i ++)
        	System.out.print(nums[i]+" ");
        System.out.println();
        
        res = nums[0]+nums[1]+nums[2];
        for(int k = 0; k < len-2; k ++){            
//            if(nums[k] > target) break;
            if(k > 0 && nums[k-1] == nums[k]) continue;
            int tempTar = target-nums[k];
            int i = k+1, j = len-1;
            while(i < j){
                int temp = nums[i] + nums[j];
                if(temp == tempTar){
                	return target;
                }
                else{ 
                	int tempSum = temp+nums[k]; 
                	res = Math.abs(tempSum - target) < Math.abs(res - target) ? tempSum : res;
                	if(temp < tempTar){               	
	                    System.out.println("<< num1="+nums[i]+", num2="+nums[j]+", num3="+nums[k]+", tempSum="+tempSum);
	                    while(i < j && nums[i-1] == nums[i]) i ++;
	                    i ++;
	                }
	                else{
	                    System.out.println(">> num1="+nums[i]+", num2="+nums[j]+", num3="+nums[k]+", tempSum="+tempSum);
	                    while(i < j && nums[j-1] == nums[j]) j --; 
	                    j --;
	                }
                	System.out.println("res="+res);
                }
            }
        }	

        return res;     
		/*  int res = 0;
        if(nums.length == 3)
            return nums[0]+nums[1]+nums[2];
        
        int len = nums.length;        
        Arrays.sort(nums);
        res = nums[0]+nums[1]+nums[2];
        
        for(int k = 0; k < len-2; k ++){            
       
            if(k > 0 && nums[k-1] == nums[k]) continue;
            int tempTar = target-nums[k];
            int i = k+1, j = len-1;
            while(i < j){
                int temp = nums[i] + nums[j];
                if(temp == tempTar){
                	return target;
                }
                else{ 
                    int tempSum = temp+nums[k];                         
                    res = Math.abs(tempSum - target) < Math.abs(res - target) ? tempSum : res;
                    if(temp < tempTar) {while(nums[i-1] == nums[i]) i ++;}
                	else {while(nums[j-1] == nums[j]) j --;} 
                }
            }
        }	

        return res;*/
    }
	
	public static void main(String[] args) {
		int[] num = {1,1,1,1};
		System.out.println(threeSumClosest(num,0));
	}
}
