import java.util.PriorityQueue;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-06-24
 */
public class LC23_Merge_K_Sorted_Lists {
    public ListNode mergeKLists(ListNode[] lists) {
        // initialize a queue to sort the node by value
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);

        // add the first node of each list to the queue
        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }

        // create a dummy head
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        // merge the nodes from the queue
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            cur.next = node;
            cur = cur.next;

            if (node.next != null) {
                queue.add(node.next);
            }
        }

        return dummy.next;
    }
}
