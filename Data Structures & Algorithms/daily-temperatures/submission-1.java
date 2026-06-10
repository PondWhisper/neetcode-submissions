

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Deque<int[]> stack = new LinkedList<>();

        for (int i = 0; i < temperatures.length; i++) {
            int current = temperatures[i];
            while (!stack.isEmpty() && current > stack.peek()[0]) {
                int[] a = stack.pop();
                res[a[1]] = i - a[1];
            }
            stack.push(new int[]{current, i});
        }
        return res;
    }
}
