package LeetCode.easy;

import java.util.Arrays;

public class Compress {
	//NO.443 �ַ���ѹ������¼ÿ���ַ�������ֵĴ���
	public static int compress(char[] chars) {
        if(chars.length == 1) return 1;
        int len = chars.length, idx = 0, cnt = 1;        
        char temp = chars[0];
        
        for(int i = 1; i < len; i ++){
            if(chars[i] == temp){
                cnt++;                
            }
            else{
                chars[idx++] = temp;
                temp = chars[i];
                System.out.printf("idx=%d,i=%d,temp=%c,cnt=%d\n",idx,i,temp,cnt);
                System.out.println("chars="+Arrays.toString(chars));
                if(cnt > 1){                    
                    for(char c : String.valueOf(cnt).toCharArray())
                    	chars[idx++] = c;                	
                    cnt = 1;                    
                }
            }
        }
        chars[idx++] = temp;
        if(cnt > 1){         	
        	for(char c : String.valueOf(cnt).toCharArray())
            	chars[idx++] = c; 
        }
        System.out.println("chars="+Arrays.toString(chars));
        return idx;
    }
	
	public static int compress2(char[] chars) {
		if (chars == null || chars.length == 0) {
	        return 0;
	    }
	    int anchor = 0;
	    int slow = 0;
	    for (int fast = 0; fast < chars.length; fast++) {
	        if (fast == chars.length - 1 || chars[fast + 1] != chars[fast]) {
	            // to write.
	            chars[slow++] = chars[anchor];
	            // write number.
	            if (fast > anchor) {
	                int length = fast - anchor + 1;
	                for (char c : String.valueOf(length).toCharArray()) {
	                    chars[slow++] = c;
	                }
	            }
	            anchor = fast + 1;
	        }
	    }
	    return slow;
	}
	
	public static void main(String[] args) {
		char[] cs = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
		System.out.println(compress(cs));		
	}
}
