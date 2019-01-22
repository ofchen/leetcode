package LeetCode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsIsomorphic {
	public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        Set<Character> set = new HashSet<Character>();
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();
        int len = sa.length;
        
        for(int i = 0; i < len; i ++){
            if(!map.containsKey(sa[i])){
            	if(!set.contains(ta[i])){            
	                map.put(sa[i], ta[i]);
	                set.add(ta[i]);
            	}
            	else
            		return false;
            }
            else if(map.containsKey(sa[i]) && (char)map.get(sa[i]) != ta[i])
                return false;
            
        }
        return true;
    }
	
	public static boolean isIsomorphic2(String s, String t) {
		int[] si = new int[256];
		int[] ti = new int[256];
		int len = s.length();
		for(int i = 0; i < len; i ++){
			if(si[s.charAt(i)] != ti[t.charAt(i)]) return false;
			si[s.charAt(i)] = i + 1;
			ti[t.charAt(i)] = i + 1;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String s = "paper";
		String t = "title";
		
		System.out.println(isIsomorphic(s,t));
		System.out.println(isIsomorphic2(s,t));
	}

}
