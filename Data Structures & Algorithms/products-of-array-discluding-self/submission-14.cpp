#include <vector>

class Solution {
public:
  vector<int> productExceptSelf(vector<int>& nums) {
    int size = nums.size();
    std::vector<int> pre(size);
    std::vector<int> suff(size);
    std::vector<int> res(size);

    pre[0] = 1, suff[size - 1] = 1;
    for (int i = 1; i < size; ++i) {
      pre[i] = pre[i - 1] * nums[i - 1];
    }

    for (int i = size - 2; i >= 0; --i) {
      suff[i] = suff[i + 1] * nums[i + 1];
    }

    for (int i = 0; i < size; ++i) {
      res[i] = pre[i] * suff[i];
    }

    return res;
  }
};
