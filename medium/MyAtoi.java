package LeetCode.medium;
//�ַ���ת��Ϊ��ֵ��ע��ֵԽ������
public class MyAtoi {
	
	public static int myAtoi(String str){
		int res = 0, i = 0, len = str.length();
		if (len == 0)
			return 0;
		for(i = 0; i < len && str.charAt(i) == ' '; i ++); //iΪ��һ���ǿո��ַ��±�
		if(i == len)
			return 0;
		char c = str.charAt(i);
		if(c == '+' || c == '-' || (c >= '0' && c <= '9')){//�ַ�Ϊ+��-�Ż�������			
			if(c == '-'){//����	
				++ i;
				for(; i < len && str.charAt(i) >= '0' && str.charAt(i) <= '9' ; i++){
					res = res * 10 - (str.charAt(i)-'0');
					if((res < (Integer.MIN_VALUE/10) && i < len-1 && str.charAt(i+1) >= '0' && str.charAt(i+1) <= '9') 
							||(res > 0)) //-91283472332,-2147483648,-2147483649
						return Integer.MIN_VALUE;
				}
			}
			else{ //����
				if(c == '+') ++ i;
				for(; i < len && str.charAt(i) >= '0' && str.charAt(i) <= '9' ; i++){
					res = res * 10 + str.charAt(i)-'0';
					if((res > (Integer.MAX_VALUE/10) && i < len-1 && str.charAt(i+1) >= '0' && str.charAt(i+1) <= '9') 
							||(res < 0)) //2147483648,2147483646,2147483647
						return Integer.MAX_VALUE;
				}
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		String s = "-91283472332";//"PAYPALISHIRING";
		System.out.println(myAtoi(s));
	}
}