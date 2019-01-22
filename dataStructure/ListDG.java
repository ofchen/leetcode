package LeetCode.DataStructure;

import java.util.LinkedList;
import java.util.Queue;
//https://github.com/wangkuiwu/datastructs_and_algorithm/blob/master/source/graph/topsort/dag/java/ListDG.java
//���ڽӱ�ʵ�ֵ�����ͼ������������
public class ListDG {
	// �ڽӱ��б��Ӧ������Ķ���
	private class ENode{
		int ivex; // �ñ���ָ��Ķ����λ��
		ENode nextEdge; // ָ����һ������ָ��
	}
	
	// �ڽӱ��б�Ķ���
	private class VNode {
		char data; // ������Ϣ
		ENode firstEdge;  // ָ���һ�������ö���Ļ�
		
	}
	
	private static VNode[] mVexs; // ��������
	
	//����ֵ��-1 -- ʧ��(�����ڴ治���ԭ����),0 -- �ɹ����򣬲�������,1 -- ʧ��(������ͼ���л���)    
		public static int topologicalSort() {
			int index = 0;
		    int num = mVexs.length;
		    int[] ins;               // �������
		    char[] tops;             // �������������飬��¼ÿ���ڵ����������š�
		    Queue<Integer> queue;    // �������

		    ins   = new int[num];
		    tops  = new char[num];
		    queue = new LinkedList<Integer>();

		    // ͳ��ÿ������������
		    for(int i = 0; i < num; i++) {

		        ENode node = mVexs[i].firstEdge;
		        while (node != null) {
		            ins[node.ivex]++;
		            node = node.nextEdge;
		        }
		    }

		    // ���������Ϊ0�Ķ��������
		    for(int i = 0; i < num; i ++)
		        if(ins[i] == 0)
		            queue.offer(i);                 // �����

		    while (!queue.isEmpty()) {              // ���зǿ�
		        int j = queue.poll().intValue();    // �����С�j�Ƕ�������
		        tops[index++] = mVexs[j].data;  // ���ö�����ӵ�tops�У�tops��������
		        ENode node = mVexs[j].firstEdge;// ��ȡ�Ըö���Ϊ���ĳ��߶���

		        // ����"node"�����Ľڵ����ȼ�1��
		        // ����1֮�󣬸ýڵ�����Ϊ0���򽫸ýڵ���ӵ������С�
		        while(node != null) {
		            // ���ڵ�(���Ϊnode.ivex)����ȼ�1��
		            ins[node.ivex]--;
		            // ���ڵ�����Ϊ0������"�����"
		            if( ins[node.ivex] == 0)
		                queue.offer(node.ivex);    // �����

		            node = node.nextEdge;
		        }
		    }

		    if(index != num) {
		        System.out.println("Graph has a cycle\n");
		        return 1;
		    }
		    
		 // ��ӡ����������
	        System.out.println("== TopSort: ");
	        for(int i = 0; i < num; i ++)
	            System.out.println(tops[i]);
	        System.out.println();

	        return 0;
		}
}