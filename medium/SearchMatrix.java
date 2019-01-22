package LeetCode.medium;

public class SearchMatrix {
	//���Ҷ�Ӧ�У��ڶ�Ӧ�в���Ԫ�أ�����ʱ�䣺����2>3>1
	public static boolean searchMatrix(int[][] matrix, int target) {        
		int m = matrix.length;
		if(m == 0) return false;
        int n = matrix[0].length;
        if(n == 0) return false;
        
        int ml = 0, mh = m-1, nl = 0, nh = n-1;  
        int me = 0;
        
        while(ml <= mh){
            int mm = (mh+ml)/2;
            if(matrix[mm][0] <= target && matrix[mm][n-1] >= target) {me = mm; break;}
            else if(matrix[mm][0] > target) mh = mm-1;
            else if(matrix[mm][n-1] < target) ml = mm+1;
        }
        while(nl <= nh){            
            int nm = (nh+nl)/2;
            if(matrix[me][nm] == target) return true;
            else if(matrix[me][nm] < target) nl = nm+1;
            else nh = nm-1;
        }
        
        return false;
    }
	
	//���ÿһ���ж�
	public static boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        for (int i = 0; i < matrix.length; i++) {
            int [] tempRow = matrix[i];
            if (tempRow[tempRow.length - 1] == target) return true;
            if (tempRow[tempRow.length - 1] >= target) {
                return binarySearch(tempRow, target, 0, tempRow.length);
            }
        }
        return false;
    }
    
    public static boolean binarySearch(int[] array, int target, int low, int high) {
        if (low > high) return false;
        int middle = (low + high) / 2;
        if (array[middle] == target) return true;
        if (array[middle] > target) {
            return binarySearch(array,target,low, middle -1);
        } else {
            return binarySearch(array,target, middle + 1, high);
        }
    }
	
    //չ��һά���鴦��
    public static boolean searchMatrix3(int[][] matrix, int target) {
        if(matrix.length == 0)
            return false;
        int row = matrix.length;
        int col = matrix[0].length;
        
        int lo = 0, hi = row * col - 1;
        while(lo <= hi){
            int mid = (hi - lo) / 2 + lo;
            if(matrix[mid / col][mid % col] == target)
                return true;
            else if(matrix[mid / col][mid % col] > target)
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        return false;
    }
    
	public static void main(String[] args) {
		int[][] m = {{1,3},{10,11},{23,23}};
		int t = 0;
		System.out.print(searchMatrix(m, t));
	}

}
