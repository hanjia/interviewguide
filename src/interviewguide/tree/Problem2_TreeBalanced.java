package interviewguide.tree;

/**
 * 平衡二叉树Balanced binary tree 的定义是它是一棵空树或它的左右两个子树的高度差的绝对值不超过1。
 * @author hajia
 *
 */
public class Problem2_TreeBalanced {
	
    public static int getMaxDepth(BinarySearchTreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getMaxDepth(root.left), getMaxDepth(root.right));
    }

    public static int getMinDepth(BinarySearchTreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.min(getMinDepth(root.left), getMinDepth(root.right));
    }

    public static boolean isBalanced(BinarySearchTreeNode root) {
        return (getMaxDepth(root) - getMinDepth(root)) <= 1;
    }
    
	 public static void main(String[] args) {
		 BinarySearchTreeNode root = new BinarySearchTreeNode(40);
		 root.addNode(root, 35);
	     root.addNode(root, 42);
	     root.addNode(root, 29);
	     root.addNode(root, 37);
	     root.addNode(root, 41);
	     root.addNode(root, 45);
	     root.addNode(root, 23); 
	     System.out.println(isBalanced(root));
	 }
}
