import java.util.Arrays;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-05-19
 */
public class LC912_Sort_an_Array {
    /**
     * @param nums an array of integers
     * @return int[] - the sorted array
     * @implSpec Given an array of integers nums, sort the array in ascending order and return it.
     * You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest space complexity possible.
     * @author Brian Qu
     * @since 2024-05-19 19:18
     */
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        // call the merge sort function
        mergeSort(nums, 0, nums.length - 1);

        return nums;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left < right) {
            // find the middle point
            int mid = left + (right - left) / 2;
            // recursively sort the first half
            mergeSort(nums, left, mid);
            // recursively sort the second half
            mergeSort(nums, mid + 1, right);
            // merge the sorted halves
            merge(nums, left, mid, right);
        }
    }

    private void merge(int[] nums, int left, int mid, int right) {
        // calculate lengths of the two halves
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // create temporary arrays to hold the two halves
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // copy data to temp arrays
        for (int i = 0; i < n1; ++i) {
            leftArray[i] = nums[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            rightArray[j] = nums[mid + 1 + j];
        }

        // merge the temp arrays back into the original array

        // initial indexes of the first and second halves
        int i = 0, j = 0;

        // initial index of the merged array
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                nums[k] = leftArray[i];
                i++;
            } else {
                nums[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // copy the remaining elements of leftArray, if any
        while (i < n1) {
            nums[k] = leftArray[i];
            i++;
            k++;
        }

        // copy the remaining elements of rightArray, if any
        while (j < n2) {
            nums[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
