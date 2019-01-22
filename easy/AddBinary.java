package LeetCode.easy;
//�����������
public class AddBinary {
	public static String addBinary(String a, String b) {
        int len1 = a.length(), len2 = b.length();
        if(len2 > len1)
            return addBinary(b,a);
        char[] res = new char[len1];
        char[] achs = a.toCharArray();
        char[] bchs = b.toCharArray();
        int i = len1-1, j = len2-1, carry = 0, op1 = 0;
        
        for(; j >= 0; i --, j --){
            op1 = achs[i] ^ bchs[j] ^ carry; //��ǰλֵ
            carry = ((achs[i] & bchs[j]) | ((achs[i] ^ bchs[j]) & carry)) & 1; //op2  ��λ            
            res[i] = (char)(48+op1); 
        }
        for(; i >= 0; i --){
            op1 = achs[i] & 1 ^ carry ; //��ǰλֵ ֻ�ܻ�ȡ0��1ֵ������&1ȡ���λ
            carry = achs[i] & carry ; //op2  ��λ
            res[i] = (char)(48+op1); 
        }
        if((carry & 1) == 1){ //carryΪ�������н�λ
            char[] newR = new char[len1+1];
            for(i = len1-1; i >= 0; i--)
                newR[i+1] = res[i];
            newR[0] = '1';
            return String.valueOf(newR);
        }
        return String.valueOf(res);
    }
	
	public static void main(String[] args) {
		String s = "1";
		String b = "1";
		//System.out.println(1 ^ 0);
		
		System.out.println(addBinary(s,b));
	}
}
