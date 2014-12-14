package fr.janusproject.janusandroid.agents;

import java.util.UUID;

import io.sarl.lang.core.*;

/**
 * Created by VChabrette on 05/11/2014.
 */

public class HelloWorldAgent extends Agent {

    public HelloWorldAgent(UUID parentID) {
        super(parentID);
    }

    public void live() {
        System.out.println("Coucou!");
    }
}
