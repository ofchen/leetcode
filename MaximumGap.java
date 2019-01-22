package LeetCode.hard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaximumGap {
	//���Ե�ʱ��Ϳռ䣬��ôֻ����Ͱ������߻�����
	//���ҳ���������ֵ����Сֵ��Ȼ��Ҫȷ��ÿ��Ͱ����������Ϊ(���ֵ - ��Сֵ) / ���� + 1����ȷ��Ͱ�ĸ�������Ϊ(���ֵ - ��Сֵ) / Ͱ������ + 1��Ȼ����Ҫ��ÿ��Ͱ���ҳ��ֲ����ֵ����Сֵ����������������������ͬһ��Ͱ�У�����һ��Ͱ����Сֵ����һ��Ͱ�����ֵ֮��ļ��
	public static int maximumGap(int[] nums) {
        int len = nums.length;
        if(len <= 2) return 0;
        
        int mn = Integer.MAX_VALUE, mx = 0;
        for(int m: nums){
        	if(m < mn)
        		mn = m;
        	if(m > mx)
        		mx = m;
        }       
        int size = (mx-mn)/len+1;
        int ns = (mx-mn)/size+1;
        int[] nmx = new int[ns];        
        int[] nmn = new int[ns];
        Arrays.fill(nmn, Integer.MAX_VALUE);
        Set<Integer> set = new HashSet<Integer>();
        for(int m: nums){
        	int idx = (m-mn)/size;
        	nmx[idx] = Math.max(nmx[idx], m);
        	nmn[idx] = Math.min(nmn[idx], m);
        	set.add(idx);
        }
        
        int res = 0, pre = 0;
        for(int i = 1; i < ns; i++){
        	if(!set.contains(i)) continue;
        	res = Math.max(res,nmn[i]-nmx[pre]);
        	pre = i;
        }
        return res;
    }
	
	public static void main(String[] args) {
		 int[] m = {10};//{3,6,9,1};
		 
		 System.out.print(maximumGap(m));
	}

}
