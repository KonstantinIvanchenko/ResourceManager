package com.company;

public class AudioClient extends Thread {
    private boolean reading = false;
    private ChannelResourceManager<AudioChannel> channelResourceManager;

    public AudioClient(ChannelResourceManager<AudioChannel> channelResourceManager){
        this.channelResourceManager = channelResourceManager;
    }

    public void run(){

        AudioChannel audioChannel = null;
        try{
            audioChannel = channelResourceManager.getResource(500);
            reading = true;

            System.out.println("Using channel with ID: " + audioChannel.getChannelId());
            audioChannel.useChannel();

        } catch (ResourceManagerException e){
            e.printStackTrace();
        }finally {
            if (audioChannel != null){
                reading = false;
                channelResourceManager.returnResource(audioChannel);
            }

            reading = false;
        }
    }

}
