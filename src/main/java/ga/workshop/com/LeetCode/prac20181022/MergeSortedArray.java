package ga.workshop.com.LeetCode.prac20181022;

public class MergeSortedArray {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] tmpNums1 = new int[m];
        System.arraycopy(nums1, 0, tmpNums1, 0, m);
        for(int i=0,mi=0,ni=0;i<m+n;i++) {
        	if(ni >= n)
        		nums1[i] = tmpNums1[mi++];
        	else if(mi >= m)
        		nums1[i] = nums2[ni++];
        	else if(tmpNums1[mi] <= nums2[ni]) {
        		nums1[i] = tmpNums1[mi++];
        	}else {
        		nums1[i] = nums2[ni++];
        	}
        }
    }
	
	public static void main(String[] args) {
		MergeSortedArray a = new MergeSortedArray();
		int[] nums1 = new int[] {1,2,3,0,0,0},nums2 = new int[] {2,5,6};
		a.merge(nums1,3,nums2,3);
		StringBuilder sb = new StringBuilder("");
		for(Integer i : nums1)
			sb.append(","+i);
		System.out.println(sb.replace(0, 1, "[").toString()+"]");
	}
}
