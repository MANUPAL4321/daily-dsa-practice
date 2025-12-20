import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite {

    public static boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];

        for (int i = 0; i < n; i++) {
            if (color[i] != 0) continue;

            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            color[i] = 1;

            while (!queue.isEmpty()) {
                int node = queue.poll();

                for (int neighbor : graph[node]) {
                    if (color[neighbor] == 0) {
                        color[neighbor] = -color[node];
                        queue.offer(neighbor);
                    } else if (color[neighbor] == color[node]) {
                        return false; 
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = {
            {1, 3},
            {0, 2},
            {1, 3},
            {0, 2}
        };

        System.out.println("Is Graph Bipartite? " + isBipartite(graph));
    }
}
