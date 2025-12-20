import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {

    public static int numEnclaves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 || i == rows - 1 || j == 0 || j == cols - 1) {
                    if (grid[i][j] == 1) {
                        queue.offer(new int[]{i, j});
                    }
                }
            }
        }

        int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];

            grid[r][c] = 0; 

            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                    grid[nr][nc] = 0;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {0, 0, 0, 0},
            {1, 0, 1, 0},
            {0, 1, 1, 0},
            {0, 0, 0, 0}
        };

        System.out.println("Number of Enclaves: " + numEnclaves(grid));
    }
}
