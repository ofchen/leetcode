package LeetCode.medium;

import java.util.PriorityQueue;
import java.util.Random;

public class FindKthLargest {
	//ʹ����С�Ѽ�java priorityQueue���Ѵ�СΪk���Ѷ�Ԫ�ؼ�Ϊ����
	public static int findKthLargest(int[] nums, int k) { 
		if(nums == null || nums.length == 0) return 0;
		
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k);
		for(int n : nums){
			if(queue.size() < k)
				queue.offer(n);
			else {
				if(queue.peek() < n){
					queue.poll();
					queue.offer(n);
				}
			}
			/*queue = new PriorityQueue<Integer>(); //��ʼ��ʱ��СΪk+1
			 * queue.offer(n);
			 * if(queue.size() > k) queue.poll();
			 * */
		}
		
		return queue.peek();
	}
	
	//ʹ��quick-select�����ŵ�һ��ֻ����ֻ������Ҫ��һ�����ݣ����ڿ��Ż�׼Ԫ�ص�ѡȡ�ȽϹؼ���������shuffleԪ����
	public static int findKthLargest2(int[] nums, int k) { 
		if(nums == null || nums.length == 0) return 0;
		shuffle(nums);
		k--; //�Ѵӵ�k��Ԫ�ر�Ϊ�������鵹����k��Ԫ�أ����㴦��߽�Ԫ��
		int l = 0, h = nums.length-1;
		while(l < h){
			int j = partition(nums, l, h);
			if(j < k) l=j+1;
			else if (j > k) h=j-1;
			else return nums[j];
		}
		return nums[l]; //ֻ��һ��Ԫ��
	}
	
	private static int partition(int[] nums, int l, int h) {
		int pt = nums[l];
		while(l < h){
			while(l < h && nums[h] >= pt) --h;
			nums[l] = nums[h];
			while(l < h && nums[l] <= pt) l++;
			nums[h] = nums[l];
		}
		nums[l] = pt;
		return l;
	}
	
	private static void shuffle(int[] nums){
		/*Random(long seed)��ʹ�õ��� long ���Ӵ���һ���µ��������������
		 * Random()������һ���µ��������������Ĭ�ϵ�ǰϵͳʱ��ĺ�������Ϊ������
		 * */
		Random random = new Random(System.currentTimeMillis());
		for(int i = 0; i < nums.length; i ++){
			int r = random.nextInt(i+1);
			swap(nums, i, r);
		}
	}
	
	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] nums = {3,2,1,5,6,4};
		int k =  2;
		
		System.out.print(findKthLargest(nums,k));
	}
}
