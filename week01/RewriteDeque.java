import java.util.Deque;
import java.util.LinkedList;

public class RewriteDeque {
    public static void main(String[] args) {
        // 示例代码 - Deque
        /*
        Deque<String> deque = new LinkedList<String>();
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        System.out.println(deque);

        String str = deque.peekFirst();
        System.out.println(str);
        System.out.println(deque);

        while(deque.size() > 0) {
            System.out.println(deque.removeFirst());
        }
        System.out.println(deque);
        */

        // 用新的API改写后
        Deque<String> deque = new LinkedList<String>();
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        System.out.println(deque);

        String str = deque.peekFirst();
        System.out.println(str);
        System.out.println(deque);

        while(deque.size() > 0) {
            System.out.println(deque.removeFirst());
        }
        System.out.println(deque);
    }
}

