package ga.workshop.com.LeetCode.prac20181023;

public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		if(root == null)
			return true;
        return isSymmetric(root.left, root.right);
		
    }
	
	private boolean isSymmetric(TreeNode left,TreeNode right) {
		if(left == null && right == null)
			return true;
        if((left == null && right != null) || (left != null && right == null))
        	return false;
        if(left.val != right.val)
        	return false;
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
	
	
	public static void main(String[] args) {
		SameTree a = new SameTree();
//		System.out.println(a.isSameTree(119532598));
	}
}
