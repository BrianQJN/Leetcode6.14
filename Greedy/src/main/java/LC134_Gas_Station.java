/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-07-15
 */
public class LC134_Gas_Station {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int surplus = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i] - cost[i];
            surplus += gas[i] - cost[i];

            if (surplus < 0) {
                surplus = 0;
                start = i + 1;
            }
        }

        return totalGas >= 0 ? start : -1;
    }
}
