package LeetCode.easy;

import java.util.Stack;
//�жϱ�㴮�Ƿ�Ϸ�
public class IsValid {

	public static boolean isValid(String s){
		Stack<Character> stack = new Stack<Character> ();
		int len = s.length(), i = 0;
		if(len == 0) return true;
		
		stack.push(s.charAt(0));
		for(i = 1;i < len; i ++){
			char ch = s.charAt(i);
			if(ch == '{' || ch == '(' || ch == '[')
				stack.push(ch);
			else if(ch == '}'){
				if(stack.isEmpty() || stack.pop() != '{')
					return false;
			}
			else if(ch == ')'){
				if(stack.isEmpty() || stack.pop() != '(')
					return false;
			}
			else if(ch == ']'){
				if(stack.isEmpty() || stack.pop() != '[')
					return false;
			}
		}		
		if(i == len && !stack.isEmpty())
			return false;
		return true;
	}
	
	public static void main(String[] args) {
		String s = "";
		System.out.println(isValid(s));
	}
	
}
