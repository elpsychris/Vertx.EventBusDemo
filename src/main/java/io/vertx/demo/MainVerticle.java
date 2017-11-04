package io.vertx.demo;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.Starter;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.eventbus.EventBus;
import io.vertx.demo.utils.CustomCodec;

import java.awt.*;

public class MainVerticle extends AbstractVerticle {

    public void start(Future<Void> startFuture) {
        System.out.println("MainArticle will start");

        System.out.println("WillDeploy _StandardVert");
        vertx.deployVerticle("io.vertx.demo.StandardVerticle", res -> {
            if (res.succeeded()) {
                startFuture.complete();
            } else {
                startFuture.fail(res.cause());
            }
        });
        System.out.println("WillDeploy _WorkerVert");
        DeploymentOptions depOptions = new DeploymentOptions().setWorker(true);
        vertx.deployVerticle("io.vertx.demo.WorkerVerticle", depOptions);

        EventBus eventBus = vertx.eventBus();

        CustomCodec myCodec = new CustomCodec();
        eventBus.registerDefaultCodec(MessObj.class, myCodec);


        System.out.println("== Send mess: Main -> Worker");
        eventBus.send("SubVert.Worker", new MessObj("Hi, Worker! I'm Main","Worker","Main"));

        System.out.println("== Send mess: Main -> Standard");
        eventBus.send("SubVert.Standard", new MessObj("Hi, Worker! I'm Main","Standard","Main"));

    }

}

