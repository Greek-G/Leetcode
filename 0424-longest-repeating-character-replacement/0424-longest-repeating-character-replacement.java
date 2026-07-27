class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> freq = new HashMap<>();
        int low = 0;
        int maxFreq = 0;
        int res = 0;
        for (int high = 0; high < s.length(); high++) {
            char right = s.charAt(high);
            freq.put(right, freq.getOrDefault(right, 0) + 1);
            maxFreq = Math.max(maxFreq, freq.get(right));
            while ((high - low + 1) - maxFreq > k) {
                char left = s.charAt(low);
                freq.put(left, freq.get(left) - 1);
                low++;
            }
            res = Math.max(res, high - low + 1);
        }
        return res;
    }
}