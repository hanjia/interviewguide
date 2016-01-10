package interviewguide.tree;

public class Problem7_TreeFindCommonAncestor {
	
	/*
	 * 解法：因为是二叉查找树，所以很简单。最近共同父节点的值n和任意两个节点n1，n2之间一定满足关系`n1<n<n2`
	 */
    public static int findCommonAncestor(BinarySearchTreeNode root, BinarySearchTreeNode t1, BinarySearchTreeNode t2) {
        int left = t1.value;
        int right = t2.value;
        BinarySearchTreeNode parent = null;

        if (left > right) {
            int temp = left;
            left = right;
            right = temp;
        }

        while (true) {
            if (root.value < left) {
                parent = root;
                root = root.right;
            } else if (root.value > right) {
                parent = root;
                root = root.left;
            } else if (root.value == left || root.value == right) {
                return parent.value;
            } else {
                return root.value;
            }
        }
    }
    
    public static int findCommonAncestorRecursive(BinarySearchTreeNode root, BinarySearchTreeNode n1, BinarySearchTreeNode n2) {
        if (n1.value < root.value && n2.value > root.value) {
            return root.value;
        }
        if (n1.value < root.value && n2.value < root.value) {
            return findCommonAncestorRecursive(root.left, n1, n2);
        } else if (n1.value > root.value && n2.value > root.value) {
            return findCommonAncestorRecursive(root.right, n1, n2);
        }
        return -1;
    }
    
	 @SuppressWarnings("unused")
	public static void main(String[] args) {
	        BinarySearchTreeNode root = new BinarySearchTreeNode(40);
	        BinarySearchTreeNode n1 = root.addNode(root,35);
	        BinarySearchTreeNode n2 = root.addNode(root,42);
	        BinarySearchTreeNode n3 = root.addNode(root,29);
	        BinarySearchTreeNode n4 = root.addNode(root,37);
	        BinarySearchTreeNode n5 = root.addNode(root,41);
	        BinarySearchTreeNode n6 = root.addNode(root,45);
	        BinarySearchTreeNode n7 = root.addNode(root,23);
	        
	        System.out.println(findCommonAncestor(root, n7, n2));
	        System.out.println(findCommonAncestorRecursive(root, n7, n2));

	        System.out.println(findCommonAncestor(root, n5, n6));
	        System.out.println(findCommonAncestorRecursive(root, n5, n6));
	 }
}
