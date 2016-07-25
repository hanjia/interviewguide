package interviewguide.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 *        _9_
 *      _/   \_
 *   _4_       _15_
 *  /   \     /    \
 * 2     6   12    17
 *        \
 *        10
 *        
 * @author hanjia
 *
 */
public class Problem10_TreeBSTDeepestElement {

	public static void main(String[] args) {
		TreeNode node = new TreeNode(9);
		node.left = new TreeNode(4);
		node.right = new TreeNode(15);
		node.right.right = new TreeNode(17);
		
		Problem10_TreeBSTDeepestElement s = new Problem10_TreeBSTDeepestElement();
		int result = s.findValueForDeepestLeafNode(node);

		List<Integer> pathResult = new ArrayList<Integer>();
		List<Integer> temp = new ArrayList<Integer>();
		temp.add(node.val);
		s.preorderTraverse(node, pathResult, temp, result);
		System.out.println(pathResult);
	}
	
	public int findValueForDeepestLeafNode(TreeNode root) {
		int result = 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode current = queue.poll();
			result = current.val;
			if (current.left != null)
				queue.add(current.left);
			if (current.right != null)
				queue.add(current.right);
		}
		return result;
	}

	public void preorderTraverse(TreeNode root, List<Integer> pathResult, List<Integer> path, int target) {
		if (root == null)
			return;

		if (root.val == target) {
			pathResult.addAll(path);
			return;
		}

		if (root.left != null) {
			path.add(root.left.val);
			preorderTraverse(root.left, pathResult, path, target);
			path.remove(path.size() - 1);
		}

		if (root.right != null) {
			path.add(root.right.val);
			preorderTraverse(root.right, pathResult, path, target);
			path.remove(path.size() - 1);
		}
	}

}
