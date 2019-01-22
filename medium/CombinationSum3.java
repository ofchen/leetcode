package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
	public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if(k == 0 || k == 1 && (n > 9 || n < 1)) return res;
        List<Integer> ares = new ArrayList<Integer>();
        combinationSum3(k, n, 1, ares, res);
        
        System.out.println("\nresult==");
        for(int i = 0; i < res.size(); i ++){
        	ares = res.get(i);
        	if(!ares.isEmpty())
	        	for(int j = 0; j < 3; j++)
	        		System.out.print(ares.get(j)+" ");
        	System.out.println();
        }
        return res;
    }
    
    public static void combinationSum3(int k, int n, int temp, List<Integer> ares,List<List<Integer>> res){
    	System.out.println("\nk = " + k + ",n = " + n + ",temp = " + temp);
    	if(n == 0 && ares.size() == k) {
        	res.add(new ArrayList<Integer>(ares));        	
        	return ;
        }
        if(n < 0 || k == ares.size()) return ;
        for(int i = temp; i <= 9; i ++){
            ares.add(i);
            
//            for(int j = 0; j < ares.size(); j++)
//        		System.out.print(ares.get(j)+" ");
//            System.out.println(", before i = " + i);
            
            combinationSum3(k, n-i, i+1, ares, res);
            ares.remove(ares.size()-1);
            
//            for(int j = 0; j < ares.size(); j++)
//        		System.out.print(ares.get(j)+" ");
//            System.out.println(", after i = " + i);
        }
    }
	public static void main(String[] args) {
		int k = 3;
		int n = 9;
		
		combinationSum3(k, n);
		//String s = k +"->"+ n;
		//String s2 = Integer.toString(n);
		//System.out.println(s);
	}

}
