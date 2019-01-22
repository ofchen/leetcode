package LeetCode.easy;
//�жϾ��������һ�����ʵĳ��ȣ��Կո�Ϊ�ָ������ֻ��һ�����ʼ��õ��ʳ���
public class LengthOfLastWord {
	public static int lengthOfLastWord(String s) {
        char[] chs = s.toCharArray();
        int len = chs.length;
        if(len == 0)
            return 0;
        if(len == 1){  
            if(chs[0] != ' ')
                return 1;
            else 
                return 0;
        }
        
        int i = len-1, j = 0;
       
        for(;i >= 0 && chs[i] == ' ';i --);

        for(;i >= 0 && chs[i] != ' '; i--,j++);
        return j;
	}
	
	public static void main(String[] args) {
		String s = "b   a   ";
		System.out.println(lengthOfLastWord(s));
	}
}