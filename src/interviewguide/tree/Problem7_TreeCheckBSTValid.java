package interviewguide.tree;

/**
 * 判断一个二叉树是否为二叉查找树
 * @author hanjia
 *
 */
public class Problem7_TreeCheckBSTValid {

	/*
	 * 解法：递归实现中序遍历LDR，所以需要查看当前的值是否大于先前的值
	 * Reference: http://articles.leetcode.com/2010/09/determine-if-binary-tree-is-binary.html
	 */
	public static boolean checkBSTValid(BinarySearchTreeNode bstNode, int previousValue){
		if(bstNode == null)
			return true;
		
		if(checkBSTValid(bstNode.left, previousValue)){
			if (bstNode.value > previousValue) {
				previousValue = bstNode.value;
			    return checkBSTValid(bstNode.right, previousValue);
			} else {
				return false;
			}
		}else {
		    return false;
		}
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
	     System.out.println(checkBSTValid(root,Integer.MIN_VALUE));
	 }
}
