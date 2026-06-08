

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] freq = new LinkedList[nums.length + 1];

        for (int i = 0; i < freq.length; i++) {
            freq[i] = new LinkedList<>();
        }

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());

        }

        int[] res = new int[k];
        int count = 0;
        for (int i = freq.length - 1; i > 0; i--) {
            for (int x : freq[i]) {
                res[count++] = x;
                if (count == k) {
                    return res;
                }
            }
        }
        return res;
    }
}
