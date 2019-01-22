package LeetCode.medium;

public class HIndex {
	public static int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        int len = citations.length, l = 0, h = len-1;
        
        while(l <= h){
            int m = (h-l)/2+l;
            if(citations[m] < len-m) l = m+1;
            else if(citations[m] == len-m) return len-m;
            else h = m-1;
            
        }
        
        return len-l;
    }
	
	public static void main(String[] args) {
		 int[] c ={0,1,2,3,4,5,6};
		 System.out.println(hIndex(c));
	}

}
