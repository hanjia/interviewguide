package interviewguide.tree;
/**
 * Author: haozhou, hanjia
 * Date: 8/13/12
 * Time: 8:23 PM
 */
public class BinarySearchTreeNode {
    int value;
    BinarySearchTreeNode left;
    BinarySearchTreeNode right;

    public BinarySearchTreeNode(int value) {
        this.value = value;
    }

    public BinarySearchTreeNode addNode(BinarySearchTreeNode root, int value) {
        BinarySearchTreeNode current = root;
        BinarySearchTreeNode parent = root;
        while (current != null) {
            parent = current;
            if (value == parent.value) {
                return root; // duplicate value;
            }else if (value < parent.value) {
                current = parent.left;
            } else {
                current = parent.right;
            }
        }
        
        if (value < parent.value) {
            parent.left = new BinarySearchTreeNode(value);
            return parent.left;
        }else{
            parent.right = new BinarySearchTreeNode(value);
            return parent.right;
        }
    }  
}
