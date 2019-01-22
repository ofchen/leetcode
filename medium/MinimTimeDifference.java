package LeetCode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimTimeDifference {
	//NO.539 �жϸ���list����������ʱ�����Сʱ������������23:59��00:00��1m
	//�������д���
	public static int findMinDifference(List<String> timePoints) {
        int[] codes = new int[timePoints.size()+1];
        int j = 0, res = 0;
        for(String s : timePoints){
            if(s.equals("00:00"))
            	codes[j++] = 0;
        	codes[j++] = encode(s)[1];
        }
        codes = Arrays.copyOf(codes, j);
        Arrays.sort(codes);
        for(int i = 1; i < j; i++){
        	res = Math.max(res, codes[i]-codes[i-1]);
        }
        
        return res;
    }
    
    public static int[] encode(String time){
        int[] res = new int[2];
        int comma = time.indexOf(':');
        int h = Integer.parseInt(time.substring(0,comma));
        int m = Integer.parseInt(time.substring(comma+1,time.length()));
        res[0] = h;
        
        if(h == 0 && m == 0)
            res[1] = 24*60;
        else
            res[1] = h*60+m;
        return res;
    }
    
    public static void main(String[] args) {
		List<String> time = new ArrayList<String>();
		time.add("23:59");
		time.add("00:00");
		System.out.print(findMinDifference(time));
	}
}
