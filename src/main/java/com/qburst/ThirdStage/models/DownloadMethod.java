package com.qburst.ThirdStage.models;

/**
 * Created by qbuser on 14/8/15.
 */
public class DownloadMethod {
    private String downloadMethod;
    private String userName;
    private String password;
    private String url;
    private String host;
    private String remotePath;
    private String localPath;
    public void setDownloadMethod(String method){
        this.downloadMethod=method;
    }
    public void setUsernamePassword(String username,String password){
        this.userName=username;
        this.password=password;
    }
    public void setHost(String host){
        this.host=host;
    }
    public void setRemotePath(String remotePath){
        this.remotePath=remotePath;
    }
    public void setLocalPath(String localPath){
        this.localPath=localPath;
    }
    public String getLocalPath(){
        return this.localPath;
    }
    public String getRemotePath(){
        return this.remotePath;
    }

    public void setUrl(String url){
        this.url=url;
    }
    public String getDownloadMethod(){
        return this.downloadMethod;
    }
    public String getUserName(){
        return this.userName;
    }
    public String getPassword(){
        return this.password;
    }
    public String getUrl(){
        return this.url;
    }
}
