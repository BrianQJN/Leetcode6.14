/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-06-18
 */
public class LC74_Search_a_2D_Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        // initialize two pointers and two intermediate variables
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;
        int mid, midValue;

        // shrink the interval
        while (left <= right) {
            // map the 1D to 2D matrix
            mid = left + (right - left) / 2;
            midValue = matrix[mid / n][mid % n];

            // comparison
            if (midValue == target) {
                return true;
            } else if (midValue > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }
}
