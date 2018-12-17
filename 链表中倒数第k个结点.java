/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */

public class 链表中倒数第k个结点 {

    public static ListNode FindKthToTail(ListNode head,int k) {
        if (head == null) return null;
        int length = 0;
        ListNode curr1 = head;
        while (curr1 != null) {
            length ++;
            curr1 = curr1.next;
        }
        int kk = length - k;
        if (kk < 0) return null;
        ListNode cur = head;
        for (int i = 1; head != null && i <= kk; i++) {
            cur = cur.next;
        }
        return cur;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}