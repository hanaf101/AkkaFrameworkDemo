package com.qburst.ThirdStage.actors;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;
import com.qburst.ThirdStage.models.UrlGenerator;
import com.qburst.ThirdStage.utilities.DatabaseDownloader;
import com.qburst.ThirdStage.utilities.ZipUnzip;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public  class ActorDownloadAndExtract extends UntypedActor {

    private final ActorRef listener;
    ArrayList<String> arrayRows = new ArrayList<String>();
    List<String> list;
    public ActorDownloadAndExtract(ActorRef listener) {
        this.listener = listener;

    }
    public void onReceive(Object message) throws IOException {
        int numlines ,index = 0;
        if (message instanceof UrlGenerator) {
            UrlGenerator urlDownload = (UrlGenerator) message;
            DatabaseDownloader loadDB = new DatabaseDownloader();
            loadDB.downloader(urlDownload.getUrl());
            ZipUnzip unZip=new ZipUnzip();
            unZip.unZip("test.zip");
            getSender().tell( "Extracted", getSelf());
        }
        else {
            unhandled(message);
        }
    }
}
