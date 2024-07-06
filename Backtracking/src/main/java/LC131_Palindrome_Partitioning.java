import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-07-06
 */
public class LC131_Palindrome_Partitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), s, 0);
        return res;
    }

    private void backtrack(List<List<String>> res, List<String> curPartition, String s, int start) {
        // if we reached the end of the string, found a valid partition
        if (start == s.length()) {
            res.add(new ArrayList<>(curPartition));
            return;
        }

        // try all possible substrings starting from start
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                // add cur palindrome substring to the partition
                curPartition.add(s.substring(start, end + 1));
                // recursively partition the rest of the string
                backtrack(res, curPartition, s, end + 1);
                // backtrack: remove the cur substring to try other partitions
                curPartition.remove(curPartition.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
