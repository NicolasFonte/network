package com.nicolas.network;

import org.jgrapht.UndirectedGraph;
import org.jgrapht.alg.ConnectivityInspector;
import org.jgrapht.generate.EmptyGraphGenerator;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

public class Network {

    private final UndirectedGraph<String, DefaultEdge> simpleGraph = new SimpleGraph<>(DefaultEdge.class);
    private final int size;

    public Network(int size) {
        this.size = size;
        if (size < 0) {
            throw new IllegalArgumentException("Network size is negative: " + size);
        }
        createGraph(size);
    }

    private void createGraph(int size) {
        EmptyGraphGenerator<String, DefaultEdge> emptyGraphGenerator = new EmptyGraphGenerator<>(size);
        emptyGraphGenerator.generateGraph(simpleGraph, new NetworkVertexFactory(), null);
    }

    public void connect(int source, int target) {
        checkVertexBoundaries(source, target);
        simpleGraph.addEdge("v" + source, "v" + target);
    }

    public boolean query(int source, int target) {
        checkVertexBoundaries(source, target);
        ConnectivityInspector<String, DefaultEdge> inspector = new ConnectivityInspector<>(simpleGraph);
        return inspector.pathExists("v" + source, "v" + target);
    }

    private void checkVertexBoundaries(int source, int target) {
        if (source < 0 || target < 0 || source > size - 1 || target > size - 1) {
            throw new IllegalArgumentException(
                    String.format("vertex boundaries should be between %d and %d", 0, size - 1));
        }
    }
}
