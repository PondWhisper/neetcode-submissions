#include <algorithm>
#include <string>
#include <unordered_map>
#include <utility>
#include <vector>

class Solution {
public:
  std::vector<std::vector<std::string>>
  groupAnagrams(const std::vector<std::string>& strs) {
    std::unordered_map<std::string, std::vector<std::string>> groups;
    groups.reserve(strs.size());

    for (const auto& str : strs) {
      std::string key = str;
      std::sort(key.begin(), key.end());
      groups[key].push_back(str);
    }

    std::vector<std::vector<std::string>> result;
    result.reserve(groups.size());

    for (auto& entry : groups) {
      result.push_back(std::move(entry.second));
    }

    return result;
  }
};
