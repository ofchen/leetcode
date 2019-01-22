package LeetCode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeastBricks {
	public static int leastBricks(List<List<Integer>> wall) {
        int res = Integer.MAX_VALUE, wlen = wall.size();        
        List<Integer> list = wall.get(0);
        int sum = 0, len = list.size();
        for(int i = 0; i < len; i ++)
            sum += list.get(i);
        
        for(int i = 1; i < sum; i ++){            
            int temp = 0;
            for(int j = 0; j < wlen; j ++){
                list = wall.get(j);
                len = list.size();
                int ts = 0;
                for(int k = 0; k < len; k ++){
                    ts += list.get(k);
                    if(ts > i){
                        temp ++;
                        break;
                    } 
                    else if(ts == i)
                    	break;
                }
            }
            if(temp < res)
                res = temp;
        }
        return res;
    }
	
	public static void main(String[] args) {
		List<List<Integer> > wall = new ArrayList<List<Integer> >
		(Arrays.asList(Arrays.asList(1,2,2,1),Arrays.asList(3,1,2),
		 Arrays.asList(1,3,2),Arrays.asList(2,4),
		 Arrays.asList(3,1,2),Arrays.asList(1,3,1,1)));
		
		System.out.print(leastBricks(wall));
		
	}

}
