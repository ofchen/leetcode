package LeetCode.medium;

import java.util.Stack;

public class IsValidSerialization {
	//NO.331 ��#����ս�㣬�ж�string����Ķ��������������Ƿ���ȷ
	/*����:
	 * 1. ���ֵĸ������Ǳ�#����һ��
	   2. ���һ��һ����#��	
		����degree��ʾ�����̵�"#"�ĸ���,�����ͱ���degree_is_zero����¼degree��ʱ�Ƿ�Ϊ0��״̬,
		����⵽"#"ʱ��degree�Լ�1����ʱ��degreeΪ0�ˣ�degree_is_zero��ֵΪtrue��
		��ô������滹�������������Ļ������´�ѭ����ʼ��ʼǰ�����ж�degree_is_zero�����Ϊtrue�Ļ���
		ֱ�ӷ���false���������ַ�Ϊ���ֵĻ���degree����1����ô��ʱdegree�ͳ���2��
		��ʾ�����������������"#"����ѭ���˳���ʱ�򣬴�ʱ�ж�degree�Ƿ�Ϊ0����Ϊ����Ҫ����"#"�ĸ�����
		����Ҳ�ǲ��Ե�
	*/
	public static boolean isValidSerialization(String preorder) {
        if(preorder == null || preorder.length() == 0) return true;
        
		String[] sc = preorder.split(",");
		int len = sc.length;
		int degree = 1;
		boolean dIsZero = false;
		 
		for(int i = 0; i < len; i ++){
			if(dIsZero) return false;
			if(sc[i].equals("#")){
				if(--degree == 0) dIsZero = true;
			}
			else {
				++degree;
			}
			
		}
		return degree == 0;
    }
	
	/*capacity����¼������"#"�ĸ���,��preorderĩβ��һ�����ţ��������Դ���ĩβ��"#",
	 * ����preorder�ַ�������������˷Ƕ��ŵ��ַ���ֱ������������Ļ�capacity�Լ�1��
	 * �����ʱcapacityС��0�ˣ�ֱ�ӷ���true����ʱ���ж϶���ǰ����ַ��Ƿ�Ϊ"#"��
	 * ������ǵĻ���capacity����2��������Ʒǳ�����������ǰ����"#"������capacity�Լ�1û���⣬
	 * ��Ϊ������һ��"#"�����ǰ�������֣���ô���Լ���1�����Կ����ǳ�ʼ����1�����ˣ�Ȼ��������2��
	 * ��Ϊÿ��һ�����֣����Զ���������"#"�������Ҫ�ж�capacity�Ƿ�Ϊ0��������Ľⷨһ����
	 * ����Ҫ����"#"�ĸ���������Ҳ�ǲ��Ե�
	 * */
	public static boolean isValidSerialization2(String preorder) {
		int capacity = 1;
		preorder += ",";
		int len = preorder.length();
		
		for(int i = 0; i < len; i ++){
			if(preorder.charAt(i) != ',')
				continue;
			if(--capacity < 0)
				return false;
			if(preorder.charAt(i-1) != '#')
				capacity += 2;
			System.out.println("i="+i+" c="+preorder.charAt(i)+" bc="+preorder.charAt(i-1)+" cap="+capacity);
		}
		
		return capacity == 0;
	}
	
	//���ö�������ջ������������Ϸ��Ķ�����ջ�����һ��ֻʣ��#
	public static boolean isValidSerialization3(String preorder) {
		if(preorder == null || preorder.isEmpty()) return false;
	    String[] res = preorder.split(",");
	    Stack<String> st = new Stack<>();
	    st.push(res[res.length-1]); //���һ���ַ�һ���ǡ�#��
	    
	    for(int i = 0; i < res.length - 1; i++){
            String s = res[i];
	        if("#".equals(s)){
	            if(!st.isEmpty())
	                st.pop();
	            else
	                return false;
	        }
	        else
	            st.push(s);
	    }
	    return !st.isEmpty() && st.peek().equals("#");
	}
	
	//ÿһ��Ҷ�ڵ�Ľṹ�ǡ����֣�#��#�����������ǰ����е������ĸ�ʽ���滻��һ����#�������ϵ�������ֱ���������Ӧ����һ��#
	public boolean isValidSerialization4(String preorder) {
	         String after = preorder.replaceAll("\\d+,#,#", "#");
	         return after.equals("#") 
	        		 || !after.equals(preorder) && isValidSerialization(after);
	         //after.equals("#") ���յ���ȷ���
	         //!after.equals(preorder) ���Ϸ�������
     }
	
	public static void main(String[] args) {
		String string = "9,3,4,#,#,1,#,#,2,#,6,#,#";
		System.out.print(isValidSerialization2(string));
	}

}
