package ga.workshop.com.LeetCode.prac20190503;

import java.util.Random;

import com.google.gson.Gson;

public class SmallestSetsCoverAllIntervals {
	
	private static Gson gson = new Gson();
	private static int totalElementSize;
	
	private static String[][] genTests(){
		totalElementSize = 0;
		int elementLimit = 20,eachLengthLimit = 3;
		Random random = new Random();
		String[][] results = new String[elementLimit][];
		for(int i=0,size=0;i<results.length;i++) {
			results[i] = new String[(size = random.nextInt(eachLengthLimit)+1)];
			totalElementSize += size;
			for(int j=0;j<results[i].length;j++) {
				results[i][j] = String.valueOf(random.nextInt(elementLimit)+1);
			}
		}
		return results;
	}
	
	private static String toString(Object input) {
		return gson.toJson(input);
	}

	public static void main(String[] args) {
		long recordTime = System.currentTimeMillis();
		
		//String[][] inputs = new String[][] {{"0","3"},{"2","6"},{"3","4"},{"6","9"}};
		//String[][] inputs = new String[][] {{"0","1","3"},{"2","3","6"},{"3","4"},{"0","5"},{"4","6","9"}};
		String[][] inputs = genTests();
		//Record[] elements = new Record[8];
		//Record[] elements = new Record[13];
		inputs = gson.fromJson("[[\"16\"],[\"3\",\"15\"],[\"15\",\"3\",\"6\"],[\"20\",\"14\"],[\"2\",\"15\"],[\"15\",\"6\",\"4\"],[\"19\",\"12\",\"5\"],[\"3\"],[\"20\",\"20\"],[\"4\",\"8\"],[\"14\",\"16\",\"13\"],[\"3\",\"12\"],[\"9\",\"3\"],[\"5\",\"12\"],[\"13\"],[\"9\"],[\"4\",\"15\"],[\"13\"],[\"2\",\"5\",\"19\"],[\"16\"]]", String[][].class);
		
		Record[] elements = new Record[20*3];
		int[] sums = new int[inputs.length];
		
		Record tmp = null;
		int end = 0;
		for(int i=0,index=0;i<inputs.length;i++) {
			for(int j=0;j<inputs[i].length;j++) {
				sums[i]++;
				if(!isExistAndRecord(inputs[i][j],i, elements)) {
					elements[index] = (tmp = new Record());
					tmp.setElement(inputs[i][j]);
					tmp.setLength(inputs.length);
					tmp.getInfo()[i]++;
					end = ++index;
				}
			}
		}
		int[] tmpInfo = null;
		String[] results = new String[end];
		for(int i=0,index = 0;i<end;i++) {
			tmpInfo = elements[i].getInfo();
			if(!intArraysInteract(sums,tmpInfo,"-")) {
				intArraysInteract(sums, tmpInfo, "+");
				results[index++] = elements[i].getElement();
			}
		}
		System.out.printf("inputs => %s%n",toString(inputs));
		System.out.printf("results => %s%n",toString(results));
		System.out.printf("sums => %s%n",toString(sums));
		System.out.printf("end in %s ms%n",System.currentTimeMillis()-recordTime);
	}
	
	private static boolean isExistAndRecord(String arg, int index, Record[] array) {
		for(int i=0;i<array.length;i++) {
			if(arg != null && array[i] != null && arg.equals(array[i].getElement())) {
				array[i].getInfo()[index]++;
				return true;
			}
		}
		return false;
	}
	
	private static boolean intArraysInteract(int[] a, int[] b, String operate) {
		boolean isAllPositive = true;
		for(int i=0;i<a.length;i++) {
			switch (operate) {
			case "+":
				a[i] += b[i];
				break;
			case "-":
				a[i] -= b[i];
				break;
			default:
				System.err.printf("unsupported operate (%s)%n",operate);
				return false;
			}
			if(a[i] <= 0) {
				isAllPositive = false;
			}
		}
		return isAllPositive;
		
	}
	
	static class Record {
		String element;
		int[] info;
		
		public void setElement(String element) {
			this.element = element;
		}
		
		public String getElement() {
			return element;
		}
		
		public void setLength(int length) {
			info = new int[length];
		}
		
		public int[] getInfo() {
			return info;
		}
	}
}
