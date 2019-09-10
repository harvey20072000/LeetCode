package ga.workshop.com.LeetCode.prac20181019;

import java.util.Arrays;

public class PlusOne {
	public int[] plusOne(int[] digits) {
		digits[digits.length-1] += 1;
		for(int i=digits.length-1;i>=0;i--) {
			if(digits[i] >= 10) {
				digits[i] = digits[i] % 10;
				if(i-1 < 0) {
					int[] nDigits = new int[digits.length+1];
					System.arraycopy(digits, 0, nDigits, 1, digits.length);
					digits = nDigits;
					i++;
				}
				digits[i-1] += 1;
			}
		}
		return digits;
    }
	
	
	public static void main(String[] args) {
		PlusOne m = new PlusOne();
//		System.out.println(m.plusOne(new int[] {9,8,7,6,5,4,3,2,1,0}));
		System.out.println(m.plusOne(new int[] {5,2,2,6,5,7,1,9,0,3,8,6,8,6,5,2,1,8,7,9,8,3,8,4,7,2,5,8,9}));
	}
			
}
