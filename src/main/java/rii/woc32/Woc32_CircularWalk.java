package rii.woc32;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Woc32_CircularWalk {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int s = in.nextInt();
		int t = in.nextInt();
		int r_0 = in.nextInt();
		int g = in.nextInt();
		int seed = in.nextInt();
		int p = in.nextInt();
		int result = circularWalk(n, s, t, r_0, g, seed, p);
		System.out.println(result);
	}

	static int circularWalk(int n, int s, int t, int r_0, int g, int seed, int p) {
		int[] R = new int[n];
		R[0] = r_0;
		WeightedGraph gr = new WeightedGraph(false);
		gr.addVertex(0);
		for (int i = 1; i < n; i++) {
			gr.addVertex(i);
			R[i] = (R[i - 1] * g + seed) % p;
		}
		return 0;
	}

	static class Edge implements Comparable<Edge> {
		private Double weight;
		private Integer from;
		private Integer to;

		public Edge(Double weight) {
			this.weight = weight;
		}

		public Edge(Integer from, Integer to, Double weight) {
			this.weight = weight;
			this.from = from;
			this.to = to;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;

			Edge edge = (Edge) o;

			if (weight != null ? !weight.equals(edge.weight) : edge.weight != null)
				return false;
			if (from != null ? !from.equals(edge.from) : edge.from != null)
				return false;
			return !(to != null ? !to.equals(edge.to) : edge.to != null);

		}

		@Override
		public String toString() {
			return "Edge{" +
					"weight=" + weight +
					", from=" + from +
					", to=" + to +
					'}';
		}

		@Override
		public int hashCode() {
			int result = weight != null ? weight.hashCode() : 0;
			result = 31 * result + (from != null ? from.hashCode() : 0);
			result = 31 * result + (to != null ? to.hashCode() : 0);
			return result;
		}

		public Double getWeight() {
			return weight;
		}

		public void setWeight(Double weight) {
			this.weight = weight;
		}

		public Integer getFrom() {
			return from;
		}

		public void setFrom(Integer from) {
			this.from = from;
		}

		public Integer getTo() {
			return to;
		}

		public void setTo(Integer to) {
			this.to = to;
		}

		@Override
		public int compareTo(Edge o) {
			return (int) (this.weight - o.weight);
		}
	}

	static class Dijsktra {

		Map<Integer, Double> distance;
		private WeightedGraph graph;

		public Dijsktra(WeightedGraph graph) {
			this.graph = graph;
			distance = new HashMap<>();
		}

		/**
		 * This is naive implementation of Dijsktra shortest path algorithm. Running time is O(VE);
		 * this implementation works best with dense graphs
		 */
		public void shortestPath(Integer source) {

			Set<Integer> openSet = new TreeSet<>();
			for (Integer vertex : graph.getVertices()) {
				if (source.equals(vertex))
					distance.put(source, 0d);
				else
					distance.put(vertex, Double.POSITIVE_INFINITY);
				openSet.add(vertex);
			}
			while (!openSet.isEmpty()) {

				Integer min = 0;
				double minDis = Double.POSITIVE_INFINITY;
				for (Integer vertex : openSet) {
					if (minDis > distance.get(vertex)) {
						minDis = distance.get(vertex);
						min = vertex;
					}
				}

				openSet.remove(min);

				for (Edge edge : graph.getEdges(min)) {

					Double newPath = distance.get(min) + edge.getWeight();
					if (distance.get(edge.getTo()) > newPath) {
						distance.put(edge.getTo(), newPath);
					}
				}
			}
		}

		/**
		 * This is optimized version of shortest path algorithm, whose running time is O(E logE)
		 * this works better than other implementations in practise
		 */
		public void shortestPathOptimized(Integer source) {
			PriorityQueue<Pair> queue = new PriorityQueue<>();
			Map<Integer, Pair> map = new HashMap<>();
			for (Integer vertex : graph.getVertices()) {
				Pair pair;
				if (source.equals(vertex))
					pair = new Pair(vertex, 0d);
				else
					pair = new Pair(vertex, Double.POSITIVE_INFINITY);
				queue.add(pair);
				map.put(vertex, pair);
			}
			while (!queue.isEmpty()) {

				Pair pair = queue.remove();

				if (map.get(pair.label) != pair)
					continue; // if pair is already updated

				for (Edge edge : graph.getEdges(pair.label)) {
					Double newPath = pair.weight + edge.getWeight();
					if (newPath < map.get(edge.getTo()).weight) {
						Pair newPair = new Pair(edge.getTo(), newPath);
						map.put(edge.getTo(), newPair);
						queue.add(newPair);
					}
				}
			}

		}

		private class Pair implements Comparable<Pair> {
			Integer label;
			Double weight;

			public Pair(Integer name, Double weight) {
				this.label = name;
				this.weight = weight;
			}

			@Override
			public int compareTo(Pair p) {
				return (int) (this.weight - p.weight);
			}
		}

	}

	static class WeightedGraph {
		Set<Edge> edges = new HashSet<>();
		private boolean Undirected = false;
		private Map<Integer, Set<Edge>> map = new HashMap<>();

		public WeightedGraph(boolean Undirected) {
			this.Undirected = Undirected;
		}

		public void addVertex(Integer v) {
			map.put(v, new HashSet<>());
		}

		public void addEdge(Integer v1, Integer v2, Double weight) {
			if (!map.containsKey(v1))
				return;
			if (!map.containsKey(v2))
				return;
			Edge edge = new Edge(v1, v2, weight);

			map.get(v1).add(edge);
			edges.add(edge);

			if (Undirected) {
				Edge edge2 = new Edge(v2, v1, weight);
				map.get(v2).add(edge2);
				edges.add(edge2);
			}
		}

		public void removeVertex(Integer v) {

		}

		public Set<Integer> getVertices() {
			return new HashSet<>(map.keySet());
		}

		public Set<Edge> getEdges() {
			return edges;
		}

		public Set<Edge> getEdges(Integer ver) {
			return map.get(ver);
		}

		public int size() {
			return map.size();
		}
	}
}
