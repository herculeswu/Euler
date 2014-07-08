package ca.uwaterloo.comsec.leet.solutions.p4;

public class Solution {

	public ListNode creat(int[] a) {
		ListNode head, tail, tmp;
		int len = a.length;
		head = new ListNode(a[0]);
		tail = head;
		
		for(int i = 1; i < len; i++) {
			tmp = new ListNode(a[i]);
			tail.next = tmp;
			tail = tmp;
		}
		
		return head;
	}

	public void print(ListNode head) {
		ListNode c = head;
		while(c != null) {
			System.out.print(c.val + "->");
			c = c.next;
		}
		System.out.println(";");
	}

    public ListNode sortList(ListNode head) {
		if(head == null)
			return null;
		if(head.next == null)
			return head;
			
        ListNode tmp, phead = head, ptail = head, shead = null, stail = null, ghead = null, gtail = null, c = head.next;
		
		while(c != null) {
			tmp = c.next;
			if(c.val < head.val) {
				if(shead == null) {
					c.next = null;
					shead = c;
					stail = c;
				} else {
					c.next = null;
					stail.next = c;
					stail = c;
				}
			} else if(c.val == head.val) {
				c.next = null;
				ptail.next = c;
				ptail = c;
			} else if(c.val > head.val) {
				if(ghead == null) {
					c.next = null;
					ghead = c;
					gtail = c;
				} else {
					c.next = null;
					gtail.next = c;
					gtail = c;
				}
			}
			c = tmp;
		}
		shead = sortList(shead);
		ghead = sortList(ghead);
		if(shead != null) {
			c = shead;
			while(c.next != null)
				c = c.next;
			c.next = phead;
		} else
			shead = phead;
		ptail.next = ghead;
		return shead;
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	int[] a = {1, 5, 8, 0, 1, 2, 9, 0};
    	ListNode head = s.creat(a);
    	s.print(head);
    	head = s.sortList(head);
    	s.print(head);
    }
}
