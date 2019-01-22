package LeetCode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReplaceWords {
	public static String replaceWords(List<String> dict, String sentence) {     
        List<String>[] map = new List[26];
        
        for(String str : dict){
            int index = str.charAt(0)-'a';
            if(map[index] != null){
                int mlen = map[index].size();
                int i = 0;
                for(i = 0; i < mlen; i ++){
                    int len = map[index].get(i).length();
                    if(len > str.length()){
                        map[index].add(i,str);
                        break;
                    }
                }
                if(i == mlen)
                    map[index].add(str);
            }
            else{
            	map[index] = new ArrayList<String>();
            	map[index].add(str);
            }
        }
        
        String[] spse = sentence.split(" ");
        int slen = spse.length;
        StringBuffer res = new StringBuffer();
        List<String> adict;
        for(int i = 0; i < slen; i ++){
            adict = map[spse[i].charAt(0)-'a'];
            if(adict == null){ 
                if(i != slen-1)
                    res.append(spse[i]+" ");
                else 
                    res.append(spse[i]);
            }
            else{
                int alen = adict.size();
                int j = 0;
                for(j = 0; j < alen; j ++){
                    String astr = adict.get(j);
                    int aslen = astr.length();
                    if(spse[i].length() >= aslen && astr.equals(spse[i].substring(0,aslen))){
                        if(i != slen-1)
                            res.append(astr+" ");
                        else 
                            res.append(astr);
                        break;
                    }
                }
                if(j == alen){
                	if(i != slen-1)
                        res.append(spse[i]+" ");
                    else 
                        res.append(spse[i]);
                }
            }
        }
      return res.toString();  
    }
	
	public static String replaceWords2(List<String> dict, String sentence) {  		
		Set<String> set = new HashSet<String>();
		for(String dt : dict)
			set.add(dt);
		
		StringBuffer res = new StringBuffer();
		for(String word : sentence.split("")){
			String prefix = "";
			for(int i = 1; i <= word.length(); i ++){
				prefix = word.substring(0, i);
				if(set.contains(prefix))
					break;
			}
			if(res.length() > 0) res.append(" ");
			res.append(prefix);
		}
		return res.toString();  
	}

	public static class TrieNode{
		TrieNode[] children;
		String word;
		TrieNode(){ children = new TrieNode[26]; }
	}
	
	//ʹ��ǰ׺��prefix tree
	public static String replaceWords3(List<String> dict, String sentence) {
		TrieNode root = new TrieNode();
		//java�ڲ�����ã���̬�ڲ��� static classʹ��ʱ��������
		//�Ǿ�̬�ڲ��������Ҫ����������� eg.Calculator calculator1=new Calculator(2,2);
		//Calculator.Operator operator1=calculator1.new Operator();
		//�����࣬�ֲ��ࣿ 
		for(String dt : dict){ //����ǰ׺��
			TrieNode cur = root;
			for(char c : dt.toCharArray()){
				if(cur.children[c-'a'] == null)
					cur.children[c-'a'] = new TrieNode();
				cur = cur.children[c-'a'];
			}
			cur.word = dt;
		}
		
		StringBuffer res = new StringBuffer();
		for(String word : sentence.split(" ")){
			if(res.length() > 0) res.append(" ");
			TrieNode cur = root;
			for(char c : word.toCharArray()){
				if(cur.children[c-'a'] == null || cur.word != null)
					break;
				cur = cur.children[c-'a'];
			}
			res.append(cur.word != null ? cur.word : word);
		}
		return res.toString();
	}
	
	public static void main(String[] args) {
		ArrayList<String> dict = new ArrayList<String>();
		dict.add("a");
		dict.add("aa");
		dict.add("aaa");
		dict.add("aaaa");
		String n = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa";
		System.out.print(replaceWords3(dict, n));		
	}
	
}
