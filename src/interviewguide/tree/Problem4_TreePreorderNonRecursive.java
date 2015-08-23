package interviewguide.tree;

import java.util.Stack;

public class Problem4_TreePreorderNonRecursive {
	
	/*
	 * 要点: 在于用栈来保存左右节点
	 */
    public static void preOrderNoRecursive(BinarySearchTreeNode root) {
        Stack<BinarySearchTreeNode> s = new Stack<BinarySearchTreeNode>();
        BinarySearchTreeNode node = null;
        s.push(root);
        while (!s.isEmpty()) {
            node = s.pop();
            System.out.println(node.value);
            if (node.right != null) {
                s.push(node.right);
            }
            if (node.left != null) {
                s.push(node.left);
            }
        }
    }
    
	 public static void main(String[] args) {
	        BinarySearchTreeNode root = new BinarySearchTreeNode(40);
	        root.addNode(root,35);
	        root.addNode(root,42);
	        root.addNode(root,29);
	        root.addNode(root,37);
	        root.addNode(root,41);
	        root.addNode(root,45);
	        root.addNode(root,23);
	        preOrderNoRecursive(root);
	 }
}
