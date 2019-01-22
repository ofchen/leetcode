package LeetCode.easy;
//�ַ���ģʽƥ�䣬 �����Ӵ���������һ�γ��ֵ�λ��
public class StrStr {
	public static int strStr(String haystack, String needle) {
        int hlen = haystack.length(), nlen = needle.length();
        if(nlen == 0)
        	return 0;
        else if(nlen == 1)
        	return haystack.indexOf(needle.charAt(0));
        if(hlen == 0 || hlen < nlen)
        	return -1;
       
       
        //��ģʽ����nextval[]
        int i = 0, j = -1;
        int[] nextval = new int[nlen];  
        nextval[0] = -1;
        while(i < nlen-1){
        	if(j == -1 || needle.charAt(i) == needle.charAt(j)){
        		++ i;
        		++ j;        		
        		if(needle.charAt(i) != needle.charAt(j)) 
        			nextval[i] = j;
        		else
        			nextval[i] = nextval[j]; 
        	}
        	else
        		j = nextval[j];
        }
        
        i = 0;
        j = haystack.indexOf(needle.charAt(0));        
    	if(j >= 0){
	        while(i < nlen && j < hlen){
	    		if(haystack.charAt(j) == needle.charAt(i)){
	    			i ++; 
	    			j ++;
	    			System.out.println("i= "+ i + ", j=" + j);
	        	}
	        	else{
	        		System.out.println("i= "+ i + ",next[i]= " +nextval[i] + ", j=" + j);
	        		i = nextval[i]; 
	        		if(i == -1){
	        			j ++;
	        			i = 0;
	        		}
	        	}    			
	        }
	    	if(i == nlen)
	    		return j-nlen;
    	}
    	return -1;
        
    }
	
	public static void main(String[] args) {
		String s = "";
		String n = "";
		System.out.println("res= " + strStr(s,n));
	}
}
