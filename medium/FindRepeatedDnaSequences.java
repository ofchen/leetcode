package LeetCode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindRepeatedDnaSequences {
	public static List<String> findRepeatedDnaSequences(String s) {
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        List<String> res = new ArrayList<String>();
        int len = s.length();
        for(int i = 0; i <= len-10; i++){
        	String sub = s.substring(i, i+10);
        	int code = encode(sub);
        	if(!hashMap.containsKey(code)){
        		hashMap.put(code, 1);
        	}
        	else {
        		if(hashMap.get(code) == 1){
        			res.add(sub);
        			hashMap.put(code, 2);
        		}
        	}
        }
        
        for(int i = 0; i < res.size(); i++)
        	System.out.println(res.get(i));
        return res;
    }
	
	private static int encode(String str){
        int code = 0;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            // ÿ��λ��ʾһ���ַ�
            code <<= 2;
            switch(c){
                case 'A': code += 0; break;
                case 'C': code += 1; break;
                case 'T': code += 2; break;
                case 'G': code += 3; break;
            }
        }        
        return code;
    }
	
	public static void main(String[] args) {
		String str = "AAAAACCCCCAAAAACCCCCCAAAAAGGGGGTTTTTGGGGGTTTTT";
		findRepeatedDnaSequences(str);
	}

}
