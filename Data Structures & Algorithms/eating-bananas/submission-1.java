
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int r = Arrays.stream(piles).max().getAsInt();

        int res = 0;
        int l = 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            long curr = 0;
            for (int i = 0; i < n; i++) {
                curr += (piles[i] + mid - 1) / mid;
            }
            if (curr <= h) {
                r = mid - 1;
                res = mid;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }
}
