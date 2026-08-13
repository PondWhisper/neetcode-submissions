#include <vector>

class Solution {
public:
  vector<int> productExceptSelf(vector<int>& nums) {
    int size = nums.size();
    std::vector<int> reverseNums, normalNums;
    reverseNums.reserve(size);
    normalNums.reserve(size);

    int multiper = 1;
    int reverseMulti = 1;
    for (int i = 0; i < size; ++i) {
      multiper *= nums[i];
      normalNums[i] = multiper;

      reverseMulti *= nums[size - 1 - i];
      reverseNums[size - 1 - i] = reverseMulti;
    }

    std::vector<int> res;
    res.reserve(size);
    res.push_back(reverseNums[1]);
    for (int i = 1; i < size - 1; ++i) {
      res.push_back(normalNums[i - 1] * reverseNums[i + 1]);
    }
    res.push_back(normalNums[size - 2]);

    return res;
  }
};
