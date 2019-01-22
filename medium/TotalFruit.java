package LeetCode.medium;

public class TotalFruit {
	public static int totalFruit(int[] tree) {
        int len = tree.length;
		if(len <= 1) return tree.length;                                
        int i = 0, j = 0, max = 0;                   
        while(i < len){
            int bt1 = tree[j];
        	for(; i < len && tree[i] == bt1; i ++);
            int bt2 = tree[i];
            for(; i < len && (tree[i] == bt1 || tree[i] == bt2); i ++);
            if(i - j > max)
            	max = i - j;
            for(j = i-2; j >= 0 && tree[j] == tree[i-1]; j --);
            j++;
        }
        return max;
    }
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,2,2};//{3,3,3,1,2,1,1,2,3,3,4};//{1,2,2};//{0,1,2,2};//
		System.out.println(totalFruit(nums));
	}
}
