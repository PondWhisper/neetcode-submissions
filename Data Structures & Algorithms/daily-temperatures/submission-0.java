
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Deque<int[]> stack = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            int currTem = temperatures[i];
            while (!stack.isEmpty() && currTem > stack.peek()[0]) {
                int[] curr=stack.pop();
                res[curr[1]] = i - curr[1];
            }
            stack.push(new int[]{currTem, i});
        }
        return res;

    }
}
