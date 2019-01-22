package LeetCode.DataStructure;

import java.util.Stack;

import LeetCode.basic.TreeNode;

//BST�������ڵ�ֵС�ڸ��ڵ㣬�������ڵ�ֵ���ڸ��ڵ�
//����������������ķǵݹ���ʽ
public class BSTIterator {
	Stack<TreeNode> stack = new Stack<TreeNode>();
	
	public BSTIterator(TreeNode root) {
	     while(root != null){
	    	 stack.push(root);
	    	 root = root.left;
	     }
	    	 
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();        
    }

    /** @return the next smallest number */
    //���ص�ǰֵ��ʹջ��ָ�������һ������Ԫ��
    public int next() {
    	TreeNode q = stack.pop();
    	int res = q.val;
    	if(q.right != null){
    		q = q.right;
    		while (q != null ) {
    			stack.push(q);
   	    	    q = q.left;
			}
    	}
    	return res;
    }
    
    public static void main(String[] args){
    	
    }
}
