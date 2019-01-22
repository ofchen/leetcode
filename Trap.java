package LeetCode.hard;

import java.util.Stack;

//Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.	
public class Trap {
	//��̬�滮,�����������飬��һ�����dp[i]�д���iλ����ߵ����ֵ��Ȼ��ʼ�ڶ���������飬�ڶ��α���ʱ���ұ����ֵ��Ȼ���������ֵ�Ƚ�ȡ���еĽ�Сֵ��Ȼ�����ǰֵA[i]��ȣ�������ڵ�ǰֵ���򽫲�ֵ������
	private static int trap(int[] h) {
		int res = 0, mx = 0, n = h.length;
		int[] dp = new int[n];
		for(int i = 0; i < n; i++) {
			dp[i] = mx;
			mx = Math.max(mx, h[i]);
		}
		mx = 0;
		for(int i = n-1; i >= 0; i--) {			
			dp[i] = Math.min(mx, dp[i]);
			mx = Math.max(mx, h[i]);
			if(dp[i] > h[i])
				res += dp[i]-h[i];
		}
		
		return res;
	}
	
	//����һ��,left��right����ָ��ֱ�ָ���������βλ�ã����������м�ɨ�裬�ڵ�ǰ��ָ��ȷ���ķ�Χ�ڣ��ȱȽ���ͷ�ҳ���Сֵ�������Сֵ��leftָ���ֵ�����������ɨ�裬�����Сֵ��rightָ���ֵ�����������ɨ�裬��������ֵ�ȵ���СֵС���򽫲�ֵ����������������ֵ��������ȷ���µĴ��ڷ�Χ���Դ�����ֱ��left��rightָ���غ�
	public static int trap2(int[] height) { 
		//��ʹ��˫ָ��ԭ������i,j֮��һ������ĳ��kʹ��h[k] >= h[i]||h[j]��ʹ����i��j��һ���ܴ洢��ˮ
        //��������ô��֤�洢��ˮ������ȷ�ģ�ͨ��ȷ���߽�ֵ��λ�ñ�֤���ڴ���ĵ��ǽ�С��ˮ����һ��
		 /*int res = 0, l = 0, r = height.length - 1;
        while (l < r) {
            int mn = Math.min(height[l], height[r]);
            if (height[l] == mn) {
                ++l;
                while (l < r && height[l] < mn) {
                    res += mn - height[l++];
                }
            } else {
                --r;
                while (l < r && height[r] < mn) {
                    res += mn - height[r--];
                }
            }
        }
       */
		//ÿ�θ��µ�ǰˮ�����޺�ˮ������
        int l = 0, r = height.length - 1, level = 0, res = 0;
        while (l < r) {
            int lower = height[(height[l] < height[r]) ? l++ : r--];
            level = Math.max(level, lower);
            res += level - lower;
        } 
        
        return res;
    }
	
	//��stack,�����߶ȣ������ʱջΪ�գ����ߵ�ǰ�߶�С�ڵ���ջ���߶ȣ���ѵ�ǰ�߶ȵ�����ѹ��ջ��ע�����ǲ�ֱ�ӰѸ߶�ѹ��ջ�����ǰ�����ѹ��ջ���������������ں�����ˮƽ���롣������������ջ���߶ȴ��ʱ�򣬾�˵���п��ܻ��пӴ��ڣ�����װ��ˮ����ʱ����ջ��������һ���߶ȣ����ֻ��һ���Ļ�����ô�����γɿӣ�����ֱ���������������һ���Ļ�����ô��ʱ��ջ��Ԫ��ȡ���������ӣ��µ�ջ��Ԫ�ؾ�����߽磬��ǰ�߶����ұ߽磬ֻҪȡ���߽�С�ģ���ȥ�ӵĸ߶ȣ����Ⱦ����ұ߽������ȥ��߽������ټ�1��������˾���ʢˮ��
	 public static int trap3(int[] height) { //û��������������
	        Stack<Integer> s = new Stack<Integer>();
	        int i = 0, n = height.length, res = 0;
	        while (i < n) {
	        	//δ�ҵ����Դ�ˮ���ұ߽�
	            if (s.isEmpty() || height[i] <= height[s.peek()]) {
	                s.push(i++);
	            } 
	            else {
	                int t = s.pop(); //��ˮ��
	                if (s.isEmpty()) continue;
	                //height[s.peek()]Ϊ��ˮ���ұ߽�
	                res += (Math.min(height[i], height[s.peek()]) - height[t]) * (i - s.peek() - 1);
	            }
	        }
	        return res;
	  }
	 
	public static void main(String[] args) {
		int[] h = {0,1,0,2,0,0,0,3,2,1,2,1};//{3,0,1,3};//{1,0,3,0,2};
		System.out.println(trap3(h));
	}

}
