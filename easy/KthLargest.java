package LeetCode.easy;

//import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargest {
	private PriorityQueue<Integer> queue;
	private int k;
	
	public KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<Integer>(k);
        for(int i : nums){
        	add(i);
        }
    }
	
	public int add(int val) {
		if(queue.size() < k)
			queue.offer(val);
		else if(queue.peek() < val){
			queue.poll();
			queue.offer(val);
		}
		return queue.peek();
	}
	/*private int k;
	private int[] nums;
	public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = nums;
        Arrays.sort(this.nums);
    }
    
    public int add(int val) {
        int len = nums.length, i = 0, j = 0;        
        int[] n = new int[len+1];
        for(; i < len; i ++){
        	if(nums[i] < val)
        		n[i] = nums[i];        	
        	else break;
        }
        
    	n[i] = val;
    	for(j = i+1; j <= len; j ++, i ++)
    		n[j] = nums[i];        	        
        
    	nums = n;
        
        return n[len+1-k];
    }
	*/
	public static void main(String[] args) {
		int k = 3;
		int[] arr = {4,5,8,2};
		KthLargest obj = new KthLargest(k, arr);
		System.out.println(obj.add(3));
		System.out.println(obj.add(5));
		System.out.println(obj.add(10));
		System.out.println(obj.add(9));
		System.out.println(obj.add(4));
	}

}
