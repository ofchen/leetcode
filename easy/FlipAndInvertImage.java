package LeetCode.easy;

public class FlipAndInvertImage {
	public static int[][] flipAndInvertImage(int[][] A) {
        int row = A.length;  
        
        for(int i = 0; i < row; i ++ ){
        	int col = A[i].length;
        	int j = 0;
        	if(col > 0){//������Ԫ��	        
	        	for(; j < col/2; j++)
	        		if((A[i][j] ^ A[i][col-1-j]) == 0){
	        			A[i][j] = 1 - A[i][j];
	        			A[i][col-1-j] = 1 - A[i][col-1-j];
	        		}
	        	if((col & 1) == 1)	
	        		A[i][j] = 1 - A[i][j];		
	        }
/*	        if(col > 0 && (col & 1) == 1){//������Ԫ��	        
	        	for(; j < col/2; j++)
	        		if((A[i][j] ^ A[i][col-1-j]) == 0){
	        			A[i][j] = 1 - A[i][j];
	        			A[i][col-1-j] = 1 - A[i][col-1-j];
	        		}
	        		//else 
	        	A[i][j] = 1 - A[i][j];		
	        }
	        else if(row > 0 && (col & 1) == 0){
	        	for(; j < col/2; j++)
	        		if((A[i][j] ^ A[i][col-1-j]) == 0){
	        			A[i][j] = 1 - A[i][j];
	        			A[i][col-1-j] = 1 - A[i][col-1-j];
	        		}
	        }
	        */
	        for(int k = 0; k < col; k++)
	        	System.out.print(A[i][k]+" ");
	        System.out.println();
        }
        return A;
    }
	
	public static void main(String[] args) {
		//int[][] A = {{1,1,0},{1,0,1},{0,0,0}};
		
		//int[][] A = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
		//int[][] A = {{1,0},{0,1}};
		//int[][] A = {{0}};
		int[][] A = {};
		System.out.println("res= " + flipAndInvertImage(A));
	}
}
