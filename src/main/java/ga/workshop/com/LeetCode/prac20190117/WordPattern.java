package ga.workshop.com.LeetCode.prac20190117;

import java.util.HashSet;
import java.util.Set;

public class WordPattern {
	public boolean wordPattern(String pattern, String str) {
        Set<Character> patternSet = new HashSet<>();
        Set<String> strSet = new HashSet<>();
        Set<String> pairSet = new HashSet<>();
        String[] strArray = str.split(" ");
        if(pattern.length() != strArray.length) {
        	return false;
        }
        for(int i=0;i<pattern.length();i++) {
        	char c = pattern.charAt(i);
        	String s = strArray[i];
        	if(!patternSet.contains(c) && !strSet.contains(s)) {
        		patternSet.add(c);
        		strSet.add(s);
        		pairSet.add(String.format("%s$%s", c,s));
        	}else if(!pairSet.contains(String.format("%s$%s", c,s))){
        		return false;
        	}
        }
        return true;
    }
	
	public static void main(String[] args) {
		WordPattern wp = new WordPattern();
		System.out.println(wp.wordPattern("abba", "dog cat cat fish"));
	}
}
