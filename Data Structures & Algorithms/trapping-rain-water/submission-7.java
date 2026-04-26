

class Solution {
    public int trap(int[] height) {
        int length = height.length;
        if (length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int res=0;

        for (int i = 0; i < length; i++) {
            while(!stack.isEmpty()&&height[i]>=height[stack.peek()]){
                int mid=stack.pop();
                if(!stack.isEmpty()){
                  int h=Math.min(height[i], height[stack.peek()])-height[mid];
                  int l=i-stack.peek()-1;
                  res+=h*l;
                }
            }
            stack.push(i);
        }
        return res;
    }
}
