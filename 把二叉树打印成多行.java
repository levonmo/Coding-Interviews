import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class 把二叉树打印成多行 {
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        if (pRoot == null) return new ArrayList<ArrayList<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        queue.offer(pRoot);
        int count = 0;
        int nextCount = 1;
        ArrayList<Integer> list = new ArrayList<Integer>();
        //是否为反过来打印
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            list.add(poll.val);
            if (poll.left != null) queue.offer(poll.left);
            if (poll.right != null) queue.offer(poll.right);
            count++;
            if (count == nextCount) {
                lists.add(list);
                list = new ArrayList<Integer>();
                nextCount = queue.size();
                count = 0;
            }
        }
        return lists;
    }
}
