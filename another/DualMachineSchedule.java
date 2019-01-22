package LeetCode.another;

public class DualMachineSchedule {	
	//˫�������������⣬�ҵ�������������ʱ��Ҫ�������ظ��Ҹ������������ص�
	//��������ʱ�估�����������ĸ��������
	public static void dualMachineSchedule(int[] MA, int[] MB){	
		int lenA = MA.length;		
		int[] leastTime	= new int[lenA];		
		int sumA = MA[0];
		for (int i = 1; i < lenA; i ++)
			sumA += MA[i];
		int F[][] = new int[lenA][sumA+1];
		
		//k = 1
		leastTime[0] = Math.min(MA[0] , MB[0]);
		for (int i = 0; i < MA[0]; i ++) //F����ֵӦ��ʼ��Ϊ0�����������
			F[0][i] = MB[0];
		
		//k >= 2
		sumA = MA[0];
		for (int k = 1; k < lenA; k ++){
			sumA += MA[k];
			leastTime[k] = Integer.MAX_VALUE;
			int j = 0;
			for ( ; j <= sumA; j ++){
				if (j < MA[k]){ // Aִ���굱ǰ����֮ǰB�Ѿ����У�����һ������Bִ��
					F[k][j] = F[k-1][j] + MB[k];
					//System.out.println("j= "+ j + ",B "+F[k][j]);
				}
				else{
					int BDid = F[k-1][j] + MB[k]; //k������B���
					int BDidnot = F[k-1][j-MA[k]]; //k������A���
					F[k][j] = Math.min(BDid , BDidnot);
					//System.out.println("j= "+ j +" ,A or B "+BDid +" "+ BDidnot+ " "+ F[k][j]);
				}
				leastTime[k] = Math.min(leastTime[k], Math.max(F[k][j], j)); //A��B�������������Ҫ���ʱ����֮ǰ��õ����ʱ��Ƚϣ���С������ʱ��
			}
			
			for (j = 0; Math.max(j, F[k][j]) != leastTime[k]; j++);//���ݣ����Ҷ�Ӧ�������Ļ���
			int tempK = k, tempJ = j;
			char M[] = new char[tempK+1];
			while(tempK > 0){
				if(F[tempK][tempJ] == F[tempK-1][tempJ] + MB[tempK]){
					M[tempK] = 'B';
					tempK --;
				}
				else if(F[tempK][tempJ] == F[tempK-1][tempJ - MA[tempK]]){
					M[tempK] = 'A';
					tempJ -= MA[tempK];
					tempK --;
				}
			}
			if(F[tempK][tempJ] == 0){
				M[0] = 'A';
			}
			else
				M[0] = 'B';
			for (j = 0; j <= k; j ++)
				System.out.print(M[j]+" ");
			System.out.println("k= "+(k+1)+" "+leastTime[k]);
		}
		
	}	
	
	public static void main(String[] args) {
		int[] MA ={2, 5, 7, 10, 5, 2};
		int[] MB ={3, 8, 4, 11, 3, 4};

		dualMachineSchedule(MA,MB);
		
	}

}
