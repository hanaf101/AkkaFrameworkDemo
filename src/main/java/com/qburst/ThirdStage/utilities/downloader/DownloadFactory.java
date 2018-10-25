package com.qburst.ThirdStage.utilities.downloader;

import com.qburst.ThirdStage.models.DownloadMethod;

/**
 * Created by qbuser on 14/8/15.
 */
public class DownloadFactory  {
    public Download startDownload(DownloadMethod downloadMethod) {
        if (downloadMethod.getDownloadMethod().equals("URLDownload")) {
            return new UrlDownload();
        }
        if (downloadMethod.getDownloadMethod().equals("FTPDownload")) {
            return new FTPDownload();
        }

        return null;
    }
}
