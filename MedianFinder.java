package LeetCode.hard;

import java.util.PriorityQueue;
import java.util.Queue;
/*C++˼·���������е����ݲ���������ģ�����Ӧ��������������������������vector�������������Ļ���ÿ����һ��������
 * ��Ҫ���������򣬺ܲ���Ч������֮���뵽��multiset������ݽṹ�������򱣴����ݵģ��������������±�ֱ�ӷ���
 * Ԫ�أ�����λ��Ҳ����Ч�������õ��Ľⷨʮ���������ʹ�ô�С����������⣬���д�ѱ����Ұ�νϴ�����֣�
 * С�ѱ������ν�С�����顣������������ͱ��м��Ϊ�����ˣ����ڶѵı��淽ʽ���ɴ�С������ϣ����������
 * �����Ǵ�С��������ȡ��һ����������λ�����㡣�����õ�һ��С���ɣ����Ǵ浽����������ȡ���ٴ棬
 * �����ɴ�С��������˳�����ʵ����������Ҫ�Ĵ�С�����˳�򡣵���Ѻ�С���е�����һ����ʱ��
 * ����ȡ�����С�ѵ���Ԫ����ƽ��ֵ����С��Ԫ�ض�ʱ��ȡС����Ԫ��Ϊ��λ��
 * */
public class MedianFinder {
	static Queue<Integer> minQueue;
	static Queue<Integer> maxQueue;
	
	public MedianFinder() {
        minQueue = new PriorityQueue();  
        maxQueue = new PriorityQueue();  
    }
    
    public static void addNum(int num) {
        minQueue.offer(num);
        maxQueue.offer(-minQueue.poll());
        if(minQueue.size() < maxQueue.size()){
        	minQueue.offer(-maxQueue.poll());
        }
    }
    
    public static double findMedian() {
        return minQueue.size() > maxQueue.size()? (double)minQueue.peek() : 0.5*(minQueue.peek()-maxQueue.peek());
    }
	
	
	public static void main(String[] args) {
		MedianFinder obj = new MedianFinder();
		MedianFinder.addNum(1);
		MedianFinder.addNum(2);
		System.out.println(findMedian());  
		MedianFinder.addNum(3); 
		System.out.println(findMedian());    
		
	}

}
