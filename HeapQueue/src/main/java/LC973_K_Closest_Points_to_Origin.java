import java.util.PriorityQueue;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-06-30
 */
public class LC973_K_Closest_Points_to_Origin {
    public int[][] kClosest(int[][] points, int k) {
        // initialization
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(k, (a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));

        // calculate
        for (int[] point : points) {
            maxHeap.add(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i] = maxHeap.poll();
        }

        return res;
    }
}
