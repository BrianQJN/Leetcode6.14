import java.util.PriorityQueue;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-06-30
 */
public class LC215_Kth_Largest_Element_in_an_Array {
    public int findKthLargest(int[] nums, int k) {
        // initialization
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);

        // add all elements to maxHeap
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }
}
