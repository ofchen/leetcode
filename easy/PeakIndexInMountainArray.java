package LeetCode.easy;

public class PeakIndexInMountainArray {
	public static int peakIndexInMountainArray(int[] A) {
        int len = A.length, l = 0, h = len-1;
        while(l <= h){
            int m = (h-l)/2+l;
            if(A[m] > A[m+1] && A[m] > A[m-1]) return m;
            int s = m;
            for(; s < len && A[s] == A[s-1]; s ++);
            if(A[s] > A[s-1]) l = s;
            else h = m; 
            
        }
        return l;
    }
	
	public static int peakIndexInMountainArray2(int[] A) {
        int left = 0, right = A.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] >= A[mid-1] && A[mid] <= A[mid+1]) { //���������׶���
                left = mid+1;
            } else if(A[mid] <= A[mid-1] && A[mid] >= A[mid+1]) { //�����½��׶���
                right =  mid;
            } else {
                return mid;
            }
        }
        return -1;
    }
	
	public static void main(String[] args) {
		int[] ar = {0,1,1,2,1,1,1,1};
		System.out.println(peakIndexInMountainArray2(ar));
	}

}
