package LeetCode.easy;

public class ImageSmoother {
	public static int[][] imageSmoother(int[][] board) {
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; i ++)
            for(int j = 0; j < n; j ++){
            	int lives = board[i][j], temp = 0;
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
                
                if((i == 0 && (j == 0 || j == n-1)) || (i == m-1 && (j == 0 || j == n-1))) //�ĸ���                  
                        temp = lives/4;                
                else if(((i == 0 || i == m-1) && (j >= 1 && j <= n-2)) || ((j == 0 || j == n-1) && (i >= 1 && i <= m-2))) //���ĸ��ǵı���     
                        temp = lives/6;               
                else if((j >= 1 && j <= n-2) && (i >= 1 && i <= m-2))
                    temp = lives/9; 
                
                if(board[i][j] == 1 && temp == 0){ //��������ֻ��0��1     1->0              
                        board[i][j] = 2;
                }
                
            }
        //����ʱ����0��1��2��3
        for(int i = 0; i < m; i ++)
            for(int j = 0; j < n; j ++)
                board[i][j] = (board[i][j] & 1);
        
        return board;
    }
	
	public static void main(String[] args) {
		int [][] board = {{1,1,1},{1,1,1},{1,0,1}};
		imageSmoother(board);
	}
}
