package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;
//ʹ��������Ԫ�ع���Ŀ��ֵ�������ظ���ʹ�õݹ�
public class CombineSum {
	public static List<Integer> ls = new ArrayList<Integer>();
	public static void dfsComSum(int[] candidates, int target, int index, List<List<Integer>> result, List<Integer> list){
				if(target < 0)
					return ;
				else if(target == 0){
					result.add(new ArrayList<Integer>(list));
					//System.out.println(list.toString());
				}
				else{
				    for (int i = index; i < candidates.length; i++){
				    	if (candidates[i] > target) break;
				    	list.add(candidates[i]);
				    	dfsComSum(candidates, target- candidates[i], i, result, list);//��ȱ���
				    	list.remove(list.size() - 1);//���ݣ�ʹ����һ������Ԫ��ֵ
				    }
				}
		
	}
	
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		
	   List<List<Integer>> result = new ArrayList<List<Integer>>();
	   List<Integer> list = new ArrayList<Integer>();
	   dfsComSum(candidates, target, 0, result, list);	   
		
	   return result;
	}
	
	public static void main(String args[]){
		int[] nums = {2, 3, 5,7};//{2, 3, 6, 7};
		int target = 7; //;9
		//long startTime = System.currentTimeMillis();
		List<List<Integer>> result = combinationSum(nums,target);
		System.out.println(result.toString());
	}
	
}
