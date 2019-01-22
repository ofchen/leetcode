package LeetCode.easy;

import java.util.Stack;

public class CalPoints {
	//˫ջ��һ���洢��Ч�÷֣���һ���洢��ǰ��
	public static int calPoints(String[] opStrings) {
		Stack<Integer> p = new Stack<Integer>();
		Stack<Integer> sum = new Stack<Integer>();
		
		for(String s :opStrings){
			char[] sc = s.toCharArray();
			if(s.length() != 0){
				if(sc[0] >= '0' && sc[0] <='9' || sc[0] == '-'){
					int n = Integer.parseInt(s);
					p.push(n);
					if(!sum.isEmpty()){
						sum.push(sum.peek()+n);
					}
					else {
						sum.push(n);
					}
				}
				else if(sc[0] == 'C'){
					sum.pop();
					p.pop();
				}
				else if(sc[0] == 'D'){
					int t = p.peek();
					p.push(t+t);
					sum.push(sum.peek()+p.peek());
				}
				else if(sc[0] == '+'){
					int t1 = p.pop();
					int t2 = p.peek();
					p.push(t1);
					p.push(t1+t2);
					sum.push(sum.peek()+p.peek());
				}
			}
		}
		
		return sum.peek();
	}
	
	//��������stack������Ч�÷֣�index��ӦԪ��ָʾ��һ������Ч�÷�
	public static int calPoints2(String[] ops) {
		int[] stack = new int[ops.length];
		int index = -1;
		
		for(String s: ops){
			if(s.length() == 1){
				if("+".equals(s)){
					int now = stack[index]+stack[index-1];
					stack[++index] = now;
				}
				else if("D".equals(s)){
					int now = stack[index] * 2;
					stack[++index] = now;
				}
				else if("C".equals(s)){
					--index;
				}
				else{
					int now = Integer.parseInt(s);
					stack[++index] = now;
				}
			}
			else{
				int now = Integer.parseInt(s);
				stack[++index] = now;
			}
		}
		
		int res = 0;
		if(index == -1) return 0;
		for (int i = 0; i <= index; i++) {
			res += stack[i];
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		String[] opStrings= {"5","2","C","D","+"};//{"5","-2","4","C","D","9","+","+"}; 
		System.out.println(calPoints2(opStrings));
	}

	

}
