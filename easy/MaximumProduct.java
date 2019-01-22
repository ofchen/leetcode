package LeetCode.easy;

import java.util.Arrays;

public class MaximumProduct {
	public static int maximumProduct(int[] nums) { //�����и���
        int len = nums.length;
        if(len == 3)
            return nums[0]*nums[1]*nums[2];
        /*
        Arrays.sort(nums);
        if(nums[len-3] > 0)
            return Math.max(nums[len-1]*nums[len-2]*nums[len-3], nums[0]*nums[1]*nums[len-1]);
        else //nums[len-3] < 0 ֻ����������
            return nums[0]*nums[1]*nums[len-1];
         */   
        double x = Double.MIN_VALUE;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        
        for(int i = 0; i < len; i ++){
        	if(nums[i] > max1){
        		max3 = max2;
        		max2 = max1;
        		max1 = nums[i];        		
        	}
        	else if(nums[i] > max2){
        		max3 = max2;
        		max2 = nums[i];
        	}
        	else if(nums[i] > max3){
        		max3 = nums[i]; 
        	}
        	
        	if(nums[i] < min1){
        		min2 = min1;
        		min1 = nums[i];
        	}
        	else if(nums[i] < min2){
        		min2 = nums[i];
        	}
        }
        
        return max1*Math.max(max2*max3, min1*min2); 
    }
	public static void main(String[] args) {
		int[] flowerbed = {722,634,-504,-379,163,-613,-842,-578,750,951,-158,30,
				-238,-392,-487,-797,-157,-374,999,-5,-521,-879,-858,382,626,803,
				-347,903,-205,57,-342,186,-736,17,83,726,-960,343,-984,937,-758,
				-122,577,-595,-544,-559,903,-183,192,825,368,-674,57,-959,884,29,
				-681,-339,582,969,-95,-455,-275,205,-548,79,258,35,233,203,20,-936,
				878,-868,-458,-882,867,-664,-892,-687,322,844,-745,447,-909,-586,
				69,-88,88,445,-553,-666,130,-640,-918,-7,-420,-368,250,-786};
		
		System.out.print(maximumProduct(flowerbed));				 
	}
}
