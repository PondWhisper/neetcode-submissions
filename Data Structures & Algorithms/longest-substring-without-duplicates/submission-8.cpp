#include <string>
#include <unordered_set>

class Solution {
public:
  int lengthOfLongestSubstring(string s) {
    if (s.size() == 0) {
      return 0;
    }

    int left = 0, right = 0;
    std::unordered_set<char> alph_set;

    int maxLength = 0;
    while (right < s.size()) {

      while (alph_set.contains(s[right])) {
        alph_set.erase(s[left++]);
      }

      alph_set.insert(s[right++]);
      maxLength = std::max(maxLength, right - left);
    }

    return maxLength;
  }
};
