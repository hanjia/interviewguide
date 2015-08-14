package interviewguide.tree;
/**
 * User: haozhou
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

    public BinarySearchTreeNode addNode(int value) {
        BinarySearchTreeNode current = this;
        BinarySearchTreeNode parent = this;
        while (current != null) {
            parent = current;
            if (value == parent.value) {
                return null; // duplicate value;
            }
            if (value < parent.value) {
                current = parent.left;
            } else {
                current = parent.right;
            }
        }
        
        if (parent == null) {
            parent = new BinarySearchTreeNode(value);
        }else if (value < parent.value) {
            parent.left = new BinarySearchTreeNode(value);
            return parent.left;
        }else{
            parent.right = new BinarySearchTreeNode(value);
            return parent.right;
        }
        return null;
    }
}
