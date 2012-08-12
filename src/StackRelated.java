
/**
 * User: haozhou
 * Date: 8/11/12
 * Time: 11:34 PM
 */
public class StackRelated {

    public static void main(String[] args) {
        HStack s1 = new HStack();
        s1.push(1);
        s1.push(2);
        s1.push(3);
        s1.push(4);
        s1.push(5);

        reverseStack(s1);
        System.out.println(s1.pop());

        HStack s2 = new HStack();
        s2.push(4);
        s2.push(3);
        s2.push(1);
        s2.push(5);
        s2.push(2);

        HStack s3 = sort(s2);
        System.out.println(s3.pop());
        System.out.println(s3.pop());
        System.out.println(s3.pop());
        System.out.println(s3.pop());
        System.out.println(s3.pop());
    }

    public static void reverseStack(HStack stack) {
        if (!stack.isEmpty()) {
            int data = stack.pop();
            reverseStack(stack);
            insertAtBottom(stack, data);
        }
    }

    public static void insertAtBottom(HStack stack, int value) {
        if (stack.isEmpty()) {
            stack.push(value);
        } else{
            int data = stack.pop();
            insertAtBottom(stack, value);
            stack.push(data);
        }
    }

    public static HStack sort(HStack stack) {
        HStack r = new HStack();
        while (!stack.isEmpty()) {
            int tmp = stack.pop();
            while (!r.isEmpty() && r.peek() > tmp) {
                stack.push(r.pop());
            }
            r.push(tmp);
        }
        return r;
    }
}
