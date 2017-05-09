package rii.practice.graphs;

import java.util.HashMap;
import java.util.Map;

public class GraphWithNodes {

    Map<Integer, Node> nodes;

    public GraphWithNodes(int n) {
        nodes = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            nodes.put(i, new Node(i));
        }
    }

    public void addEdge(int x, int y, int length) {
        Node nx = nodes.get(x);
        if (nx != null)
            nx.addEdge(y, length);
    }

    class Node {
        int id;
        Map<Integer, Integer> edges;

        public Node(int id) {
            this.id = id;
            edges = new HashMap<>();
            edges.put(id, 0);
        }

        void addEdge(int toId, int length) {
            edges.computeIfPresent(toId, (key, oldVal) -> Integer.min(oldVal, length));
        }
    }
}

