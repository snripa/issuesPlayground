package rii.practice.graphs;

import java.util.*;

/**
 * Dijkstra: Shortest Reach 2
 */
public class Solution {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // t - number of test cases
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            // n - num of nodes in graph
            int n = in.nextInt();
            Graph graph = new Graph(n);
            // m - num of edges in graph
            int m = in.nextInt();
            for (int a1 = 0; a1 < m; a1++) {
                int x = in.nextInt();
                int y = in.nextInt();
                int r = in.nextInt();
                graph.addEdge(x, y, r);
            }
            int startPos = in.nextInt();
            Collection<Integer> shortestDistances = calcShortest(graph, startPos);
            for(int d : shortestDistances){
                System.out.print(d + " ");
            }
        }
    }

    private static Collection<Integer> calcShortest(Graph graph, int startPoint) {
        Map<Integer, Integer> distances = new DijkstraPath(graph).shortestPath(startPoint).distances;
        distances.remove(startPoint);
        for (Map.Entry<Integer, Integer> e : distances.entrySet())
            if (e.getValue() == Integer.MAX_VALUE) e.setValue(-1);
        return distances.values();

    }

    static class DijkstraPath {
        private final Graph graph;

        private Map<Integer, Integer> distances;
        private Set<Integer> unvisited;

        public DijkstraPath(Graph graph) {
            this.graph = graph;
        }

        public DijkstraPath shortestPath(int source) {
            unvisited = new HashSet<>();
            distances = new HashMap<>();
            for (Integer v : graph.vertices) {
                if (v == source) distances.put(v, 0);
                else distances.put(v, Integer.MAX_VALUE);
                unvisited.add(v);
            }

            while (!unvisited.isEmpty()) {
                // visit unvisited vtx with smallest known dst to source vtx
                int selectedVtx = 0;
                int smallestDistance = Integer.MAX_VALUE;
                for (Integer vtx : unvisited) {
                    int currDist = distances.get(vtx);
                    if (currDist < smallestDistance) {
                        smallestDistance = currDist;
                        selectedVtx = vtx;
                    }
                }
                //remove selected vtx from unvisited
                unvisited.remove(selectedVtx);

                for (Graph.Edge edge : graph.getEdges(selectedVtx)) {
                    if (unvisited.contains(edge.dst)) {
                        int newDistance = distances.get(selectedVtx) + edge.weight;
                        if (newDistance < distances.get(edge.dst)) {
                            distances.put(edge.dst, newDistance);
                        }
                    }
                }
            }
            return this;
        }
    }

    /**
     * Bidirectional Graph
     */
    static class Graph {
        private final Set<Integer> vertices;
        private Map<Integer, List<Edge>> edges;

        public Graph(int verticesNum) {
            this.vertices = new HashSet<>(verticesNum);
            edges = new HashMap<>();
        }

        public void addEdge(int src, int dst, int distance) {
            vertices.add(src);
            vertices.add(dst);

            List<Edge> edgesSrc = edges.getOrDefault(src, new ArrayList<>());
            edgesSrc.add(new Edge(dst, distance));
            edges.put(src, edgesSrc);

            List<Edge> edgesDst = edges.getOrDefault(dst, new ArrayList<>());
            edgesDst.add(new Edge(src, distance));
            edges.put(dst, edgesDst);

        }

        public List<Edge> getEdges(Integer vtx) {
            if (edges.containsKey(vtx)) return edges.get(vtx);
            else return new ArrayList<>();
        }

        public class Edge {
            int dst, weight;

            public Edge(int dst, int weight) {
                this.dst = dst;
                this.weight = weight;
            }
        }

    }
}