package LeetCode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import LeetCode.basic.TreeNode;

public class ZigzagLevelOrder {
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>() ;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) return res;
        queue.offer(root);
        boolean reverse = true;
        while(!queue.isEmpty()){
        	List<Integer> ares = new ArrayList<Integer>();
        	int len = queue.size();
        	for (int i = 0; i < len; i++) {
        		TreeNode treeNode = queue.poll();
        		if(treeNode.left != null) queue.offer(treeNode.left);
        		if(treeNode.right != null) queue.offer(treeNode.right);
        		
        		if(reverse)
        			ares.add(treeNode.val);
        		else
        			ares.add(0,treeNode.getVal());
			}
        	res.add(ares);
        	reverse = !reverse;
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
		
		System.out.println(zigzagLevelOrder(rootNode));
	}

}
