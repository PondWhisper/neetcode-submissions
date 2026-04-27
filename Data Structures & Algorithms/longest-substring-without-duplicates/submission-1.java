
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if (length == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        List<Character> list = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (list.contains(c)) {
                max = Math.max(list.size(), max);
                while(true){
                    char x=list.removeFirst()   ;
                    if(x==c){
                        break;
                    }
                }
            }
            list.add(c);
        }
        max=Math.max(max, list.size());
        return max;

    }
}
