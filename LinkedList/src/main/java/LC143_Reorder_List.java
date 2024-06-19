/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-06-19
 */
public class LC143_Reorder_List {
    public void reorderList(ListNode head) {
        // step 1: find the middle of the linked list
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // step 2: reverse the second half
        ListNode prev = null, cur = slow, next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        // step 3: merge the two halves
        ListNode first = head, second = prev;
        while (second.next != null) {
            next = first.next;
            first.next = second;
            first = next;

            next = second.next;
            second.next = first;
            second = next;
        }
    }
}
