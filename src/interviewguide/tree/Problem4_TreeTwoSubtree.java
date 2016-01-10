package interviewguide.tree;

public class Problem4_TreeTwoSubtree {
   public boolean areTwoTreesEqual(BinarySearchTreeNode node1, BinarySearchTreeNode node2) {
       if (node1 == null && node2 == null) {
           return true;
       }

       if (node1 == null || node2 == null) {
           return false;
       }

       return (node1.value == node2.value && areTwoTreesEqual(node1.left, node2.left) && areTwoTreesEqual(node1.right, node2.right));
   }

   public boolean isSubtree(BinarySearchTreeNode main, BinarySearchTreeNode subtree) {
       if (subtree == null) {
           return true;
       }

       if (main == null) {
           return false;
       }

       if (areTwoTreesEqual(main, subtree)) {
           return true;
       }

       return isSubtree(main.left, subtree) || isSubtree(main.right, subtree);
   }
}
