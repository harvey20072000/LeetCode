package ga.workshop.com.LeetCode.prac20190119;

public class ValidPerfectSquare {
	public boolean isPerfectSquare(int num) {
		int up = num/2,down = 0,avg = up,lastAvg = -1,avgCross = 0;
		if(num == 1 || num == up*up)
			return true;
		boolean result = true;
		while(avg != lastAvg) {
			lastAvg = avg;
			avg = (up+down)/2;
			if(avg > 46340) {
				avg = 46340;
			}
			if(result = (avgCross = avg*avg) == num) {
				break;
			}else if(avgCross > num) {
				up = avg;
			}else if(avgCross < num) {
				down = avg;
			}
		}
        return result;
    }
	
	public static void main(String[] args) {
		ValidPerfectSquare t = new ValidPerfectSquare();
		System.out.println(t.isPerfectSquare(2147483647));
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Math.sqrt(Integer.MAX_VALUE));
	}
}
