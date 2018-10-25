package com.qburst.ThirdStage.utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by qbuser on 7/8/15.
 */
public class DatabaseDownloader {
    public void downloader(String url) {
        try {
            URL link = new URL(url);
            URLConnection conn = link.openConnection();
            InputStream in = conn.getInputStream();
            FileOutputStream out = new FileOutputStream("test.zip");
            byte[] b = new byte[1024];
            int count;
            while ((count = in.read(b)) >= 0) {
                out.write(b, 0, count);
            }
            out.flush();
            out.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
