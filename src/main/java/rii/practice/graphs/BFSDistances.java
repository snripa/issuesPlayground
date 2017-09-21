package rii.practice.graphs;

import rii.utils.graph.Graph;
import rii.utils.graph.UndirectedGraph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class BFSDistances {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            Graph g = new UndirectedGraph();
            int n = in.nextInt();

            for (int i = 1; i <= n; i++) {
                g.addVertex(i);
            }
            int m = in.nextInt();
            for (int a1 = 0; a1 < m; a1++) {
                int u = in.nextInt();
                int v = in.nextInt();
                g.addEdge(u, v);
            }
            int s = in.nextInt();
            int[] distances = getDistances(g, s);
            //        ArrUtils.printArr(distances);
        }
        in.close();
    }

    private static int[] getDistances(Graph g, Integer start) {
        System.out.println("Started");
        Integer curr = start;
        int[] result = new int[g.size() - 1];
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(curr);
        while (!queue.isEmpty()) {
            curr = queue.peek();
            System.out.println(curr);
            visited.add(curr);

            for (Integer v : g.getConnectedVertices(curr)) {
                queue.add(v);
            }
            queue.remove();
        }
        return result;

    }
}
