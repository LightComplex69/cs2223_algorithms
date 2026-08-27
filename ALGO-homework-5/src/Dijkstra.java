import java.util.*;

public class Dijkstra {
    private int[][] graph;
    private int[] dist, prev;
    private boolean[] visited;
    private int startNode, endNode;

    public void program() {
        Scanner scanner = new Scanner(System.in);

        graph = new int[][] {
                { 0, 54, 11, 13, 0, 0, 0, 0, 0, 0 },
                { 54, 0, 37, 0, 3, 0, 102, 0, 0, 0 },
                { 11, 37, 0, 10, 36, 19, 0, 0, 0, 0 },
                { 13, 0, 10, 0, 0, 18, 0, 0, 7, 0 },
                { 0, 3, 36, 0, 0, 15, 124, 123, 0, 0 },
                { 0, 0, 19, 18, 15, 0, 0, 138, 8, 0 },
                { 0, 102, 0, 0, 124, 0, 0, 9, 0, 72 },
                { 0, 0, 0, 0, 123, 138, 9, 0, 146, 67 },
                { 0, 0, 0, 7, 0, 8, 0, 146, 0, 213 },
                { 0, 0, 0, 0, 0, 0, 72, 67, 213, 0 }
        } ;


        System.out.print("Enter the start node (0 - 9): ");
        startNode = scanner.nextInt();

        System.out.print("Enter the end node (0 - 9): ");
        endNode = scanner.nextInt();

        dijkstra();
        returnShortestPath();
    }

    private void dijkstra() {
        dist = new int[graph.length];
        prev = new int[graph.length];
        visited = new boolean[graph.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(prev, -1);
        dist[startNode] = 0;

        for (int i = 0; i < graph.length; i++) {
            int u = getClosestUnvisitedNode();
            visited[u] = true;

            for (int v = 0; v < graph.length; v++) {
                if (!visited[v] && graph[u][v] != 0) {
                    int alt = dist[u] + graph[u][v];

                    if (alt < dist[v]) {
                        dist[v] = alt;
                        prev[v] = u;
                    }
                }
            }
        }
    }

    private int getClosestUnvisitedNode() {
        int minDist = Integer.MAX_VALUE;
        int closestNode = -1;

        for (int i = 0; i < dist.length; i++) {
            if (!visited[i] && dist[i] < minDist) {
                minDist = dist[i];
                closestNode = i;
            }
        }

        return closestNode;
    }

    private void returnShortestPath() {
        List<Integer> path = new ArrayList<>();
        int node = endNode;

        while (node != -1) {
            path.add(node);
            node = prev[node];
        }

        Collections.reverse(path);

        System.out.println("Shortest Path Length: " + dist[endNode]);
        System.out.println("Shortest Path: " + path);
    }

}
