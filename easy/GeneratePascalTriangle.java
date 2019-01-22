package LeetCode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GeneratePascalTriangle {
	public static List<List<Integer>> generate(int numRows) {
        int i = 1, j = 0;
        List<List<Integer>> res = new ArrayList<List<Integer>>();        
        res.add(Arrays.asList(1));
        if(numRows == 1)
            return res;
        res.add(Arrays.asList(1,1));
        if(numRows == 2)
            return res;
            
        for(i = 1; i <= numRows-2; i ++){
            List<Integer> ares = new ArrayList<Integer> ();
            ares.add(1);
            List<Integer> r = res.get(res.size()-1);
            for(j = 1; j <= i; j ++){                            	
            	ares.add(r.get(j-1)+r.get(j));
            }          
            ares.add(1);
            res.add(ares);
        }
        return res;
    }
}
