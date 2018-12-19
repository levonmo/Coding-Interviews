import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 中序遍历非递归版本 {

    //二叉树的四种遍历方式，递归
    public static void pre(Node root) {
        if (root == null) {
            return;
        } else {
            System.out.print(root.val + ",");
        }
        pre(root.left);
        pre(root.rigth);
    }
    public static void after(Node root) {
        if (root == null) return;
        after(root.left);
        after(root.rigth);
        System.out.print(root.val + ",");
    }
    public static void zhong(Node root) {
        if (root == null) return;
        zhong(root.left);
        System.out.print(root.val + ",");
        zhong(root.rigth);
    }
    //用一个队列
    public static void ceng(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            System.out.print(poll.val + ",");
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.rigth != null) {
                queue.offer(poll.rigth);
            }
        }
    }

}

class Node {
    Node left;
    Node rigth;
    int val;

    public Node(int val) {
        this.val = val;
    }
}

