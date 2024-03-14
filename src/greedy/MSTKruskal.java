package greedy;

import java.util.*;

class MSTKruskal {
    static class Edge {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    static class DisjointSet {
        int[] parent;

        public DisjointSet(int n) {
            parent = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootX] = rootY;
            }
        }
    }

    public static int kruskalMST(List<Edge> edges, int n) {
        Collections.sort(edges, (a, b) -> a.weight - b.weight);
        DisjointSet ds = new DisjointSet(n);
        int minWeight = 0;

        for (Edge edge : edges) {
            int fromRoot = ds.find(edge.from);
            int toRoot = ds.find(edge.to);

            if (fromRoot != toRoot) {
                ds.union(fromRoot, toRoot);
                minWeight += edge.weight;
            }
        }

        return minWeight;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            int weight = scanner.nextInt();
            edges.add(new Edge(from, to, weight));
        }

        int minWeight = kruskalMST(edges, n);
        System.out.println(minWeight);
    }
}

