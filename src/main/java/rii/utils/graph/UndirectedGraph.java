package rii.utils.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UndirectedGraph implements Graph {
	Map<Integer, Set<Integer>> vertices = new HashMap();

	@Override
	public void addVertex(Integer vtx) {
		vertices.put(vtx, new HashSet<>());

	}

	@Override
	public void addEdge(Integer from, Integer to) {
		if (!vertices.containsKey(from))
			return;
		if (!vertices.containsKey(to))
			return;
		vertices.get(from).add(to);
		vertices.get(to).add(from);
	}

	@Override
	public void removeVertex(Integer vtx) {
		return;
	}

	@Override
	public void removeEdge(Integer from, Integer to) {
		return;
	}

	@Override
	public Set<Integer> getVertices() {
		return new HashSet<>(vertices.keySet());
	}

	@Override
	public Set<Integer> getConnectedVertices(Integer vtx) {
		return vertices.get(vtx);
	}

	@Override
	public int size() {
		return vertices.size();
	}
}
