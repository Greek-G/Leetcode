import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        int low = 0;
        int high = 0;
        int res = 0;

        while (high < s.length()) {
            char right = s.charAt(high);
            freq.put(right, freq.getOrDefault(right, 0) + 1);


            while (freq.get(right) > 1) {
                char left = s.charAt(low);
                freq.put(left, freq.get(left) - 1);

                if (freq.get(left) == 0) {
                    freq.remove(left);
                }

                low++;
            }

            int len = high - low + 1;
            res = Math.max(res, len);

            high++;
        }

        return res;
    }
}