class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        int[] tCount = new int[58];
        int[] sCount = new int[58];
        int start = 0;
        int min = Integer.MAX_VALUE;

        int count = 0;
        for (char c : t.toCharArray()) {
            tCount[c - 'A']++;
        }
        for (int j : tCount) {
            count += (j > 0) ? 1 : 0;
        }

        int matchCount = 0;
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            int index = s.charAt(r) - 'A';
            if (++sCount[index] == tCount[index] && tCount[index] != 0) {
                matchCount++;
            }
            index = s.charAt(l) - 'A';
            while (sCount[index] > tCount[index] || tCount[index] == 0) {
                sCount[index]--;
                if (l == r) {
                    break;
                }
                index = s.charAt(++l) - 'A';
            }
            if (matchCount == count) {
                int currLength = r - l + 1;
                if (currLength < min) {
                    min = currLength;
                    start =l;
                }
            }
        }
        return min ==Integer.MAX_VALUE?"":s.substring(start,start+min);
    }
}
