import java.util.HashMap;
class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int low = 0;
        int max = 0;
        for (int high = 0; high < fruits.length; high++) {
            // Add current fruit
            freq.put(fruits[high], freq.getOrDefault(fruits[high], 0) + 1);
            // Shrink window if more than 2 fruit types
            while (freq.size() > 2) {
                int leftFruit = fruits[low];
                freq.put(leftFruit, freq.get(leftFruit) - 1);
                if (freq.get(leftFruit) == 0) {
                    freq.remove(leftFruit);
                }
                low++;
            }
            // Update maximum window size
            max = Math.max(max, high - low + 1);
        }
        return max;
    }
}