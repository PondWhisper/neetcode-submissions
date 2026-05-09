class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int res = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int currMid = nums[mid];
            if (currMid == target) {
                res = mid;
            }
            if (currMid >= nums[l]) {
                if (target >= nums[l] && target <= currMid) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else if (currMid <= nums[r]) {
                if (target >= currMid && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return res;
    }
}
