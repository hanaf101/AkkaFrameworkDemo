package com.qburst.ThirdStage.utilities.downloader;

import com.qburst.ThirdStage.models.DownloadMethod;
import com.qburst.ThirdStage.utilities.DatabaseDownloader;

public class UrlDownload implements Download {
    public void download(DownloadMethod downloadMethod) {
        DatabaseDownloader loadDB = new DatabaseDownloader();
        loadDB.downloader(downloadMethod.getUrl());
//        System.out.println("Success");
    }
}
