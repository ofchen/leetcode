package LeetCode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.omg.CORBA.PUBLIC_MEMBER;

public class GroupAnagrams {

	
		public static List<List<String>> groupAnagrams(String[] strs) {
	        
	        if(strs == null || strs.length == 0) return new ArrayList<List<String>>();;
	        
	        Map<String, List<String>> map = new HashMap<String, List<String>>();
	        for(String str : strs){
	            String code = encode(str.toCharArray());
	            System.out.println(str + " " + code);
	            List<String> res;
	            if(!map.containsKey(code)){
	                res = new ArrayList();
	            }
	            else{
	                res = map.get(code);
	            }
	            res.add(str);
	            map.put(code, res);
	        }
	        System.out.println(map.values());
	        return new ArrayList<List<String>>(map.values());
	    }
	    
	    public static String encode(char[] cs){
	        int[] ar = new int[26];
	        for(char c : cs){
	            ar[c-'a']++;
	        }
	        String re = new String();
	        for(int i = 0; i < 26; i++){
	            if(ar[i] >= 1){              
	            	re+=""+ (char) ('a'+i)+""+ar[i];
	            }
	        }
	        System.out.println(re);
	        return re;
	    }
	    
	    public static void main(String[] args) {
	    	String[] rStrings = {"eat", "tea", "tan", "ate", "nat", "bat"};
	    	groupAnagrams(rStrings);
	    	
	    }

}
