package LeetCode.medium;

public class FindMin2 {
	//{2, 2, 2, 2, 2, 2, 2, 2, 0, 1, 1, 2} �� {2, 2, 2, 0, 2, 2, 2, 2, 2, 2, 2, 2}�� ���Ƿ��֣�����һ�����ֺ����һ�����֣������м��Ǹ�����ȫ����ȵ�ʱ�򣬶��ֲ��ҷ��ͱ����ˣ���Ϊ���޷��жϵ��׸�ȥ���߻����Ұ�ߡ���������£����ǽ���ָ������һλ���Թ�һ����ͬ���֣���Խ���������Ӱ�죬��Ϊ����ֻ��ȥ����һ����ͬ�ģ�Ȼ���ʣ��Ĳ��ּ����ö��ֲ��ҷ������������£�������������Ԫ�ض���ͬ��ʱ�临�ӶȻ�����O(n)
	public static int findMin2(int[] nums) {		
		int l = 0, h = nums.length-1;
        int res = nums[0];
        
        while(l < (h-1)){
            int m = (h-l)/2+l;
            if(nums[m] > nums[l]){
                res = Math.min(res, nums[l]);
            	l = m+1;
            }
            else if(nums[m] < nums[l]){
            	res = Math.min(res, nums[h]);
            	h = m;
            }
            else {
				l ++;
			}
         }
         res = Math.min(res, nums[l]);
         res = Math.min(res, nums[h]);
         return res; 
	}
	
	public static void main(String[] args) {
		int[] nums = {2, 2, 2, 0, 2, 2, 2, 2, 2, 2, 2, 2};
		System.out.print(findMin2(nums));
	}

}
