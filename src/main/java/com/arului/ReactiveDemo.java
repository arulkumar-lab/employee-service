package com.arului;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import java.time.Duration;

@ApplicationScoped
public class ReactiveDemo {

    public Uni<String> getReactiveDemoCall( String name){
        return Uni.createFrom ().item (name).onItem ().apply (n -> String.format ("hello %s", name));
    }

    public Multi<String> getReactiveDemoMulti( int count, String name) {
        return Multi.createFrom().ticks().every(Duration.ofSeconds(1))
                .onItem().apply(n -> String.format("hello %s - %d", name, n))
                .transform().byTakingFirstItems(count);
    }

}