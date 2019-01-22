package LeetCode.medium;

//Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
public class NextPermutation {
//���������������һ������˳������Ŀ�и������ӿ��Կ�������������������ǽ���
//��˵����ȫ���е����һ�����������һ�����о������ʼ���
/*�����µ�һ������
1����2����7����4����3����1
��һ������Ϊ��
1����3����1����2����4����7
��ô����εõ����أ�����ͨ���۲�ԭ������Է��֣������ĩβ��ǰ����
�����𽥱�󣬵���2ʱ�ż�С�ģ�Ȼ�������ٴӺ���ǰ�ҵ�һ����2������֣�
��3����ô���ǽ���2��3���ٰѴ�ʱ3�������������ת��һ�¼��ɣ��������£�
1����2����7����4����3����1
1����2����7����4����3����1
1����3����7����4����2����1
1����3����1����2����4����7
 * */	
	public static void nextPermutation(int[] nums) {
	    int n = nums.length;
	    int i = n - 2;
	    int j = n - 1;
	    
	    //�Ӻ���ǰ�ҵ���һ���ǽ������
	    while(i >= 0 && nums[i] >= nums[i+1]) --i;
	    if(i >= 0){
	    	//�Ӻ���ǰ�ҵ���һ������nums[i]����
	    	while(nums[j] <= nums[i]) --j;
	    	
	    	//����nums[i], nums[j]
	    	int temp = nums[j];
	    	nums[j] = nums[i];
	    	nums[i] = temp;
	    }
	    //��תnums[i]���������
	    reverse(nums, i+1, nums.length-1);
	}
	
	public static void reverse(int[] nums, int start, int end) {
		for(int i = start, j = end; i <= j; i ++, j --){
			int temp = nums[j];
	    	nums[j] = nums[i];
	    	nums[i] = temp;
		}		
	}
	
	public static void main(String[] args) {
		int[] nums = {3,2,1};
		nextPermutation(nums);
	}
	
}
