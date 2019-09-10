package ga.workshop.com.LeetCode.prac20181017;

public class PalindromeNumber {
	public boolean isPalindrome(int x) {
        StringBuilder sb = new StringBuilder(String.valueOf(x));
        try {
        	return (sb = sb.reverse()).toString().equals(String.valueOf(x));
		} catch (Exception e) {}
        return false;
    }
}
