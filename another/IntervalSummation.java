package LeetCode.another;

public class IntervalSummation {
//�ҵ������в��������ֵ�����
	/*
	public static int intervalSummation(int[]arr, int index, int sum){
		System.out.println("index= "+ index + " Sum = " + sum);
		if(index == 1)
			return sum + (arr[0] >= arr[1] ? arr[0] : arr[1]);
		else if(index == 0)
			return sum + arr[0];
		else{
			System.out.println("\t A ~~~~~~~~~");
			int A = intervalSummation(arr, index-2, sum+arr[index]);//ѡ��arr[index]
			System.out.println("\t B ~~~~~~~~~");
			int B = intervalSummation(arr, index-1, sum);//��ѡarr[index]
					
			int pr = (A >= B ? A : B);
			System.out.println("result A B ="+ pr);
			return pr;
		}
	}
*/
	//�ݹ鷽ʽ
	public static int intervalSummation(int[]arr, int index){
		if(index == 1)
			return (arr[0] >= arr[1] ? arr[0] : arr[1]);
		else if(index == 0)
			return arr[0];
		else{
			System.out.println("\t A ~~~~~~~~~");
			int A = intervalSummation(arr, index-2)+arr[index];//ѡ��arr[index]
			System.out.println("\t B ~~~~~~~~~");
			int B = intervalSummation(arr, index-1);//��ѡarr[index]
					
			int pr = (A >= B ? A : B);
			System.out.println("result A B ="+ pr);
			return pr;
		}
	}
	
	//�ǵݹ鷽ʽ
	public static int intervalSummationArray(int[]arr){
		int len = arr.length;
		int[] res = new int[len]; 
		res[0] = arr[0];
		res[1] = arr[0] >= arr[1] ? arr[0] : arr[1];
		for (int i = 2; i <= len-1; i ++){
			int update = res[i-2] + arr[i];
			res[i] = (res[i-1] >= update ? res[i-1] : update);
		}
		
		return res[len-1];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {4, 1, 1, 9, 1};//{1, 2, 4, 1, 7, 8, 3};
		//long startTime = System.currentTimeMillis();
		//int result = intervalSummation(nums, nums.length-1, 0);
		//int result = intervalSummation(nums, nums.length-1);
		//long endTime = System.currentTimeMillis();
		
		System.out.println("result="+ intervalSummationArray(nums));
	}

}
