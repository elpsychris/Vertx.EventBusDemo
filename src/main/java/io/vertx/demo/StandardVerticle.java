package io.vertx.demo;

import io.vertx.core.AbstractVerticle;

public class StandardVerticle extends SubVerticle {
    public void start() {
        System.out.println("I'm a standard vert");
        this.setVerticleName("Standard");

        this.registerEventBus("SubVert.Standard");
    }
}
