package LeetCode.another;

public class LCS {
	
	//longest common subsequence
	public static char[] lcs(String str1, String str2){
		int len1 = str1.length();
		int len2 = str2.length();
		char[] res = new char[Math.min(len1, len2)]; 
		int [][]F = new int[len1+1][len2+1]; 		
		int i = 0, j = 0, reslen = 0;
		
		for(j = 1; j < len1+1; j ++){//��
			F[j][1] = F[j-1][len2];
			for(i = 1; i < len2+1; i ++){//��
				if(str1.charAt(j-1) == str2.charAt(i-1))
					F[j][i] = F[j][i-1] + 1;
				else F[j][i] = Math.max(F[j][i-1], F[j-1][i]);
			}
		}
		
		reslen = F[len1][len2]; //����������еĳ���
		int k = 0, temp = reslen;
		
		//���ݲ��������������
		i = len1;
		j = len2;
		while(i > 0 && j > 0){		
			if(F[i-1][j] == F[i][j-1] && F[i-1][j] != temp){
				res[k] = str2.charAt(j-1);				
				//System.out.print(res[k]+" ");
				k ++;
				i --;
				j --;
				temp = F[i][j];				
			}
			else if(F[i-1][j] != F[i][j-1] && temp == F[i-1][j]){
				i --;
			}
			else if(F[i-1][j] != F[i][j-1] && temp == F[i][j-1]){//
				j --;	
			}
			else
				j --;
		}
		
		//System.out.println("len="+reslen+" ,k="+k);
		for(i = 0; i < reslen/2; i ++){
			char t = res[reslen-1-i];
			res[reslen-1-i] = res[i];
			res[i] = t;
		}
		return res;		
	}
	
	public static void main(String[] args) {
		String str1= "abcdefg";
		String str2= "agk";
		
		System.out.println(lcs(str2,str1));

	}
}
