package com.qburst.ThirdStage.models;

/**
 * Created by qbuser on 14/8/15.
 */
public class GetFileLineInfo {
    private String fileName;
    private int begin,end;
    public String getFileName(){
        return this.fileName;
    }
    public int getBeginPosition(){
        return begin;
    }
    public int getEnd(){
        return end;
    }
    public void setNameBeginEnd(String name,int begin,int end){
        this.fileName=name;
        this.begin=begin;
        this.end=end;
    }
}
