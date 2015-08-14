package interviewguide.stackandqueue;
/**
 * Author: haozhou
 * Date: 8/11/12
 * Time: 11:54 PM
 */
public class Problem3_HStackToQueue {
    HStack s1;
    HStack s2;

    /*
     * 解法：栈和队列的区别在于访问策略，栈是FILO，队列是FIFO。
     * 假设有栈s1，s2，在读取元素的时候，第一次将s1所有元素出栈并压入s2，
     * 之后只要判断s2不为空则直接从s2 pop出第一个元素，当s2为空时重复s1出栈并压入s2的过程即可实现队列。
     */
    public void add(int value) {
        s1.push(value);
    }

    public int size() {
        return s1.size() + s2.size();
    }

    public int remove() {
        if (!s2.isEmpty()) {
            return s2.pop();
        }
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        return s2.pop();
    }
}
