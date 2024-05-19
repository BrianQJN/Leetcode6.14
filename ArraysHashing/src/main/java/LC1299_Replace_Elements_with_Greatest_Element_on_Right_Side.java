/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-05-19
 */
public class LC1299_Replace_Elements_with_Greatest_Element_on_Right_Side {
    /**
     * @param arr an integer arr
     * @return int[] - replace every element in that array with the greatest element among the elements to its right
     * @implSpec Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.
     * After doing so, return the array.
     * @author Brian Qu
     * @since 2024-05-19 16:05
     */
    public int[] replaceElements(int[] arr) {
        int n = arr.length;

        // initialize a MaxRight to track max value seen so far
        int maxRight = -1;

        for (int i = n - 1; i >= 0; i--) {
            // store cur value temporarily
            int temp = arr[i];
            // replace cur value with maxRight
            arr[i] = maxRight;
            // update maxRight
            maxRight = Math.max(maxRight, temp);
        }

        return arr;
    }
}
