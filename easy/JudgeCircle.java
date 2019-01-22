package LeetCode.easy;

public class JudgeCircle {
	public static boolean judgeCircle(String moves) {
        int horizontal = 0, vertical = 0;
        for(char c : moves.toCharArray()){
            if(c == 'R')
                horizontal ++;
            else if(c == 'L')
                horizontal --;
            else if(c == 'U')
                vertical ++;
            else if(c == 'D')
                vertical --;
        }
        return horizontal == 0 && vertical == 0;
    }
	
	public static void main(String[] args) {
    	String bottom = "UD";
	System.out.println(judgeCircle(bottom));
    }
       
}
