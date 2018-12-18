/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 *
 */
public class 反转链表 {

    public static ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }  else {
            ListNode one = head;
            ListNode two = head.next;
            ListNode three = head.next.next;
            one.next = null;//初始化原来的头节点为 反转后的尾节点，置为null
            while (three != null) {
                two.next = one;
                one = two;
                two = three;
                three = three.next;
            }
            two.next = one;
            return two;
        }
    }

}


