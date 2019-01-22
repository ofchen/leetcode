package LeetCode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//��������֮��Ϊ0��Ҫ�������ظ���������ȷ��һ��ֵ��������ֵ��͵ķ���
public class ThreeSum {
	public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 3)
            return res;
        int len = nums.length;
        
        Arrays.sort(nums);
       /* for(; i < len-1; i ++){//�����ظ��ķ�����
        	for(j = i+1;j < len-1; j ++){
            	//while(nums[i] == nums[j]) j++;
            	for(k = len-1; k > j; k --){
            		System.out.println("num1="+nums[i]+", num2="+nums[j]+", num3="+nums[k]);
            		if((nums[i]+nums[j] <= 0 && nums[k] < 0) || (nums[i]+nums[j] >= 0 && nums[k] > 0))
            			break;
            		if(nums[i]+nums[j]+nums[k] == 0){
            			System.out.println("--** num1="+nums[i]+", num2="+nums[j]+", num3="+nums[k]);
            			res.add(Arrays.asList(nums[i], nums[j], nums[k]));
            			break;
            		}          			
            	}
            }
        }
        

        HashSet h = new HashSet(res);   
        res.clear();   
        res.addAll(h);   */

	for(int k = 0; k < len-2; k ++){            
            if(nums[k] > 0) break;
            while(k > 0 && nums[k-1] == nums[k]) k ++;
            int target = -nums[k];
            int i = k+1, j = len-1;
            while(i < j){
                int temp = nums[i] + nums[j];
                if(temp == target){
                	res.add(Arrays.asList(nums[k], nums[i], nums[j]));
                	while(i < j && nums[i+1] == nums[i]) i ++; //����ظ�����
                    while(i < j && nums[j-1] == nums[j]) j --;
                    System.out.println("== num1="+nums[i]+", num2="+nums[j]+", num3="+nums[k]);
                    ++ i;
                    -- j;
                }
                else if(temp < target){
                	System.out.println("<< num1="+nums[i]+", num2="+nums[j]+", num3="+nums[k]);
                	i ++;
                }
                else{
                	System.out.println(">> num1="+nums[i]+", num2="+nums[j]+", num3="+nums[k]);
                	j --;
                }
            }
        }	

        return res;
    }
	
	public static void main(String[] args) {
		int[] num = {-1, 0, 0, 0, 1, 2, -1, -4};
		System.out.println(threeSum(num));
	}
}
