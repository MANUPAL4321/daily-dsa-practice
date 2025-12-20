import java.util.LinkedList;
import java.util.Queue;

public class UpdateMatrix01 {

    public static int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        // Multi-source BFS
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];

            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n && mat[nx][ny] == -1) {
                    mat[nx][ny] = mat[x][y] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        return mat;
    }

    public static void main(String[] args) {
        int[][] mat = {
            {0, 0, 0},
            {0, 1, 0},
            {1, 1, 1}
        };

        int[][] result = updateMatrix(mat);

        System.out.println("Updated Matrix:");
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
