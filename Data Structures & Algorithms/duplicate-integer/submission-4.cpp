
class Solution {
public:
  bool hasDuplicate(vector<int>& nums) {
    set<int> duplicate;
    for (const int& num : nums) {
      if (duplicate.count(num)) {
        return true;
      }

      duplicate.insert(num);
    }
    return false;
  }
};