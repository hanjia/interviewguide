package interviewguide.linkedlist;

/**
 * 判断单链表是否存在环
 * @author hanjia
 *
 */
public class Problem2_LinkedListCircleExists {

	/*
	 * 解法：设置2个指针p1，p2均指向链表头部，p1每次向后移动一格，p2每次向后移动2格。如果p2 == p1则说明链表中存在环。
	 */
    public static boolean isCircular(Node head) {
        Node p1 = head;
        Node p2 = head;

        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;

            if (p1 == p2) {
                return true;
            }

        }
        return false;
    }
    
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        
        System.out.println(isCircular(head));
        head.next.next.next = head;
        System.out.println(isCircular(head));
    }
}
