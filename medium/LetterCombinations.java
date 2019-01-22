package LeetCode.medium;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
//�绰������ܵ��ַ���ϣ��ѵ��������п��ܵı�������һ�ַ���ʹ��counterMap��¼��ǰ���ڱ��滻����ĸ��
//�ڶ��ַ���ͨ������������е�ÿ��Ԫ�ز����µĽ�β��
public class LetterCombinations {
	
	public static List<String> letterCombinations(String digits) {   
/*
		List<String> res = new ArrayList<String>();
		if(digits == null || digits.length() == 0){		
			return res;
		}
	        char[][] digitsMap = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, 
	        		{'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, 
	        		{'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
	        
	        int len = digits.length();
	        char[] chs = digits.toCharArray();
	        char[] ares = new char[len]; //ÿһ���������
	        int i = 0, j = 0, total = 1;
	        int cIndex = len-1; //��λָ��
	        int[] counterMap = new int[len]; 
	        for(i = 0; i < len; i ++){
	        	counterMap[i] = 0;
	        	total *= digitsMap[i].length;
	        }	        	
	        res = new ArrayList<String>(total);
	        
	        while(cIndex >= 0){
	        	for(j = 0; j < len; j ++){ 
	        		char[] jchs = digitsMap[chs[j]-'2'];
	        		ares[j] = jchs[counterMap[j]];
	        		if(j == len-1){
	        			int jlen = jchs.length;
	        			if(++counterMap[j] > jlen-1){
	        				counterMap[j] = 0; //����ָ��
	        				int cidx = j; //��λ
	        				while(--cidx >= 0){
	        					//�ж�����պ�ǰһλҲҪ��λ��������ָ���λ
	        					if(++counterMap[cidx] > digitsMap[chs[cidx]-'2'].length - 1){
	        						counterMap[cidx] = 0;
	        						continue;
	        					}
	        					break;
	        				}
	        				if(cidx < cIndex){//�ƶ���λָ��
	        					cIndex = cidx;
	        				}
	        			}
	        		}
	        	}
	        	res.add(String.valueOf(ares));
	        }
	       
	        return res;
*/	        
	        List<String> res = new ArrayList<>();
	        if(digits.length()==0||digits==null)  return res;
	        HashMap<Character, String> hm = new HashMap<>();
	        hm.put('0', ""); hm.put('1', ""); hm.put('2', "abc"); hm.put('3', "def"); hm.put('4', "ghi");
	        hm.put('5', "jkl"); hm.put('6', "mno"); hm.put('7', "pqrs"); hm.put('8', "tuv"); hm.put('9', "wxyz");
	        Queue<String> q = new ArrayDeque<>();
	        q.offer("");
	        for(int i=0; i<digits.length(); i++) {
	            String mch=hm.get(digits.charAt(i));
	            int size=q.size();
	            for(int j=0; j<size; j++) {
	                String top = q.poll();
	                for(int k=0; k<mch.length(); k++) {
	                    q.offer(top+mch.charAt(k));
	                }
	            }
	        }
	        res.addAll(q);
	        return res;
	    }

	    public static void main(String[] args) {
			String s = "9378";
			//System.out.println(letterCombinations(s).size());
			System.out.println(letterCombinations(s));
		}	    
}
