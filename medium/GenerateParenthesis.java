package LeetCode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class GenerateParenthesis {
	//NO.22 ����С���Ŷ������жϹ�����������������еĸ���
	public static List<String> generateParenthesis(int n) {
		Set<String> res = new HashSet<String>();
		res.add("");
		for(int j = 1; j <= n; j++){	
			Set<String> pre = new HashSet<String>(res);
			res.clear();
			for(String str : pre){
				//System.out.println(str);
				int len = str.length();
				String temp = str;
                for(int i = 0; i < len; i++){                    
                    if(str.charAt(i) == '('){
                        str = str.substring(0, i+1)+"()"+str.substring(i+1,len);
                        res.add(str);
                        str = temp;
                    }
                }
                res.add(str+"()");
            }
		}
		
		return new ArrayList<String>(res);
	}
	public static void main(String[] args) {
		int n = 3;
		List<String> reStrings = generateParenthesis(n);
		for(String str : reStrings)
			System.out.println(str);
	}
}
