import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    public static int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.add(new int[]{r, c, 0});
                } else if (grid[r][c] == 1) {
                    fresh++;
                }
            }
        }

        int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        int time = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1], t = curr[2];

            time = Math.max(time, t);

            for (int[] d : directions) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2; 
                    fresh--;
                    queue.add(new int[]{nr, nc, t + 1});
                }
            }
        }

        return fresh == 0 ? time : -1;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };

        System.out.println("Minimum time to rot all oranges: " + orangesRotting(grid));
    }
}
