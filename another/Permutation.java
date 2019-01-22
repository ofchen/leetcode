package LeetCode.another;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
	static void permutation(int[] chs,int start){
		if(start==chs.length-1)
        {
			System.out.println("res="+Arrays.toString(chs));
            //����Ѿ�������������һ��Ԫ�أ�ǰ���Ԫ���Ѿ��źã������
        }
        for(int i=start;i<=chs.length-1;i++)
        {
        //�ѵ�һ��Ԫ�طֱ�������Ԫ�ؽ��н������ݹ�ĵ������������������
                Swap(chs,i,start);
                //System.out.println("before="+Arrays.toString(chs)+",i="+i+",st="+start);
                permutation(chs,start+1);                
                Swap(chs,i,start);
                //System.out.println("after="+Arrays.toString(chs)+",i="+i+",st="+start);
        //���������򷵻غ�Ҫ����һ��Ԫ�ؽ���������  
        //����������������������˵��һ��1��2��������һ��λ��Ϊ2�����������򷵻غ��������1��2
        //���������ڶ��ν�����ʱ��ͻὫ2��3��������˱��뽫1��2����ʹ1�����ڵ�һ��λ�� 
        }
	}
	
	static void permutation2(int[] chs){
		Arrays.sort(chs);
        //�ȶ������Ԫ�ؽ�����������
        while(true)
        {
            System.out.println(Arrays.toString(chs));
            int j=chs.length-1;
            int index=0;
            for(j=chs.length-2;j>=0;j--)
            {
                if(chs[j]<chs[j+1])
                {
                    index=j;
                    break;
                    //���������ҵ���һ���ǵ�����Ԫ��
                }
                else if(j==0){
                    return;
                }
            }           

            for(j=chs.length-1;j>=0;j--)
            {
                if(chs[j]>chs[index])
                    break;
                    //���������ҵ���һ���ȷǵ���Ԫ�ش��Ԫ��
            }
                Swap(chs,index,j);
                //�����ҵ�������Ԫ��
                Reverse(chs,index+1);
                //�Էǵ���Ԫ��λ�ú�������������������
        }       
    }
    public static void Reverse(int chs[],int i)
    {
        int k=i,j=chs.length-1;
        while(k<j)
        {
            Swap(chs,k,j);
            k++;
            j--;
        }
    }

    public static void Swap(int chs[],int i,int j)
    {
        int temp;
        temp=chs[i];
        chs[i]=chs[j];
        chs[j]=temp;
    }
    
    public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		//permutation2(nums);
		//List<String> list = new ArrayList<>();
		permutation(nums, 0);
	}
}
