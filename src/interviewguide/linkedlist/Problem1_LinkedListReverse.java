package interviewguide.linkedlist;

/**
 * 给定一单链表 1->2->3->4，要求在`O(n)`时间复杂度内反转得到新的单链表 4->3->2->1
 * @author hanjia
 *
 */
public class Problem1_LinkedListReverse {
    public static Node reverse(Node head) {
        Node pre = null;
        Node next = null;
        Node current = head;
        while (current != null) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }
    
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        Node c = reverse(head);
        System.out.println(c.value);
        System.out.println(c.next.value);
    }
}
