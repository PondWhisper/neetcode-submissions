#include <algorithm>

class Solution {
public:
  int lengthOfLIS(vector<int>& nums) {
    int n = nums.size();
    std::vector<int> dp(n, 1);

    for (int i = n - 1; i >= 0; i--) {
      for (int j = i + 1; j < n; ++j) {
        if (nums[j] > nums[i]) {
          dp[i] = std::max(dp[i], dp[j] + 1);
        }
      }
    }

    return *std::max_element(dp.begin(),dp.end());
  }
};
