package ga.workshop.com.LeetCode.prac20181015;

public class InterleavingString {
	static long count = 0L;
	public boolean isInterleave(String s1, String s2, String s3) {
		String tmp = rearrange(s1+s2),tmpS3 = rearrange(s3);
		if(tmp.equals(tmpS3))
			return isInterleave(s1, s2, s3,0);
		else
			return false;
		
//		return isInterleave(s1, s2, s3,0);
	}
	
	private boolean isInterleave(String s1, String s2, String s3, int offset) {
		if(++count % 100 == 0)
			System.out.printf("s1:%s , s2:%s , s3:%s%n",s1,s2,s3);
//		if(++count > 100) {
//			System.out.println("system force end!");
//			System.exit(0);
//		}
		if(s1.isEmpty() && s2.isEmpty() && s3.isEmpty())
			return true;
		if((s1.isEmpty() || s2.isEmpty())) {
			if((s1.isEmpty() && s2.equals(s3)) || (s2.isEmpty() && s1.equals(s3)))
				return true;
			else
				return false;
		}
		int result = 1;
		if(s1.length() + s2.length() != s3.length())
			return false;
//		for(int i=0;i<2;i++) {
//			if((s3.startsWith(s1.substring(0, 1)) && isInterleave(s1.substring(1), s2, s3.substring(1), 0))
//					|| (s3.startsWith(s2.substring(0, 1)) && isInterleave(s1, s2.substring(1), s3.substring(1), 0)))
//				result *= -1;
//			if(result < 0)
//				return true; 
//		}
		if((s3.startsWith(s1.substring(0, 1)) && isInterleave(s1.substring(1), s2, s3.substring(1), 0))
				|| (s3.startsWith(s2.substring(0, 1)) && isInterleave(s1, s2.substring(1), s3.substring(1), 0)))
			result *= -1;
		if(result < 0)
			return true; 
		return false;
	}
	
	private String rearrange(String input) {
		char[] cs = input.toCharArray();
		char tmp;
		for(int i=0;i<cs.length;i++)
			for(int j=i+1;j<cs.length;j++) {
				if((tmp = cs[i]) > cs[j]) {
					cs[i] = cs[j];
					cs[j] = tmp;
				}
			}
		return String.valueOf(cs);
	}
	
//	private boolean isInterleave(String s1, String s2, String s3, int offset) {
//		if(++count % 1000 == 0)
//			System.out.printf("s1:%s , s2:%s , s3:%s%n",s1,s2,s3);
//		if(s1.isEmpty() && s2.isEmpty() && s3.isEmpty() || s2.equals(s3))
//			return true;
//		if((s1.isEmpty() || s2.isEmpty())) {
//			if((s1.isEmpty() && s2.equals(s3)) || (s2.isEmpty() && s1.equals(s3)))
//				return true;
//			else
//				return false;
//		}
//		if(s1.length() + s2.length() != s3.length())
//			return false;
//		String tmpS1 = null,tmpS3 = null;
//		int result = 1;
//		for(int i=s1.length();i>=1;i--) {
//			if(s3.substring(offset).indexOf(tmpS1 = s1.substring(0, i)) >= 0) {
//				for(int j=offset;j<s3.length();j++) {
//					if((tmpS3 = s3.substring(j)).startsWith(tmpS1) && isInterleave(s1.replaceFirst(tmpS1, ""), s2, new StringBuilder(s3).replace(j, j+tmpS1.length(), "").toString(),j))
//						result *= -1;
//					if(result < 0)
//						break;
//				}
//			}
//			if(result < 0)
//				break;
//		}
//		if(result < 0)
//			return true;
//		return false;
//	}
	
	
	public static void main(String[] args) {
//		Pattern pattern = Pattern.compile("\\w*a\\w*a\\w*b\\w*c\\w*c\\w*");
//		Matcher matcher = pattern.matcher("aadbbcbcac");
//		System.out.println(matcher.find());
		InterleavingString i = new InterleavingString();
		long record = System.currentTimeMillis();
//		System.out.println(i.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
		System.out.println(i.isInterleave("bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa", "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab", "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab"));
		System.out.println("count:"+count);
		System.out.println("cost "+(System.currentTimeMillis()-record)+" ms");
	}
}
