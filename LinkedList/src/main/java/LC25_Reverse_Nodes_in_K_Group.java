/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-06-24
 */
public class LC25_Reverse_Nodes_in_K_Group {
    public ListNode reverseKGroup(ListNode head, int k) {
        // calculate the length of the list
        int len = 0;
        ListNode current = head;
        while (current != null) {
            len++;
            current = current.next;
        }

        // create dummy node to handle edge cases
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy, cur = dummy, next = dummy;

        // loop for each node group
        while (len >= k) {
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
            len -= k;
            prev = cur;
        }

        return dummy.next;
    }
}
