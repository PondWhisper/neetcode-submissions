class Solution {
    public int maxProfit(int[] prices) {
        int start=prices[0];
        int length=prices.length;
        int maxDiff=0;

        for (int i = 0; i < length; i++) {
            int currValue=prices[i];
            start=Math.min(start, currValue);
            maxDiff=Math.max(maxDiff, currValue-start);
        }
        return maxDiff;

    }
}
