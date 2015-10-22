package interviewguide.tree;

public class Problem3_TreeTwoEquals {
	
    public static boolean areTwoTreesEqual(BinarySearchTreeNode t1, BinarySearchTreeNode t2) {
        if (t1 == t2) {
            return true;
        }
        return (t1.value == t2.value) && areTwoTreesEqual(t1.left, t2.left) && areTwoTreesEqual(t1.right, t2.right);
    }
    
	 public static void main(String[] args) {
		 BinarySearchTreeNode root1 = new BinarySearchTreeNode(40);
		 root1.addNode(root1, 35);
	     root1.addNode(root1, 42);
	     root1.addNode(root1, 29);
	     root1.addNode(root1, 37);
	     root1.addNode(root1, 41);
	     root1.addNode(root1, 45);
	     root1.addNode(root1, 23); 
	     
		 BinarySearchTreeNode root2 = new BinarySearchTreeNode(39);
		 root2.addNode(root2, 35);
	     root2.addNode(root2, 42);
	     root2.addNode(root2, 29);
	     root2.addNode(root2, 37);
	     root2.addNode(root2, 41);
	     root2.addNode(root2, 45);
	     root2.addNode(root2, 23);      
	     
	     System.out.println(areTwoTreesEqual(root1,root2));
	 }
}
