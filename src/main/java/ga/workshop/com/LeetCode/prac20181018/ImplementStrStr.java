package ga.workshop.com.LeetCode.prac20181018;

public class ImplementStrStr {
	public int strStr(String haystack, String needle) {
        if(needle.isEmpty())
        	return 0;
        char[] haystackA = haystack.toCharArray(),needleA = needle.toCharArray();
        boolean match = true;
        for(int i=0;i<haystackA.length-needleA.length+1;i++) {
        	match = true;
        	for(int j=0;j<needleA.length;j++)
        		if(needleA[j] != haystackA[i+j]) {
        			match = false;
        			break;
        		}
        	if(match)
        		return i;
        }
        return -1;
    }
}
