package com.qburst.ThirdStage.utilities.downloader;

import com.qburst.ThirdStage.models.DownloadMethod;

/**
 * Created by qbuser on 14/8/15.
 */
public interface Download {
    void download(DownloadMethod downloadMethod)throws Exception;

}
