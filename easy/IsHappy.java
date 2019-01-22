package LeetCode.easy;

public class IsHappy {
	public static boolean isHappy(int n) {
        if(n < 0)
            return false;
                
        while(n != 1 && n != 4){
            int dt = 0;
        	while(n != 0){
                dt += (n % 10)*(n % 10);
                n /= 10;
            }
            n = dt;
        }
        System.out.print(n);
        return n == 1;
    }
	
	public static void main(String[] args){
		
		int k = 19;
		isHappy(k);
	}
}
