package ca.uwaterloo.comsec.leet.solutions.p10LinkedListCycle;

import ca.uwaterloo.comsec.leet.solutions.p4.ListNode;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode p0, p1, p2, tmp;
		boolean isCycle = false;
		p0 = head;
		p1 = head;
		p2 = head;
		
		while(p1 != null && p2 != null) {
			
			p1 = p1.next;
			tmp = p2.next;
			if(tmp == null)
				break;
			p2 = tmp.next;
		}
		
		return null;
    }
}
