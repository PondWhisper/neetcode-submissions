
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;

        int l = 0, r = 0;
        for (; r < s.length(); r++) {
            char c = s.charAt(r);
            if (map.containsKey(c)) {
                l = Math.max(map.get(c) + 1, l);
            }
            map.put(c, r);
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}
