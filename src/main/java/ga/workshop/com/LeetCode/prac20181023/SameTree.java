package ga.workshop.com.LeetCode.prac20181023;

public class SameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p == null && q == null)
			return true;
        if((p == null && q != null) || (p != null && q == null))
        	return false;
        if(p.val != q.val)
        	return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
	
	public static void main(String[] args) {
		SameTree a = new SameTree();
//		System.out.println(a.isSameTree(119532598));
	}
}

class TreeNode {
	 int val;
	 TreeNode left;
	 TreeNode right;
	 TreeNode(int x) { val = x; }
}
