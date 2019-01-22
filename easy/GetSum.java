package LeetCode.easy;

public class GetSum {
	//ʹ����λ����ʵ�ּӷ�
	public static int getSum(int a, int b){
		//��λ���㣬�����ǽ�λ
		int res = a ^ b;
		//��λ���㣬Ϊ1��λ����Ҫ��λ��λ
		int temp = (a & b) << 1;
		while(temp != 0){
			System.out.println(res);
			System.out.println(temp);
			int copy = res;
			res ^= temp;
			temp = (copy & temp) << 1;
		}
		return res;
	}
	
	public static void main(String[] args) {
		int a = 123;
		int b = 789;
		System.out.println(getSum(a, b));
	}
}
