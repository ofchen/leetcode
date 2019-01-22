package LeetCode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
/*You are given two arrays (without duplicates) nums1 and nums2 where nums1��s elements are subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.

The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.
 * */
public class NextGreaterElement {
	//���������������Ӽ����е�ÿһ�����֣�Ȼ����ԭ�������ҵ�������֣�Ȼ�����ұ������ҵ���һ�����ڸ����ֵ���
	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {        
		if(nums1.length == 0) return new int[]{};
        int[] res = new int[nums1.length];
        
        int len1 = nums1.length, len2 = nums2.length;
        for(int i = 0; i < len1; i ++){
        	int j = 0, k = 0;
        	res[i] = -1;
        	for(; j < len2; j++)
        		if(nums2[j] == nums1[i]) break;        	
        	for(k = j+1; k < len2; k ++){
        		if(nums2[k] > nums1[i]){
        			res[i] = nums2[k];
        			break;
        		}
        	}
        }
        
        return res;
    }
	
	//�ù�ϣ����������ÿ�����ֺ�������λ��֮���ӳ�䣬��ô�����ڱ����Ӽ����е�����ʱ������ֱ�Ӷ�λ����������ԭ�����е�λ�ã�Ȼ�������ұ߱���Ѱ�ҽϴ���
	public static int[] nextGreaterElement2(int[] nums1, int[] nums2) {        
		if(nums1.length == 0) return new int[]{};
        int[] res = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        int len1 = nums1.length, len2 = nums2.length;
        for(int i = 0; i < len2; i ++)
        	map.put(nums2[i], i);
        for(int i = 0; i < len1; i ++){
        	res[i] = -1;
        	int s = map.get(nums1[i]);
        	for(int k = s+1; k < len2; k ++){
        		if(nums2[k] > nums1[i]){
        			res[i] = nums2[k];
        			break;
        		}
        	}
        }
        
        return res;
    }
	
	/*����ÿ�����ֺ����ұߵ�һ���ϴ���֮���ӳ�䣬û�еĻ�����-1�����Ǳ���ԭ�����е��������֣������ʱջ��Ϊ�գ���ջ��Ԫ��С�ڵ�ǰ���֣�˵����ǰ���־���ջ��Ԫ�ص��ұߵ�һ���ϴ�������ô�������ߵ�ӳ�䣬����ȥ����ǰջ��Ԫ�أ���󽫵�ǰ������������ѹ��ջ�����������ֶ�������ӳ�䣬��ô������ǿ���ֱ��ͨ����ϣ����ٵ��ҵ��Ӽ��������ֵ��ұ߽ϴ�ֵ
	 * */
	public static int[] nextGreaterElement3(int[] nums1, int[] nums2) {        
		if(nums1.length == 0) return new int[]{};
        int len1 = nums1.length;
		int[] res = new int[len1];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Stack<Integer> stack = new Stack<Integer>();        
        
        for(int i : nums2){
        	while(!stack.isEmpty() && stack.peek() < i){
        		map.put(stack.peek(), i);
        		stack.pop();
        	}
        	stack.push(i);
        }
        for(int i = 0; i < len1; i ++){
        	res[i] = map.containsKey(nums1[i]) ? map.get(nums1[i]) : -1;        	
        }
        
        return res;
    }
	
	//���������±��ʾ���֣�Ԫ��Ϊ��Ӧ���
	static int[] cal = new int[10000];
	public static int[] nextGreaterElement4(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        cal = calculate(nums2);
        for(int i = 0 ; i < nums1.length; i++){
            ans[i] = cal[nums1[i]];
        }
        
        return ans;	    	    
	}
	public static int[] calculate(int[] nums){
	        for(int i = 0; i < nums.length; i++){
	            int j = i + 1;
	            while(j < nums.length && nums[j] < nums[i]){
	                j++;
	            }
	            cal[nums[i]] = j==nums.length?-1:nums[j];
	        }
	        return cal;
	}
	
	public static void main(String[] args) {
		int[] nums2 = {1,3,4,2};
		int[] nums1 = {4,1,2};
		System.out.println(Arrays.toString(nextGreaterElement3(nums1, nums2)));
	}

}
