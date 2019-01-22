package LeetCode.medium;

import LeetCode.basic.ListNode;

/*You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Example
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807. 				problem2
*/
public class AddTwoNumber {

	public static ListNode addTwoNumber(ListNode A, ListNode B){
		ListNode res = new ListNode(0);
		ListNode temp = res;//����ɾ��ͷ���
		ListNode c = A;
		ListNode d = B;
		int val = 0;
		int carry = 0;
		
		while(c != null && d != null){
			val = (c.getVal() + d.getVal()+ carry ) % 10 ;			
			carry = (c.getVal() + d.getVal() + carry) / 10; //��λ�������
			res.next = new ListNode(val);
			res = res.next;
			c = c.next;
			d = d.next;
		}
			
		while(c != null){
			val = (c.getVal()+ carry) % 10;
			carry = (c.getVal() + carry) / 10;
			res.next = new ListNode(val);
			res = res.next;
			c = c.next;
		}
		
		while(d != null){
			val = (d.getVal()+ carry) % 10;
			carry = (d.getVal() + carry) / 10; 
			res.next = new ListNode(val);
			res = res.next;
			d = d.next;
		}
		
		if(carry != 0){
			res.next = new ListNode(carry);
		}
		
		return temp.next;
		
	}
	
	public static void main(String[] args){
		ListNode A = new ListNode(2);
		ListNode headA = A;
		A.next = new ListNode(4);
		A = A.next;
		A.next = new ListNode(3);
		
		ListNode B = new ListNode(5);
		ListNode headB = B;
		B.next = new ListNode(6);
		B = B.next;
		B.next = new ListNode(4);
		
		ListNode C =  addTwoNumber(headA,headB);
		ListNode headC = C;
		while(headC != null){
			System.out.print(headC.getVal());
			headC = headC.next;
		}
	}
}
