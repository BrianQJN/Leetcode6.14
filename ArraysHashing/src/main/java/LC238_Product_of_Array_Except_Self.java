/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-06-16
 */
public class LC238_Product_of_Array_Except_Self {
    public int[] productExceptSelf(int[] nums) {
        // initialize two arrays to store left and right products
        int n = nums.length;
        int[] leftProducts = new int[n];
        int[] rightProducts = new int[n];

        // calculate the left products
        leftProducts[0] = 1;
        for (int i = 1; i < n; i++) {
            leftProducts[i] = leftProducts[i - 1] * nums[i - 1];
        }

        // calculate the right products
        rightProducts[n - 1] = 1;
        for (int j = n - 2; j >= 0; j--) {
            rightProducts[j] = rightProducts[j + 1] * nums[j + 1];
        }

        // combine the left and right products
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = leftProducts[i] * rightProducts[i];
        }

        return res;
    }

    public int[] productExceptSelf2(int[] nums) {
        int n = nums.length;

        int[] res = new int[n];

        res[0] = 1;
        // left products
        for (int i = 1; i < n; i++) {
            res[i] = res[i-1] * nums[i-1];
        }

        // right products
        int rightProduct = 1;
        for (int j = n - 1; j >= 0; j--) {
            res[j] = res[j] * rightProduct;
            rightProduct *= nums[j];
        }

        return res;
    }
}
