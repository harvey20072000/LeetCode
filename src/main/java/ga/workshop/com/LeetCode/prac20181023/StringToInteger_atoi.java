package ga.workshop.com.LeetCode.prac20181023;

public class StringToInteger_atoi {
	public static void main(String[] args) {
		StringToInteger_atoi a = new StringToInteger_atoi();
//		System.out.println(a.myAtoi("   +0 123"));
		System.out.println(a.myAtoi("4193 with words"));
	}
	
	public int myAtoi(String str) {
        if(str == null || str.trim().isEmpty())
        	return 0;
        int result = 0;
        boolean isNegative = false;
        try {
        	String target = str.trim();
        	if(target.startsWith("+-") || target.startsWith("-+")) {
        		result = 0;
        	}else if((target = judgeStr(target)).matches("(\\+|\\-)?[0-9\\.]+")) {
            	if(target.startsWith("-"))
            		isNegative = true;
            	result = new Double(Double.parseDouble(target)).intValue();
        	}else
        		result = 0;
		} catch (Exception e) {
			if(isNegative)
				result = Integer.MIN_VALUE;
			else
				result = Integer.MAX_VALUE;
		}
        return result;
    }
	
	private String judgeStr(String input) {
		char[] inputA = input.toCharArray();
		for(int i=0;i<inputA.length;i++) {
			if(!Character.isDigit(inputA[i])) {
				if(i==0 && (inputA[i] != '-' || inputA[i] != '+'))
					continue;
				if(i>0 && inputA[i] == '.')
					continue;
				return input.substring(0, i);
			}
		}
		return input;
	}
	
	
//	public int myAtoi(String str) {
//        if(str == null || str.trim().isEmpty())
//        	return 0;
//        int result = 0;
//        boolean isNegative = false;
//        try {
//        	String target = str.trim();
//        	if(target.startsWith("+-") || target.startsWith("-+")) {
//        		result = 0;
//        	}else if((target = target.substring(0, target.contains(" ")?target.indexOf(" "):target.length())).matches("(\\+|\\-)?[0-9\\.]+")) {
//            	if(target.startsWith("-"))
//            		isNegative = true;
//            	result = new Double(Double.parseDouble(target)).intValue();
//        	}else
//        		result = 0;
//		} catch (Exception e) {
//			if(isNegative)
//				result = Integer.MIN_VALUE;
//			else
//				result = Integer.MAX_VALUE;
//		}
//        return result;
//    }
	
//	public int myAtoi(String str) {
//        if(str == null || str.trim().isEmpty())
//        	return 0;
//        int result = 0;
//        boolean isNegative = false;
//        try {
//        	String target = str.replace(" ", "");
//        	if(target.contains("+-") || target.contains("-+")) {
//        		result = 0;
//        	}else if(target.matches("[\\+,\\-,0-9]\\S*")) {
//        		Pattern pattern = Pattern.compile("(?<target>(\\+|\\-)?[0-9\\.]+)");
//            	Matcher matcher = pattern.matcher(target);
//            	if(matcher.find()) {
//            		if((target = matcher.group("target")).startsWith("-"))
//            			isNegative = true;
//            		result = new Double(Double.parseDouble(matcher.group("target"))).intValue();
//            	}else
//            		result = 0;
//        	}else
//        		result = 0;
//		} catch (Exception e) {
//			if(isNegative)
//				result = Integer.MIN_VALUE;
//			else
//				result = Integer.MAX_VALUE;
//		}
//        return result;
//    }
	
}
