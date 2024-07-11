import java.util.Arrays;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-07-10
 */
public class LC252_Meeting_Rooms {
    public boolean canAttendMeetings(int[][] intervals) {
        // sort the intervals based on their start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // check for overlaps
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                // there is an overlap
                return false;
            }
        }

        return true;
    }
}
