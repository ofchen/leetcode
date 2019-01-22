package LeetCode.easy;
//�ж������Ƿ��ǻ��Ĵ�
public class IsPalindrome {

	public static boolean isPalindrome(int x){
		if(x < 0)
			return false;
		else{
			int digits[] = new int[10];
			int i = 0;
			while(x > 0){
				digits[i] = x % 10;
				x /= 10 ;
				i ++ ;
			}
			int len = i;			
			if(len == 1)
				return true;	
			int half = len/2;			
			for(i = 0; i < half; i ++)
				if(digits[i] != digits[len-1-i])
					return false;
			return true;
		}
			
	}
	
	public static void main(String[] args) {
		int x = 12344321;
		System.out.println(isPalindrome(x));
	}

}
