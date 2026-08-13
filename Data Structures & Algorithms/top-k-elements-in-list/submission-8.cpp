#include <queue>
#include <vector>
#include <functional>
#include <unordered_map>
#include <utility>

class Solution {
public:
  std::vector<int> topKFrequent(std::vector<int>& nums, int k) {
    std::unordered_map<int, int> indices;

    for (int num : nums) {
      indices[num]++;
    }

    using Entry=std::pair<int,int>;

    std::priority_queue<Entry, std::vector<Entry>, std::greater<Entry>> heap;

    for (const auto& entry : indices) {
      heap.emplace(entry.second, entry.first);
      if (heap.size() > k) {
        heap.pop();
      }
    }

    std::vector<int> res;
    res.reserve(k);

    while(!heap.empty()){
        res.push_back(heap.top().second);
        heap.pop();
    }

    return res;
  }
};
