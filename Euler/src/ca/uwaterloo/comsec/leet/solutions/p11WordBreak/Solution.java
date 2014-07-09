package ca.uwaterloo.comsec.leet.solutions.p11WordBreak;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Solution {

	public HashSet<String> createDict(String[] words) {
		HashSet<String> ret = new HashSet<String>();

		for (String word : words)
			ret.add(word);

		return ret;
	}

	public List<String> wordBreak(String s, Set<String> dict) {
		ArrayList<String> ret = new ArrayList<String>(), tmp;
		StringBuilder sb = new StringBuilder();
		String sub, word;
		HashSet<Character> characters = new HashSet<Character>();
		Iterator<String> it = dict.iterator();
		int len = s.length();
		
		if(dict.size() == 0)
            return ret;
		
		if (len == 0) {
			ret.add("");
			return ret;
		}

		while(it.hasNext()) {
			word = it.next();
			int lent = word.length();
			for(int i = 0; i < lent; i++)
				characters.add(word.charAt(i));
		}
		
		for (int i = 0; i < len; i++)
			if(!characters.contains(s.charAt(i)))
				return ret;
			
		
		for (int i = 0; i < len; i++) {
			sb.append(s.charAt(i));
			word = sb.toString();
			if (dict.contains(word)) {
				sub = s.substring(i + 1);
				tmp = (ArrayList<String>) wordBreak(sub, dict);
				if (tmp.size() == 0)
					continue;
				for (String str : tmp) {
					if(!str.equals(""))
						ret.add(word + " " + str);
					else
						ret.add(word);
				}
			}
		}

		return ret;
	}

	public String testStr(int index) {
		switch (index) {
		case 0:
			return "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		case 1:
			return "catsanddog";
		case 2:
			return "aaaaaab";
		default:
			return "";
		}
	}

	public HashSet<String> testDict(int index) {
		String[] words0 = { "a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa",
				"aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa" };
		String[] words1 = { "cat", "cats", "and", "sand", "dog" };
		switch (index) {
		case 0:
		case 2:
			return createDict(words0);
		case 1:
			return createDict(words1);
		default:
			return null;
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int index = 0;
		ArrayList<String> se = (ArrayList<String>) s.wordBreak(
				s.testStr(index), s.testDict(index));

		if (se == null)
			System.out.println("No result");
		else
			for (String sec : se)
				System.out.println(sec);
	}
}