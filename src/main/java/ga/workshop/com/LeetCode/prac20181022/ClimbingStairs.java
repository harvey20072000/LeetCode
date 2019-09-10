package ga.workshop.com.LeetCode.prac20181022;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class ClimbingStairs {
	public int climbStairs(int n) {
		// x+2y=n，再把每組答案做排列組合相加
		List<Integer[]> solutions = new ArrayList<>();
		for(int i=0;i<=n/2;i++)
			solutions.add(new Integer[] {n-2*i,i});
		int result = 0,tmp,up,down;
		for(Integer[] solution : solutions) {
			if((solution[0] == 0 && solution[1] != 0) || (solution[1] == 0 && solution[0] != 0)) {
				result++;
				continue;
			}else if(solution[0] >= solution[1]) {
				up = solution[0]+solution[1];
				down = solution[1];
			}else {
				up = solution[1]+solution[0];
				down = solution[0];
			}
			result += operatorC(up, down);
		}
		return result;
    }
	
	private int operatorC(int up,int down) {
		return calStairs(up,down).divide(calStairs(down,-1)).intValue();
	}
	
	private BigInteger calStairs(int n,int m) {
		BigInteger result = new BigInteger("1");
		if(m < 0)
			m = n;
		for(int i=n,j=1;i>=0 && j<=m;i--,j++)
			result = result.multiply(new BigInteger(String.valueOf(i)));
		return result;
	}
	
//	static int count = 0;
//	public int climbStairs(int n) {
//		count = 0;
//		climb(n);
//		return count;
//    }
//	
//	private boolean climb(int n) {
//		if(n < 0)
//			return false;
//		if(n == 0) {
//			count++;
//			return true;
//		}
//		return climb(n-1)|climb(n-2);
//	}
	
	
	public static void main(String[] args) {
		ClimbingStairs a = new ClimbingStairs();
//		System.out.println(a.climbStairs(44));
//		System.out.println(a.climbStairs(6));
		System.out.println(a.climbStairs(35));
	}
}
