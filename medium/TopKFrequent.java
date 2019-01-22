package LeetCode.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class TopKFrequent {
	public static List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for(String word: words){
        	if(map.containsKey(word))
        		map.put(word, map.get(word)+1);
        	else
        		map.put(word, 1);
        }
        //sortedsetΪ�̳�set�Ľӿڣ�ʵ������TreeSet,ConcurrentSkipListSet 
        //��Ȼʹ������set����ʹ�ַ���˳�����У����ҳ�top k���ַ�����Ҫ�������fm����ʱû�뵽����?
        //->��words.length()-k���Բ����ڽ�����ַ���,�ñ���set
          
        /*Map<Integer, SortedSet<String>> fm = new TreeMap<>();
        java.util.Iterator<Entry<String, Integer>> entries = map.entrySet().iterator();
        while (entries.hasNext()) {
        	Map.Entry<String, Integer> entry = entries.next();
        	int am = entry.getValue();
        	if(fm.containsKey(am)){
        		SortedSet<String> as = fm.get(am);
        		as.add(entry.getKey());
        	}
        	else{        		
        		SortedSet<String> as = new TreeSet<String>();
        		as.add(entry.getKey());
        		fm.put(entry.getValue(), as);
        	}
        }*/
        /*Ͱ����:���ݳ��ִ����������bucket��Ͱ�ĸ������ᳬ�����ʵĸ�����
         * ��ÿ��Ͱ�У����ǶԵ��ʰ��ַ�˳������������ǿ����ø���������ʾͰ��ÿһ���з�һ�����ϣ�
         * ����set���Զ�����Ĺ��ܣ�ʹ���ܰ���ĸ˳�����С����ǻ�����Ҫ���Ƚ���ÿ�����ʺ�����ִ�����ӳ�䣬
         * Ȼ�������pair����map�֣�map�Ǵ�С��������ģ��������ǵ���������е�Ͱ������ȡpair��
         * ���Ǵ������ģ�ÿ��ȡ��һ�������еĵ��ʣ������ʱ��k���ڸò�ĵ��ʸ�����
         * �ͽ�����ĵ��ʼ�����res�У������ȡǰK�������ˣ�ȡ��Ҫ������Kֵ�����KС�ڵ���0�ˣ�
         * ��break�������ؽ��res
         * vector<string> topKFrequent(vector<string>& words, int k) {
		        vector<string> res;
		        unordered_map<string, int> freq;
		        vector<set<string>> v(words.size() + 1, set<string>());
		        for (string word : words) ++freq[word];
		        for (auto a : freq) {
		            v[a.second].insert(a.first);
		        }
		        for (int i = v.size() - 1; i >= 0; --i) {
		            if (k <= 0) break;
		            vector<string> t(v[i].begin(), v[i].end());
		            if (k >= t.size()) {
		                res.insert(res.end(), t.begin(), t.end());
		            } else {
		                res.insert(res.end(), t.begin(), t.begin() + k);
		            }
		            k -= t.size();
		        }
		      	return res;
		    }
         * */
        
        
        //ʹ��������У���Ƶ������ȡ���k��Ԫ��
        Queue<Pair> q = new PriorityQueue<Pair>(k, new PairComparator());
        for (Entry<String, Integer> entry : map.entrySet()) {
			Pair pair = new Pair(entry.getValue(), entry.getKey());
			q.offer(pair);
			if(q.size() > k)
				q.poll();
		}
        
        while (! q.isEmpty()) {
			Pair curPair = q.poll();
			res.add(0, curPair.w);			
		}
        
        return res;
    }
	
	public static class Pair{
		int freq;
		String w;
		public Pair(int freq, String w){this.freq = freq; this.w = w;}
	}
	
	public static class PairComparator implements Comparator<Pair>{
		public int compare(Pair p1, Pair p2){
			if(p1.freq != p2.freq)
				return p1.freq - p2.freq;
			return p2.w.compareTo(p1.w);
		}
		
	}
	
	public static void main(String[] args){
		String[] words ={"i", "love", "leetcode", "i", "love", "coding"};
		
		topKFrequent(words, 2);
	}
}
