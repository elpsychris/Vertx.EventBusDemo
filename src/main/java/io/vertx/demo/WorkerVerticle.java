package io.vertx.demo;

import io.vertx.core.AbstractVerticle;

public class WorkerVerticle extends SubVerticle {

    public void start() {
        System.out.println("I'm a worker");
        this.setVerticleName("Worker");

        this.registerEventBus("SubVert.Worker");
    }
}
