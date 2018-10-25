package com.qburst.ThirdStage.utilities.downloader;

import com.qburst.ThirdStage.models.DownloadMethod;
import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;


public class FTPDownload implements Download {

    FTPClient ftp = null;
    public void download(DownloadMethod downloadMethod) throws Exception {
        ftp = new FTPClient();
        ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
        int reply;
        ftp.connect(downloadMethod.getUrl());
        reply = ftp.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            ftp.disconnect();
            throw new Exception("Exception in connecting to FTP Server");
        }
        ftp.login(downloadMethod.getUserName(), downloadMethod.getPassword());
        ftp.setFileType(FTP.BINARY_FILE_TYPE);
        ftp.enterLocalPassiveMode();
        try {
            FileOutputStream fos = new FileOutputStream(downloadMethod.getLocalPath());
            this.ftp.retrieveFile(downloadMethod.getRemotePath(), fos);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
