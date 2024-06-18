import java.util.Arrays;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-06-18
 */
public class LC875_KoKo_Eating_Bananas {
    public int minEatingSpeed(int[] piles, int h) {
        // initialize two pointers
        int left = 1;
        int right = getMaxSpeed(piles);
        int mid;

        // shrink the interval
        while (left < right) {
            mid = left + (right - left) / 2;

            // determine if koko can eat all or not
            if (canFinish(piles, h, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private int getMaxSpeed(int[] piles) {
        // helper func to find max eating speed
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        return max;
    }

    private boolean canFinish(int[] piles, int h, int speed) {
        // helper func to determine if koko can eat all on time or not
        int totalTime = 0;
        for (int pile : piles) {
            totalTime += (pile + speed - 1) / speed;
        }

        return totalTime <= h;
    }
}
