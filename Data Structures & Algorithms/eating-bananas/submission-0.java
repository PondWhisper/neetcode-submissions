class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, piles[i]);
        }


        int res = 0;
        int l = 1;
        while (l <= max) {
            int mid = l + (max - l) / 2;
            int curr = 0;
            for (int i = 0; i < n; i++) {
                int division = piles[i] / mid;
                curr += piles[i] % mid != 0 ? division + 1 : division;
            }
            if (curr <= h) {
                max = mid - 1;
                res = mid;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }
}
