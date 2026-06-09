

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int fastPointer = 0;
        int slowPointer = 0;
        int maxLength = 0;
        Set<Character> set = new HashSet<>();

        while (fastPointer < s.length()) {
            if (!set.contains(s.charAt(fastPointer))) {
                set.add(s.charAt(fastPointer));
            } else {
                while (s.charAt(slowPointer) != s.charAt(fastPointer)) {
                    set.remove(s.charAt(slowPointer));
                    slowPointer++;
                }
                slowPointer++;
            }
            maxLength = Math.max(maxLength, (fastPointer - slowPointer + 1));

            fastPointer++;
        }
       
        return maxLength;
    }
}
