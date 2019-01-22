package LeetCode.easy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RepeatedSubstringPattern {
	//NO.459 �ж�s�Ƿ���������ַ����ظ��������λ�ԭ
	
	//���Ӵ�����ΪԴ����һ�뿪ʼ������ֱ����һ���ַ�����
	public static boolean repeatedSubstringPattern(String s) {        
        int len = s.length();
        
        for(int i = len/2; i >= 1; --i){
            if(len % i == 0){
                int c = len/i;                
                for(int j = 0; j < c; j++){
                    if(!s.substring(i*j, i*(j+1)).equals(s.substring(0, i)))
                        break;
                    if(j == c-1) return true;
                }
            }
        }
        return false;    
    }
	
	//KMP�㷨������next���������
	public static boolean repeatedSubstringPattern2(String s) {
		int i = 1, j = 0, len = s.length();
		//dp[i]��ʾ�ظ��ַ�������
		int[] dp = new int[len+1];
		char[] cs = s.toCharArray();
		while(i < len){
			if(cs[i] == cs[j]) 
				dp[++i] = ++j;
			else if(j == 0)
				++i;
			else 
				j = dp[j];
		}
		
		//len-dp[len]��ʾ���ַ�������
		return (dp[len]>0) && (dp[len]%(len-dp[len])==0);
	}
	
	//���˼��ľ��������ͨ������һ���ַ��������Ҹ����ƻ�һС���֣�Ȼ��ͨ����������ƴ�����ԭ���Ĳ��ҡ�
	//�����������Ҫ������ԣ���ƴװ�������ġ�
	public static boolean repeatedSubstringPattern3(String s) {
		String s2 = s.substring(1,s.length())+s.substring(0,s.length()-1);
		if(s2.contains(s))
			return true;
		return false;
	}
		
	public static void main(String[] args) {
		//String string = "abcdabcabcabc";
		String string = "abcabcabcabc";
		System.out.println(repeatedSubstringPattern3(string));
	}
}
