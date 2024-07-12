import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-07-12
 */
public class LC1851_Minimum_Interval_to_Include_Each_Query {
    public int[] minInterval(int[][] intervals, int[] queries) {
        // sort intervals by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // create a priority queue to store intervals, sorted by size
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (a[1] - a[0]) - (b[1] - b[0]));

        // create a sorted array of query indices
        int n = queries.length;
        int[][] indexQueries = new int[n][2];
        for (int i = 0; i < n; i++) {
            indexQueries[i] = new int[]{queries[i], i};
        }

        Arrays.sort(indexQueries, (a, b) -> a[0] - b[0]);

        int[] res = new int[n];
        Arrays.fill(res, -1);

        int i = 0;
        for (int[] query : indexQueries) {
            // add all the intervals start before or at query point
            while (i < intervals.length && intervals[i][0] <= query[0]) {
                queue.offer(intervals[i]);
                i++;
            }

            // remove all the intervals that end before query point
            while (!queue.isEmpty() && queue.peek()[1] < query[0]) {
                queue.poll();
            }

            res[query[1]] = queue.isEmpty() ? -1 : queue.peek()[1] - queue.peek()[0] + 1;
        }

        return res;
    }
}
