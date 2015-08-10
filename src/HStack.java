import interviewguide.linkedlist.Node;

/**
 * User: haozhou
 * Date: 8/11/12
 * Time: 11:26 PM
 */
public class HStack {
    Node head;
    int size;

    public void push(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    public int size() {
        return this.size;
    }

    public int pop() {
        int value = head.value;
        head = head.next;
        size--;
        return value;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int peek() {
        return head.value;
    }
}
