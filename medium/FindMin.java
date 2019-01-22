package LeetCode.medium;

public class FindMin {
	//����Ҫ�ж�������������Ƿ���ת�ˣ�ͨ���Ƚϵ�һ�������һ�����Ĵ�С�������һ����С����û����ת��ֱ�ӷ���������������һ�����󣬾�Ҫ��һ�����������Ƕ���left��right����ָ��ֱ�ָ��ͷ�ͽ�β����Ҫ�ҵ��м��Ǹ�����Ȼ���leftָ�����Ƚϣ�����м��������������ֲ����Ұ�����飬��֮�������Ρ���ֹ�����ǵ���������ָ�����ڣ�����С���Ǹ�
	public static int findMin(int[] nums) {
        int l = 0, h = nums.length-1;
        
        if(nums[l] <= nums[h])
        	return nums[0];
        while(l != (h-1)){
            int m = (h-l)/2+l;
            if(nums[m] > nums[l]){
                l = m;
            }
            else
               h = m;
         }        
         return Math.min(nums[l],nums[h]); 
    }
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5};
		System.out.print(findMin(nums));
	}

}
