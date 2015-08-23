package interviewguide.tree;

import java.util.ArrayDeque;

public class Problem5_TreeBreadthFirstTraversal {
	
	/*
	 * 要点: 在于用队列来保存左右节点
	 */
	public static void breadthFirstTraversal(BinarySearchTreeNode root) {
        ArrayDeque<BinarySearchTreeNode> queue = new ArrayDeque<BinarySearchTreeNode>();
        BinarySearchTreeNode node = null;
        queue.add(root);
        while (!queue.isEmpty()) {
            node = queue.remove();
            System.out.println(node.value);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
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
	        breadthFirstTraversal(root);
	 }
}
