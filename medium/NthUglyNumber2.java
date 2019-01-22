package LeetCode.medium;

public class NthUglyNumber2 {
	/*1. The naive approach is to call isUgly for every number until you reach the nth one. Most numbers are not ugly. Try to focus your effort on generating only the ugly ones.
	  2. An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly number.
	  3. The key is how to maintain the order of the ugly numbers. Try a similar approach of merging from three sorted lists: L1, L2, and L3.
	  4. Assume you have Uk, the kth ugly number. Then U(k+1) must be Min(L1 * 2, L2 * 3, L3 * 5).
	 eg.
	 (1) #1x2,  2x2, #2x2,  3x2, #3x2, #4x2,  5x2...
	 (2) 1x3,  #1x3,  2x3,  2x3, #2x3,  3x3, #3x3...
	 (3) 1x5,   1x5,  1x5, #1x5,  2x5,  2x5,  2x5...
	 */
	
	public static int nthUglyNumber(int n){
		int[] res = new int[n];
		int i2 = 0, i3 = 0, i5 = 0, idx = 0;
		res[0] = 1;
		while(++idx < n){
			int m2 = res[i2]*2, m3 = res[i3]*3, m5 = res[i5]*5;
			int mn = Math.min(m3, Math.min(m2, m5));
			if(mn == m2) i2++;
			if(mn == m3) i3++;
			if(mn == m5) i5++;
			res[idx] = mn;
		}
		
		return res[n-1];
	}
	
	public static void main(String[] args) {
		int n = 10;
		
		System.out.print(nthUglyNumber(n));
	}
}
