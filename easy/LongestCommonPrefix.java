package LeetCode.easy;
//����ʵ������ǰ׺����
public class LongestCommonPrefix {

	public static String longestCommonPrefix(String[] strs) {
		String res = "";
		int len = strs.length;
		if(len > 0){
			int i = 0;		
			int minStrlen = strs[0].length();
			for(i = 0; i < len; i ++){
				int curlen = strs[i].length();
				if(curlen == 0)
					return res;
				if(curlen < minStrlen)
					minStrlen = curlen;				
			}
			for(i = 0; i < minStrlen; i ++){
				char c = strs[0].charAt(i);
				int j = 1;
				for( ; j < len; j ++){
					if(c != strs[j].charAt(i))
						break;
				}
				if(j != len)
					break;
			}			
			res = strs[0].substring(0,i);
		}
		return res;
	}
	
	public static void main(String[] args) {
		String[] strs = {};//{" ","doga","dogb"};
		System.out.println(longestCommonPrefix(strs));
	}

}
