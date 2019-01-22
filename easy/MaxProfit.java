package LeetCode.easy;
/*Say you have an array for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock),
design an algorithm to find the maximum profit.
Note that you cannot sell a stock before you buy one.
 * */
public class MaxProfit {
	//����һ�����飬��һ��������¼���������е���Сֵ��Ȼ��ÿ�μ��㵱ǰֵ�������Сֵ֮��Ĳ�ֵ��Ϊ����
	//Ȼ��ÿ��ѡ�ϴ�����������¡���������ɺ�ǰ����Ϊ����
	public static int maxProfit(int[] prices) {
        int len = prices.length;
        
        if(len <= 1)
            return 0;

        int l = Integer.MAX_VALUE, h = 0;
        for(int i : prices){
        	if(i < l)
        		l = i;
        	if(i - l > h)
        		h = i - l;
        }
                
        return h;
    }
	
	public static void main(String[] args) {
		int[] num = {7,1,5,3,6,4};
		System.out.println(maxProfit(num));		
	}
}
