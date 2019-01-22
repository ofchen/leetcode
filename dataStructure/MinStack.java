package LeetCode.DataStructure;

import java.util.Stack;

//��Щ����
public class MinStack {
	//NO.155 ���һ����Сջ���ڳ���ʱ����������СԪ�أ�push��ջ,popɾ��ջ��Ԫ��,top��ȡջ��Ԫ��,getMin����ջ����СԪ��
    private Stack<Integer> s;
    private Stack<Integer> minStack;     
    
    /** initialize your data structure here. */
    public MinStack() {
    	s = new Stack<>();
    	minStack = new Stack<>();
    }
    
     
    public void push(int x) {
        s.push(x);
    	if(minStack.isEmpty()){
    		minStack.push(x);           
        }
    	else{
    		minStack.push(Math.min(x, minStack.peek()));
    	}
    }
    
    public void pop() {
    	if(s.isEmpty()) return;
    	s.pop();
    	minStack.pop(); 
    }
    
    //top����ջ
    public int top() {
    	
    	if(!s.isEmpty()) return s.peek();
    	return 0;
    }
    
    public int getMin() {
    	if(!minStack.isEmpty()) return minStack.peek();
    	return 0;
    }
    
    /*//��Сֵ�б仯ʱ��ջ��ǰ��Сֵ�͵�ǰֵ����ջʱ�жϵ�ǰֵ����Сֵ�Ƿ���ȣ���ȳ�ջ�����µ�ǰ��Сֵ
     private Stack<Integer> stack;
     private int min;

    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }
    
    public void pop() {
        if (min == stack.pop()) {
            min = stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
     */
    
    public static void main(String[] args) {
    	MinStack obj = new MinStack();
    	obj.push(-2);
    	obj.push(0);
    	obj.push(-3);
    	int l = obj.getMin();
    	System.out.println("minStack.getMin()="+l);
    	obj.pop();
    	l = obj.top();
    	System.out.println("obj.top()="+l);
    	l = obj.getMin();
    	System.out.println("minStack.getMin()="+l);
    	obj.pop();
    	l = obj.top();
    	System.out.println("obj.top()="+l);
    	l = obj.getMin();
    	System.out.println("minStack.getMin()="+l);
    	obj.pop();
    	l = obj.top();
    	System.out.println("obj.top()="+l);
	}
}
