package LeetCode.medium;
//�ַ�������ظ��ַ��Ӵ��ĳ���
public class LengthOfLongestSubstring {

	public static int lengthOfLongestSubstring(String s){
		int res = 0;
		int len = s.length();
		int i = 0, temp = 0;
		if(len >= 1){
			res = 1;
		}
		i = 1;
		while(i < len){
			String sub = s.substring(temp, i);
			char ch = s.charAt(i);
			int pos = sub.indexOf(ch);
			if(pos < i && pos != -1){
				temp += sub.indexOf(ch)+1;
				System.out.println("temp= " + temp +",i = " + i);
			}
			else{
				System.out.println("res= " + res + ",i-temp= " +(i-temp));
				res = Math.max(res, i+1-temp);
				System.out.println(res);
			}
			i ++;
		}
		
		System.out.println("result = " + res);
		return res;		
	}
	
	public static void main(String[] args) {
		String s = "abcaab";//"abcdabcaefghi";//"abcabcdabcdefg";//"pwwkew";//"bbbbb";//"abcabcbb";
		lengthOfLongestSubstring(s);
	}

}
