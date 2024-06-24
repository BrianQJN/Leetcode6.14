/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-06-24
 */
public class LC25_Reverse_Nodes_in_K_Group {
    public ListNode reverseKGroup(ListNode head, int k) {
        // create dummy node
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode cur = dummy, next = dummy, prev = dummy;
        int count = 0;

        // count the nodes in list
        while (cur.next != null) {
            cur = cur.next;
            count++;
        }

        // loop for each k group
        while (count >= k) {
            cur = prev.next;
            next = cur.next;

            // reverse the nodes within a group
            for (int i = 1; i < k; i++) {
                cur.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = cur.next;
            }

            // move to next group
            count -= k;
            prev = cur;
        }
    }
}
