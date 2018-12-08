import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        Node node1= new Node("1");
        Node node2 = new Node("2");
        Node node3 = new Node("3");
        Node node4 = new Node("4");
        Node node5 = new Node("5");

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node3;

        Node node = node(node1);
        for (int i = 0; i < 100 && node != null; i++) {
            System.out.print(node.data);
            node = node.next;
        }

    }

    //如果存在环将环的入口节点返回
    public static Node node(Node node) {
        Node slow = node;
        Node fast = node;
        Node slow2 = node;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            //存在节点
            if (slow == fast) {
                while (slow != slow2) {
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }

    //使用两指针来判断是否存在环
    public static boolean isLoop(Node node) {
        Node slow = node;
        Node fast = node;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    //使用内存地址来判断是否存在环
    public static boolean isLoop2(Node node) {
        //set来存放对象的地址，如果存在两个相同
        HashSet<String> set = new HashSet<String>();
        Node cur = node;
        while (cur != null) {
            boolean add = set.add(cur.toString());
            if (!add) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }


}

class Node {
    Object data;
    Node next;


    public Node(Object val) {
        this.data = val;
    }

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}