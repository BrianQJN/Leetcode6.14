import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-06-17
 */
public class LC76_Minimum_Window_Substring {
    public String minWindow(String s, String t) {
        // create a frequency map for characters in t
        Map<Character, Integer> tFreqMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tFreqMap.put(c, tFreqMap.getOrDefault(c, 0) + 1);
        }

        // initialize sliding window and variables to track the result
        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        int start = 0;
        int required = tFreqMap.size();
        int formed = 0;

        // create a frequency map for cur window
        Map<Character, Integer> windowFreqMap = new HashMap<>();

        // move the window
        while (right < s.length()) {
            // include the char at right position into the window
            char curChar = s.charAt(right);
            windowFreqMap.put(curChar, windowFreqMap.getOrDefault(curChar, 0) + 1);

            // if the char's frequency in the cur window matches its frequency in t
            if (tFreqMap.containsKey(curChar) && windowFreqMap.get(curChar).intValue() == tFreqMap.get(curChar).intValue()) {
                formed++; // means the desirable char complete one more
            }

            // try to contract the window until it ceases to be desirable
            while (left <= right && formed == required) {
                curChar = s.charAt(left);

                // save the smallest window until now
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }

                // the char at the position left is no longer part of the window
                windowFreqMap.put(curChar, windowFreqMap.get(curChar) - 1);
                if (tFreqMap.containsKey(curChar) && windowFreqMap.get(curChar).intValue() < tFreqMap.get(curChar).intValue()) {
                    formed--;
                }

                // move the left pointer
                left++;
            }

            right++;
        }

        // return the minimum window or an empty string if no such window is found
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }
}
