package LeetCode.medium;

import LeetCode.basic.ListNode;

public class RemoveNthFromEnd {
	public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        if(p == null || n == 0)
            return p;
        int len = 0;
        while(p != null){
            p = p.next;
            len ++;
        }
        if(n > len)
            return head;
        else if(n == len)
            return head.next;
        
        p = head;
        int i = 1;
        while(i < len-n){
            p = p.next;
            ++ i;
        }
        p.next=p.next.next;
        return head;
    }
	
	public static void main(String[] args){
		ListNode head = null;
/*		ListNode A = new ListNode(1);
		ListNode head = A;
		A.next = new ListNode(2);
		A = A.next;
		A.next = new ListNode(3);		
		A = A.next;
		A.next = new ListNode(4);
		A = A.next;
		A.next = new ListNode(5);
*/		
		ListNode C =  removeNthFromEnd(head,2);
		ListNode headC = C;
		while(headC != null){
			System.out.print(headC.getVal());
			headC = headC.next;
		}
	}
}
