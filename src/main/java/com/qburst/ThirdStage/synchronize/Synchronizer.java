package com.qburst.ThirdStage.synchronize;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Synchronizer {
    private static Synchronizer ourInstance = new Synchronizer();
    private final ScheduledExecutorService scheduler =
            Executors.newScheduledThreadPool(1);
    public static Synchronizer getInstance() {
        return ourInstance;
    }

    private Synchronizer() {


        final Runnable beeper = new Runnable() {
            public void run() {
                System.out.println("beep");
            }
        };
        final ScheduledFuture<?> beeperHandle =
                scheduler.scheduleAtFixedRate(beeper, 10, 10, TimeUnit.HOURS);
        scheduler.schedule(new Runnable() {
            public void run() {
                beeperHandle.cancel(true);
            }
        }, 60 * 60, TimeUnit.HOURS);

    }



    }

