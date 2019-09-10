package ga.workshop.com.LeetCode.prac20181022;

public class PeakIndexInAMountainArray {

	public int peakIndexInMountainArray(int[] A) {
		int tmp,result=-Integer.MAX_VALUE,resultI = 0;
        for(int i=0;i<A.length;i++) {
        	if((tmp = A[i]) > result) {
        		result = tmp;
        		resultI = i;
        	}
        }
        return resultI;
    }
	
	public static void main(String[] args) {
		PeakIndexInAMountainArray a = new PeakIndexInAMountainArray();
		System.out.println(a.peakIndexInMountainArray(new int[] {0,2,1,0}));
	}
}
