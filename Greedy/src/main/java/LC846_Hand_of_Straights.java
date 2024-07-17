import java.util.TreeMap;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-07-16
 */
public class LC846_Hand_of_Straights {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        TreeMap<Integer, Integer> cardCounts = new TreeMap<>();

        // count the frequency
        for (int card : hand) {
            cardCounts.put(card, cardCounts.getOrDefault(card, 0) + 1);
        }

        while (!cardCounts.isEmpty()) {
            int firstCard = cardCounts.firstKey();

            // check if we can form a group of size groupSize
            for (int i = 0; i < groupSize; i++) {
                int curCard = firstCard + i;
                if (!cardCounts.containsKey(curCard)) {
                    return false;
                }

                cardCounts.put(curCard, cardCounts.get(curCard) - 1);
                if (cardCounts.get(curCard) == 0) {
                    cardCounts.remove(curCard);
                }
            }
        }

        return true;
    }
}
