package greedy;

import java.util.*;

public class MSTPrim {
    static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Node {
        int id;
        List<Edge> edges;

        public Node(int id) {
            this.id = id;
            this.edges = new ArrayList<>();
        }

        public void addEdge(int to, int weight) {
            edges.add(new Edge(to, weight));
        }
    }

    public static int primMST(List<Node> graph, int n) {
        boolean[] visited = new boolean[n + 1];
        int[] minWeight = new int[n + 1];
        Arrays.fill(minWeight, Integer.MAX_VALUE);

        minWeight[1] = 0;
        int totalWeight = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
        pq.offer(new Edge(1, 0));

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int u = edge.to;
            int weight = edge.weight;

            if (!visited[u]) {
                visited[u] = true;
                totalWeight += weight;

                for (Edge neighbor : graph.get(u).edges) {
                    int v = neighbor.to;
                    int w = neighbor.weight;
                    if (!visited[v] && w < minWeight[v]) {
                        minWeight[v] = w;
                        pq.offer(new Edge(v, w));
                    }
                }
            }
        }

        return totalWeight;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<Node> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new Node(i));
        }

        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int weight = scanner.nextInt();
            graph.get(u).addEdge(v, weight);
            graph.get(v).addEdge(u, weight);
        }

        int minWeight = primMST(graph, n);
        System.out.println(minWeight);
    }
}

