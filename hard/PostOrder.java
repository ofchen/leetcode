package LeetCode.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import LeetCode.basic.TreeNode;

public class PostOrder {
	//�ݹ����
	public static List<Integer> postorderTraversal_1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        return postOrder(root, res);
    }
    
    static List<Integer> postOrder(TreeNode root, List<Integer> res){
        if(root != null){
            if(root.left != null)  postOrder(root.left, res);
            if(root.right != null) postOrder(root.right, res);
            res.add(root.getVal());
        }
        return res; 
    }
    
    //�ǵݹ����
    public static List<Integer> postorderTraversal_2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> s = new Stack<TreeNode>();
        //��pre��¼�ϴη��ʽڵ㣬�жϵ�ǰ�ڵ�������������������
        TreeNode cur = root, pre = null;
        while(cur != null){
        	s.push(cur);
        	cur = cur.left;
        }
        while(!s.isEmpty()){
        	cur = s.pop();
        	if(cur.right == null || cur.right == pre){
        		res.add(cur.val);
        		pre = cur;
        	}
        	else {
				s.push(cur);
				cur = cur.right;
				while (cur != null) {
					s.push(cur);
					cur = cur.left;
				}
			}
        }
        
        return res;
    }
    
    //�ǵݹ����
    enum Tag{
    	LEFT, RIGHT
    	} //ö�ٳ�������,��Աȫ����д 
    private static class TagNode{
    	TreeNode root;
    	Tag tag;
    	public TagNode(TreeNode t, Tag tg) {
			this.root = t;
			this.tag = tg;
		}
    }
    public static List<Integer> postorderTraversal_3(TreeNode root) {
    	List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TagNode> s = new Stack<TagNode>();
        TagNode tg = null;
        TreeNode p = root;
        while(!s.isEmpty() || p != null){
        	while(p != null){
        		s.push(new TagNode(p, Tag.LEFT)); //TagNode���붨��ɾ�̬�����ֱ�ӵ��� 
        		p = p.left;
        	}
        	tg = s.pop();
        	if(tg.tag == Tag.LEFT){
        		tg.tag = Tag.RIGHT;
        		s.push(tg);
        		p = tg.root.right;
        	}
        	else {
				res.add(tg.root.val);
				p = null;
			}
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
		
		System.out.println(postorderTraversal_3(rootNode));
	}
}
