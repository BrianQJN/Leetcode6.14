/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-07-17
 */
public class LC1899_Merge_Triplets_to_Form_Target_Triplet {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] canAchieve = new boolean[3];

        for (int[] triplet : triplets) {
            if (triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] <= target[2]) {
                canAchieve[0] |= (triplet[0] == target[0]);
                canAchieve[1] |= (triplet[1] == target[1]);
                canAchieve[2] |= (triplet[2] == target[2]);
            }
        }

        return canAchieve[0] && canAchieve[1] && canAchieve[2];
    }
}
