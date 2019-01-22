package LeetCode.medium;

import java.util.Arrays;

public class GetHint {
	public static String getHint(String secret, String guess) {
        int resA = 0, resB = 0, slen = secret.length(), ai = 0;
        int[] s = new int[slen];
        int[] g = new int[slen];
        
        char[] sc = secret.toCharArray();
        char[] gc = guess.toCharArray();
        int i = 0;
        
        for(; i < slen; i ++){
            if(sc[i] == gc[i])
                resA ++;
            else{
                s[ai] = sc[i];
                g[ai] = gc[i];
                ai ++;
            }
        }
        
        int j = 0;
        i = 0;
        Arrays.sort(s);
        Arrays.sort(g);
        for(i = 0; i < slen && s[i] == 0; i ++);
        for(j = 0; g[j] == 0  && j < slen; j ++);
        while(i < slen && j < slen){
            if(s[i] < g[j])
                i ++;
            else if(s[i] > g[j])
                j ++;
            else{
                resB ++;
                i ++;
                j ++;
            }
        }
        
        return resA+"A"+resB+"B";
    }
	//������һ����Ϊ10��int���飬index��Ӧ��Ԫ��ֵ��ʾsecret�и�index���ֵĴ�����
	//���secret����һ��ĳ�����֣���λ�þ�����1�������ʱ��λ��С��0����˵�����������guess���ֹ������cows������1��
	//guess�Ĵ����secret���ƣ��������index��ӦԪ����Ҫ�Լ�
	public static String getHint2(String secret, String guess) {
		int resA = 0, resB = 0;
		int[] count = new int[10];
		for(int i = 0; i < secret.length(); i ++){
			if(secret.charAt(i) == guess.charAt(i))
				resA ++;
			else{
				if(count[secret.charAt(i) - '0']++ < 0) resB ++;
				if(count[guess.charAt(i) - '0']-- > 0) resB ++;
			}
		}
		
		return resA+"A"+resB+"B";		
	}
	
	public static void main(String[] args) {
		String secret = "01234545";
		String guess = "02315445";
		System.out.println(getHint(secret, guess));
		System.out.println(getHint2(secret, guess));
	}

}
