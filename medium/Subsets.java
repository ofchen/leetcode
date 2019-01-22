package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;
//��������Ӽ�
public class Subsets {
	public static List<List<Integer>> subsets(int[] nums){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> select = new ArrayList<Integer>();
		helper(select, nums, res, 0, 0);
		
		return res;	
	}
	
	//s������ȡ��������nums�������������ĳ��ӣ�pos����Ҫȡ�ڼ���λ�õ���
	public static void helper(List<Integer> s, int[] nums, List<List<Integer>> res, int pos, int iter){
		//��ÿ��helper�ж�����ǰ��ϼ������У���Ϊ������Ӽ�������ȫ����
		res.add(new ArrayList<Integer>(s));
		if(pos == nums.length) return;
		//����iter��������������ǰ����λ�ã�ֻ��ȡ�����������
		for(int i = iter; i < nums.length; i ++){
			int num = nums[i];
			//ȡ����������ȡ 
			if(s.contains(num)) continue;
			s.add(num);
			helper(s, nums, res, pos+1, i);
			//�������˽ڵ��Ҫ���ݵ���һ�������Ҫ�Ѽ��뵽����еĴ˵�ȥ����
			s.remove(s.size()-1);
		}
	}
		
		public static void main(String[] args) {
			int[] nums = {1,2,3,4};
			System.out.print(subsets(nums));
		}

}
