package com.qburst.ThirdStage.listeners; /**
 * Created by qbuser on 7/8/15.
 */
import akka.actor.UntypedActor;

public class Listener extends UntypedActor
{
    @Override
    public void onReceive(Object message) throws Exception {
        if( message instanceof String ){
            System.out.println("success");
            getContext().system().shutdown();
        }
        else{
            unhandled( message );
        }
    }
}