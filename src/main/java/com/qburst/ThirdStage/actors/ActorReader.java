package com.qburst.ThirdStage.actors;

import akka.actor.UntypedActor;
import com.qburst.ThirdStage.utilities.ReadWriteDB;

import java.util.List;


/**
 * Created by qbuser on 10/8/15.
 */

public class ActorReader extends UntypedActor {
    @Override
    public void onReceive(Object message) {
        try {
            List<String> list = (List<String>) message;
            ReadWriteDB reader = new ReadWriteDB();
            reader.readDB(list);
        } catch (Exception e) {
            sender().tell(message,getSelf());
        }
    }
}
