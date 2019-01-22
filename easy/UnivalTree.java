package LeetCode.easy;

import java.util.Stack;

import LeetCode.basic.TreeNode;

public class UnivalTree {
	public static boolean isUnivalTree(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return true;
        int val = root.val;
        
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode p = root;
        while(!st.isEmpty() || p != null){            
            while(p != null){
                if(p.left != null && p.left.val != val)
                    return false;
                st.push(p);                
                p = p.left;                 
            }
            if(!st.isEmpty()){
                p = st.pop();
                if(p.right != null && p.right.val != val)
                    return false;
                p = p.right;     
            }
        }
        return true;
    }
	
	public static boolean isUnivalTree2(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return true;
        int val = root.val;
        return isUnivalTreeDFS(root, val);
	}
	
	//ʹ�����������
	public static boolean isUnivalTreeDFS(TreeNode root, int val) {		
		if(root == null)
			return true;
		else 
			return ((root.val == val) 
					&& (isUnivalTreeDFS(root.right, val)) 
					&& (isUnivalTreeDFS(root.left, val)));
		
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode le1 = new TreeNode(1);
		TreeNode r1 = new TreeNode(1);
		TreeNode le21 = new TreeNode(1);
		TreeNode r21 = new TreeNode(1);
		TreeNode r22 = new TreeNode(2);
		root.left = le1;
		root.right = r1;
		le1.left = le21;
		le1.right = r21;
		r1.right = r22;
		System.out.print(isUnivalTree2(root));
	}
}
