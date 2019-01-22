package LeetCode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import LeetCode.basic.TreeNode;

public class GenerateTrees {
	//No95. ����1~n�����ֹ��ɵĶ���������
	static List<TreeNode> res = new ArrayList<TreeNode>();//�ȹ������к����������ظ������
	public static List<TreeNode> generateTrees(int n) {                
        int[] ar = new int[n];
        for (int i = 1; i <= n; i++) {
        	ar[i-1] = i;
        }
        helper(ar, 0, n-1);        
		return res;
    }
	
	public static void helper(int[] ar, int idx, int end){
		if(idx == end){
			System.out.println(Arrays.toString(ar));
			res.add(buildBST(ar));
			return ;
		}
		else{
			for (int i = idx; i <= end; i++) {
				swap(ar, i, idx);
				helper(ar, idx+1, end);
				swap(ar, i, idx);
			}
		}
	}
	public static void swap(int[] ar, int i, int idx) {
		int temp = ar[i];
		ar[i] = ar[idx];
		ar[idx] = temp;
	}
	
	public static TreeNode buildBST(int[] ar){
		TreeNode t = new TreeNode(ar[0]);
		TreeNode q = t;
		for(int i = 1; i < ar.length; i++){
			while (q != null) {
				if(ar[i] < q.val){
					if(q.left == null){
						q.left = new TreeNode(ar[i]);
						break;
					}
					else 
						q = q.left;
				}
				else if(ar[i] > q.val){
					if(q.right == null){
						q.right = new TreeNode(ar[i]);
						break;
					}
					else 
						q = q.right;	
				}
			 }
		}
		return t;
	}
	
	public static void main(String[] args) {
		int n = 4;
		generateTrees(n);
	}

}
