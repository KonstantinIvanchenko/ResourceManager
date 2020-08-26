package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        LinkedList<AudioChannel> audioChannels = new LinkedList<AudioChannel>();
        audioChannels.add(new AudioChannel(888734));
        audioChannels.add(new AudioChannel(564522));
        audioChannels.add(new AudioChannel(234676));
        audioChannels.add(new AudioChannel(333344));

        ChannelResourceManager channelResourceManager = new ChannelResourceManager(audioChannels);

        for(int i = 0; i < 100; i++){
            AudioClient audioClient = new AudioClient(channelResourceManager);
            audioClient.start();
        }

    }
}
