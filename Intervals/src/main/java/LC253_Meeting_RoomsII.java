import java.util.Arrays;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-07-10
 */
public class LC253_Meeting_RoomsII {
    public int minMeetingRooms(int[][] intervals) {
        // separate start and end time
        int n = intervals.length;
        int[] startTimes = new int[n];
        int[] endTimes = new int[n];

        for (int i = 0; i < n; i++) {
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }

        // sort start times and end times
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int roomsOccupied = 0;
        int endIdx = 0;

        // process all start times
        for (int startTime : startTimes) {
            if (startTime >= endTimes[endIdx]) {
                roomsOccupied--;
                endIdx++;
            }

            roomsOccupied++;
        }

        return roomsOccupied;
    }
}
