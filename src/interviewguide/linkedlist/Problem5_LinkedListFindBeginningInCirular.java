package interviewguide.linkedlist;

public class Problem5_LinkedListFindBeginningInCirular {
    public static Node findBeginning(Node head) {
        Node p1 = head;
        Node p2 = head;

        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
               break;
            }
        }
        // no meeting point and therefore no loop
        if (p2.next == null) {
            return null;
        }
        p1 = head;
        while (p1 != p2) {
            p1=p1.next;
            p2=p2.next.next;
        }
        return p2;
    }
    
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // 1->2->3->4->5->3
        head.next.next.next.next.next = head.next.next;
        Node c = findBeginning(head.next);
        System.out.println(c);
    }

}
