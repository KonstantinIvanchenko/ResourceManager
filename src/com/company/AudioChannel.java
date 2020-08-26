package com.company;

public class AudioChannel {
    private int channelId;

    public AudioChannel(int id){
        super();
        this.channelId = id;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int id){
        this.channelId = id;
    }

    public void useChannel(){
        try{
            Thread.sleep(new java.util.Random().nextInt(100));
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
