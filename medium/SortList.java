package LeetCode.medium;

import LeetCode.basic.ListNode;
//O(nlogn)ʱ�临�Ӷȣ�O(1)�ռ临�Ӷ�
public class SortList {
	
	private static ListNode merge(ListNode h1, ListNode h2){
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		
		while(h1 != null && h2 !=null){
			if(h1.getVal() > h2.getVal()){
				tail.next = h2;
				h2= h2.next ;
			}
			else{
				tail.next = h1;
				h1= h1.next ;
			}
			tail = tail.next;
		}
		if(h1 != null)
			tail.next = h1;
		else
			tail.next = h2;			
		
		return dummy.next;
	}
	
	public static ListNode sortList(ListNode head){
		if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head, pre = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        return merge(sortList(head), sortList(slow));
	}
	
	public static void main(String[] args){
		ListNode A = new ListNode(1);		
		ListNode head = A;
		A.next = new ListNode(3);
		A = A.next;
		A.next = new ListNode(5);		
		A = A.next;
		A.next = new ListNode(2);
		A = A.next;
		A.next = new ListNode(4);
		
		ListNode C =  sortList(head);
		ListNode headC = C;
		while(headC != null){
			System.out.print(headC.getVal()+" ");
			headC = headC.next;
		}
	}
}
