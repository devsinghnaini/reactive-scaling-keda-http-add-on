package org.acme.main;

import io.quarkus.runtime.Quarkus;

@io.quarkus.runtime.annotations.QuarkusMain
public class QuarkusMain {
    
    public static void main(String... args){
        Quarkus.run(args);
    }
}
