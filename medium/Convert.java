package LeetCode.medium;
//�ַ�������һ����ʽ��������ظ�ʽ����ÿ��������ɵ��ַ���
public class Convert {
	
	public static String convert(String s, int numRows) {
        if(numRows >= 2){
        	int len = s.length();
        	char[] arr = new char[len] ;
        	
        	int i = 0;        	
        	int jump = 2*(numRows-1);
        	for(i = 0; i*jump < len; i ++)//��һ��
        		arr[i] = s.charAt(i*jump);       	
        	String res = String.valueOf(arr).substring(0, i);
        	
        	for(i = 1; i < numRows-1; i ++){
        		int index1 = i;
        		int index2 = jump-i;
        		int j = 0;
        		int k = 0;
        		while(index1 < len){
        			arr[j] = s.charAt(index1);
        			index1 += jump;
        			j += 2;
        		}
        		k = j;
        		for(j = 1; index2 < len; index2 += jump, j += 2)
        			arr[j] = s.charAt(index2);
        		j = j > k ? j : k; 
        		String a = String.valueOf(arr).substring(0, j-1);
        		System.out.println(a);
        		res += String.valueOf(arr).substring(0, j-1);
        	}
        	
        	for(i = 0; i*jump+(numRows-1) < len; i ++)//���һ��
        		arr[i] = s.charAt(i*jump+(numRows-1));       		
        	res += String.valueOf(arr).substring(0,i);
        	
        	return res;
        }        			        
        else
        	return s;
		
    }
	
	public static void main(String[] args) {
		String s = "PAYAL";//"PAYPALISHIRING";
		int n = 2;
		System.out.println(convert(s,n).toString());
	}

}
