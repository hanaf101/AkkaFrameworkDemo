package com.qburst.ThirdStage.utilities;
/**
 * Created by qbuser on 7/8/15.
 */
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

public class ZipUnzip {
    public void unZip(String name) {
        try {
            ZipFile zipFile = new ZipFile(name);
            zipFile.extractAll("./");
        } catch (ZipException e) {
            e.printStackTrace();
        }
    }
}