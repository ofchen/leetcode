package LeetCode.easy;
/*Given a 32-bit signed integer, reverse digits of an integer.
Example 1:  Input: 123, Output: 321,
Example 2:  Input: -123, Output: -321
Example 3:  Input: 120, Output: 21
Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [- 2^31,  2^31 - 1]. 
For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */
public class Reverse {

	public static int reverse(int x){
		//the point is 0, overflow for example 1534236496,
		int re = 0;
		int[] digits = new int[10];
		boolean minus = false; 
		int i = 0;
		int len = 0;
		
		if (x == 0)
			return 0;
		if (x < 0){
			minus = true;
			x = -x;
			System.out.println(x);
		}
		while(x > 0){	//Simultaneous splitting and combination, and don't need digits[]
			digits[i] = x % 10;
			x /= 10;
			i ++;
		}
		len = i;
		for(i = 0; (digits[i] == 0) && (i < len) ; i ++);
		for(; i < len; i ++){
			re = re * 10 + digits[i]; 
			System.out.println(re);
			//after overflow the data's expression has been changed, so judge the second to the last. 
			if((re > (Integer.MAX_VALUE/10)) && i < len-1) 
				return 0;
		}
		if(minus){
			re = -re;
			System.out.println(re);
		}
		
		return re;
	}
	
	public static void main(String[] args) {
		int x = 1534236496;
		//System.out.println(Integer.MAX_VALUE+" "+Integer.MIN_VALUE);//max 2147483647,-2147483647
		System.out.println(reverse(x));
	}

}
