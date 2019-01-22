package LeetCode.medium;
//����ת�����ַ����ѵ�����4��9���ж�
public class IntToRoman {
	public static String intToRoman(int num) {
		String res = "";
		int quotient = 0, i = 0, temp = 0, j = 0;		
		int[] divisorNum = {1000, 500, 100, 50, 10, 5, 1};
		char[] divisorRoman = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
		char[] roman = new char[15];
		
		while(num > 0 && i <= 5){
			quotient = num / divisorNum[i];
			if(quotient == 1 && num / divisorNum[i+1] == 9){
				roman[temp] = divisorRoman[i+1];
				roman[temp+1] = divisorRoman[i-1];
				temp += 2;
				num -= 9*divisorNum[i+1];
				quotient = 0;
			} 
			else if(quotient == 0 && num / divisorNum[i+1] == 4){
				roman[temp] = divisorRoman[i+1];
				roman[temp+1] = divisorRoman[i];
				temp += 2;
				num -= 4*divisorNum[i+1];
			}
			else if(quotient > 0 ){					
				for(j = 0; j < quotient; j ++)
						roman[temp+j] = divisorRoman[i];
				num -= quotient*divisorNum[i];
				temp += j;				
			}
			i ++;
		}
		
		
//		quotient = num / divisorNum[i]; //ȥ��1000�����
//		if(quotient > 0){
//			for(j = 0; j < quotient; j ++)
//				roman[temp+j] = divisorRoman[i];
//			num -= quotient*divisorNum[i];
//			temp += j;
//		}
//		while(num > 0 && i <= 5){			//�Ǵ��149			
//			quotient = num / divisorNum[i]; 			
//			if(quotient > 0){
//				int another = (divisorNum[i]*quotient + ((num-divisorNum[i]*quotient)/divisorNum[i+1])*divisorNum[i+1]);
//				if(divisorNum[i-1]-divisorNum[i+1] == another){ // 9
//					roman[temp] = divisorRoman[i+1];
//					roman[temp+1] = divisorRoman[i-1];
//					temp += 2;
//					num -= another;
//				}
//				else if(divisorNum[i]-divisorNum[i+1] == another){ //4
//					roman[temp] = divisorRoman[i];
//					roman[temp+1] = divisorRoman[i-1];
//					temp += 2;
//					num -= another;
//				}
//				else{
//					for(j = 0; j < quotient; j ++)
//						roman[temp+j] = divisorRoman[i];
//					temp += j;
//					num -= (quotient*divisorNum[i]);
//				}
//			}
//			i ++ ;
//		}
		if(num <= 3 && num > 0){
			for(j = 0; j < num; j ++)
				roman[temp+j] = divisorRoman[i];
			temp += j;
		} 
		
		res = String.valueOf(roman);
		
		return res.substring(0,temp);
	}
	
	public static void main(String[] args) {
		int num = 200;
		System.out.println(intToRoman(num));
	}
}
