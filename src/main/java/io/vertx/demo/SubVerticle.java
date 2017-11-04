package io.vertx.demo;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;

public class SubVerticle extends AbstractVerticle {
    String verticleName;

    public String getVerticleName() {
        return verticleName;
    }

    public void setVerticleName(String verticleName) {
        this.verticleName = verticleName;
    }

    public EventBus registerEventBus(String address) {
        EventBus eb = vertx.eventBus();

        eb.consumer(address, mess -> {
            System.out.println(String.format(" %s received new mess from %s: %s", ((MessObj)mess.body()).getReceiver(), ((MessObj)mess.body()).getSender(), ((MessObj)mess.body()).getMess()));
        });
        return eb;
    }
}
