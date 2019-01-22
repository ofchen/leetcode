package LeetCode.easy;

import java.util.List;

public class CanPlaceFlowers {
	public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        if(n == 0) return true;
        if(n > (len+1)/2) return false;
        
        for(int i = 0; i < len; i ++){
            if(flowerbed[i] == 0){
	            int pre = (i == 0 ? 0 : flowerbed[i-1]);            
	            int next = (i == len-1 ? 0 : flowerbed[i+1]);
	        	 if(pre + next == 0){
	                flowerbed[i] = 1;
	                n --;                             
	            }
	            if(n == 0)
	                return true;
	          }
        }
        return n <= 0;
    }
	
	public static void main(String[] args) {
		int[] flowerbed = {1,0,0,0,1};
		int n = 1;
		System.out.print(canPlaceFlowers(flowerbed, n));		
	}

}
