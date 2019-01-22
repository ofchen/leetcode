package LeetCode.medium;

public class SingleNumberIII {
/*����������������ͬ������Ϊ A �� B��
1.ͨ�������������鲢������������������֮��� XOR������ XOR �����Կ��Եõ����յĽ��Ϊ AXORB = A XOR B��
2.ͨ��ĳ���ض��ķ�ʽ�����ǿ���ͨ�� AXORB �õ������� A ������ B �Ķ�������ĳһλ����ͬ��λ����ΪA �� B 
�ǲ���ͬ�ģ��������ǵĶ�������������������һλ�ǲ���ͬ�ġ����ǽ���һλ����Ϊ 1���������е�����λ����Ϊ 0��
���Ǽ������ǵõ����������Ϊ bitFlag��
3.��ô���ڣ����Ǻ�����֪�������� A �� ���� B �б�Ȼ��һ���������� bitFlag Ϊ 0����ΪbitFlag 
��־������ A ������ B �е�ĳһλ��ͬ����ô������ A �� B �е���һλ��Ȼ��һ��Ϊ 0����һ��Ϊ 1��
�������� bitFlag �н�����λ������Ϊ 0����ô��λΪ 0 ���������� bitFlag �͵��� 0��
����λΪ 1 ���������� bitFlag �͵��� bitFlag
4.��������ͼ��ˣ�����ֻ��Ҫ��ѭ��һ�����飬������ bitFlag Ϊ 0 �����ֽ��� XOR ���㣬
���� bitFlag ��Ϊ 0 ��������ж����� XOR ���㡣��ô������ǵõ������������־��� A �� B��
*/
	public static int[] singleNumber(int[] nums) {
        int AXORB = 0;
        for (int num : nums) {
            AXORB ^= num; 
        }
        // pick one bit as flag
        int bitFlag = (AXORB & (~ (AXORB - 1)));
        int[] res = new int[2];
        for (int num : nums) {
            if ((num & bitFlag) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }
	
	public static void main(String[] args){
		int[] nums={1,1,2,3,3,4};
		singleNumber(nums);
	}
}
