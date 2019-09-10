package ga.workshop.com.LeetCode.prac20181023;

public class BalancedBinaryTree {
	public static void main(String[] args) {
		BalancedBinaryTree a = new BalancedBinaryTree();
//		System.out.println(a.isSameTree(119532598));
	}
	
	private boolean result = true;

    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return result;
    }

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        if (Math.abs(l - r) > 1)
            result = false;
        return 1 + Math.max(l, r);
    }
	
	
//	static int record1,record2;
//	
//	public boolean isBalanced(TreeNode root) {
//		record1 = record2 = -1;
//        if(root == null)
//        	return true;
//        iterate(root.left, 1);
//        iterate(root.right, 1);
//        if(record1 - record2 > 1)
//        	return false;
//        return true;
//    }
//	
//	private void iterate(TreeNode node, int level) {
//		if(node == null) {
//			if(record1 < 0 && record2 < 0)
//				record1 = record2 = level;
//			else if(level > record1)
//				record1 = level;
//			else if(level < record2)
//				record2 = level;
//			return;
//		}
//		level++;
//		iterate(node.left, level);
//		iterate(node.right, level);
//	}
}
