/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-06-19
 */
public class LC206_Reverse_Linked_List {
    public ListNode reverseList(ListNode head) {
        // initialize three pointers
        ListNode pre = null, cur = head, next = null;

        // traverse through the linked list
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        // update head
        head = pre;
        return head;
    }
}
