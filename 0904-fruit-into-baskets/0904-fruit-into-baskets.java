import java.util.HashMap;

class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int low = 0;
        int high = 0;
        int res = 0;

        while (high < fruits.length) {
            // Add current fruit
            int rightFruit = fruits[high];
            freq.put(rightFruit, freq.getOrDefault(rightFruit, 0) + 1);

            // Shrink window if more than 2 fruit types
            while (freq.size() > 2) {
                int leftFruit = fruits[low];
                freq.put(leftFruit, freq.get(leftFruit) - 1);

                if (freq.get(leftFruit) == 0) {
                    freq.remove(leftFruit);
                }

                low++;
            }

            // Update answer
            int len = high - low + 1;
            res = Math.max(res, len);

            high++;
        }

        return res;
    }
}