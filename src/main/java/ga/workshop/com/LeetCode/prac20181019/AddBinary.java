package ga.workshop.com.LeetCode.prac20181019;

public class AddBinary {
	public String addBinary(String a, String b) {
		// 補齊a,b字串的長度為一致
		int diff = 0,tmp,nextAdd = 0;
		if((diff = a.length() - b.length()) != 0)
			if(diff > 0)
				for(int i=0;i<diff;i++)
					b = "0".concat(b);
			else
				for(int i=0;i>diff;i--)
					a = "0".concat(a);
		
		char[] aA = a.toCharArray(),bA = b.toCharArray(),resultA = new char[aA.length];
		for(int i=resultA.length-1;i>=0;i--) {
			resultA[i] = Character.forDigit(Character.getNumericValue(aA[i])+Character.getNumericValue(bA[i])+nextAdd, 10);
			nextAdd = 0;
			if(resultA[i] >= '2') {
				nextAdd = (tmp = Character.getNumericValue(resultA[i])) / 2;
				resultA[i] = Character.forDigit(tmp % 2, 10);
			}
		}
		if(nextAdd > 0) {
			char[] tmpResult = new char[resultA.length+1];
			System.arraycopy(resultA, 0, tmpResult, 1, resultA.length);
			tmpResult[0] = (char)('0'+nextAdd);
			resultA = tmpResult;
		}
		return String.valueOf(resultA);
    }
	
	public static void main(String[] args) {
		AddBinary a = new AddBinary();
		System.out.println(a.addBinary("11", "1"));
	}
	
//	public String addBinary(String a, String b) {
//		int rawResult = Integer.parseInt(a)+Integer.parseInt(b),rest = 0,nextAdd = 0;
//		StringBuilder sb = new StringBuilder(""); 
//		while(rawResult > 0) {
//			rest = rawResult % 10;
//			nextAdd = rest / 2;
//			sb.insert(0, rest%2);
//			rawResult /= 10;
//			rawResult += nextAdd;
//		}
//		
//		return sb.toString();
//    }
}
