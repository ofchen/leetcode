package LeetCode.medium;

public class SearchMatrix2 {
	public static boolean searchMatrix2(int[][] matrix, int target) {
        //��ά�����пշ�������
		//if(matrix == null || matrix[0].length == 0) return false;
		//�����׵�ַ�Ƿ�Ϊ��,�Ƿ�Ϊ{}Ҳ����array.length==0, �Ƿ�Ϊ{{}}��ʱarray.length=1����array[0].length==0
		if(matrix == null || matrix.length == 0|| matrix[0].length == 0) return false;
		int m = matrix.length, n = matrix[0].length;
       
        for(int i = 0; i < m; i ++){
            if(matrix[i][0] <= target && matrix[i][n-1] >= target){
               if(binarySearch(matrix[i], target))
                   return true;
            }
            else
                return false;
        }        
        return false;
    }
    
    public static boolean binarySearch(int[] nums, int target){
        int l = 0, h = nums.length-1;
        while(l <= h){
            int m = (h-l)/2+l;
            if(nums[m] < target) l = m+1;
            else if(nums[m] == target) return true;
            else h = m-1;
        }
        return false;
    }
    
    //�ȶ�λԪ�ض�Ӧ���л�����һ�����ƽ�
    public static boolean searchMatrix2_2(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0|| matrix[0].length == 0) return false;
		int m = matrix.length, n = matrix[0].length;
	    int row = 0;
	    int col = n-1;
	    
	    while(row < m && col >=0){
	        if(matrix[row][col] == target){
	            return true;
	        }
	        
	        if(matrix[row][col] < target)
	            row++;
	        else 
	            col--;
	    }
    	return false;    
    }
    
	public static void main(String[] args) {
		int[][] m = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
		int target = 5;
		
		System.out.print(searchMatrix2(m, target));
//
//		int[][] n1 = {};
//		int[][] n2 = {{}};
//		System.out.println(n1 == null); false
//		System.out.println(n2 == null); false
//		
//		System.out.println(n1.length == 0); true
//		System.out.println(n2.length == 0); false
//		
//		System.out.println(n2[0].length == 0); true
	}

}
