package LeetCode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagrams {
	public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int slen = s.length(), plen = p.length();
        if(slen == 0 || plen == 0 || plen > slen) return res;
        char[] sc = s.toCharArray();
        int[] count = new int[26];
        for(int i = 0; i < plen; i ++)
            count[p.charAt(i)-'a']++;
        
        for(int i = 0; i <= slen-plen; i ++){
        	boolean isAnagram = true;
            int[] temp = Arrays.copyOf(count,26);
            int j = 0;
            for(j = 0; j < plen; j ++)
                temp[sc[i+j]-'a']--;
            for(j = 0; j < count.length; j ++)
                if(temp[j] != 0){
                    temp[j] = 0;
                    isAnagram = false;
                }
            if(isAnagram)
                res.add(i);
        }
        return res;
    }
	
	public static void main(String[] args) {
		String pattern = "cbaebabacd";
		String str = "abc";
		System.out.println(findAnagrams(pattern, str));
	}

}
