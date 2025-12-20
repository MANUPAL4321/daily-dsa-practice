public class FloodFill {

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];

        if (originalColor == color) return image;

        dfs(image, sr, sc, originalColor, color);
        return image;
    }

    private static void dfs(int[][] image, int x, int y, int originalColor, int color) {
      
        if (x < 0 || x >= image.length || y < 0 || y >= image[0].length)
            return;
        if (image[x][y] != originalColor)
            return;
        image[x][y] = color;

        dfs(image, x + 1, y, originalColor, color);
        dfs(image, x - 1, y, originalColor, color);
        dfs(image, x, y + 1, originalColor, color);
        dfs(image, x, y - 1, originalColor, color);
    }

    public static void main(String[] args) {
        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };

        int sr = 1, sc = 1, color = 2;

        int[][] result = floodFill(image, sr, sc, color);

        System.out.println("Flood Fill Result:");
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
