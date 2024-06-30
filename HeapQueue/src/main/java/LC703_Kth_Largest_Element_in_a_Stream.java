import java.util.PriorityQueue;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-06-29
 */
public class LC703_Kth_Largest_Element_in_a_Stream {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public LC703_Kth_Largest_Element_in_a_Stream(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>(k);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.offer(val);
        } else if (val > minHeap.peek()) {
            minHeap.poll();
            minHeap.offer(val);
        }

        return minHeap.peek();
    }
}
