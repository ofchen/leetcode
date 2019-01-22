package LeetCode.easy;

import LeetCode.basic.TreeNode;
//ʹ��ջ��Ҫ�ع��ڵ㣬�������Ա�ʾ���ýڵ���֪·���ڵ��
public class HasPathSum {
	public static boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
        	return false;
        if(root.left == null && root.right == null)
        	return root.getVal() == sum;
        return hasPathSum(root.left, sum-root.getVal()) || hasPathSum(root.right, sum-root.getVal());		
    }
	
	public static void main(String[] args) {
		TreeNode t = new TreeNode(5);
		TreeNode t1 = new TreeNode(4);
		TreeNode t2 = new TreeNode(8);
		TreeNode t3 = new TreeNode(11);
		TreeNode t4 = new TreeNode(13);
		TreeNode t5 = new TreeNode(4);
		TreeNode t6 = new TreeNode(7);
		TreeNode t7 = new TreeNode(2);
		TreeNode t8 = new TreeNode(1);
		
		t.left = t1;
		t.right = t2;
		t1.left = t3;		
		t2.left = t4;
		t2.right = t5;
		t3.left = t6;
		t3.right = t7;
		t5.right = t8;
		System.out.println("result="+ hasPathSum(t,18));
	}
	
}
