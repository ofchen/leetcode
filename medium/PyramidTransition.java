package LeetCode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;


public class PyramidTransition {
		//NO.756 �����ַ����������жϸ����ַ����Ƿ���Թ��ɽ�������״
	
		public static boolean pyramidTransition(String bottom, List<String> allowed) {
	        Map<String, HashSet<Character>> m = new HashMap<String, HashSet<Character>>();
	        for(String str : allowed){
	            String key = str.substring(0,2);
	            HashSet<Character> set; 
	            if(!m.containsKey(key)){
	                set = new HashSet<Character>();
	            }
	            else{
	                set = m.get(key);
	            }
	            set.add(str.charAt(2));
	            m.put(key, set);
	        }
	        
	        return helper(bottom, "", m);
	    }
	    
	    public static boolean helper(String cur, String above, Map<String, HashSet<Character>> m){
	        int clen = cur.length(), alen = above.length();
	        if(clen == 2 && alen == 1) return true;
	        if(alen == clen-1) return helper(above, "", m);
	        int pos = alen;
	        String base = cur.substring(pos, pos+2);
	        if(m.containsKey(base)){
	            for(char c : m.get(base)){
	            	System.out.println("cur="+cur+",base="+base+",c="+c+",above="+above);
	            	if(helper(cur, above+c, m)) return true;
	            }
	        }
	        return false;
	    }
	    
	    public static void main(String[] args) {
//	    	String bottom = "XYZ";
//	    	String[] al = {"XYD", "YZE", "DEA", "FFF"};
	    	String bottom = "XXYX";
	    	String[] al = {"XXX", "XXY", "XYX", "XYY", "YXZ"};
	    	List<String> allowed = arToList(al);//Arrays.asList(al)
	    	System.out.println(pyramidTransition(bottom, allowed));
	    }
	    
	    public static List<String> arToList(String[] al) {
			List<String> resList = new ArrayList<String>();
			for(String s : al)
				resList.add(s);
			return resList;
		}
	    
}
