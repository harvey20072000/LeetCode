package ga.workshop.com.LeetCode.prac20181025;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {
	
	public static void main(String[] args) {
		MedianOfTwoSortedArrays a = new MedianOfTwoSortedArrays();
		System.out.println(a.findMedianSortedArrays(new int[] {1,2},new int[] {3,4}));
	}
	
//	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        if(nums1.length == 0 || nums2.length == 0) {
//        	return findMedianOfAtLeastOneEmptyArray(nums1, nums2);
//        }else if(nums1.length > 1 && nums2.length > 1) {
//        	nums1 = findAvgSubarray(nums1);
//            nums2 = findAvgSubarray(nums2);
//            double temp;
//            if((temp = findMedian(nums1)) == findMedian(nums2)) {
//            	return temp;
//            }else {
//    			return handle(nums1, nums2);
//            }
//        }else
//        	return handle(nums1, nums2);
//    }
//	
//	private double handle(int[] nums1, int[] nums2) {
//		int[] nums = new int[nums1.length + nums2.length];
//		for (int i = 0, m = 0, n = 0; i < nums.length; i++) {
//			if (m >= nums1.length) {
//				nums[i] = nums2[n++];
//				continue;
//			}
//			if (n >= nums2.length) {
//				nums[i] = nums1[m++];
//				continue;
//			}
//			if (nums1[m] < nums2[n]) {
//				nums[i] = nums1[m++];
//			} else {
//				nums[i] = nums2[n++];
//			}
//		}
//		if (nums.length % 2 != 0)
//			return nums[nums.length / 2] * 1.0;
//		return (nums[nums.length / 2] + nums[nums.length / 2 - 1]) / 2.0;
//	}
//	
//	private double findMedianOfAtLeastOneEmptyArray(int[] nums1, int[] nums2) {
//		if(nums1.length == 0)
//    		nums1 = nums2;
//    	if(nums1.length % 2 != 0)
//    		return nums1[nums1.length/2]*1.0;
//    	return (nums1[nums1.length/2]+nums1[nums1.length/2-1])/2.0;
//	}
//	
//	private double findMedian(int[] nums) {
//		int length = nums.length;
//		boolean isOdd = length % 2 != 0;
//		double median = isOdd ? nums[length/2]*1d : (nums[length/2-1]+nums[length/2])/2d;
//		return median;
//	}
//	
//	private int[] findAvgSubarray(int[] nums) {
//		int length = nums.length;
//		boolean isOdd = length % 2 != 0;
//		double avg = (nums[0]+nums[length-1])/2d;
//		double median = isOdd ? nums[length/2]*1d : (nums[length/2-1]+nums[length/2])/2d;
//		if(avg != median) {
//			if(avg > median) {
//				nums = Arrays.copyOfRange(nums, 0, length/2);
//			}else {
//				nums = Arrays.copyOfRange(nums, isOdd ? length/2+1 : length/2, length);
//			}
//			return findAvgSubarray(nums);
//		}else
//			return nums;
//	}
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0) {
        	if(nums1.length == 0)
        		nums1 = nums2;
        	if(nums1.length % 2 != 0)
        		return nums1[nums1.length/2]*1.0;
        	return (nums1[nums1.length/2]+nums1[nums1.length/2-1])/2.0;
        }
        int totalLength = nums1.length+nums2.length;
        boolean isOdd = totalLength % 2 != 0;
        int[] nums = new int[totalLength];
        for(int i=0,m=0,n=0;i<nums.length;i++) {
        	if(m >= nums1.length) {
        		nums[i] = nums2[n++];
        	}else if(n >= nums2.length) {
        		nums[i] = nums1[m++];
        	}else if(nums1[m] < nums2[n]) {
        		nums[i] = nums1[m++];
        	}else {
        		nums[i] = nums2[n++];
        	}
        	if(isOdd && i == totalLength / 2) {
        		return nums[i]*1d;
        	}else if(!isOdd && i == totalLength / 2) {
        		return (nums[i-1]+nums[i])/2d;
        	}
        }
    	return -1d;
    }
}
