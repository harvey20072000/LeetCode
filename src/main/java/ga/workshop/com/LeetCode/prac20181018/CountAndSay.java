package ga.workshop.com.LeetCode.prac20181018;

public class CountAndSay {
	public String countAndSay(int n) {
        String src=null;
        StringBuilder sb = new StringBuilder("1");
        char[] srcA = null;
        int count = 1;
        while(count++ < n) {
        	src = sb.toString();
        	srcA = src.toCharArray();
        	sb = new StringBuilder("");
        	for(int i=0;i<srcA.length;i++) {
        		if(i == srcA.length-1)
        			sb.append(1).append(srcA[i]);
        		for(int j=i+1;j<srcA.length;j++) {
        			if(srcA[i] != srcA[j]) {
        				sb.append(j-i).append(srcA[i]);
        				i = j-1;
        				break;
        			}
        			if(j == srcA.length-1) {
        				sb.append(j-i+1).append(srcA[i]);
        				i = j;
        			}
        		}
        	}
        }
        return sb.toString();
    }
	
	public static void main(String[] args) {
		CountAndSay r = new CountAndSay();
		System.out.println(r.countAndSay(4));
	}
}
