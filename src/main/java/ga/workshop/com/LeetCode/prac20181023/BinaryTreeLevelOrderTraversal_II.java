package ga.workshop.com.LeetCode.prac20181023;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal_II {
	
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = new LinkedList<>();
		if(root == null)
			return result;
		List<Integer> subList = new LinkedList<>();
		subList.add(root.val);
		result.add(0, subList);
        calDepth(root.left, 1, result);
        calDepth(root.right, 1, result);
        return result;
    }
	
	private int calDepth(TreeNode node,int count,List<List<Integer>> list) {
		if(node == null)
			return count;
		count++;
		int index = list.size()-count;
		if(index < 0) {
			List<Integer> subList = new LinkedList<>();
			subList.add(node.val);
			list.add(0, subList);
		}else
			list.get(index).add(node.val);
		return Math.max(calDepth(node.left, count, list), calDepth(node.right, count, list));
	}
	
	public static void main(String[] args) {
		BinaryTreeLevelOrderTraversal_II a = new BinaryTreeLevelOrderTraversal_II();
//		System.out.println(a.isSameTree(119532598));
	}
}
