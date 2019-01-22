package LeetCode.medium;
//���ַ�����������Ӵ�����̬�滮
public class LongestPalindrome {
	public static String longestPalindrome(String s){
		if(s.length() <= 1)
			return s;
				
		int len = s.length(), i = 0, j = 0;		
		boolean[][] F = new boolean[len][len];
		String res=String.valueOf(s.charAt(0));

		for(; i < len-1; i++){
			F[i][i] = true;
			F[i][i+1] = (s.charAt(i) == s.charAt(i+1) ? true : false);
			if(F[i][i+1])
				res = s.substring(i, i+2);
		}
		F[i][i] = true;
		
		for(j = 2; j < len; j ++)
			for(i = 0; i <= len-1-j; i ++){
				if(s.charAt(i) == s.charAt(i+j)){
					F[i][i+j] = F[i+1][i+j-1];
					if(F[i][i+j])
						res = s.substring(i, i+j+1);
				}
				else
					F[i][i+j] = false;
			}
		
		return res;
	}
	
	public static void main(String[] args) {
		String s = "bbcc";//"abcdabcaefghi";//"abcabcdabcdefg";//"pwwkew";//"bbbbb";//"abcabcbb";
		System.out.println(longestPalindrome(s));
	}
}
