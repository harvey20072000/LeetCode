package ga.workshop.com.LeetCode.prac20181018;

import java.util.ArrayList;
import java.util.List;

public class MaximumSubarray {
	/*
	public int maxSubArray(int[] nums) {
		if(nums.length == 1)
			return nums[0];
		
		int finalR = 0,finalL = 0,finalSum = -Integer.MAX_VALUE,tmpSum = 0;
        for(int i=0;i<nums.length;i++) {
        	if(tmpSum + nums[i] > nums[i]) {
        		tmpSum += nums[i];
        		finalR = i;
        	}else {
        		tmpSum = nums[i];
        		finalL = finalR = i;
        	}
        }
		return tmpSum;
    }
	*/
	
	public int maxSubArray(int[] nums) {
		if(nums.length == 1)
			return nums[0];
		
		boolean hasPositive = false;
		int a=-Integer.MAX_VALUE;
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<nums.length;i++) {
			if(nums[i] > 0) {
        		hasPositive = true;
        		list.add(i);
			}
			if(nums[i] > a)
				a = nums[i];
		}
		if(!hasPositive)
			return a;
			
		if(list.size() > 5)
			return maxSubArray(nums,hasPositive);
		int tmpResult = 0,finalResult = -Integer.MAX_VALUE,finalL = 0,finalR=0;
		for(int i=0;i<list.size();i++) {
			for(int j=i;j<list.size();j++) {
				tmpResult = 0;
				for(int k=list.get(i);k<=list.get(j);k++)
					tmpResult += nums[k];
				if(tmpResult > finalResult) {
					finalResult = tmpResult;
					finalL = list.get(i);
					finalR = list.get(j);
				}
			}
		}
		return finalResult;
    }
	
	public int maxSubArray(int[] nums,boolean hasPositive) {
		if(nums.length == 1)
			return nums[0];
		
		int[][] resultsA = new int[2][3];
		// 從左邊開始
        int finalR = 0,finalL = 0,finalSum = -Integer.MAX_VALUE,tmpSum = 0;
        for(int i=0,x=finalSum;i<nums.length;i++) {
        	boolean greaterNum = false;
        	if(nums[i] > x) {
        		x = nums[i];
        		greaterNum = true;
        	}
        	tmpSum += nums[i];
        	if(tmpSum >= finalSum || (!hasPositive && nums[i] < 0 && nums[i-1] > nums[i]) || greaterNum) {
        		finalSum = tmpSum;
        		finalR = i;
        	}
        }
        
        tmpSum = finalSum;
        for(int i=0;i<finalR;i++) {
        	tmpSum -= nums[i];
        	if(tmpSum >= finalSum) {
        		finalSum = tmpSum;
        		finalL = i+1;
        	}
        }
        
        resultsA[0][0] = finalL;
        resultsA[0][1] = finalR;
        resultsA[0][2] = finalSum;
        
        // 從右邊開始
        finalR = 0;
        finalL = 0;
        finalSum = -Integer.MAX_VALUE;
        tmpSum = 0;
        for(int i=nums.length-1,x=finalSum;i>=0;i--) {
        	boolean greaterNum = false;
        	if(nums[i] > x) {
        		x = nums[i];
        		greaterNum = true;
        	}
        	tmpSum += nums[i];
        	if(tmpSum >= finalSum || (!hasPositive && nums[i] < 0 && nums[i+1] < nums[i]) || greaterNum) {
        		finalSum = tmpSum;
        		finalL = i;
        	}
        }
        
        tmpSum = finalSum;
        for(int i=nums.length-1;i>finalL;i--) {
        	tmpSum -= nums[i];
        	if(tmpSum >= finalSum) {
        		finalSum = tmpSum;
        		finalR = i+1;
        	}
        }
        
        resultsA[1][0] = finalL;
        resultsA[1][1] = finalR;
        resultsA[1][2] = finalSum;
        
        if(resultsA[0][2] > resultsA[1][2])
        	return resultsA[0][2];
        return resultsA[1][2];
    }
	
	public static void main(String[] args) {
		MaximumSubarray m = new MaximumSubarray();
//		System.out.println(m.maxSubArray(new int[] {-2,-1,-2}));
		System.out.println(m.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
//		System.out.println(m.maxSubArray(new int[] {-1,-2}));
//		System.out.println(m.maxSubArray(new int[] {0,-3,1,1}));
//		System.out.println(m.maxSubArray(new int[] {-2,-3,-1}));
//		System.out.println(m.maxSubArray(new int[] {0,-3,-2,-3,-2,2,-3,0,1,-1}));
	}
	
	/*
	public int maxSubArray(int[] nums) {
		if(nums.length == 1)
			return nums[0];
		
		int[][] resultsA = new int[2][3];
		// 從左邊開始
        int finalR = 0,finalL = 0,finalSum = -Integer.MAX_VALUE,tmpSum = 0;
        for(int i=0;i<nums.length;i++) {
        	tmpSum += nums[i];
        	if(tmpSum >= finalSum || (tmpSum <= 0 && nums[i] <= 0 && nums[i-1] < nums[i])) {
        		finalSum = tmpSum;
        		finalR = i;
        	}
        }
        
        tmpSum = finalSum;
        for(int i=0;i<finalR;i++) {
        	tmpSum -= nums[i];
        	if(tmpSum > finalSum) {
        		finalSum = tmpSum;
        		finalL = i+1;
        	}
        }
        
        resultsA[0][0] = finalL;
        resultsA[0][1] = finalR;
        resultsA[0][2] = finalSum;
        
        // 從右邊開始
        finalR = 0;
        finalL = 0;
        finalSum = -Integer.MAX_VALUE;
        tmpSum = 0;
        for(int i=nums.length-1;i>=0;i--) {
        	tmpSum += nums[i];
        	if(tmpSum >= finalSum || (tmpSum <= 0 && nums[i] <= 0 && nums[i-1] < nums[i])) {
        		finalSum = tmpSum;
        		finalR = i;
        	}
        }
        
        tmpSum = finalSum;
        for(int i=0;i<finalR;i++) {
        	tmpSum -= nums[i];
        	if(tmpSum > finalSum) {
        		finalSum = tmpSum;
        		finalL = i+1;
        	}
        }
        
        resultsA[0][0] = finalL;
        resultsA[0][1] = finalR;
        resultsA[0][2] = finalSum;
        return finalSum;
    }
    */
	
}
