/**
 * User: haozhou
 * Date: 8/11/12
 * Time: 11:54 PM
 */
public class MyQueue {
    HStack s1;
    HStack s2;

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
