package LeetCode.easy;
//���������ּ�1����Ҫ�����λ
public class PlusOne {
	public static int[] plusOne(int[] digits) {
        int len = digits.length;
        int i = len-1;
        if(digits[i] <= 8){
            digits[i] += 1;   
            return digits;
        }
        else{
            //int[] newD = new int[len+1];//��1���������һλ���߲�����
            int carry = 1; //j�������һ�������±�
            for(i = len-1; i >= 0; i --){
                if((digits[i]+carry) / 10 == 1){
                    carry = 1;
                    digits[i] = 0;    
                }
                else{
                	digits[i] += carry;
                    carry = 0;
                    break;
                }
            }
            if(carry == 1){
                int [] newD = new int[len+1];
                for(i = len-1; i >= 0; i --){
                    newD[i+1] = digits[i];
            	newD[0] = 1;
            	return newD;
                }
            }
            return digits;
            } 
    }
	
	public static void main(String[] args) {
		int[] num = {9};
		//System.out.println(1 ^ 0);
		System.out.println(plusOne(num));
	}
}
