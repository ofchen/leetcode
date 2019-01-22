package LeetCode.medium;

public class MinSubArrayLen {
//��������֮�ʹ��ڵ��ڸ���ֵ����С����,ʵ��O(n)��O(nlogn)���ֽⷨ
	
	//O(n)ʱ�临�Ӷ�,����ָ��
	public static int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0) return 0;
        int l = 0, r = 0, sum = 0, len = nums.length, res = len+1;
        while(r < len){
        	while(sum < s && r < len) sum += nums[r++];
        	while(sum >= s){
        		res = Math.min(res, r-l);
        		sum -= nums[l++];
        	}
        }
        
        return res == len+1 ? 0 : res;
    }
	
	public int minSubArrayLen1_1(int s, int[] nums) {
        int L = 0;
        int R = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        
        while(R < nums.length){
            sum += nums[R];
            
            while(sum >= s){
                minLen = Math.min(minLen, R - L + 1);
                sum -= nums[L];
                L++;
            }
            
            R++;
        }
        
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
	
	/*O(nlogn)ʱ�临�Ӷȣ�����һ����ԭ���鳤һλ��sums���飬����sums[i]��ʾnums������[0, i - 1]�ĺͣ�
	 * Ȼ�����Ƕ���sums��ÿһ��ֵsums[i]���ö��ֲ��ҷ��ҵ���������ұ߽�λ�ã�ʹ��������֮�ʹ���sums[i] + s��
	 * Ȼ�����Ǹ�����̳��ȵľ��뼴�ɡ�
	*/
	public static int minSubArrayLen2(int s, int[] nums) {
		int n = nums.length, res = n+1;
		int[] sums = new int[res];
		
		for(int i = 1; i < n+1; i++)
			sums[i] = sums[i-1]+nums[i-1];
		for(int i = 0; i < n; i ++){
			int l = i+1, r = n, t = sums[i]+s;
			while(l <= r){
				int m = (l+r)/2;
				if(sums[m] < t) l = m+1;
				else r = m-1; 	
			}
			if(l == n+1) break;
			res = Math.min(res, l-i);
		}
		
		return res == n+1 ? 0 : res;
	}
	
	public static void main(String[] args) {
		int s = 7;
		int[] nums = {2,3,1,2,4,3};
		System.out.print(minSubArrayLen2(s, nums));
	}
}
