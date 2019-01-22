package LeetCode.DataStructure;

import java.util.Arrays;

public class Dijkstra {
	//Dijkstra��Դ��ͼ������������·������
	public static int[] dijkstra(int start, int[][] m){
		int len = m.length;
		int[] res = new int[len]; //��ͼ�����������������
		boolean[] isVisited = new boolean[len]; //�ѱ��������δ��������
		Arrays.fill(res, Integer.MAX_VALUE); //���������ʼ��Ϊ���ֵ
		/*for(int i = 0; i < len; i ++){
			//isVisited[i] = false;
			res[i] = Integer.MAX_VALUE;
		}*/
		isVisited[start] = true;
		res[start] = 0;
		int unVisitedNum  = len-1;
		int index = start; //ָʾ��ǰ�����Ķ���
		for(int i = 0; i < len; i ++){
			while (unVisitedNum > 0 && !isVisited[i]) {
				//��δ�����ĵ㼯�в��Ҿ�����С����ĵ㣬��Ϊ���¾���ֵ�Ļ�׼
				int min = Integer.MAX_VALUE;
				for (int j = 0; j < len; j++) 
					if(min > res[j] && !isVisited[j]){
						index = j;
						min = res[j];
				}
				
				//�������е�ľ���ֵ
				for (int j = 0; j < len; j++) 
					if(res[index]+m[index][j] < res[j])
						res[j] = res[index]+m[index][j];
				
				//δ�����ĵ����-1
				unVisitedNum --;
				isVisited[index] = true; //����׼������ѱ����㼯��
			}
		}
		return res;
	}
	
	//�����޻�ͼDAGʹ��dijkstra��i->j, �����޻�ͼ��i->j,ͬʱj->i
	public static int[][] toMatrix(int[][] edges, int k){
		int[][] res = new int[k][k];
		for(int i = 0; i < k; i ++){
			for (int j = 0; j < k; j++) 
				res[i][j] = 6000;
			res[i][i] = 0;
		}
		for (int i = 0; i < edges.length; i++) {
			res[edges[i][0]-1][edges[i][1]-1] = edges[i][2];
		}
		return res;
	}
	
	
	public static void main(String[] args) {
		int max = 6000;
		int N = 4;
		int [][] edges = {{2,1,1},{2,3,1},{3,4,1}};//{{2,1,1},{2,3,1},{2,4,3},{5,3,1}};
		//�б�ʾ�ĵ㵽�б�ʾ�ĵ�
		int[][] m = toMatrix(edges, N);//{{0,max,max,3},{2,0,1,1},{max,max,0,1},{max,max,max,0}};		
		int K = 2;
		System.out.println(Arrays.toString(dijkstra(K-1, m)));
		int[] out = dijkstra(K-1, m);
		int res = 0;
		for (int i = 0; i < N; i++)
			res = res > out[i] ? res : out[i];
		System.out.println(res == max ? -1 : res);
	}
}
