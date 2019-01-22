package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

import LeetCode.basic.TreeNode;

public class InorderTraversal {
	public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        return inOrder(root, res);
    }
    
    static List<Integer> inOrder(TreeNode root, List<Integer> res){
        if(root != null){
            if(root.left != null)  inOrder(root.left, res);
            res.add(root.getVal());
            if(root.right != null) inOrder(root.right, res); 
        }
        return res; 
    }
    
	public static void main(String[] args) {
		TreeNode rootNode = new TreeNode(1);
		TreeNode t1 = new TreeNode(2);
		TreeNode t2 = new TreeNode(3);
		rootNode.left = null;
		rootNode.right = t1;
		t1.left = t2;
		t1.right = null;
		t2.left = null;
		t2.right = null;
		
		System.out.println(inorderTraversal(rootNode));
	}

}
