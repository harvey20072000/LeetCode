package ga.workshop.com.LeetCode.prac20181015;

public class InterleavingString3 {
	static long count = 0L;
	public boolean is_Interleave(String s1, int i, String s2, int j, String s3, int k, int[][] memo) {
		count++;
		System.out.printf("s1_i:%s , s2_j:%s , s3_k:%s%n",i,j,k);
		System.out.printf("s1:%s , s2:%s , s3:%s%n",s1.substring(i),s2.substring(j),s3.substring(k));
        if (i == s1.length()) {
            return s2.substring(j).equals(s3.substring(k));
        }
        if (j == s2.length()) {
            return s1.substring(i).equals(s3.substring(k));
        }
        if (memo[i][j] >= 0) { // XXX 這行最重要，代表走訪過的直接濾除，
        	System.err.printf("i:%s , j:%s%n",i,j);
            return memo[i][j] == 1 ? true : false;
        }
        boolean ans = false;
        if (s3.charAt(k) == s1.charAt(i) && is_Interleave(s1, i + 1, s2, j, s3, k + 1, memo)
                || s3.charAt(k) == s2.charAt(j) && is_Interleave(s1, i, s2, j + 1, s3, k + 1, memo)) {
            ans = true;
        }
        memo[i][j] = ans ? 1 : 0;
        return ans;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        int memo[][] = new int[s1.length()][s2.length()];
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                memo[i][j] = -1;
            }
        }
        return is_Interleave(s1, 0, s2, 0, s3, 0, memo);
    }
	
	public static void main(String[] args) {
//		Pattern pattern = Pattern.compile("\\w*a\\w*a\\w*b\\w*c\\w*c\\w*");
//		Matcher matcher = pattern.matcher("aadbbcbcac");
//		System.out.println(matcher.find());
		InterleavingString3 i = new InterleavingString3();
		long record = System.currentTimeMillis();
//		System.out.println(i.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
		System.out.println(i.isInterleave("bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa", "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab", "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab"));
		System.out.println("count:"+count);
		System.out.println("cost "+(System.currentTimeMillis()-record)+" ms");
	}
}
