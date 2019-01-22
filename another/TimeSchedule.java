package LeetCode.another;

//�������̵��ȣ���ͬ���̼䲻���ݣ���̬�滮��ͼ��Visio-���� ���ѵ��ڱ�������indexֵ���ݹ����
public class TimeSchedule {
	public static int tSchedule(int[] endTime, int[] dur, int[] values, int index, int ltindex,int price){
		System.out.println("func index="+ index +" ltindex="+ ltindex + " value= "+ price);
		if(index == -1){
			System.out.println("result -1 = "+ price);
			return price;
		}
		else if (endTime[index]-dur[index] == 0)
			return price+values[index];
		else if(index == 0)
			return price+values[0];		
		else{
			int ed = endTime[index]-dur[index];
			int index1 = -1;
			for (int j = 0; j < endTime.length; j++){
				if (endTime[j] == ed)
					index1 = j;
			}
			System.out.println("\t A ~~~~~~~~~");
			int A = tSchedule(endTime, dur, values, index1, index, price+values[index]);//ѡ���±�Ϊindex������
			System.out.println("\t B~~~~~~~~~~");
			int B = tSchedule(endTime, dur, values, index-1, ltindex, price);//��ѡ�±�Ϊindex������
			int pr = (A >= B ? A : B);
			System.out.println("result A B ="+ pr);
			return pr;
			
		}
	}
	
	
	public static void main(String args[]){
		int[] endTime = {4, 5, 6, 7, 8, 9, 10, 11, 12};
		int[] dur = {3, 2, 6, 3, 5, 4, 4, 3, 5};
		int[] values = {5, 1, 8, 4, 6, 3, 2, 4, 5};
		//long startTime = System.currentTimeMillis();
		int pr = tSchedule(endTime, dur, values, endTime.length-1, endTime.length-1, 0);
		System.out.println("result="+ pr);
		//long endTime = System.currentTimeMillis();
		
		//System.out.println("result="+ result[0]+" "+result[1]);
		//System.out.println("��������ʱ�䣺" + (endTime - startTime) + "ms");//��������ʱ��϶̣�<1ms
	}
}
