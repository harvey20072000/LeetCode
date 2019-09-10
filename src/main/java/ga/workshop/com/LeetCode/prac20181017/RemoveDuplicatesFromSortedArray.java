package ga.workshop.com.LeetCode.prac20181017;

import java.util.Set;
import java.util.TreeSet;

public class RemoveDuplicatesFromSortedArray {
//	public int removeDuplicates(int[] nums) {
//        Set<Integer> numSet = new TreeSet<>();
//        for(Integer n : nums)
//        	numSet.add(n);
//        int index = 0;
//        for(Integer n : numSet)
//        	nums[index++] = n;
//        System.out.println(nums);
//        return numSet.size();
//    }
	
	public int removeDuplicates(int[] nums) {
		int count = 1;
		for (int i = 0, j = i + 1; j < nums.length; j++) {
			if (nums[i] < nums[j]) {
				nums[++i] = nums[j];
				count++;
			}
		}
        return count;
    }
	
//	public int removeDuplicates(int[] nums) {
//		int count = 1;
//		Set<Integer> numSet = new TreeSet<>();
//        for(int i=0;i<nums.length;i++) {
//        	for(int j=i+1;j<nums.length;j++)
//        		if(numSet.contains(nums[i]) && nums[i] < nums[j]) {
//        			nums[i] = nums[j];
//        			count++;
//        			break;
//        		}
//        	numSet.add(nums[i]);
//        }
//        return count;
//    }
	
	public static void main(String[] args) {
		RemoveDuplicatesFromSortedArray r = new RemoveDuplicatesFromSortedArray();
		System.out.println(r.removeDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4}));
	}
}
