package LeetCode.hard;

import java.util.Stack;

public class Calculate {
	//ֻ����С���źͿո�+��-������, �ѵ�����ȥ����
	//������(,����ǰres��op����ջ�в�����res,op��ֵ������)ʱop��res���γ�ջ�͵�ǰ�������
	public static int calculate(String s) {       
        if(s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        char[] sc = s.toCharArray();
        int num = 0, res = 0, op = 1;
        for(int i = 0 ; i < sc.length; i++){       	
        	if(sc[i] >= '0') 
                num = num*10+sc[i]-'0';
        	else if(sc[i] == '+' || sc[i] == '-') {                        		
        		res += op*num;
                num = 0;
                op = (sc[i] == '-' ? -1 : 1);
            }
        	else if(sc[i] == '('){
        		stack.push(res);
        		stack.push(op);
        		res = 0;
        		op = 1;
        	}        		
        	else if(sc[i] == ')'){
        		res += op*num;
                num = 0;
                res *= stack.pop();
                res += stack.pop();
        	}        	
        }
        res += op*num; //���һ���ַ���������ʱ
        return res;        
    }
	
	public static void main(String[] args) {
		//String s ="(1+(4+5+2)-3)+(6+8)";
		String s ="(-2-((5-6)-8))";
		//String s =" 2-1+1  ";
		System.out.print(calculate(s));
	}
}
