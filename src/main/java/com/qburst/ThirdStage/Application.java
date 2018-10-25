package com.qburst.ThirdStage;

import com.qburst.ThirdStage.SynchService.SynchService;

public class Application {

    public static void main(String[] args) {
        SynchService synchService=new SynchService();
        synchService.startService();
    }
}

