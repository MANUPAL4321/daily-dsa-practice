import java.util.ArrayList;
import java.util.List;

public class ConnectedComponents {

    private static void dfs(int node, List<List<Integer>> adj, boolean[] visited) {
        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited);
            }
        }
    }

    public static int countConnectedComponents(int n, List<List<Integer>> adj) {
        boolean[] visited = new boolean[n];
        int components = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited);
                components++; 
            }
        }
        return components;
    }

    public static void main(String[] args) {

        int n = 5;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(0).add(2);
        adj.get(2).add(0);

        adj.get(3).add(4);
        adj.get(4).add(3);

        System.out.println("Number of Connected Components: " +
                countConnectedComponents(n, adj));
    }
}
