

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length, col = matrix[0].length;
        int l = 0, r = row * col - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            int rth = m / col, cth = m % col;
            if (matrix[rth][cth] == target) {
                return true;
            } else if (matrix[rth][cth] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return false;
    }
}
