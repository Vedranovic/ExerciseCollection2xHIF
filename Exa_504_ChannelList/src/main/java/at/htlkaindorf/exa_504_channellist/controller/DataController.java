package at.htlkaindorf.exa_504_channellist.controller;

import java.util.*;

public class DataController {
    private List<String> channels;

    public DataController() {
        this.channels = new ArrayList<>();
    }

    public boolean addChannel(String channel) throws Exception {
        if (isChannelInList(channel)) {
            throw new Exception("The channel already exists!");
        }
        channels.add(channel);

        return true;
    }

    public boolean addChannel(String channel, int index) throws Exception {
        if (isChannelInList(channel)) {
            throw new Exception("The channel already exists!");
        }
        channels.add(index, channel);

        return true;
    }

    private boolean isChannelInList(String channel) {
        return channels.contains(channel);
    }

    public void shuffleList() {
        Collections.shuffle(channels);
    }

    public void removeChannel(String channel) {
        if (isChannelInList(channel)) {
            channels.remove(channel);
        }
    }

    public List<String> getChannels() {
        return channels;
    }
}
