import java.util.ArrayDeque;
import java.util.Stack;

/**
 * User: haozhou
 * Date: 8/13/12
 * Time: 8:32 PM
 */
public class TreeRelated {
    public static void main(String[] args) {
        /*
                       40
                     /   \
                   35     42
                   / \    / \
                 29  37  41  45
                 /  \
                23  30
        */

        BinarySearchTreeNode root = new BinarySearchTreeNode(40);
        BinarySearchTreeNode n1 = root.addNode(35);
        BinarySearchTreeNode n2 = root.addNode(42);
        BinarySearchTreeNode n3 = root.addNode(29);
        BinarySearchTreeNode n4 = root.addNode(37);
        BinarySearchTreeNode n5 = root.addNode(41);
        BinarySearchTreeNode n6 = root.addNode(45);
        BinarySearchTreeNode n7 = root.addNode(23);
        BinarySearchTreeNode n8;
        root.addNode(30);

        preOrder(root);
        System.out.println();

        preOrderNoRecursive(root);
        System.out.println();

        breadthFirstTraversal(root);

        System.out.println(isBalanced(root));

        System.out.println(findCommonAncestor(root, n7, n2));
        System.out.println(findCommonAncestorRecursive(root, n7, n2));

        System.out.println(findCommonAncestor(root, n5, n6));
        System.out.println(findCommonAncestorRecursive(root, n5, n6));
    }

    public static int getMaxDepth(BinarySearchTreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getMaxDepth(root.left), getMaxDepth(root.right));
    }

    public static int getMinDepth(BinarySearchTreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.min(getMinDepth(root.left), getMinDepth(root.right));
    }

    public static boolean isBalanced(BinarySearchTreeNode root) {
        return (getMaxDepth(root) - getMinDepth(root)) <= 1;
    }

    public static boolean isTreeEquals(BinarySearchTreeNode t1, BinarySearchTreeNode t2) {
        if (t1 == t2) {
            return true;
        }
        return (t1.value == t2.value) && isTreeEquals(t1.left, t2.left) && isTreeEquals(t1.right, t2.right);
    }

    public static void preOrder(BinarySearchTreeNode root) {
        if (root == null) {
            return;
        }
        visit(root);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void preOrderNoRecursive(BinarySearchTreeNode root) {
        Stack<BinarySearchTreeNode> s = new Stack();
        BinarySearchTreeNode node = null;
        s.push(root);
        while (!s.isEmpty()) {
            node = s.pop();
            visit(node);
            if (node.right != null) {
                s.push(node.right);
            }
            if (node.left != null) {
                s.push(node.left);
            }
        }
    }

    private static void visit(BinarySearchTreeNode node) {
        System.out.println(node.value);
    }

    public static void breadthFirstTraversal(BinarySearchTreeNode root) {
        ArrayDeque<BinarySearchTreeNode> queue = new ArrayDeque<BinarySearchTreeNode>();
        BinarySearchTreeNode node = null;
        queue.add(root);
        while (!queue.isEmpty()) {
            node = queue.remove();
            visit(node);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

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

}
