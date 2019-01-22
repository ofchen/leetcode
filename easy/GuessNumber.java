package LeetCode.easy;

public class GuessNumber {
	//��ʱ��Ӧ��ʹ�ö��ֲ���
	public static int guessNumber(int n) {
        if(guess(n) == 0) return n;
        
        int l = 1, r = n;
        while(l <= r){
            int m = (r-l)/2+l;
            int g = guess(m);
            if(g == -1)
                r = m;
            else if(g == 1)
               l = m; 
            else
                return m;
        }
        return l;
    }
	
	private static int guess(int m) {
		int pick = 1702766719;
		if(m < pick)
			return 1;
		else if(m > pick)
			return -1;
		else 
			return 0;
	}
	
	public static void main(String[] args){
		int nums=2126753390;
		System.out.println(guessNumber(nums));
	}
}
