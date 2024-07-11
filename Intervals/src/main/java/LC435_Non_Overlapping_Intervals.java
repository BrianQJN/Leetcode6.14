import java.util.Arrays;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-07-10
 */
public class LC435_Non_Overlapping_Intervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        // sort intervals based on end time
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        // initializations
        int nonOverlapping = 1;
        int end = intervals[0][1];

        // iterate through the sorted intervals
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                // cur interval doesn't overlap with the last selected interval
                nonOverlapping++;
                end = intervals[i][1];
            }
        }

        return intervals.length - nonOverlapping;
    }
}
