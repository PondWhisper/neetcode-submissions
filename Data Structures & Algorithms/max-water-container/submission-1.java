class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int primePointer = 0;
        int lastPointer = heights.length - 1;

        while (lastPointer > primePointer) {
            int lastHeight = heights[lastPointer];
            int primeHeight = heights[primePointer];
            maxArea = Math.max(maxArea, (lastPointer - primePointer) * Math.min(lastHeight, primeHeight));

            if (primeHeight < lastHeight) {
                primePointer++;
            } else if (lastHeight < primeHeight) {
                lastPointer--;
            } else {
                primePointer++;
                lastPointer--;
            }
        }

        return maxArea;
    }
}
