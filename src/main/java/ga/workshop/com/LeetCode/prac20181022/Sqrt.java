package ga.workshop.com.LeetCode.prac20181022;

public class Sqrt {
	public int mySqrt(int x) {
		Long src = new Long(x),root = 1L;
		String srcString = null;
		if(src == 1)
			return src.intValue();
		if(src >= 100) {
			for (int i = 0; i < ((srcString = String.valueOf(x)).length()-1) / 2; i++)
				root *= 10;
			if(srcString.length() % 2 == 1) {
				if(Integer.parseInt(srcString.substring(0, 1)) >= 4 && Integer.parseInt(srcString.substring(0, 1)) < 9)
					root *= 2;
				else if(Integer.parseInt(srcString.substring(0, 1)) >= 9)
					root *= 3;
			}else {
				if(Integer.parseInt(srcString.substring(0, 2)) < 16)
					root *= 3;
				else if(Integer.parseInt(srcString.substring(0, 1)) >= 16 && Integer.parseInt(srcString.substring(0, 2)) < 25)
					root *= 4;
				else if(Integer.parseInt(srcString.substring(0, 1)) >= 25 && Integer.parseInt(srcString.substring(0, 2)) < 36)
					root *= 5;
				else if(Integer.parseInt(srcString.substring(0, 1)) >= 36 && Integer.parseInt(srcString.substring(0, 2)) < 49)
					root *= 6;
				else if(Integer.parseInt(srcString.substring(0, 1)) >= 49 && Integer.parseInt(srcString.substring(0, 2)) < 64)
					root *= 7;
				else if(Integer.parseInt(srcString.substring(0, 1)) >= 64 && Integer.parseInt(srcString.substring(0, 2)) < 81)
					root *= 8;
				else if(Integer.parseInt(srcString.substring(0, 1)) >= 81)
					root *= 9;
			}
		}
		
		while(root*root <= src)
			root++;
		root--;
		return root.intValue();
    }
	
	public static void main(String[] args) {
		Sqrt a = new Sqrt();
		System.out.println(a.mySqrt(119532598));
	}
}
