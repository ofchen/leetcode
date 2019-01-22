package LeetCode.another;
import LeetCode.basic.ListNode;

public class RecursiveReverseList {
	public static ListNode recursiveReverseList(ListNode H){
		if (H == null || H.next == null)       //����Ϊ��ֱ�ӷ��أ���H.nextΪ���ǵݹ��
	        return H;
		//һֱѭ������β,��ÿ�η�תHָ��Ҫ������Ľڵ� 
		ListNode newHead = recursiveReverseList(H.next); 
		H.next.next = H;                       //��ת�����ָ��
	    H.next = null;                          //�ǵø�ֵNULL����ֹ�������
	    return newHead; 			
	}
	
	public static void main(String[] args) {
		ListNode A = new ListNode(1);
		ListNode headA = A;
		A.next = new ListNode(2);
		A = A.next;
		A.next = new ListNode(3);		
		
		ListNode C =  recursiveReverseList(headA);
		ListNode headC = C;
		while(headC != null){
			System.out.print(headC.getVal());
			headC = headC.next;
		}
 	} 

	}