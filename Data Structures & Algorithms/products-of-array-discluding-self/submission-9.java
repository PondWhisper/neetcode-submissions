

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];

        res[0] = nums[0];
        for (int i = 1; i < length; i++) {
            res[i] = res[i - 1] * nums[i];
        }

        int post = 1;
        for (int i = length - 1; i > 0; i--) {
            res[i]=res[i-1]*post;
            post*=nums[i];
        }
        res[0]=post;
        
        return res;
    }
}
