package LeetCode.hard;

import java.util.Arrays;
import java.util.Stack;

public class MaximalRectangle {
	//NO.85 ������0,1���ɵĶ�ά���ݣ��ж���1���ɵ����������
	
	//����ÿ��Ԫ�����������ж���������������ڴ����ظ����
	public static int maximalRectangle(int[][] m2) {
        int m = m2.length;
        if(m == 0) return 0;
        int n = m2[0].length;
        if(n == 0) return 0;
        int res = 0;
        for(int i = 0; i < m; i ++){

            for(int j = 0; j < n; j ++){
                if(m2[i][j] == 1){
                    int max = n;
                    int p = i;
                    for(; p < m && m2[p][j] == 1; p++){
                        int rowMax = 0;
                        for(int q = j; q < n && m2[p][q] == 1; q ++, rowMax++);                         
                        max = Math.min(max, rowMax);
                        res = Math.max(res, (p-i+1)*max); 
                    }                   
                }    
            }
        }
        return res;
    }
	
	public static int maximalRectangle2(int[][] matrix) {
	       
	        int res = 0, m = matrix.length, n = matrix[0].length;
	        int[] height = new int[n], left = new int[n], right = new int[n], out = new int[n];
	        Arrays.fill(right, n);
	        for (int i = 0; i < m; ++i) {
	            int cur_left = 0, cur_right = n;
	            for (int j = 0; j < n; ++j) {
	                if (matrix[i][j] == 1) {
	                	++height[j];
	                	left[j] = Math.max(left[j], cur_left);
	                }
	                else {
	                	height[j] = 0;
	                	left[j] = 0; cur_left = j + 1;
	                }
	            }
	            for (int j = n - 1; j >= 0; --j) {
	                if (matrix[i][j] == 1) 
	                	right[j] = Math.min(right[j], cur_right);
	                else {
	                	right[j] = n; 
	                	cur_right = j;
	                }
	                res = Math.max(res, (right[j] - left[j]) * height[j]);
	                out[j] = (right[j] - left[j]) * height[j];
	            }
	            /*
	            for (int j = 0; j < n; ++j) {
	                if (matrix[i][j] == 1) ++height[j];
	                else height[j] = 0;
	            }
	            for (int j = 0; j < n; ++j) {
	                if (matrix[i][j] == 1) left[j] = Math.max(left[j], cur_left);
	                else {left[j] = 0; cur_left = j + 1;}
	            }
	            for (int j = n - 1; j >= 0; --j) {
	                if (matrix[i][j] == 1) right[j] = Math.min(right[j], cur_right);
	                else {right[j] = n; cur_right = j;}
	            }
	            for (int j = 0; j < n; ++j) {
	                res = Math.max(res, (right[j] - left[j]) * height[j]);
	                out[j] = (right[j] - left[j]) * height[j];
	            }
	            */
	            System.out.println("row "+i);
	            System.out.println(Arrays.toString(height));
	            System.out.println(Arrays.toString(left));
	            System.out.println(Arrays.toString(right));
	            System.out.println(Arrays.toString(out));
	        }
	        return res;
	}
	
	public static int maximalRectangle3(int[][] matrix) {
		int res = 0, m = matrix.length, n = matrix[0].length;
        int[] height = new int[n+1];
        height[n] = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                height[j] = matrix[i][j] == 0 ? 0 : (1 + height[j]);
            }
            res = Math.max(res, largestRectangleArea(height));
        }
        return res;
		 
	}
	
	//ά��һ������ջ��ջ�ȴ��Ԫ���±꣬��ջ�����м��㹹�ɵ�������ֵ(�Ҳ��������)
	static int largestRectangleArea(int[] height) {
        int res = 0;
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < height.length; ++i) {
            if (s.empty() || height[s.peek()] <= height[i]) s.push(i);
            else {
                int tmp = s.pop();
                res = Math.max(res, height[tmp] * (s.empty() ? i : (i - s.peek() - 1)));
                --i;
            }
        }
        return res;
    }
	
	public static void main(String[] args) {
		 
		 //int[][] m = {{1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,0},{1,1,1,1,1,1,1,0},{1,1,1,1,1,0,0,0},{0,1,1,1,1,0,0,0}};
		//int[][] m = {{1,1,1,1,1,1,1,1},{1,1,1,1,1,0,1,0},{1,1,1,1,1,1,1,0},{1,1,1,1,1,0,0,0},{0,1,1,1,1,0,0,0}};
		//int[][] m = {{1,0,1,0,0},{1,0,1,1,1},{1,1,1,1,1},{1,0,0,1,0}};
		int[][] m = {{1,1,0,0,1},{0,1,0,0,1},{0,0,1,1,1},{0,0,1,1,1},{0,0,0,0,1}};
		System.out.print(maximalRectangle3(m));
	}

}
