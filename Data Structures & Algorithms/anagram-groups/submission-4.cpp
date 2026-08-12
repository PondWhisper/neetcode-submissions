#include <unordered_map>
#include <vector>

using namespace std;
class Solution {
public:
  vector<vector<string>> groupAnagrams(vector<string>& strs) {
    std::unordered_map<string, vector<string>> mp;

    for (const string& str : strs) {
      int tmpVector[26] = {};
      for (const char& c : str) {
        tmpVector[c - 'a']++;
      }

      string key;
      for (int i = 0; i < 26; ++i) {
        key += "#" + to_string(tmpVector[i]);
      }

      mp[key].push_back(str);
    }

    vector<vector<string>> res;
    for (auto& p : mp) {
      res.push_back(p.second);
    }

    return res;
  }
};
