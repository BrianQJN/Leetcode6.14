/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-06-16
 */
public class LC11_Container_With_Most_Water {
    public int maxArea(int[] height) {
        // initialize two pointers
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        // iterate through the array height
        while (left < right) {
            // calculate the cur area and update max area
            int curHeight = Math.min(height[left], height[right]);
            int curLength = right - left;

            maxArea = Math.max(maxArea, curHeight * curLength);

            // move the two pointers, since the curHeight is influenced by the shorter one
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
