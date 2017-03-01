package com.nicolas.network;

import static org.junit.Assert.*;

import org.junit.Test;

public class NetworkTest {


    @Test
    public void testUndirectedGraphNodesCanBeAddedAndPathChecked() {

        Network network = new Network(5);
        network.connect(0, 1);
        network.connect(1, 2);
        network.connect(3, 4);

        assertTrue(network.query(0, 2));
        assertFalse(network.query(0, 3));
    }
}