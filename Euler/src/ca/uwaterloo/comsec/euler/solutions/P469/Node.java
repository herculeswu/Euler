package ca.uwaterloo.comsec.euler.solutions.P469;

import java.util.ArrayList;

public class Node {

	private boolean isLeaf;
	private Node m2;
	private Node m3;
	private long value;
	private long left;
	private long deepth;
	
	
	
	public long getValue() {
		return value;
	}

	public long getLeft() {
		return left;
	}

	public Node(long value, long left, long deepth) {
		this.value = value;
		this.left = left;
		this.deepth = deepth;
		m2 = null;
		m3 = null;
		isLeaf = false;
	}
	
	public void buildTree() {
		if(left <= 1) {
			isLeaf = true;
			return;
		}else if(left == 2) {
			m3 = new Node(0, -1, deepth + 1);
			m2 = new Node(2, 0, deepth + 1);
		} else if(left == 3){
			m3 = new Node(1, 0, deepth + 1);
			m2 = new Node(2, 1, deepth + 1);
		} else {
			m3 = new Node(left - 2, left - 3, deepth + 1);
			m2 = new Node(2, left - 2, deepth + 1);
		}
		m3.buildTree();
		m2.buildTree();
	}
	
	public void E(long value, ArrayList<long[]> table) {
		long pro = this.value * value;
		long[] item = new long[2];
		if(isLeaf) {
			item[0] = pro;
			item[1] = left + deepth + 1;
			table.add(item.clone());
			return;
		}
		if(m3 != null)
			m3.E(pro, table);
		if(m2 != null)
			m2.E(pro, table);
	}
	
	public void printTree() {
		System.out.println("(" + value +"," + left + ")");
		if(m3 != null)
			m3.printTree();
		if(m2 != null)
			m2.printTree();
		
	}
	
	public static double Exp(long t, ArrayList<long[]> table) {
		long total = 0;
		double ret = 0;
		for(long[] item : table) {
			total += item[0];
		}
		for(long[] item : table) {
			ret += (double)(t - item[1])/t * item[0] / total;
		}
		return ret;
	}
	
	public static void main(String[] args) {
		final long max = 1000000000000000000l;
		long value = max, left = value - 3;
		double e;
		ArrayList<long[]> table = new ArrayList<long[]>();
		Node root = new Node(value, left, 0);
		root.buildTree();
		root.E(1, table);
		
		e = Exp(value, table);
		System.out.println(e);
	}
}
