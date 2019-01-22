package LeetCode.hard;

import java.util.Stack;

public class RemoveDuplicateLetters {
	//NO.316 ȥ���ַ������ظ���ĸʹ��ÿ����ĸ������һ�β��ҽ��Ϊ��С�ֵ�˳��
	
	
	//�����ַ�������֪��������������Ȼ֪��������̣�
	//����ͳ�Ƴ�ÿ���ַ����ֵĴ�������visited�����¼һ����ĸ�Ƿ񱻷��ʹ���
	//������ʹ���˵������ĸ�ڽ���ַ����е�λ���Ѱ��Ų�����ѭ����
	//���û�з��ʹ����ͽ�������һ����ĸ�Ƚϣ�
	//�������ĸ��ASCII��С������е����һ����ĸ��ͳ�������е�ֵ��Ϊ0��˵�����滹����������ĸ����
	//��ô���Ǵ�ʱ��Ҫ�ڽ����ɾȥ���һ����ĸ�ҽ�����Ϊδ���ʣ�
	//Ȼ����ϵ�ǰ����������ĸ������ ������Ϊ�ѷ��ʣ��Դ�����ֱ�����������ַ���	
	public static String removeDuplicateLetters(String s) {
        if(s == null || s.length() == 0) return null;
        char[] cs = s.toCharArray();
        int len = cs.length;
        int[] cnt = new int[26];
        for(int i = 0; i < len; i ++){
        	cnt[cs[i]-'a']++;
        }
        Stack<Character> st = new Stack<Character>();
        boolean[] visited = new boolean[26]; 
        for(int i = 0; i < len; i ++){
        	cnt[cs[i]-'a']--;
        	if(visited[cs[i]-'a'])
        		continue;
        	while(!st.isEmpty() && (st.peek() > cs[i]) && (cnt[st.peek()-'a'] > 0)){
        		visited[st.pop()-'a'] = false;
        	}
        	st.push(cs[i]);
        	visited[cs[i]-'a'] = true;
        }
        
        StringBuilder res = new StringBuilder();
        while(!st.isEmpty()){
        	res.insert(0,st.pop());
        }
        return res.toString();
    }
	
	//��һ�ַ����ĸĽ�������ģ��ջ
	public static String removeDuplicateLetters1(String s) {
		if(s == null || s.length() == 0) return null;
        char[] cs = s.toCharArray();
        int len = cs.length;
        int[] cnt = new int[26];
        for(int i = 0; i < len; i ++){
        	cnt[cs[i]-'a']++;
        }
        
        boolean[] visited = new boolean[26]; 
        char[] res = new char[len];
        int rlen = 0;
        for(int i = 0; i < len; i ++){
        	cnt[cs[i]-'a']--;
        	if(!visited[cs[i]-'a']){
        		while(rlen > 0 && (res[len-1] > cs[i]) && (cnt[res[len-1]-'a'] > 0)){
            		visited[res[--len]-'a'] = false;
            	}
            	res[len++] = cs[i];
            	visited[cs[i]-'a'] = true;
        	}
        }
        
        return new String(res, 0, len);
	}
	/*
	 �ȼ�¼ÿ����ĸ���ִ������ٱ����������ַ������ҳ���С����ĸ��ÿ�Ƚ�һ����ĸ����ͳ��������ֵ�ͼ�1�������ʱΪ0�˾Ͳ����������ˣ�
	 ��ʱ���Ǽ�¼��һ��λ�ã����ַ���str����ߵ�����ĸȫɾ�����ұ������ٳ��ֵĸ���ĸҲɾ�����ݹ���ô˺���
	 */
	public static String removeDuplicateLetters2(String str) {
		int[] count = new int[26];		
		for(int i=0; i<str.length(); i++)
			count[str.charAt(i)-'a']++;//ͳ��ÿ���ַ����ִ���
		
		int pos = 0;
		for(int i=0; i<str.length(); i++){
			if(str.charAt(i) < str.charAt(pos))
				pos = i;
			if(--count[str.charAt(i)-'a'] == 0)
				break;//��һ���ַ�������0ʱ����ʾ���ַ��������
		}		
		
		return str.length()==0 ? "":str.charAt(pos) + removeDuplicateLetters2(str.substring(pos + 1).replaceAll("" + str.charAt(pos), ""));
	}
	
	public static void main(String[] args){
		String string = "cbacdcbc";
		System.out.print(removeDuplicateLetters2(string));
		
	}
	
}
