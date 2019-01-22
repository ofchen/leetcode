package LeetCode.DataStructure;

import java.util.LinkedList;
import java.util.Queue;
//Implement the following operations of a stack using queues.
public class MyStack {
	 private Queue<Integer> q;
	    
     /** Initialize your data structure here. */
     public MyStack() {
        q = new LinkedList<Integer>();
     }
    
     /** Push element x onto stack. */
     public void push(int x) {
    	Queue<Integer> tempQ = new LinkedList<Integer>();
        while(!q.isEmpty()) {               //ע�⣺���ĳ�����л�������ѭ��ֻ�漰����߳������ǳ�����⣬��ô�Ͳ�Ҫʹ��forѭ��
            tempQ.offer(q.poll());
        }
        q.offer(x);
        while(!tempQ.isEmpty()) {
            q.offer(tempQ.poll());
        }
     }
    
     /** Removes the element on top of the stack and returns that element. */
     public int pop() {
        return q.poll();
     }
    
     /** Get the top element. */
     public int top() {
        return q.peek();
     }
    
     /** Returns whether the stack is empty. */
     public boolean empty() {
        return q.isEmpty();
     }
	    
	    public static void main(String[] args) {
	    	MyStack obj = new MyStack();
	    	
	    	obj.push(1);
	    	obj.push(2);
	    	int l = obj.top();
	    	System.out.println("minStack.top()="+l);	    	
	    	l = obj.pop();
	    	System.out.println("obj.pop()="+l);
	    	boolean e = obj.empty();
	    	System.out.println("obj.empty()="+e);
		}
}
