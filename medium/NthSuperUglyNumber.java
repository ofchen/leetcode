package LeetCode.medium;

import java.util.Arrays;

public class NthSuperUglyNumber {
	 public static int nthSuperUglyNumber(int n, int[] primes) {      
	        int[] temp = new int[primes.length];
	        int[] res = new int[n];
	        int[] idx = new int[primes.length];  
	        Arrays.fill(temp, 1);
	        res[0] = 1;
	        Arrays.fill(idx, 0);
	        int len = primes.length;
	        for(int i = 1; i < n; i ++){
	            for(int j = 0; j < len; j ++)
	            	temp[j] = res[idx[j]]*primes[j];
	            int min = findMin(temp);
	            res[i] = min;
	            for(int j = 0; j < len; j ++)
	            	if(temp[j] == min)
	            		idx[j]++;
	        }
	        
	        return res[n-1];
	    }
	    
	    public static int findMin(int[] nums){
	        int res = nums[0]; 
	        for(int i = 1; i < nums.length; i ++){
	            if(nums[i] < res){
	                res = nums[i];
	            }
	        }
	        return res;
	    }
	    
	    //ֻ���º���Сֵ��ȵ��������ټ�����
	    public static int nthSuperUglyNumber2(int n, int[] primes) {
	        int[] ugly = new int[n];
	        int k = primes.length;
	        ugly[0] = 1;
	        int[] it = new int[k];
	        int[] nxt = new int[k];
	        for(int j=0;j<k;j++) {
	            nxt[j] = primes[j];
	        }        
	        for(int i=1;i<n;i++) {
	            int nxt_ugly = Integer.MAX_VALUE;
	            for(int j = 0;j<k;j++) {
	                nxt_ugly = Math.min(nxt_ugly, nxt[j]);
	            }            
	            ugly[i] = nxt_ugly;
	            for(int j = 0;j<k;j++) {
	                if(nxt[j] == nxt_ugly) {
	                    it[j]++;
	                    nxt[j] = ugly[it[j]]*primes[j];
	                }                
	            }                         
	        }
	        return ugly[n-1];
	    }
	    
	    public static void main(String[] args) {
			int n = 12;
			int[] primes = {2,7,13,19};
			
			System.out.print(nthSuperUglyNumber(n,primes));
		}
}
