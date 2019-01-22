package LeetCode.medium;

import java.util.Arrays;

public class LengthOfLIS {
	public static int lengthOfLIS(int[] nums) {
		 if(nums == null || nums.length == 0) return 0;
			int len = nums.length, res = 0;
			int max[] = new int[len];
			max[0] = 1;
				        
	       for(int i = 1; i < len; i ++){			
			   int temp = 0;
	    	   for(int j = 0; j < i; j ++)
				//if(nums[i] > nums[j]) max[i] = Math.max(max[i], max[j]+1);
	    		   if(nums[i] > nums[j] && temp < max[j])
						temp =  max[j];
				max[i] = temp+1;
				res = Math.max(res, max[i]);
	       }
	       return res; 
	}
	
	//һֱ�滻���������е�Ԫ�����Ե��������С���䣡
	//���ֲ��ҷ�O(nlgn),�Ƚ���һ������ends������Ԫ�طŽ�ȥ��Ȼ��Ƚ�֮���Ԫ�أ��������������Ԫ�ر�
	//ends�����е���Ԫ��С�Ļ����滻��Ԫ��Ϊ����Ԫ�أ��������������Ԫ�ر�ends�����е�ĩβԪ�ػ���Ļ���
	//������Ԫ����ӵ�ends����ĩβ(ע�ⲻ����ԭĩβԪ��)���������������Ԫ�ر�ends������Ԫ�ش�
	//��βԪ��Сʱ����ʱ�ö��ֲ��ҷ��ҵ���һ����С�ڴ���Ԫ�ص�λ�ã����ǵ�λ�õ�ԭ�������֣�
	//�Դ�����ֱ������������nums���飬��ʱends����ĳ��Ⱦ�������Ҫ���LIS�ĳ��ȣ�
	//�ر�ע�����ends�����ֵ���ܲ���һ����ʵ��LIS����������������numsΪ{4, 2�� 4�� 5�� 3�� 7}��
	//��ô������ends����Ϊ{2�� 3�� 5�� 7}�����Է���������һ��ԭ�����LIS��ֻ�ǳ�����ȶ��ѣ�
	public static int lengthOfLIS2(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		int ends[] = new int[nums.length];
		Arrays.fill(ends, nums[0]);
		int templen = 1;
		
		for(int i: nums){
			if(i < ends[0]) 
				ends[0] = i;
			else if(i > ends[templen-1]){
				ends[templen++] = i;
			}
			else {
				int l = 0, r = templen;
				while(l < r){
					int m = l+(r-l)/2;
					if(ends[m] < i) l = m+1;
					else r = m;
				}
				ends[r] = i;
			}
		}
		return templen;
	}	
		
	//���ֲ��ҷ�O(nlgn),�Ƚ���һ���յ�dp���飬Ȼ��ʼ����ԭ���飬����ÿһ�������������֣�
	//�����ö��ֲ��ҷ���dp�����ҵ�һ����С���������֣����������ֲ����ڣ�
	//��ôֱ����dp���������ϱ����������֣�������ڣ���������ָ���Ϊ��ǰ�����������֣�
	//��󷵻�dp���ֵĳ��ȼ��ɣ�ע����ǣ�������ķ���һ�����ر�ע�����dp�����ֵ���ܲ���һ����ʵ��LIS
	public static int lengthOfLIS3(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		int max[] = new int[nums.length];
		int templen = 1;
		for(int i = 0; i < nums.length; i ++){	
			int l = 0, r = templen;
			while(l < r){
				int m = l+(r-l)/2;
				if(max[m] < nums[i]) l = m+1;
				else r = m;
			}
			if(r >= templen){
				max[templen++] = nums[i];
			}
			else max[templen] = nums[i];
		}
		return templen;
	}
	public static void main(String[] args) {
		int[] nums = {4,10,4,3,8,9};//{1,3,6,7,9,4,10,5,6};//{5,4,3,4,4,5};//{6,5,4,3,2,1};//{10,9,2,5,3,7,101,18};//
		System.out.print(lengthOfLIS2(nums));
	}

	
}
