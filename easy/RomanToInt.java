package LeetCode.easy;
//�����ַ�ת��Ϊ����
public class RomanToInt {
	public static int romanToInt(String s){
		int res = 0;
		int len = s.length();
		int i = 0;
		int[] digits = new int[len+1];
		for(i = 0; i < len; i ++){			
			switch(s.charAt(i)) {
				case 'I' : digits[i] = 1; break;
				case 'V' : digits[i] = 5; break;
				case 'X' : digits[i] = 10; break;
				case 'L' : digits[i] = 50; break;
				case 'C' : digits[i] = 100; break;
				case 'D' : digits[i] = 500; break;
				case 'M' : digits[i] = 1000; break;
			}
		}
		digits[len] = 0;
		for(i = 0; i < len; i ++){
			if(digits[i]<digits[i+1]){
				res += (digits[i+1]-digits[i]);
				i++;
			}
			else{
				res += digits[i];
			}
		}
		
		return res;
	}
	public static void main(String[] args) {
		String s = "XVIII";//"LVIII";
		
		//char[] chs = s.toCharArray();
		//System.out.println(chs.length);
		System.out.println(romanToInt(s));
	}
}
