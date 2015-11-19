package interviewguide.tree;

import java.util.Stack;

/**
 * 判断一个二叉树是否为二叉查找树
 * @author hanjia
 *
 */
public class Problem7_TreeCheckBSTValid {

    public static boolean isValidBST(BinarySearchTreeNode root) {
        return isValidBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);    
    }
     
    public static boolean isValidBST(BinarySearchTreeNode p, double min, double max){
        if(p==null) 
            return true;
     
        if(p.value <= min || p.value >= max)
            return false;
     
        return isValidBST(p.left, min, p.value) && isValidBST(p.right, p.value, max);
    }
	
    public static boolean isValidBSTIterative(BinarySearchTreeNode root) { //In order traversal
        if (root == null) {
        	return true;
        }
        
        Stack<BinarySearchTreeNode> s = new Stack<BinarySearchTreeNode>();
        BinarySearchTreeNode current = root;        
        BinarySearchTreeNode pre = null;
        
        while(true) {
            while (current != null) {
                s.push(current);
                current = current.left;
            }          
            if (s.isEmpty()) {
                break;
            }
            
            current = s.pop();            
            if(pre != null && pre.value >= current.value) { // check the numbers are increasing
                return false;
            }            
            pre = current;
            current = current.right;
        }
        
        return true;
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
	     System.out.println(isValidBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE));
	     System.out.println(isValidBSTIterative(root));

	 }
}
