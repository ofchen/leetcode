package LeetCode.easy;

import java.util.HashMap;

public class NumJewelsInStones {
	private static int numJewelsInStones(String j, String s) {	
/*		int res = 0;
		char[] Jewels = j.toCharArray();
        char[] Stones = s.toCharArray();
        HashMap<Character, Integer> jandn = new HashMap<Character,Integer>();
       
        int slen = Stones.length;        
        for(int i = 0; i < slen; i ++){
        	if(jandn.containsKey(Stones[i]))
        		jandn.put(Stones[i],((int)jandn.get(Stones[i]))+1);
        	else
        		jandn.put(Stones[i], 1);
        }
        
        int jlen = Jewels.length;   
        for(int i = 0; i < jlen; i ++){
        	if(jandn.containsKey(Jewels[i]))
        		res += jandn.get(Jewels[i]);
        }
*/
		int res = 0;
		char[] Stones = s.toCharArray();
                            
        for(char i:Stones){
        	if(j.indexOf(i) >= 0)
        		res ++;
        }
        return res;		
		
	}
	
	public static void main(String[] args) {
		String s = "aAAccc";
		String j = "aAc";
		System.out.println("res= " + numJewelsInStones(j,s));
	}
}
