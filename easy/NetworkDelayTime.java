package LeetCode.easy;

public class NetworkDelayTime {
//NO.743 ����Ԫ���(u,v,w),uΪԴ�ڵ㣬vΪĿ�Ľڵ㣬wΪ�źŴ���������ӽڵ�k�����ź���Ҫ������нڵ㶼���յ��ź�
	private static int networkDelayTime(int[][] nums, int N, int K) {
		int[][] map = new int[N][N];
        int max = 6000;
        
        //�����ڽӾ���
        for(int i = 0; i < N; i ++){
			for (int j = 0; j < N; j++) 
				map[i][j] = 6000;
			map[i][i] = 0;
		}
		for (int i = 0; i < nums.length; i++) {
			map[nums[i][0]-1][nums[i][1]-1] = nums[i][2];
		}
        
        //Dijkstra��Դ��ͼ������������·������
        int len = N, start = K-1;
		int[] res = new int[len];
		boolean[] isVisited = new boolean[len];
		for(int i = 0; i < len; i ++){
			//isVisited[i] = false;
			res[i] = Integer.MAX_VALUE;
		}
		isVisited[start] = true;
		res[start] = 0;
		int unVisitedNum  = len-1;
		int index = start;
		for(int i = 0; i < len; i ++){
			while (unVisitedNum > 0 && !isVisited[i]) {
				int min = Integer.MAX_VALUE;
				for (int j = 0; j < len; j++) 
					if(min > res[j] && !isVisited[j]){
						index = j;
						min = res[j];
				}
			
			
			for (int j = 0; j < len; j++) 
				if(res[index]+map[index][j] < res[j])
					res[j] = res[index]+map[index][j];
		
			unVisitedNum --;
			isVisited[index] = true;
			}
		}
        
        int out = 0;
		for (int i = 0; i < N; i++)
			out = out > res[i] ? out : res[i];
        
        return out == max ? -1 : out;
	
	}

	public static void main(String[] args) {
		int[][] nums = {{2,1,1},{2,3,1},{3,4,1}};
		int N = 4;
		int K = 2;
		System.out.println(networkDelayTime(nums, N, K));

	}	

}
