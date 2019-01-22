package LeetCode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import LeetCode.basic.TreeNode;

public class PathSum {
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(sum == 0 || root == null ) return res;
        preOrder(root, new ArrayList<Integer>(), res, sum);
        return res;
    }
    
    public static void preOrder(TreeNode r, List<Integer> ares, List<List<Integer>> res, int sum){        
        if(r != null && r.left == null && r.right == null){
        	if(sum == r.val){
        		ares.add(r.val);
        		res.add(ares);
        		System.out.println(ares);
        		//ares = new ArrayList<Integer>();
        	}            
            return ;
        }
        else if(r != null){
                ares.add(r.val);
                sum -= r.val;
                preOrder(r.left, ares, res, sum);
                
                //sum += r.val;
                preOrder(r.right, ares, res , sum);  
                ares.remove(ares.size()-1);     
        }
        else return;
    }
	public static void main(String[] args) {
		TreeNode t = new TreeNode(5);
		TreeNode t2 = new TreeNode(4);
		TreeNode t3 = new TreeNode(8);
		TreeNode t4 = new TreeNode(11);
		TreeNode t5 = new TreeNode(13);
		TreeNode t6 = new TreeNode(4);
		TreeNode t7 = new TreeNode(7);
		TreeNode t8 = new TreeNode(2);
		TreeNode t9 = new TreeNode(5);
		TreeNode t10 = new TreeNode(1);
		t.left = t2;
		t.right = t3;
		t2.left = t4;
		t3.left = t5;
		t3.right = t6;
		t4.left = t7;
		t4.right = t8;
		t6.left = t9;
		t6.right = t10;
		pathSum(t,22);
	}

}
