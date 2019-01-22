package LeetCode.medium;

//Find the contiguous subarray within an array (containing at least one number) which has the largest product.
public class MaxProduct {
	/*��������������˻������������������֮�������ݱ����������ȴ�������������֮��Ҫ���ӣ�
	 * ��Ϊ����͵�ʱ������0������ı����ֵ������������Ҳֻ�ǻ��С���ֵ���ѡ�
	 * ���������������˻��������У�����0��ʹ�����˻�Ϊ0�����������������ʹ���˻������С�˻���
	 * ����Ϊ�и�����0�Ĵ��ڣ�ʹ�����ø����˲���
	 * */
	/*��DP����������Ҫ������dp���飬����f[i]��ʾ������[0, i]��Χ�ڵ����������˻���
	 * g[i]��ʾ������[0, i]��Χ�ڵ���С������˻�����ʼ��ʱf[0]��g[0]����ʼ��Ϊnums[0]��
	 * ���඼��ʼ��Ϊ0����ô������ĵڶ������ֿ�ʼ��������ô��ʱ�����ֵ����Сֵֻ��������������֮�������
	 * ��f[i-1]*nums[i]��g[i-1]*nums[i]����nums[i]�����������������е����ֵ������f[i]��
	 * ����Сֵ������g[i]��Ȼ����f[i]�����½��res����
	 * */
	public static int maxProduct(int[] nums) {
        
		int res = nums[0], n = nums.length;
        int[] f = new int[n];
        int[] g = new int[n];
        
        f[0] = nums[0];
        g[0] = nums[0];
        for(int i = 1; i < n; i++){
        	f[i] = Math.max(Math.max(f[i - 1] * nums[i], g[i - 1] * nums[i]), nums[i]);
            g[i] = Math.min(Math.min(f[i - 1] * nums[i], g[i - 1] * nums[i]), nums[i]);
            res = Math.max(res, f[i]);
        }
        
        return res;
    }
	
	public static int maxProduct2(int[] nums) {
		if(nums.length == 0) return 0;
		int res = nums[0], mn = nums[0], mx = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            int tmax = mx, tmin = mn;
            mx = Math.max(Math.max(nums[i], tmax * nums[i]), tmin * nums[i]);
            mn = Math.min(Math.min(nums[i], tmax * nums[i]), tmin * nums[i]);
            res = Math.max(res, mx);
        }
        return res;
	}
	
	/*��������������ʾ��ǰ���ֵ����Сֵ�ģ�����û�����ԱȽ������������Ƕ��ڵ�ǰ��nums[i]ֵ������������������ۣ�
	1. ��������һ������ʱ����ʱ�����ֵ����֮ǰ�����ֵ������������͵�ǰ�����еĽϴ�ֵ����ʱ����Сֵ����֮ǰ����Сֵ������������͵�ǰ�����еĽ�Сֵ��
	2. ��������һ������ʱ����������һ������t����֮ǰ�����ֵmx��Ȼ���ʱ�����ֵ����֮ǰ��Сֵ������������͵�ǰ�����еĽϴ�ֵ����ʱ����Сֵ����֮ǰ��������ֵt������������͵�ǰ�����еĽ�Сֵ��
	3. ��ÿ������һ����ʱ����Ҫ�������յ����ֵ��
	P.S. �������ĳ�����Сֵ�Ļ�����������С������˻�������ʱ�临�Ӷ�O(n)
	 * */
	public static int maxProduct3(int[] nums) {
		int res = nums[0], mx = res, mn = res;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > 0) {
                mx = Math.max(mx * nums[i], nums[i]);
                mn = Math.min(mn * nums[i], nums[i]);
            } else {
                int t = mx;
                mx = Math.max(mn * nums[i], nums[i]);
                mn = Math.min(t * nums[i], nums[i]);
            }
            res = Math.max(res, mx);
        }
        return res;
	}
	
	public static void main(String[] args) {
		int[] num = {2,3,-2,4};
		System.out.println(maxProduct2(num));		
	}
}
