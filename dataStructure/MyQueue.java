package LeetCode.DataStructure;

import java.util.Stack;

public class MyQueue {
	private Stack<Integer> s; 
	/** Initialize your data structure here. */
    public MyQueue() {
        s = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        s.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int res = 0;
    	if(!s.isEmpty()){
        	Stack<Integer> t = new Stack<Integer>();
        	while(!s.isEmpty())
        		t.push(s.pop());
        	res = t.pop();
        	while(!t.isEmpty())
        		s.push(t.pop());        	
        }
        return res;
    }
    
    /** Get the front element. */
    public int peek() {
    	if(!s.isEmpty())
    		return s.get(0);
    	return 0;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s.isEmpty();
    }
    
    public static void main(String[] args) {
    	MyQueue obj = new MyQueue();
    	
    	obj.push(1);
    	obj.push(2);
    	int l = obj.peek();
    	System.out.println("obj.peek()="+l);	    	
    	l = obj.pop();
    	System.out.println("obj.pop()="+l);
    	boolean e = obj.empty();
    	System.out.println("obj.empty()="+e);
	}
}
