package ga.workshop.com.LeetCode.prac20181023;

public class MaximumDepthOfBinaryTree {
	public int maxDepth(TreeNode root) {
        if(root == null)
        	return 0;
        return Math.max(calDepth(root.left, 1), calDepth(root.right, 1));
    }
	
	private int calDepth(TreeNode node,int count) {
		if(node == null)
			return count;
		count++;
		return Math.max(calDepth(node.left, count), calDepth(node.right, count));
	}
	
	public static void main(String[] args) {
		MaximumDepthOfBinaryTree a = new MaximumDepthOfBinaryTree();
//		System.out.println(a.isSameTree(119532598));
	}
}
