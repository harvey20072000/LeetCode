package ga.workshop.com.LeetCode.prac20181004;

public class AdditiveNumber {
	
	public boolean isAdditiveNumber(String num) {
        String first, second, rest;
        boolean tempResult;
        int finalResult = 1;
        
        try {
        	for(int i=1;i<=num.length();i++) {
            	for(int j=1;j<=num.length();j++) {
            		if(i+j >= num.length())
            			break;
            		first = num.substring(0,i);
            		System.out.println(String.format("i=%s,j=%s", i,j));
                	second = num.substring(i,i+j);
                	rest = num.substring(i+j);
                	if(first.isEmpty() || second.isEmpty() || rest.isEmpty() ||
                			(first.startsWith("0") && first.length() > 1) || (second.startsWith("0") && second.length() > 1))
                		continue;
                	if((tempResult = isAdditiveNumber(first, second, rest)))
                		finalResult *= -1;
                	if(finalResult < 0)
                		break;
            	}
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        if(finalResult < 0)
        	return true;
        else
        	return false;
    }
	
	private boolean isAdditiveNumber(String first, String second, String rest) {
		String temp;
		if(rest.startsWith(temp = String.valueOf(Long.parseLong(first)+Long.parseLong(second)))){
        	if(rest.length() <= second.length() || rest.length() == temp.length())
        		return true;
        	else if(rest.length() > temp.length())
        		return isAdditiveNumber(second,temp,rest.substring(temp.length()));
        	else
        		return false;
        }else
        	return false;
	}
	
	public static void main(String[] args) {
		AdditiveNumber a = new AdditiveNumber();
		System.out.println(a.isAdditiveNumber("198019823962"));
	}
	
}
