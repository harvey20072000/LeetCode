package ga.workshop.com.LeetCode.prac20181023;

import java.util.Arrays;

public class ConvertSortedArrayToBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] nums) {
		TreeNode result = null;
        if(nums.length == 0)
        	return result;
        int index = nums.length / 2;
        result = new TreeNode(nums[index]);
        sortedArrayToBST(Arrays.copyOfRange(nums, 0, index), result, true);
        sortedArrayToBST(Arrays.copyOfRange(nums, index+1, nums.length), result, false);
        return result;
    }
	
	private void sortedArrayToBST(int[] nums,TreeNode parent,boolean isLeft) {
		if(nums.length == 0)
			return;
		int index = nums.length / 2;
        TreeNode node = new TreeNode(nums[index]);
        if(isLeft)
			parent.left = node;
        else
        	parent.right = node;
        sortedArrayToBST(Arrays.copyOfRange(nums, 0, index), node, true);
        sortedArrayToBST(Arrays.copyOfRange(nums, index+1, nums.length), node, false);
	}
}
