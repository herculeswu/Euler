package ca.uwaterloo.comsec.leet.solutions.p2;

public class Solution {

    public int parse(String str) {
		if(str.equals("+"))
			return 0;
		else if(str.equals("-"))
			return 1;
		else if(str.equals("*"))
			return 2;
		else if(str.equals("/"))
			return 3;
		else
			return 4;
    }
	
	public int evaluate(int[] stack, int pointer, int operator) {
		int len = stack.length, tmp;
		
		if(len < 2 || pointer < 2)
			return -1;
		
		switch(operator) {
		case 0:
			tmp = stack[pointer - 2] + stack[pointer - 1];
			break;
		case 1:
			tmp = stack[pointer - 2] - stack[pointer - 1];
			break;
		case 2:
			tmp = stack[pointer - 2] * stack[pointer - 1];
			break;
		case 3:
			tmp = stack[pointer - 2] / stack[pointer - 1];
			break;
		default:
			return -1;
		}
		stack[pointer - 2] = tmp;
		return pointer - 1;
	}

    public int evalRPN(String[] tokens) {
        int[] stack = new int[128];
		int pointer = 0, ret, len = tokens.length;
		
		stack[0] = 0;
		
		for(int i = 0; i < len; i++) {
			ret = parse(tokens[i]);
			switch(ret) {
			case 0:
			case 1:
			case 2:
			case 3:
				pointer = evaluate(stack, pointer, ret);
				if(pointer == -1) {
					System.out.println("Incorrect format!");
					return -1;
				}
				break;
			case 4:
				stack[pointer] = Integer.parseInt(tokens[i]);
				pointer++;
				break;
			}
		}
		if(pointer != 1) {
			System.out.println("Incorrect format!");
			return -1;
		} else
			return stack[0];
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	String[] tokens = {"4", "13", "5", "/", "+"};
    	int ret = s.evalRPN(tokens);
    	System.out.println(ret);
    }
}
