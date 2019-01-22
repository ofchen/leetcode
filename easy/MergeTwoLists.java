package LeetCode.easy;

import LeetCode.basic.ListNode;
//����ϲ���������
public class MergeTwoLists {
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode a = l1;
		ListNode b = l2;
		ListNode aNext = l1;
		ListNode bNext = l2;
		
		if(a == null)
			return b;
		 if(b == null)
	        return a;
		if(a.getVal() > b.getVal())
			return mergeTwoLists(l2,l1);
		while(b != null && a != null){									
			while(a.next != null && a.next.getVal() < b.getVal()){
					a = a.next;
			}
			aNext = a.next;
			if(aNext == null){
				a.next = b;
				return l1;
			}
				
			bNext = b.next;
			b.next = a.next; 
			a.next = b;
			a = b;
			b = bNext;						
		}			
		
		return l1;
	}
	
	
	public static void main(String[] args){
//		ListNode headA = null;
		ListNode headB = null;
		ListNode A = new ListNode(1);
		ListNode headA = A;
		A.next = new ListNode(3);
		A = A.next;
		A.next = new ListNode(6);		
//		
//		ListNode B = new ListNode(2);
//		ListNode headB = B;
//		B.next = new ListNode(4);
//		B = B.next;
//		B.next = new ListNode(5);
		
		ListNode C =  mergeTwoLists(headA,headB);
		ListNode headC = C;
		while(headC != null){
			System.out.print(headC.getVal());
			headC = headC.next;
		}
	}
}
