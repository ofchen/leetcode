package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;
//Given a collection of distinct integers, return all possible permutations.
//��һ�������ȫ���У�ʹ�û��ݷ�
public class Permutations {
	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> select = new ArrayList<Integer>();
		helper(select, nums, res, 0);
		
		return res;	        
	}
	
	//s������ȡ��������nums�������������ĳ��ӣ�pos����Ҫȡ�ڼ���λ�õ���
	public static void helper(List<Integer> s, int[] nums, List<List<Integer>> res, int pos){
		//������������ȡ�˳��������е��������һ������
		if(pos == nums.length){
			res.add(new ArrayList<Integer>(s));
			return ;
		}
		for(int i = 0; i < nums.length; i ++){
			int num = nums[i];
			//ȡ����������ȡ 
			if(s.contains(num)) continue;
			s.add(num);
			helper(s, nums, res, pos+1);
			//�������˽ڵ��Ҫ���ݵ���һ�������Ҫ�Ѽ��뵽����еĴ˵�ȥ����
			s.remove(s.size()-1);
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		System.out.print(permute(nums));
	}
}
