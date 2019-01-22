package LeetCode.DataStructure;

public class FloydAlgorithm {
	//��ͼ�Ĵ�Ȩ�ڽӾ�����ÿһ�Զ��������·��ʱ�临�Ӷ�O(n^3)
	public static void ShortestPath_FLOYD(int[][] matrix) {
		//���������и��Զ���v��w֮������·��p[v][w]�����Ȩ����d[v][w],��p[v][w][u]Ϊtrue��u�Ǵ�v��w��ǰ������·���ϵĶ���
		int len = matrix.length;
		int[][] d = new int[len][len];
		boolean[][][] p = new boolean[len][len][len];
		
		for(int v = 0; v < len; v ++)
			for(int w = 0; w < len; w ++){
				d[v][w] = matrix[v][w];
				if(d[v][w] < Integer.MAX_VALUE){
					p[v][w][v] = true;
					p[v][w][w] = true;
				}
			}
		
		for(int u = 0; u < len; u ++)
			for(int v = 0; v < len; v ++)
				for(int w = 0; w < len; w ++){
					if(d[v][u]+d[u][w] < d[v][w]){//��v��u��w��һ��·������
						d[v][w] = d[v][u]+d[u][w];
						for(int i = 0; i < len; i ++)
							p[v][w][i] = p[v][u][i] || p[u][w][i];
					}
				}
		
		System.out.println("shortest path length:");
		for(int v = 0; v < len; v ++){
			for(int w = 0; w < len; w ++)
				System.out.print(" "+d[v][w]);
			System.out.println();
		}
		
		System.out.println("shortest path");
		for(int v = 0; v < len; v ++){
			for(int w = 0; w < len; w ++){
				for (int u = 0; u < len; u++) {
					if(p[v][w][u])
						System.out.print(" "+u);
				}
				System.out.print("\t");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int [][] matrix = {{0,4,11},{6,0,2},{3,Integer.MAX_VALUE,0}};
		ShortestPath_FLOYD(matrix);
	}
}
