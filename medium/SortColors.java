package LeetCode.medium;

import java.util.Arrays;

/*����һ�����к�ɫ����ɫ����ɫ��n����������飬�����ǽ��о͵�����ʹ��ͬ��ɫ�Ķ������ڣ���ɫ˳��Ϊ��ɫ��
  ��ɫ����ɫ��������ǽ�ʹ������0,1��2�ֱ��ʾ��ɫ����ɫ����ɫ��
ע�⣺����Ӧ��ʹ�ÿ������������������⡣
  */
public class SortColors {
	//ά������λ�ã��ֱ�Ϊ0�Ľ���λ�ú�2�Ŀ�ʼλ�ã�����ʱ�������0���ǰ���λ�ý���������2��ͺ����λ�ý���
	public static int[] sortColors(int[] nums) {
		int pos0 = 0, pos1 = 0, pos2 = nums.length-1;
		//pos1==pos2ʱ��Ҫ�жϣ���Ϊ��֪����λ�õľ���ֵ,posָ��Ҫ�жϵ�����
		while(pos1 <= pos2){
			int temp; 
			if(nums[pos1] == 0){
				temp = nums[pos0];
				nums[pos0] = nums[pos1];
				nums[pos1] = temp;
				++ pos0;
				++ pos1;
			}
			else if(nums[pos1] == 2){
				temp = nums[pos1];
				nums[pos1] = nums[pos2];
				nums[pos2] = temp;
				-- pos2;
			}
			else {
				++ pos1;
			}
		}
		return nums;
	}
	
	public static void main(String[] args) {
		int[] nums = {2,1,0,0,0,1};
		System.out.println(Arrays.toString(sortColors(nums)));
	}
}
