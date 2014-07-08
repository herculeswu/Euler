package ca.uwaterloo.comsec.leet.solutions.p6LRU;

public class LRUCache {

	private int[] keys;
	private int[] values;
	private int capacity;
	private int size;

	public LRUCache(int capacity) {
		keys = new int[capacity];
		values = new int[capacity];

		for (int i = 0; i < capacity; i++) {
			keys[i] = -1;
			values[i] = 0;
		}

		size = 0;
		this.capacity = capacity;
	}
	
	private void reorder(int pointer) {
		int key = keys[pointer], value = values[pointer];
		for(int i = pointer; i > 0; i--) {
			keys[i] = keys[i - 1];
			values[i] = values[i - 1];
		}
		keys[0] = key;
		values[0] = value;
	}

	public int get(int key) {
		int ret = -1;
		for (int i = 0; i < size; i++) {
			if (keys[i] == key) {
				ret = values[i];
				reorder(i);
				return ret;
			}
		}
		return -1;
	}

	public int isExisted(int key) {
		for (int i = 0; i < size; i++) {
			if (keys[i] == key)
				return i;
		}
		return -1;
	}

	public void set(int key, int value) {
		int ret, pointer;
		ret = isExisted(key);
		if (ret < 0) {
			if (size == capacity) { 
				pointer = capacity - 1;
				keys[pointer] = key;
				values[pointer] = value;
				reorder(pointer);
			} else {
				keys[size] = key;
				values[size] = value;
				reorder(size);
				size++;
			}
		} else {
			values[ret] = value;
			reorder(ret);
		}
	}
	
	public static void main(String[] args) {
		LRUCache s = new LRUCache(2);
		s.set(2,1);s.set(1,1);s.set(2,3);s.set(4,1);s.get(1);s.get(2);
	}
}