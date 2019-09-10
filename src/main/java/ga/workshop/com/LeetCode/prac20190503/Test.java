package ga.workshop.com.LeetCode.prac20190503;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
	public static void main(String[] args) {
		try {
			String name = "hello";
	        for (int i = 0; i < 10000000; i++) {
	            name += name;
	        }
	        System.out.println(name);
		} catch (Throwable e) {
			System.out.println(e);
		}
	}
}
