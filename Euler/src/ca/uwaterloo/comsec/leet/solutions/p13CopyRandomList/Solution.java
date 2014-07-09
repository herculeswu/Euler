package ca.uwaterloo.comsec.leet.solutions.p13CopyRandomList;

import java.util.ArrayList;

public class Solution {
	
	public int getLen(RandomListNode head) {
		RandomListNode c = head;
		int len = 0;
		while(c != null) {
			len++;
			c = c.next;
		}
		return len;
	}
	
    public RandomListNode copyRandomList(RandomListNode head) {
        ArrayList<ArrayList<RandomListNode>> dict = new ArrayList<ArrayList<RandomListNode>>();
		RandomListNode c = head, tmp, rhead, rc;
		ArrayList<RandomListNode> queue;
		
		rhead = new RandomListNode(0);
		rc = rhead;
		
		while(c != null) {
			queue = null;
			tmp = new RandomListNode(c.label);
			rc.next = tmp;
			for(ArrayList<RandomListNode> list : dict)
				if(list.get(0) == c)
					queue = list;
			if(queue == null) {
				queue = new ArrayList<RandomListNode>();
				queue.add(c);
				queue.add(tmp);
				dict.add(queue);
			} else {
				if(queue.get(1) == null) {
					queue.remove(1);
					queue.add(1, tmp);
				}
			}
			
			for(ArrayList<RandomListNode> list : dict) {
				if(list.get(0) == c.random)
					list.add(tmp);
				else {
					queue = new ArrayList<RandomListNode>();
					queue.add(c.random);
					queue.add(null);
					dict.add(queue);
				}
			}
			c = c.next;
			rc = tmp;
		}
    }
}
