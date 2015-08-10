package interviewguide.linkedlist;

public class Problem4_LinkedListAddTwoNumbers {
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
    
    public static void main(String[] args) {
        Node n1 = new Node(3);
        n1.next = new Node(1);
        n1.next.next = new Node(5);

        Node n2 = new Node(5);
        n2.next = new Node(9);
        n2.next.next = new Node(2);

        Node c = addList(n1, n2, 0);
        System.out.println(c);
        System.out.println(c.next);
        System.out.println(c.next.next);
    }
}
