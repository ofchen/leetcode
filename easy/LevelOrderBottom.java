package LeetCode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import LeetCode.basic.TreeNode;
//���Ĳ�α����������ʹ�ö��У����õķ�����һ��ֱ�ӱ���һ�㡣
public class LevelOrderBottom {
	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(root == null)
			return res;
		
		Queue<TreeNode> qu = new LinkedList<TreeNode>();
		List<Integer> ares = new ArrayList<Integer>();
		qu.offer(root);
		qu.offer(null); //�����ʾ������ı�־,ÿ�α�������queue��������������
		while(!qu.isEmpty()){
			TreeNode q = qu.poll();
			while(q == null && !qu.isEmpty()){ 
				q = qu.poll();
			}
			if(q == null && qu.isEmpty())
				break;
			ares.add(q.getVal());
			TreeNode aq = qu.peek(); //�鿴�¸�Ԫ���Ƿ��ǲ������־
			if(aq == null){
				res.add(0, ares);//�������
				System.out.println("ares= "+ares);
				qu.poll();
				ares = new ArrayList<Integer>();
				System.out.println("res= "+res);
				//ares.clear();//ÿ�ζ�Ҫ��������ares.
			}		
			if(q.left != null){
				qu.offer(q.left);
				if(aq == null && q.right == null)
					qu.offer(null);//���������־
			}
			if(q.right != null){
				qu.offer(q.right);
				if(aq == null)
					qu.offer(null);//���������־
			}
			if(q.left == null && q.right == null){//Ҷ�ӽ��
				qu.offer(null);
			}
		}
		
		return res;
	    }
	
	public static void main(String[] args) {
		TreeNode t = new TreeNode(3);
		TreeNode t1 = new TreeNode(4);
		TreeNode t3 = new TreeNode(-7);
		TreeNode t4 = new TreeNode(-6);
		TreeNode t6 = new TreeNode(-5);
		t.left = t1;
		t1.left = t3;
		t1.right = t4;
		t4.left = t6;
		System.out.println("result="+ levelOrderBottom(t));
	}
}
