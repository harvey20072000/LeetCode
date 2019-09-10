package ga.workshop.com.LeetCode.prac20181017;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
	
	public int romanToInt(String s) {
        Map<String, Integer> symbols = new HashMap<>();
        symbols.put("I", 1);
        symbols.put("V", 5);
        symbols.put("X", 10);
        symbols.put("L", 50);
        symbols.put("C", 100);
        symbols.put("D", 500);
        symbols.put("M", 1000);
                     
        char[] sA = s.toCharArray();
        int result = 0,tmp;
        for(int i=sA.length-1;i>=0;i--) {
        	tmp = symbols.get(String.valueOf(sA[i]));
        	if(i != sA.length-1 && tmp < symbols.get(String.valueOf(sA[i+1])))
        		result -= tmp;
        	else 
        		result += tmp;
        }
        return result;
    }
	
	public static void main(String[] args) {
		RomanToInteger r = new RomanToInteger();
		System.out.println(r.romanToInt("MCMXCIV"));
	}
}
