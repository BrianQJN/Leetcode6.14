/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-06-16
 */
public class LC125_Valid_Palindrome {
    public boolean isPalindrome(String s) {
        // convert to lowercase and remove non-alphanumeric chars
        StringBuilder filteredStr = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                filteredStr.append(Character.toLowerCase(c));
            }
        }

        // initialize two pointers to verify palindrome
        int left = 0, right = filteredStr.length() - 1;
        while (left < right) {
            if (filteredStr.charAt(left) != filteredStr.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
