package com.qburst.ThirdStage.actors;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.actor.UntypedActorFactory;
import akka.routing.RoundRobinRouter;
import com.qburst.ThirdStage.models.DownloadMethod;
import com.qburst.ThirdStage.models.UrlGenerator;
import com.qburst.ThirdStage.utilities.downloader.Download;
import com.qburst.ThirdStage.utilities.downloader.DownloadFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Supervisor extends UntypedActor {
    //    private final ActorRef actorDownloader;
    private final ActorRef actorDownloadExtractor;
    private final ActorRef actorReader;
    ArrayList<String> arrayRows = new ArrayList<String>();
    List<String> list;
    ActorRef listener;
    public Supervisor(final ActorRef listener) {
        this.listener=listener;
        actorDownloadExtractor = context().actorOf(new Props(new UntypedActorFactory() {
            public UntypedActor create() {
                return new ActorDownloadAndExtract(listener);
            }
        }), "DownloadAndProcess");
        actorReader = this.getContext()
                .actorOf(new Props(ActorReader.class)
                        .withRouter(new RoundRobinRouter(10)), "workerReader");
    }

    @Override
    public void onReceive(Object message) throws Exception {
        int numlines,index=0;
        if (message instanceof String) {
            if (message.equals("BSE")) {
                DownloadMethod downloadMethod=new DownloadMethod();
                downloadMethod.setDownloadMethod("URLDownload");
                downloadMethod.setUrl("http://www.bseindia.com/download/BhavCopy/Equity/EQ050815_CSV.ZIP");
                DownloadFactory downloadFactory=new DownloadFactory();
                Download download= downloadFactory.startDownload(downloadMethod);
                download.download(downloadMethod);
                UrlGenerator urlforDownload = new UrlGenerator(
                        "http://www.bseindia.com/download/BhavCopy/Equity/EQ050815_CSV.ZIP");
                actorDownloadExtractor.tell(urlforDownload, getSelf());
            }
            if (message.equals("Extracted")){
                String line,fileName = "EQ050815.CSV";
                if (message.equals("Extracted")) {
                    BufferedReader reader = new BufferedReader(new FileReader(fileName));
                    line = reader.readLine();
                    while (line != null) {
                        arrayRows.add(line + "\n");
                        line = reader.readLine();
                    }
                    numlines=arrayRows.size();
                    reader.close();
                    try {
                        while (numlines > 0) {
                            list = arrayRows.subList(index, Math.min(index+10,index+numlines));
                            actorReader.tell(list, getSelf());
                            index = index + 10;
                            numlines = numlines - 10;
                        }
                        listener.tell("success",getSelf());
                    } catch (IndexOutOfBoundsException e) {
                        e.printStackTrace();
                    }
                    System.out.println(list);
                }
            }
            if (message instanceof List){

                actorReader.tell(message,getSelf());
            }
        }

        else{
            unhandled( message );
        }

    }

}
