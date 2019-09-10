package ga.workshop.com.LeetCode.prac20181018;

public class SearchInsertPosition {
	public int searchInsert(int[] nums, int target) {
        for(int i=0;i<nums.length;i++)
        	if(target <= nums[i])
        		return i;
        if(target > nums[nums.length-1])
        	return nums.length;
        return 0;
    }
}
