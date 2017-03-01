package com.nicolas.network;

import org.jgrapht.VertexFactory;

public class NetworkVertexFactory implements VertexFactory {

    private int id = 0;

    @Override
    public String createVertex() {
        return "v" + id++;
    }
}
