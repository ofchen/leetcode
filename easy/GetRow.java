package LeetCode.easy;

import java.util.ArrayList;
import java.util.List;

public class GetRow {
	//Given a non-negative index k where k �� 33, 
	//return the kth index row of the Pascal's triangle. index from 0
	//����Ḳ�ǣ�������ֵ
	public static List<Integer> getRow(int rowIndex) {
		List<Integer> res = new ArrayList<Integer>(rowIndex+1);
		for(int i = 0; i < rowIndex+1; i ++)
			res.add(1);
		for(int i = 3; i <= rowIndex+1; i ++)
			for(int j = i-2; j > 0; j --)
				res.set(j, res.get(j)+res.get(j-1));
		return res;
    }
	
	public static void main(String[] args) {
		int nums = 4;
		getRow(nums);
	}
}
