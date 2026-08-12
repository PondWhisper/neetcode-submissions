#include <unordered_map>
#include <vector>

using namespace std;

class Solution {
public:
  vector<vector<string>> groupAnagrams(vector<string>& strs) {
    unordered_map<string, vector<string>> indices;
    for (int i = 0; i < strs.size(); ++i) {
      string tmp = strs[i];
      sort(tmp.begin(), tmp.end());
      indices[tmp].push_back(strs[i]);
    }

    vector<vector<string>> res;
    for (auto& p : indices) {
      res.push_back(p.second);
    }

    return res;
  }
};
