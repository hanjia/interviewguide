package interviewguide.linkedlist;

/**
 * 查找链表中离尾部距离为n的元素
 * @author hanjia
 *
 */
public class Problem3_LinkedListFindElementNToRear {

	/*
	 * 解法：设置2个指针p1，p2均指向头部。将p2向后移动n-1步，则p1和p2的距离为n。
	 * 移动p2到尾部，则p1就是那个要找的元素。
	 */
	public static Node nToLastNode(Node head, int n){
		Node p1 = head;
		Node p2 = head;
		while (n > 0){
			p2 = p2.next;
			n--;
		}
		while(p2.next != null){
			p2 = p2.next;
			p1 = p1.next;
		}
		return p1;
	}
	
	public static void main(String[] args){
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        System.out.println(nToLastNode(head,2).value);
	}
	
}
