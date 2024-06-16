/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-06-16
 */
public class LC42_Trapping_Rain_Water {
    public int trap(int[] height) {
        // initialize left max and right max
        int n = height.length;
        int totalWater = 0;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = 0;
        rightMax[n - 1] = 0;

        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i-1]);
        }

        for (int j = n - 2; j >= 0; j--) {
            rightMax[j] = Math.max(rightMax[j+1], height[j+1]);
        }

        // calculate the water trapped at each position
        for (int i = 0; i < n; i++) {
            int min = Math.min(leftMax[i], rightMax[i]);
            if (min - height[i] >= 0) {
                totalWater += min - height[i];
            }
        }

        return totalWater;
    }

    public int trap2(int[] height) {
        // initialize two pointers and two max records
        int n = height.length;
        int left = 0, right = n - 1;
        int totalWater = 0;
        int leftMax = 0;
        int rightMax = 0;

        while (left < right) {
            if (height[left] <= height[right]) {
                rightMax = Math.max(rightMax, height[right]);
                int min = Math.min(leftMax, rightMax);
                if (min - height[left] >= 0) {
                    totalWater += min - height[left];
                }
                leftMax = Math.max(leftMax, height[left]);
                left++;
            } else {
                leftMax = Math.max(leftMax, height[left]);
                int min = Math.min(leftMax, rightMax);
                if (min - height[right] >= 0) {
                    totalWater += min - height[right];
                }
                rightMax = Math.max(rightMax, height[right]);
                right--;
            }
        }

        return totalWater;
    }
}
