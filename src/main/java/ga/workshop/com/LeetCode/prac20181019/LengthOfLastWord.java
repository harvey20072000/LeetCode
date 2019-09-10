package ga.workshop.com.LeetCode.prac20181019;

public class LengthOfLastWord {
	public int lengthOfLastWord(String s) {
		int count = 0;
        for(int i=s.length()-1;i>=0;i--) {
        	if(s.charAt(i) == ' ')
        		if(count > 0)
        			break;
        		else
        			continue;
        	count++;
        }
        return count;
    }
}
