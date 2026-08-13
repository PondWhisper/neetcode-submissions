class Solution {
public:
  int maxProfit(vector<int>& prices) {
    int minbuy = prices[0];
    int maxP = 0;

    for (int sell : prices) {
      maxP = std::max(sell - minbuy, maxP);
      minbuy = std::min(sell, minbuy);
    }

    return maxP;
  }
};
