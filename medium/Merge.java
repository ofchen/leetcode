package LeetCode.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

import LeetCode.basic.Interval;

public class Merge {
	public List<Interval> merge(List<Interval> intervals) {
        int len = intervals.size();
        List<Interval> res = new ArrayList<>();
        if(len == 0) return res;
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval o1, Interval o2) {
            	return o1.start - o2.start;
            }
        });
		
        int s1 = intervals.get(0).start;
        int e1 = intervals.get(0).end;
        int s2,e2;
        
        for(int i = 1; i < len; i ++){
            s2 = intervals.get(i).start;
            e2 = intervals.get(i).end;
            if(e1 < s2){
                res.add(new Interval(s1, e1));
                s1 = s2;
                e1 = e2;
            } 
            else if(s2 <= e1 && e1 < e2){
                e1 = e2;
            }
        }
        res.add(new Interval(s1, e1));
        return res;
    }
	
	//����ʼλ�úͽ���λ�÷ֱ�浽��������ͬ������starts��ends�У�Ȼ��ֱ��������֮��������ָ��i��j����ʼ��ʱ�ֱ�ָ��starts��ends�������λ�ã�Ȼ�����iָ��starts�����е����һ��λ�ã����ߵ�starts������i+1λ���ϵ����ִ���ends�����iλ���ϵ���ʱ����ʱ˵�������Ѿ���������,��������
	public static List<Interval> merge2(List<Interval> intervals) {
        int len = intervals.size();
        List<Interval> res = new ArrayList<>();
        if(len == 0) return res;
        
        int[] s = new int[len];
        int[] e = new int[len];
        for(int i = 0; i < len; i++){
        	Interval it = intervals.get(i);
        	s[i] = it.start;
        	e[i] = it.end;
        }
        Arrays.sort(s);
        Arrays.sort(e);
        
        for (int i = 0, j = 0; i < len; i++) 
			if(i == len-1 || s[i+1] > e[i]){
				res.add(new Interval(s[j], e[i]));
				j = i+1;
		}
        return res;
    }
	
	//ʹ�ò��������˼�룬ÿ���µ��������ݼ������ºϲ�һ������
	public static List<Interval> merge3(List<Interval> intervals) {
		List<Interval> res = new ArrayList<>();
		int len = intervals.size();
		for (int i = 0; i < len; i++) {
			res = insert(res, intervals.get(i));
		}
		return res;
	}
	
	public static List<Interval> insert(List<Interval> intervals, Interval it) {
		int len = intervals.size();
        List<Interval> res = new ArrayList<>();
        int cur = 0;
        
        for (int i = 0; i < len; i++) {
        	Interval in = intervals.get(i); 
			if(in.end < it.start){
				res.add(in);
				cur++;
			}
			else if(in.start > it.end){
				res.add(in);
			}
			else{
				it.start = Math.min(it.start, in.start);
				it.end = Math.max(it.end, in.end);
			}
		}
        res.add(cur, it);
        return res;
	}
	
	public static void main(String[] args) {
		List<Interval> res = new ArrayList<>();
		
		res.add(new Interval(2, 6));res.add(new Interval(1, 3));
		res.add(new Interval(8, 10));
		res.add(new Interval(15, 18));
		res = merge3(res);
		
	}
}
