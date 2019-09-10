package ga.workshop.com.LeetCode.prac20181017;

public class ReverseInteger {
	public int reverse(int x) {
        boolean isNegative = x < 0;
        StringBuilder sb = new StringBuilder(String.valueOf(x).replace("-", ""));
        int result = 0;
        try {
        	result = Integer.parseInt((sb = sb.reverse()).toString());
		} catch (Exception e) {}
        if(isNegative)
        	result *= -1;
        return result;
    }
	
	public static void main(String[] args) {
		ReverseInteger r = new ReverseInteger();
		System.out.println(r.reverse(1534236469));
//		System.out.println(r.reverse(-123));
	}
}
