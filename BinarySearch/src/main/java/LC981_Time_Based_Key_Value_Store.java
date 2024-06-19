import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-06-19
 */
public class LC981_Time_Based_Key_Value_Store {
    private Map<String, List<Pair>> map;

    public LC981_Time_Based_Key_Value_Store() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        List<Pair> valList = map.get(key);
        // binary search to find the timestamp
        int left = 0, right = valList.size() - 1;
        int mid;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (valList.get(mid).timestamp <= timestamp) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (right == -1) {
            return "";
        }

        return valList.get(right).value;
    }

    private static class Pair {
        int timestamp;
        String value;

        Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }
}
