package rii.utils.graph;

import java.util.Set;

public interface Graph {
    void addVertex(Integer vtx);
    void addEdge(Integer from, Integer to);
    void removeVertex(Integer vtx);
    void removeEdge(Integer from, Integer to);
    Set<Integer> getVertices();
    Set<Integer> getConnectedVertices(Integer vtx);
    int size();
}
