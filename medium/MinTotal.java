package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;
//Given a triangle, find the minimum path sum from top to bottom. 
//Each step you may move to adjacent numbers on the row below.
public class MinTotal {
	//��̬�滮���ӵڶ��п�ʼ��triangle[i][j] = min(triangle[i - 1][j - 1], triangle[i - 1][j])
	/*���������������һ�У���Ϊ�������µ�һλ���顣Ȼ������������DP���飬����ÿ�����֣�
	 * ����֮���Ԫ�رȽ�ѡ���С���ټ�������һ������λ�õ�Ԫ����Ϊ�µ�Ԫ�أ�
	 * Ȼ��һ��һ�������ɨ�裬�������̺�ð�������ԭ���࣬�����С��Ԫ�ض�ð��ǰ�棬��һ��Ԫ�ؼ�Ϊ����
	 * */
	public static int minTotal(List<List<Integer>> triangle) {
		int n = triangle.size();
		List<Integer> dp = triangle.get(n-1);
		
		for(int i = n-2; i >= 0; -- i)
			for(int j = 0; j <= i; ++ j)
				dp.set(j, Math.min(dp.get(j), dp.get(j+1)) + triangle.get(i).get(j));
		
		return dp.get(0);
	}
	
	@SuppressWarnings("serial")
	public static void main(String[] args) {
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		List<Integer> dp = new ArrayList<Integer>(){{add(2);}};		
		triangle.add(dp);
		dp = new ArrayList<Integer>(){{add(3); add(4);}};		
		triangle.add(dp);
		dp = new ArrayList<Integer>(){{add(6); add(5); add(7);}};		
		triangle.add(dp);
		dp = new ArrayList<Integer>(){{add(4); add(1); add(8); add(3);}};		
		triangle.add(dp);
		minTotal(triangle);
	}
}
