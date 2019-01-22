package LeetCode.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SmallestRange {
	class dataList implements Comparable<dataList>{
        int num;
        int flag;
        
        public dataList() { }
        
		dataList(int num, int flag){
            this.num = num;
            this.flag = flag;
        }
               
		public int compareTo(dataList b){  //����
            return this.num - b.num;
        }
    }
	
	public static int[] smallestRange(List<List<Integer>> nums) {
        int[] res = new int[2];
        if(nums.size() == 1) return res;
        int len = 0, k = 0, j = 0;
        for(List<Integer> list : nums){
            len+=list.size();
            k++;
        }
        
        dataList[] bl = new dataList[len];
        int temp = k;
        for(List<Integer> list : nums){
            int flag = temp--;
            for(int i : list){
                //�ڲ����ʼ��new dataList(i, flag)���У����� ͨ���ⲿ����ʵ�֣�
            	bl[j++] = new SmallestRange().new dataList(i, flag);
            }
        }
        
        Arrays.sort(bl);
        int left = 0, cnt = 0, diff = Integer.MAX_VALUE;
        int[] m = new int[k+1];
        for (int right = 0; right < len; ++right) {
            if (m[bl[right].flag] == 0) ++cnt;
            ++m[bl[right].flag];
            while (cnt == k && left <= right) { //��С��Χ
                int tp = bl[right].num - bl[left].num;
                if (diff > tp) {
                    diff = tp;
                    res[0] = bl[left].num;
                    res[1] = bl[right].num;
                } 
                if (--m[bl[left].flag] == 0) --cnt;
                ++left;
            }
        }
        return res;
        
    }

	public static void main(String[] args) {
		 
	}
}
