package LeetCode.easy;

public class LongestPalindrome {
	public static int longestPalindrome(String s) {        
        char[] sc = s.toCharArray();
        int[] si = new int[256];
        int res = 0, temp = 0;
        for(char c : sc)
        	si[c]++;
        for(int i = 0; i < 256; i ++){
        	if((si[i] & 1) == 1){
        		temp += 1;
        		res += si[i]-1;
        	}
        	else
        		res += si[i];
        }
        if(temp >= 1)
        	res += 1;
        System.out.println("res="+res);
        return res;
    }
	
	
	public static void main(String[] args) {
		String s ="aaccccdd";
		//longestPalindrome(s);
		int[] nums = {1,2,2};//{1,2,2,5,3,5};
               
        int max1 = Math.max(nums[0], nums[1]);
		int max2 = Math.min(nums[0], nums[1]);		
		int max3 = nums[2];
		
		if(Math.max(max1, nums[2]) == max1){
			max3 = Math.min(max2, nums[2]);
			max2 = Math.max(max2, nums[2]);
		}
		else{			
			max3 = max2;
			max2 = max1;			
			max1 = nums[2];
		}
        
        for(int i = 3; i < nums.length; i ++){
            if(nums[i] == max1 || nums[i] == max2 || nums[i] == max3)
            	continue;
            else if(nums[i] > max1){
                max3 = max2;
                max2 = max1;
                max1 = nums[i];                
            }
            else if(nums[i] > max2){
                max3 = max2;
                max2 = nums[i];
            }
            else if(nums[i] > max3 || max2 == max3)                                
                max3 = nums[i];
        }
        max3 = (max2 == max3) ? max1 : max3;
		System.out.println(max1 +" ,"+max2+" ,"+max3);
	}

}
