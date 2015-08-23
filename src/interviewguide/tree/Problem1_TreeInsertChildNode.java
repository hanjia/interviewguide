package interviewguide.tree;

public class Problem1_TreeInsertChildNode {
	
    /*
	     40
	   /   \
	 35     42
	/ \    / \
  29  37  41  45
 /  \
23  30

	*/
	 public static void main(String[] args) {
	        BinarySearchTreeNode root = new BinarySearchTreeNode(40);
	        BinarySearchTreeNode n1 = root.addNode(root,35);
	        BinarySearchTreeNode n2 = root.addNode(root,42);
	        BinarySearchTreeNode n3 = root.addNode(root,29);
	        BinarySearchTreeNode n4 = root.addNode(root,37);
	        BinarySearchTreeNode n5 = root.addNode(root,41);
	        BinarySearchTreeNode n6 = root.addNode(root,45);
	        BinarySearchTreeNode n7 = root.addNode(root,23);
	        System.out.println(root.value);
	        System.out.println(n1.value);
	        System.out.println(n2.value);
	        System.out.println(n3.value);
	        System.out.println(n4.value);
	        System.out.println(n5.value);
	        System.out.println(n6.value);
	        System.out.println(n7.value);
	 }
}
