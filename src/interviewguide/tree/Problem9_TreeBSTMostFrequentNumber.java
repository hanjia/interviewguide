package interviewguide.tree;

public class Problem9_TreeBSTMostFrequentNumber {
	int maxFreqValue;
	int maxFreqCount;
	int currentFreqValue;
	int currentFreqCount;
	
	public int findMostFrequentNumberInBST(TreeNode root) {
		if (root == null)
			return -1;
		maxFreqValue = root.val;
		maxFreqCount = 1;
		currentFreqValue = root.val;
		currentFreqCount = 1;
		inorder(root);
		return maxFreqValue;
	}
	
	public void inorder(TreeNode root) {
		if (root == null)
			return;
		
		inorder(root.left);
		if (currentFreqValue != root.val) {
			currentFreqValue = root.val;
			currentFreqCount = 1;
		} else {
			currentFreqCount++;
			if (currentFreqCount > maxFreqCount) {
				maxFreqValue = currentFreqValue;
				maxFreqCount = currentFreqCount;
			}
		}
		inorder(root.right);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
	    root.left = new TreeNode(5);
	    root.left.left = new TreeNode(5);
	    root.left.right = new TreeNode(7);
	    root.right = new TreeNode(15);
	    root.right.left = new TreeNode(15);
	    root.right.right = new TreeNode(15);

		Problem9_TreeBSTMostFrequentNumber bstMostFrequentNumber = new Problem9_TreeBSTMostFrequentNumber();
		int result = bstMostFrequentNumber.findMostFrequentNumberInBST(root);
		System.out.println(result);
	}
}
