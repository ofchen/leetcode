package LeetCode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumsSameConsecDiff {
	//ʹ���������List�Ļ������鳤�Ȳ���ȷ��
	//ʹ��set�Ļ�add���Ѹ���ʱ��
	public static int[] numsSameConsecDiff(int N, int K) {
        Set<Integer> res = new HashSet<Integer>();
        //if(N == 1) return new int[]{0,1,2,3,4,5,6,7,8,9};        
        
        if(N == 1) res.add(0);
        
        for(int i = 1; i <= 9; i++){
            helper(N, K, i, res);
        }
        int len = res.size(), m = 0;
        int[] nres = new int[len];
        for(int i : res){
            nres[m++] = i;
        }
        return nres; 
    }
	
    public static void helper(int N, int K, int temp, Set<Integer> res){        
        if(N == 1){
            res.add(temp);
            return;
        }
        else{
            int lt = temp%10;
            if(lt+K < 10)
                helper(N-1, K, temp*10+lt+K, res);
            if(lt-K >= 0)
                helper(N-1, K, temp*10+lt-K, res);
        }
            
    }
    
    public static void main(String[] args) {
    	int N = 2, K = 0;
    	System.out.println(Arrays.toString(numsSameConsecDiff(N, K)));
    }
}
