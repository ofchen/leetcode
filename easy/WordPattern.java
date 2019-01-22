package LeetCode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
//null��""��ͬ��null�����������ã���ָ���κ��ڴ�ռ䣬�ڶ�(heap)��
//""�������ַ���������,length=0��ָ����ַ������ڴ�ռ䣬��ջ(stack)��
//split(" ")," "���ؿմ�����Ϊ0��""����null������Ϊ1
public class WordPattern {
	public static boolean wordPattern(String pattern, String str) {
        int plen = pattern.length(), slen = str.length();
        if(plen == 0 || slen == 0) return false;
        if((plen == 1 && str.equals(" ")) || (slen == 1 && pattern.equals(" "))) return true;	
        String[] result = str.split(" "); 
        
        if(plen != result.length) return false;
        	        
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<String>();
        
        for(int i = 0; i < plen; i++){
        	char c = pattern.charAt(i);
        	if(map.containsKey(c)){
        		String temp = map.get(c);
        		if(!temp.equals(result[i]))
        			return false;
        	}
        	else{
        		if(!set.add(result[i])) return false;        		
        		map.put(c, result[i]);
        	}
        }
       
        return true;
    }
	public static void main(String[] args) {
		String pattern = "a";
		String str = " ";
		System.out.println(wordPattern(pattern, str));
		
		//String[] result = str.split(" ");
		//System.out.println("strlen="+str.length()+" ,splitlen="+result.length);
	}

}
