package LeetCode.hard;

public class SuperpalindromesInRange {
	//�㷨δ��ɣ������Ǵ��
	public static int superpalindromesInRange(String L, String R) {
        int llen = L.length(), rlen = R.length();
        int sum = 0;
        if(llen < rlen)
            sum = (int)Math.pow(10, (rlen+1)/2) - (int)Math.pow(10, (llen+1)/2);
        else
            sum = 9*(int)Math.pow(10, (rlen+1)/2) - 1;
        
        int temp = 0;
        
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < llen; i ++)
            sb.append('9');
        String ns = plusOne(sb.toString());
        while(ns.equals(L) == false){
            if(isPalindrome(ns))
                temp ++;
            ns = plusOne(ns);
        }
        sum -= temp;
        sb = new StringBuffer();
        sb.append("1");
        for(int i = 0; i < rlen; i ++)
            sb.append('0');
        ns = sb.toString();
        temp = 0;
        while(ns.equals(R) == false){
            if(isPalindrome(R))
                temp ++;
            R = plusOne(R);
        } 
        sum -= temp;
        return sum;
    }
    
    static boolean isPalindrome(String s){
        int len = s.length();
        char[] sc = s.toCharArray();
        for(int i = 0; i <= len/2; i ++)
            if(sc[i] != sc[len-1-i])
                return false;
        return true;
        
    }
    
    static String plusOne(String s){ //�ַ�����1����ֹint�������
        char[] sc = s.toCharArray();
        int len = sc.length;
        int carry = 1;
        for(int i = len-1; i >= 0; i --){
            sc[i] += carry;
            if(sc[i] > '9'){
                sc[i] -= 1;
                carry = 1;
            }
            else
                carry = 0;
        }
        StringBuffer sb = new StringBuffer();
        if(carry == 1){            
            sb.append("1");            
        }
        for(int i = 0; i < len; i ++)
                sb.append(sc[i]);    
       return sb.toString();         
    }
    
    public static void main(String[] args) {
		String L = "4";
		String R = "1000";
		superpalindromesInRange(L, R);
	}
}
