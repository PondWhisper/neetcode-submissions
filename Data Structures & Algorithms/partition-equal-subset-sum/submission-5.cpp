class Solution {
public:
  bool canPartition(vector<int>& nums) {
    int n = nums.size();
    int total = sum(nums) / 2;

    if (sum(nums) % 2 != 0) {
      return false;
    }

    std::vector<bool> dp(total + 1, false);
    dp[0] = true;
    for (int i = 0; i < n; ++i) {
      for (int j = total; j >= nums[i]; j--) {
        dp[j] = dp[j] || dp[j - nums[i]];
      }
    }

    return dp[total];
  }

private:
  int sum(vector<int>& nums) {
    int tmp = 0;
    for (int num : nums) {
      tmp += num;
    }

    return tmp;
  }
};
