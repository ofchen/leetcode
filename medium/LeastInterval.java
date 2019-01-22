package LeetCode.medium;

import java.util.ArrayList;
import java.util.Date;

public class LeastInterval {
	//�����Ǵ���ģ�����aba,2 ; aaabbb 2 
	public static int leastInterval(char[] tasks, int n) {
        int len = tasks.length;
        if(n == 0) return tasks.length;
        if(len == 0) return 0;
        
        //�Կռ任ʱ��
        int maxlen = (n+1)*len-n;
        char[] temp = new char[maxlen];
        temp[0] = tasks[0];
        int i = 0, j = 1, k = 1, pos = 0;
        while(j < len){
            if(tasks[j] == tasks[j-1]){                
                i = i + n + 1;
                for(;temp[i] != 0; i ++);
                temp[i] = tasks[j];
            }
            else{
            	int t = k;
            	for(;t >= 0 &&temp[t] != tasks[j]; t --);            	
            	if(k-t <= n && t != -1){
            		k = t + n + 1;
	                for(;temp[k] != 0; k ++);	            	
            	}
            	temp[k] = tasks[j]; 
                i = k;
            	k ++;              
            }
            j ++;
            pos = (pos > i ? pos : i); 
        }
        
        return pos+1;
    }
	
	public static void main(String[] args) {
		char[] flowerbed = {'a','a','a','b','b','b'};
		int n = 2;
		System.out.print(leastInterval(flowerbed, n));				 
	}
}
