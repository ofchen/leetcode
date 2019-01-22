package LeetCode.medium;

import LeetCode.basic.ListNode;

public class AddTwoNumbers2 {
	public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int len1 = 0; 
        int len2 = 0;
        ListNode h1 = l1;
        ListNode h2 = l2;        
        
        for(; h1!=null; len1++, h1=h1.next);                       
        for(; h2!=null; len2++, h2=h2.next);        
        if(len1 < len2)
            return addTwoNumbers2(l2,l1);
        
        int[] res = new int[len1+1];
        h1 = l1;
        for(int i = 1; i <= len1; i++, h1 = h1.next)
            res[i] = h1.getVal();
        h2 = l2;    
        for(int i = len1-len2+1; i <= len1; i++,h2 = h2.next)           
            res[i] += h2.getVal();                        
    
        for(int i = len1; i >= 1; i --)
            if(res[i] >= 10){
                 res[i] -= 10;
                res[i-1] += 1;
            }
        
        ListNode newh = new ListNode(0);
        ListNode p = newh;
        for(int i = 1; i <= len1; i ++){
            p.next = new ListNode(res[i]);
            p = p.next;
        } 
        if(res[0] == 1){
            p = new ListNode(1);
            p.next = newh.next;
            newh.next = p;
        }
        return newh.next;
    }
	public static void main(String[] args) {
		ListNode A = new ListNode(9);
		ListNode headA = A;
		A.next = new ListNode(9);
		A = A.next;
		A.next = new ListNode(9);
		A = A.next;
		A.next = new ListNode(9);
		
		ListNode B = new ListNode(5);
		ListNode headB = B;
		//B.next = new ListNode(6);
		//B = B.next;
		//B.next = new ListNode(4);
		
		ListNode C =  addTwoNumbers2(headA,headB);
		ListNode headC = C;
		while(headC != null){
			System.out.print(headC.getVal());
			headC = headC.next;
		}
	}

	}
