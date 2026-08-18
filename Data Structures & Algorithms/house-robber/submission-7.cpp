#include <algorithm>
#include <vector>

class Solution {
public:
  int rob(vector<int>& nums) {
    std::vector<int> values;
    values.reserve(nums.size());
    values[0] = nums[0];

    for (int i = 1; i < nums.size(); ++i) {
      if (i >= 2) {
        values[i] = std::max(values[i - 1], values[i - 2] + nums[i]);
        continue;
      }
      values[i] = std::max(values[0], nums[i]);
    }

    return values[nums.size() - 1];
  }
};
