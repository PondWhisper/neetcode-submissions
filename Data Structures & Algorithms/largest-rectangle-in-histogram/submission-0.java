
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int area = Integer.MIN_VALUE;
        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || heights[i] < heights[stack.peek()])) {
                int height = heights[stack.pop()];
                int length = 0;
                if (stack.isEmpty()) {
                    length = i;
                } else {
                    length = i - stack.peek() - 1;
                }
                area = Math.max(area, height * length);
            }
            stack.push(i);
        }
        return area;
    }
}
