package LeetCode.easy;

public class IsMonotonic {
	public static boolean isMonotonic(int[] A) {
        int len = A.length;
        if(len <= 1) return true;
        
        int i = 0;
        for(i = 0; i < len-1 && A[i] == A[i+1]; i++);
        if(i == len-1) return true;
        i = i + 1;
        if(A[i] > A[i-1]){
            for(; i < len; i ++)
                if(A[i] < A[i-1])
                    return false;
        }
        else if(A[i] < A[i-1]){
            for(; i < len; i ++)
                if(A[i] > A[i-1])
                    return false;
        }
        return true;
    }
	
	public static void main(String[] args) {
		int[] A ={5,3,2,4,1};
		System.out.print(isMonotonic(A));
		
	}
}
