package ca.uwaterloo.comsec.leet.solutions.p10LinkedListCycle;

import ca.uwaterloo.comsec.leet.solutions.p4.ListNode;

public class Solution {
	
	public ListNode creatList(int[] values) {
		ListNode tmp, head, current, cycle = null;
		int len;
		
		if(values == null)
			return null;
		
		len = values.length;
		if(len == 0)
			return null;
		
		head = new ListNode(Math.abs(values[0]));
		if(values[0] < 0)
			cycle = head;
		current = head;
		
		for(int i = 1; i < len; i++) {
			tmp = new ListNode(Math.abs(values[i]));
			current.next = tmp;
			current = tmp;
			if(values[i] < 0)
				cycle = tmp;
		}
		
		current.next = cycle;
		
		return head;
	}
	
    public ListNode detectCycle(ListNode head) {
        ListNode p0, p1, p2, tmp;
        boolean isHead = false;
		p0 = head;
		p1 = head;
		p2 = head;
		
		while(p1 != null && p2 != null) {
			if(p1 == p2) {
				if(p1 != head) {
					while(p0 != p1) {
						p0 = p0.next;
						p1 = p1.next;
					}
					return p0;
				} else {
					if(!isHead)
						isHead = true;
					else
						return head;
				}
			}
			p1 = p1.next;
			tmp = p2.next;
			if(tmp == null)
				break;
			p2 = tmp.next;
		}
		
		return null;
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	ListNode head, ret;
    	int[] list = {-4, 2, 3};
    	
    	head = s.creatList(list);
    	
    	ret = s.detectCycle(head);
    	if(ret != null)
    		System.out.println(ret.val);
    	else
    		System.out.println("No cycle");
    }
}
