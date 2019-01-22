package LeetCode.medium;

//ʱ�临�Ӷ�O(n^2),�ռ临�Ӷ�O(1)
//�ѵ����ڱ��뷽ʽ�ͽ��뷽ʽ���ĸ�б����������ж�
public class GameOfLife {
	public static void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; i ++)
            for(int j = 0; j < n; j ++){
            	System.out.println("i = " + i +", j = " + j);
            	int lives = 0;
                //��
                if(i > 0) lives += (board[i-1][j] == 1 || board[i-1][j] == 2) ? 1 : 0;
                //��
                if(i < m-1) lives += (board[i+1][j] == 1 || board[i+1][j] == 2) ? 1 : 0;
                //��
                if(j > 0) lives += (board[i][j-1] == 1 || board[i][j-1] == 2) ? 1 : 0;
                //��
                if(j < n-1) lives += (board[i][j+1] == 1 || board[i][j+1] == 2) ? 1 : 0;
                //����
                if(i > 0 && j > 0) lives += (board[i-1][j-1] == 1 || board[i-1][j-1] == 2) ? 1 : 0;
                //����
                if(i > 0 && j < n-1) lives += (board[i-1][j+1] == 1 || board[i-1][j+1] == 2) ? 1 : 0;
                //����
                if(i < m-1 && j > 0) lives += (board[i+1][j-1] == 1 || board[i+1][j-1] == 2) ? 1 : 0;
                //����
                if(i < m-1 && j < n-1) lives += (board[i+1][j+1] == 1 || board[i+1][j+1] == 2) ? 1 : 0;   
                
                if(board[i][j] == 0 && lives == 3){ //��������ֻ��0��1                   
                        board[i][j] = 3;
                }
                else if(board[i][j] == 1 && (lives < 2 || lives > 3)){                     
                        board[i][j] = 2;
                }
            }
        //����ʱ����0��1��2��3
        for(int i = 0; i < m; i ++)
            for(int j = 0; j < n; j ++)
                board[i][j] = (board[i][j] & 1);
        System.out.println();
    }
	public static void main(String[] args) {
		int [][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
		gameOfLife(board);
	}

}
