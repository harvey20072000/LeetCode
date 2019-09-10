package ga.workshop.com.LeetCode.prac20181017;

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if(strs == null || strs.length == 0)
			return "";
		if(strs.length == 1)
			return strs[0];
		String matcher = strs[0];
		char[] matcherArray = matcher.toCharArray();
		StringBuilder sb = new StringBuilder("");
		boolean isCommon = true;
		for(int i=0;i<matcherArray.length;i++) {
			for(String str:strs) {
				if(str.length()-1 < i || str.charAt(i) != matcherArray[i]) {
					isCommon = false;
					break;
				}
			}
			if(isCommon)
				sb.append(matcherArray[i]);
			else
				break;
		}
		return sb.toString();
    }
}
