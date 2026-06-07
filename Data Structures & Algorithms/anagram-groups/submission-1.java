

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] tmp = new int[26];
            for (int j = 0; j < str.length(); j++) {
                tmp[str.charAt(j) - 'a']++;
            }
            String tmpString = Arrays.toString(tmp);
            map.computeIfAbsent(tmpString, k -> new LinkedList<>()).add(str);
        }

        List<List<String>> res = new LinkedList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }
}
