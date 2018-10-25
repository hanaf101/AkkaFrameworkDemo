package com.qburst.ThirdStage.SynchService;

import akka.actor.*;
import com.qburst.ThirdStage.actors.Supervisor;
import com.qburst.ThirdStage.listeners.Listener;

/**
 * Created by qbuser on 14/8/15.
 */
public class SynchService {
    public void startService(){
    ActorSystem actorSystem = ActorSystem.create("fileDownloader");
    final ActorRef listener = actorSystem.actorOf(new Props(Listener.class),"listener");
    final ActorRef supervisor = actorSystem.actorOf(new Props(new UntypedActorFactory() {
        public UntypedActor create() {
            return new Supervisor(listener);
        }
    }),"Master");
      supervisor.tell("BSE",listener);
    }

}

