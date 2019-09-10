package ga.workshop.com.LeetCode.prac20181017;

import java.util.HashMap;
import java.util.Map;

public class ValidParentheses {
//	public boolean isValid(String s) {
//        Map<String, String> parentheses = new HashMap<>();
//        parentheses.put("(", ")");
//        parentheses.put("[", "]");
//        parentheses.put("{", "}");
//        
//        s = s.replace("()", "").replace("[]", "").replace("{}", "");
//        String tmp = null;
//        while(!s.isEmpty()) {
//        	if(s.length() >= 2 && parentheses.containsKey((tmp = String.valueOf(s.charAt(0))))
//        			&& String.valueOf(s.charAt(s.length()-1)).equals(parentheses.get(tmp)))
//        		s = s.substring(1, s.length()-1);
//        	else
//        		break;
//        }
//        return s.isEmpty();
//    }
	
	public boolean isValid(String s) {
		if(s == null)
			return false;
        while(!s.isEmpty()) {
        	if(s.contains("()"))
        		s = s.replace("()", "");
        	else if (s.contains("[]"))
        		s = s.replace("[]", "");
        	else if (s.contains("{}"))
        		s = s.replace("{}", "");
        	else
        		break;
        }
        return s.isEmpty();
    }
}
