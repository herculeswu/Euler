package ca.uwaterloo.comsec.leet.solutions.p5;

import ca.uwaterloo.comsec.leet.solutions.p4.ListNode;

public class Solution {

	public ListNode creat(int[] a) {
		ListNode head, tail, tmp;
		int len = a.length;
		head = new ListNode(a[0]);
		tail = head;

		for (int i = 1; i < len; i++) {
			tmp = new ListNode(a[i]);
			tail.next = tmp;
			tail = tmp;
		}

		return head;
	}

	public void print(ListNode head) {
		ListNode c = head;
		while (c != null) {
			System.out.print(c.val + "->");
			c = c.next;
		}
		System.out.println(";");
	}

	public ListNode insertionSortList(ListNode head) {

		if (head == null)
			return null;
		ListNode source = head.next, dest_head = head, current, pre, tmp;
		head.next = null;

		while (source != null) {
			current = dest_head;
			pre = dest_head;
			tmp = source.next;
			while (current != null) {
				if (current.val >= source.val) {
					if(pre == current) {
						dest_head = source;
						source.next = current;
					} else {
						pre.next = source;
						source.next = current;
					}
					break;
				}
				pre = current;
				current = current.next;
			}
			if (current == null) {
				pre.next = source;
				source.next = null;
			}
			source = tmp;
		}
		return dest_head;
	}
}
