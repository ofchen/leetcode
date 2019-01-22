package LeetCode.easy;

import LeetCode.basic.TreeNode;

public class Tree2str {		
	public static String tree2str(TreeNode t){
		StringBuilder sb = new StringBuilder();
        if(t == null) return "";        
        sb.append("()");
        preOrder(t, sb, 1);
        String res = sb.toString().replaceAll("(\\(\\)\\(\\))+", "");
        res = res.replaceAll("\\)\\(\\)", ")");
        return res.substring(2, res.length()-2);
	}
	
	public static void preOrder(TreeNode t, StringBuilder sb, int k){
		if(t == null){
			sb.insert(sb.length()-k, "()");
			return;
		}
		else{
			sb.insert(sb.length()-k, "("+t.val+")"); 
			preOrder(t.left, sb, k+1);
			preOrder(t.right, sb, k+1);
		}
	}
	
	
	public static void preOrder2(TreeNode t, StringBuilder sb){
		if(t == null){			
			return;
		}
		sb.append("(");
		if(t.left == null && t.right != null) sb.append("()");		
		preOrder2(t.left, sb);
		preOrder2(t.right, sb);
		sb.append(")");		
	}
	
	public static String tree2str2(TreeNode t){
		if (t == null) return "";
        String res = "" + t.val;
        String left = tree2str2(t.left), right = tree2str2(t.right);
        if (left == "" && right == "") return res;
        if (left == "") return res + "()" + "(" + right + ")";
        if (right == "") return res + "(" + left + ")";
        return res + "(" + left + ")" + "(" + right + ")";
	}
	
	public static void main(String[] args) {
		TreeNode t = new TreeNode(1);
		TreeNode l1 = new TreeNode(2);
		TreeNode r1 = new TreeNode(3);
		TreeNode l2 = new TreeNode(4);
		t.left = l1;
		t.right = r1;
		l1.right = l2;
		System.out.print(tree2str(t));

	}

}
