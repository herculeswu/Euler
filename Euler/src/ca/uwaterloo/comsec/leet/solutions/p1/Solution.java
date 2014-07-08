package ca.uwaterloo.comsec.leet.solutions.p1;

public class Solution {
	
	public boolean isWhite(char c) {
		if(c == ' ')
			return true;
		return false;
	}
	
	public String reverseWords(String s) {
		String[] strs = new String[1024];
		StringBuilder sb = new StringBuilder();
		int len = s.length(), index = 0;
		
		for(int i = 0; i < len; i++) {
			if(isWhite(s.charAt(i))) {
				if(sb.length() != 0) {
					strs[index] = sb.toString();
					index++;
					sb = new StringBuilder();
				}
			} else
				sb.append(s.charAt(i));
		}
		if(sb.length() != 0)
			strs[index] = sb.toString();
		else
			index--;
		
		sb = new StringBuilder();
		
		if(index >= 0)
			sb.append(strs[index]);
		for(int i = index - 1; i >= 0; i--)
			sb.append(" " + strs[i]);
		
		return sb.toString();
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		String tmp = s.reverseWords("  the sky   is   blue  ");
		System.out.println(tmp);
	}

}
