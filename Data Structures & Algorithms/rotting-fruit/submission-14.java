
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }

        int time = 0;

        int[][] directions = {
                {1, 0},
                {0, -1},
                {0, 1},
                {-1, 0}
        };

        while (!q.isEmpty() && count > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] out = q.poll();
                for (int j = 0; j < directions.length; j++) {
                    int r = out[0] + directions[j][0];
                    int c = out[1] + directions[j][1];
                    if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1) {
                        q.offer(new int[]{r, c});
                        grid[r][c] = 2;
                        count--;
                    }
                }
            }
            time++;
        }

        return count == 0 ? time : -1;

    }
}
