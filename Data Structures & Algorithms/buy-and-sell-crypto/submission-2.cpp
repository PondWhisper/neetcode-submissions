#include <algorithm>
#include <stack>
#include <vector>

class Solution {
public:
  int maxProfit(vector<int>& prices) {
    std::stack<int> diffContainer;

    int res = 0;
    for (int price : prices) {
      if (diffContainer.empty()) {
        diffContainer.push(price);
        continue;
      }

      int topValue = diffContainer.top();

      if (price > topValue) {
        res = std::max(res, price - topValue);
      } else if (price < topValue) {
        diffContainer.push(price);
      }
    }

    return res;
  }
};
