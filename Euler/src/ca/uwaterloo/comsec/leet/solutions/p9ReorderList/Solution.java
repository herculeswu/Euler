package ca.uwaterloo.comsec.leet.solutions.p9ReorderList;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
import ca.uwaterloo.comsec.leet.solutions.p4.*;

public class Solution {

	public ListNode reorder(ListNode head, ListNode start) {
		ListNode pre, current;
		if(head == null || head.next == null)
			return null;
		if(start == null)
			return null;
		current = start;
		pre = null;	
		while(current.next != null) {
			pre = current;
			current = current.next;
		}
		if(pre == null) {
			current.next = head.next;
			head.next = current;
			return null;
		} else {
			pre.next = null;
			current.next = head.next;
			head.next = current;
			return current.next;
		}
	}

    public void reorderList(ListNode head) {
        ListNode pointer = head, start = head, h4 = null, h5 = null, h6 = null, h7 = null;
		int n = 0, n1, n2, n3, n4, n5, n6, n7;
		while(pointer != null) {
			n++;
			pointer = pointer.next;
		}
		n1 = n / 8;
		n2 = 2 * n1;
		n3 = 3* n1;
		n4 = 4* n1;
		n5 = 5* n1;
		n6 = 6* n1;
		n7 = 7* n1;
		
		n = 0;
		pointer = head;
		while(pointer != null) {
			n++;
			if(n == n4)
				h4 = pointer;
			else if(n == n5)
				h5 = pointer;
			else if(n == n6)
				h6 = pointer;
			else if(n == n7) {
				h7 = pointer;
				break;
			}
			pointer = pointer.next;
		}
		
		n = 0;
		pointer = head;
		while(pointer != null) {
			n++;
			if(n < n1)
				start = h7;
			else if(n >= n1 && n < n2)
				start = h6;
			else if(n >= n2 && n < n3)
				start = h5;
			else if(n >= n3 && n < n4)
				start = h4;
			pointer = reorder(pointer, start);
		}
    }
}