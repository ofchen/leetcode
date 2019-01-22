package LeetCode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import LeetCode.basic.Employee;

public class GetImportance {
	public static int getImportance(List<Employee> employees, int id) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, Employee> map = new HashMap<>();
        for(Employee e : employees)
            map.put(e.id, e);
        return compute(map, set, id);
    }
    
    public static int compute(Map<Integer, Employee> map, Set<Integer> set, int id){
        if(set.contains(id)) return 0;
        set.add(id);
        int res = map.get(id).importance; 
        for(int i: map.get(id).subordinates){ //subordinatesΪ��ֱ������ѭ��
            res += compute(map, set, i);
        }
        return res;
    }
    //������ȱ���
    public static int getImportance2(List<Employee> employees, int id) {
    	int res = 0;
    	Queue<Integer> qu = new LinkedList<>();
    	Map<Integer, Employee> map = new HashMap<>();
        for(Employee e : employees)
            map.put(e.id, e);
    	qu.offer(id);
        while(!qu.isEmpty()){
    		int i = qu.poll();
    		res += map.get(i).importance;
    		for(int k: map.get(i).subordinates)
    			qu.offer(k);
    	}
        return res;
    }
    
    public static void main(String[] args) {
    	List<Employee> es = new ArrayList<>();
    	List<Integer> sub = new ArrayList<>();
    	sub.add(2);sub.add(3);    	
    	Employee e = new Employee(1, 5, sub);    	
    	es.add(e);
    	
    	sub = new ArrayList<>();    	  	
    	e = new Employee(2, 3, sub);    	
    	es.add(e);
    	
    	sub = new ArrayList<>();    	  	
    	e = new Employee(3, 3, sub);    	
    	es.add(e);
    	
    	System.out.print(getImportance2(es, 1));
	}
}
