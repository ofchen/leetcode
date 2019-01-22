package LeetCode.hard;

import java.util.Arrays;

public class NumDistinct {
	//NO.115 �жϱ������˳���S��������t�ĸ��� 
	public int numDistinct1(String s, String t) {
        if(t.length() == 0) return 1; 
        if(t.length() > s.length()) return 0;
        
        int slen = s.length(), tlen = t.length();
        int[][] dp = new int[tlen+1][slen+1];
        
        for(int i = 0; i <= slen; i ++)
            dp[0][i] = 1;
        for(int j = 1; j <= tlen; j ++)
            dp[j][0] = 0;
        for(int i = 1; i <= tlen; i ++)
            for(int j = 1; j <= slen; j ++)
                if(s.charAt(j-1) == t.charAt(i-1))
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1] ; 
                else
                   dp[i][j] = dp[i][j-1];
        return dp[tlen][slen];
        
    }
	
	public static int numDistinct2(String s, String t) {
        if(t.length() == 0) return 1; 
        if(t.length() > s.length()) return 0;
        
        int slen = s.length(), tlen = t.length();
        
        return helper(s, t, slen-1, tlen-1);
        
    }
	
	public static int helper(String s, String t, int sidx, int tidx){
        if(tidx == -1){
            return 1;
        }
        else if(sidx == -1){
            return 0;
        }
        else if(s.charAt(sidx) == t.charAt(tidx)){
        	System.out.println("in equal, s="+sidx+"-"+s.charAt(sidx)+" , t="+tidx+"-"+t.charAt(tidx));
        	return helper(s, t, sidx-1, tidx)+helper(s, t, sidx-1, tidx-1);
        }
        else{
        	System.out.println("in unequal, s="+sidx+"-"+s.charAt(sidx)+" , t="+tidx+"-"+t.charAt(tidx));
            return helper(s, t, sidx-1, tidx);
        }
        
    }
	
	public static int numDistinct3(String s, String t) {
		char[] ch1 = s.toCharArray(), ch2 = t.toCharArray();
        int[] first = new int[128];
        Arrays.fill(first, -1);
        int[] pre = new int[ch2.length]; //û������
        for (int i = 0; i < ch2.length; i++) {
            pre[i] = first[ch2[i]];
            first[ch2[i]] = i+1;
        }
        int[] dp = new int[ch2.length+1];
        dp[0] = 1;
        for (int i = 0; i < ch1.length; i++) {
            for (int j = first[ch1[i]]; j != -1; j = pre[j-1])
                dp[j] += dp[j-1];
        }
        return dp[ch2.length];
	}
	
	public static void main(String[] args) { 
		 String s = "rabbbit";//"babgbag";
		 String t = "rabbit";//;"bag"
		 
		 //String s = "adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc";
		 //String t = "bcddceeeebecbc";
		 //����������ѭ��?
		 System.out.println(numDistinct3(s,t));
	}
}
