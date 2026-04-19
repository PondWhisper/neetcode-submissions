
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Integer>> row = new HashMap<>();
        Map<Integer, Set<Integer>> column = new HashMap<>();
        Map<String, Set<Integer>> set = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                String newSet = (i / 3) + "," + (j / 3);
                Integer newNum = board[i][j] - '0';
                if (row.computeIfAbsent(i, k -> new HashSet<>()).contains(newNum) ||
                        column.computeIfAbsent(j, k -> new HashSet<>()).contains(newNum) ||
                        set.computeIfAbsent(newSet, k -> new HashSet<>()).contains(newNum)) {
                    return false;
                }

                row.get(i).add(newNum);
                column.get(j).add(newNum);
                set.get(newSet).add(newNum);
            }
        }
        return true;
    }
}