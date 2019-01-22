package LeetCode.medium;

public class FirstUniqChar {
	//NO.387 �ҵ���Сд��ĸ���ɵ��ַ����ĵ�һ��ֻ����һ�ε��ַ����±꣬�߽��������ַ�������Ϊ��
	public static int firstUniqChar(String s) {
        if(s == null || s.length() == 0) return -1;
        int[][] ar = new int[128][2];
        char[] sc = s.toCharArray();
        int res = Integer.MAX_VALUE, len = sc.length;
        for(int i = 0; i < len; i++){
            if(ar[sc[i]][0]++ == 0){
                ar[sc[i]][1] = i;
            }   
        }   
        for(int i = 97; i < 123; i++) //acsii������±����±�97-122
            if(ar[i][0] == 1){
                res = res > ar[i][1] ? ar[i][1] : res;
            }
        
        
        return res == Integer.MAX_VALUE ? -1 : res;
    }
	
	public static int firstUniqChar2(String s) {
        if(s == null || s.length() == 0) return -1;
        int res = Integer.MAX_VALUE;
        
        for (char c = 'a'; c < 'z'; c++) {
			if(s.indexOf(c) != -1 && s.indexOf(c) == s.lastIndexOf(c))
				res = Math.min(res, s.indexOf(c));
			
		}
		if(res == Integer.MAX_VALUE) return -1;
		else return res;		
	}
	
	public static void main(String[] args) {
		//String s = "z";
		String s = "";
		System.out.print(firstUniqChar(s));
	}
}
