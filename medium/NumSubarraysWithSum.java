package LeetCode.medium;

import java.util.HashMap;
import java.util.Map;


public class NumSubarraysWithSum {
	//NO.930 ����0,1���ɵ��ַ��������ٷǿ��Ӵ���Ϊs
	
	//A=ȫ0��S=0Խ��
	public static int numSubarraysWithSum(int[] A, int S) {
        if(A.length == 0) {
        	if(S == 0)  return 1;        		
        	else return 0;				
        }
        int len = A.length, l = 0, r = 0, sum = A[0], res = 0;
        
        // ���ַ���û����ֱ�ӱ�������β����ȻС��S�����������β�͵���S�����,
        //˫ָ��Ļ���ָ����뵽����S��ʱ��ֹͣ������ָ���ڵ���S-1ʱֹͣ��������ָ�������Ҫ����
        //��������ָ���ΪSʱֹͣ��ͳ�ƺ�ΪS�ĸ��������ƶ���ָ�����Ϊ0�����֮ǰ�Ľ��
        while(r < len && l >= 0){
            if(sum < S){
                sum += A[++r];
            }
            else if(sum == S){
            	//res++; S=0ʱ����������
            	while(l <= r && sum == S){
            		sum -= A[l++];
            		res++;
            	}
            	while(++r < len && A[r] == 0)
            		res += (res-1);
            }                
        }        
        
		return res;
    }
	
	//ͳ����������1��0�ĸ���,�����Ϊ���ΪS��(zeros[i]+1)*(zeros[i+S]+1)��
	public static int numSubarraysWithSum2(int[] A, int S) {
		if(A.length == 0) return 0;        
        int len = A.length, res = 0, cnt = 0, idx = 0;
        int[] zeros = new int[len];
        for(int a : A){
        	if(a == 1){
        		zeros[idx++] = cnt;
        		cnt = 0;
        	}
        	else {
				cnt ++;
			}
        }
        
        if(S == 0){
        	for(int z : zeros)
        		res += z*(z+1)/2;
        	return res;
        }
        for(int i = 0; i < idx; i++)
        	res += (zeros[i]+1)*(zeros[i+S]+1);
        return res;
	}
	
	
	//ǰ׺��
	public static int numSubarraysWithSum3(int[] A, int S) {
        if(A.length == 0) return 0;        
        int len = A.length, res = 0, ans = 0;
        int[] prefixSum = new int[len];
        prefixSum[0]++;
        for(int i = 0; i < len; i++){
        	ans += A[i];
        	if(ans >= S)
        		res += prefixSum[ans-S];
        	prefixSum[ans]++;
        }        
        return res;
        
	}
	
	public static void main(String[] args) {
//		int[] A = {1,0,1,0,1,0};
//		int s = 2;
		int[] A = {0,0,0,0};
		int s = 0;
//		int[] A = {0,0,1,0,1,0}; //5
//		int s = 2;
		System.out.println(numSubarraysWithSum(A, s));
		
	}
}
