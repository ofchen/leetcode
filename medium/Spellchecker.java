package LeetCode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Spellchecker {
	//�����ִ�Сд�Լ�Ԫ�����滻���жϲ�ѯ�ַ����Ƿ����ֵ���
	public static String[] spellchecker(String[] wordlist, String[] queries) {
        
		int wlen = wordlist.length, qlen = queries.length;
        String[] res = new String[qlen];
        int[] wlens = new int[wlen];
        int[] qlens = new int[qlen];
        char[][] wrs = new char[wlen][];
        char[][] qrs = new char[qlen][];
        for(int i = 0; i < wlen; i ++){
            wlens[i] = wordlist[i].length();
            wrs[i] = wordlist[i].toCharArray();
        }
        for(int i = 0; i < qlen; i ++){
            qlens[i] = queries[i].length();
            qrs[i] = queries[i].toCharArray();
        }
        
        for(int i = 0; i < qlen; i ++){
            String ares = "";
            char[] qr = qrs[i];
            
            System.out.println("query="+queries[i]);
            
            int like1 = 0, like2 = 0;
            for(int j = 0; j < wlen; j ++){                
            	if(wlens[j] == qlens[i]){                    
                    char[] wr = wrs[j];                    
                    
                    System.out.println("----now="+wordlist[j] +" ,");
                    
                    int m = 0;
                    for(; m < wlens[j]; m ++){
                    	if(qr[m] != wr[m]){
                            if(!isVowel(qr[m]) && qr[m]-32 != wr[m] && qr[m]+32 != wr[m])
                                 break;
                            else if(isVowel(qr[m]) && !isVowel(wr[m]))
                            	break;
                        }
                        else {
							like2++;
						}
                    }
                    if(m == wlens[j] && (ares.isEmpty() || like2 > like1)){                        
                    	ares = wordlist[j];
                    	if(like2 == m || like2 == 0)
                    		break;
                    	like1 = like2;                        
                    }
                    like2 = 0;
                } 
            }
            System.out.println("i="+i+", "+ares);
            res[i] = ares;
        }
        
        return res;
    }
    
    public static boolean isVowel(char c){
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || 
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U');
    }
	
	
	public static void main(String[] args) {
		//String[] wordlist = {"KiTe","kite","hare","Hare"};
		//String[] queries = {"kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"};
		//String[] queries = {"Hare","HARE","Hear","hear","keti","keet","keto"};
		String[] wordlist = {"wg","uo","as","kv","ra","mw","gi","we","og","zu"};
		String[] queries = {"ov","lc","os","wm","Mw"};
		System.out.println(Arrays.toString(spellchecker(wordlist, queries)));
	}

}
