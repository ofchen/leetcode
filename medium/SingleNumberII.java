package LeetCode.medium;

public class SingleNumberII {
	//�벻���ף����Ǽ������ַ�����
	public static int singleNumber(int[] A) {
		int ones = 0, twos = 0;
        for(int i : A){
        	//ȡ��Ϊ8λ�����ƣ�����ȡ����Ϊ���������������Ϊ���룬��Ļ���Ϊ����������ĸ���
        	System.out.println("ones="+ones+", i="+i+", twos="+twos+", ~twos="+ ~twos);
            ones = (ones ^ i) & ~twos;
            System.out.println("twos="+twos+", i="+i+", ones="+ones+", ~ones="+ ~ones);
            twos = (twos ^ i) & ~ones;
        }
        return ones;
    }
	
	/*����һ��32λ�����֣���ͳ��ÿһλ��1���ֵĸ���������֪�����ĳһλ��Ϊ1�Ļ�����ô������������������Σ�
	 * ��3ȥ��Ϊ0�����ǰ�ÿ�����Ķ�Ӧλ����������3ȡ�࣬����ʣ�������Ǹ������ǵ���������
	*/
	public static int singleNumber2(int[] A) {
		int res = 0;
		for(int i = 0; i < 32; i++){
			int sum = 0;
			for(int j : A){
				System.out.println("i="+i+",right shift="+(j>>i));
				sum += (j >> i) & 1;
				System.out.println("sum="+sum);
			}
			res |= (sum%3) << i;
			System.out.println("sum shift="+((sum%3) << i) + ", res="+res);
		}
		
		return res;
	}
	
	public static void main(String[] args){
		int[] nums={12,4,12,3,12,3,3};
		singleNumber(nums);
	}
}
