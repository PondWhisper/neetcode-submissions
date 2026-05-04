
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                list.add(matrix[i][j]);
            }
        }
        int index = Arrays.binarySearch(list.toArray(), target);
        return index >= 0;
    }
}
