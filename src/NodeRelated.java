/**
 * User: haozhou
 * Date: 8/11/12
 * Time: 5:40 PM
 */
public class NodeRelated {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

//        Node c = reverse(head);
//        System.out.println(c.value);
//        System.out.println(c.next.value);

//        System.out.println(isCircular(head));
//        head.next.next.next = head;
//        System.out.println(isCircular(head));

        Node n1 = new Node(3);
        n1.next = new Node(1);
        n1.next.next = new Node(5);

        Node n2 = new Node(5);
        n2.next = new Node(9);
        n2.next.next = new Node(2);

        Node c = addList(n1, n2, 0);
//        System.out.println(c);

        // 1->2->3->4->5->3
        head.next.next.next.next.next = head.next.next;
        c = findBeginning(head.next);
        System.out.println(c);
    }

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

    public static Node addList(Node n1, Node n2, int carry) {
        if (n1 == null && n2 == null) {
            return null;
        }
        Node result = new Node(carry);
        int value = carry;
        if (n1 != null) {
            value += n1.value;
        }
        if (n2 != null) {
            value += n2.value;
        }
        result.value = value % 10;
        Node more = addList(n1 == null ? null : n1.next, n2 == null ? null : n2.next, value >= 10 ? 1 : 0);
        result.next = more;
        return result;
    }

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
}
