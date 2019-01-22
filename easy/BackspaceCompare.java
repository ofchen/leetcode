package LeetCode.easy;

public class BackspaceCompare {
	//��ջ���StringBuilder��
	public static boolean backspaceCompare(String S, String T) {
        StringBuilder sb = new StringBuilder();
        char[] sc = S.toCharArray();
        char[] tc = T.toCharArray();
        int slen = S.length(), tlen = T.length();
        
        for(int i = 0; i < slen; i ++){
            if(sc[i] == '#'){
                int len = sb.length();
                if(len != 0)
                    sb.delete(len-1, len); //StringBuilder.deleteCharAt(len-1);
                else
                    continue;
                }
            else
                sb.append(sc[i]);
        }
        
        StringBuilder tb = new StringBuilder();
        for(int i = 0; i < tlen; i ++){
            if(tc[i] == '#'){
                int len = tb.length();
                if(len != 0)
                    tb.delete(len-1, len);
                else
                    continue;
                }
            else
                tb.append(tc[i]);
        }
        //StringBuilderû����дequals����,���ֻ���ڴ��ַ��ͬ����ȣ���String��д��equals����
        return sb.toString().equals(tb.toString());
    }
	
	//������ָ��ֱ����S��T��λ��Ҫ�Ƚϵ��ַ�,�ɺ���ǰ����
	public static boolean backspaceCompare2(String S, String T) {
		int i = S.length(), j = T.length();
		char[] sc = S.toCharArray();
        char[] tc = T.toCharArray();
		while(i >= 0 && j >= 0){
			int sbc = 0;
			i-=1;
			while(i >= 0 && (sc[i] == '#' || sbc > 0)){
				if(sc[i] == '#') sbc += 1;
				else sbc -= 1;
				i -= 1;
			}
			int tbc = 0;
			j -= 1;
			while(j >= 0 && (tc[j] == '#' || tbc > 0)){
				if(tc[j] == '#') tbc += 1;
				else tbc -= 1;
				j -= 1;
			}
			
			if(i >= 0 && j >= 0 && sc[i] != tc[j])
				return false;
			
		}
		return i<0 && j<0;
	}
	
	public static void main(String[] args) {
		String S = "bxj##tw";
		String T = "bxj###tw";
		System.out.print(backspaceCompare2(S, T));
	}

}
