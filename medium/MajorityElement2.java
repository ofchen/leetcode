package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {
	public static List<Integer> majorityElement2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums.length == 0) return res;
        
        int len = nums.length;
        int m = 0, n = 0, mc = 0, nc = 0;
        for(int i : nums){
            if(i == m)
                mc ++;
            else if(i == n)
                nc ++;
            else if(mc == 0){
                m = i;
                mc = 1;
            }
            else if(nc ==  0){
                n = i;
                nc = 1;
            }
            else{
                mc --;
                nc --;
            }
            System.out.println("i="+i+", m="+m+", n="+n+", mc="+mc+", nc="+nc);
        }
        mc = 0;
        nc = 0;
        for(int i : nums)
            if(i == m) mc++;
            else if(i == n) nc ++;
       if(mc > len/3) res.add(m);
       if(nc > len/3) res.add(n);
        
     return res;
    }
	public static void main(String[] args) {
		int[] nums = {1, 2, 2, 3, 2, 1, 1, 3};
		System.out.print(majorityElement2(nums));
	}

}
