/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-06-19
 */
public class LC4_Median_of_Two_Sorted_Array {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // initialization, make sure num1 is the shorter array
        int m = nums1.length;
        int n = nums2.length;

        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int total = m + n;
        int half = (total + 1) / 2;

        int left = 0, right = m;
        double res = 0.0;

        while (left <= right) {
            int partition1 = left + (right - left) / 2;
            int partition2 = half - partition1;

            // get the four points around possible median
            int left1 = (partition1 > 0) ? nums1[partition1 - 1] : Integer.MIN_VALUE;
            int right1 = (partition1 < m) ? nums1[partition1] : Integer.MAX_VALUE;
            int left2 = (partition2 > 0) ? nums2[partition2 - 1] : Integer.MIN_VALUE;
            int right2 = (partition2 < n) ? nums2[partition2] : Integer.MAX_VALUE;

            // verify if partition is correct
            if (left1 <= right2 && left2 <= right1) {
                // correct partition, even case
                if (total % 2 == 0) {
                    res = (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                } else {
                    // odd case
                    res = Math.max(left1, left2);
                }
                return res;
            } else if (left1 > right2) {
                right =  partition1 - 1;
            } else {
                left = partition1 + 1;
            }
        }

        return res;
    }
}
