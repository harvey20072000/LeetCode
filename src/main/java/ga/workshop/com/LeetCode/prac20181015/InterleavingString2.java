package ga.workshop.com.LeetCode.prac20181015;

public class InterleavingString2 {
	static long count = 0L;
	public boolean isInterleave(String s1, String s2, String s3) {
		String tmp = rearrange(s1+s2),tmpS3 = rearrange(s3);
		if(tmp.equals(tmpS3))
			return isInterleave(s1, s2, s3,0,0) == -1;
		else
			return false;
		
//		return isInterleave(s1, s2, s3,0);
	}
	
	private int isInterleave(String s1, String s2, String s3, int offset, int status) {
//		if(++count % 100 == 0)
//			System.out.printf("s1:%s , s2:%s , s3:%s%n",s1,s2,s3);
		System.err.printf("offset:%s , s1:%s , s2:%s , s3:%s%n",offset,s1,s2,s3);
		if(++count > 100) {
//			System.out.println("system force end!");
//			System.exit(0);
		}
		if(s1.length() + s2.length() != s3.length())
			return -2;
		if(s1.isEmpty() && s2.isEmpty() && s3.isEmpty())
			return -1;
		if((s1.isEmpty() || s2.isEmpty())) {
			System.out.printf("offset:%s , s1:%s , s2:%s , s3:%s%n",offset,s1,s2,s3);
			if((s1.isEmpty() && s2.equals(s3)) || (s2.isEmpty() && s1.equals(s3)))
				return -1;
			else
				return 0;
		}else if (true) {
			if(s2.length() >= offset ? !s3.startsWith(s2.substring(0, offset)) : !s3.startsWith(s2)) {
				System.out.println("not match => "+s2+" — "+s3);
				return 0;
			}
		}
		
		int result = 0,next=0,tmpOffset = offset;
		while((next = s3.substring(tmpOffset).indexOf(s1.substring(0, 1))) >= 0) {
			tmpOffset += next;
			result = isInterleave(s1.substring(1), s2, new StringBuilder(s3).replace(tmpOffset, tmpOffset+1, "").toString(), tmpOffset,status);
			if(result == -1 || result == -2 || result > 0)
				break;
			tmpOffset++;
		}
		if(result > 0)
			result--;
		return result;
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
	
	public static void main(String[] args) {
//		Pattern pattern = Pattern.compile("\\w*a\\w*a\\w*b\\w*c\\w*c\\w*");
//		Matcher matcher = pattern.matcher("aadbbcbcac");
//		System.out.println(matcher.find());
		InterleavingString2 i = new InterleavingString2();
		long record = System.currentTimeMillis();
		System.out.println(i.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
//		System.out.println(i.isInterleave("bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa", "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab", "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab"));
		System.out.println("count:"+count);
		System.out.println("cost "+(System.currentTimeMillis()-record)+" ms");
	}
}
