package at.htlkaindorf.exa_504_channellist.controller;

import javafx.scene.control.Alert;

import java.util.*;

public class DataController {
    private List<String> channels;

    public DataController() {
        this.channels = new ArrayList<>();
    }

    public boolean addChannel(String channel) throws Exception {
        if (!isChannelInList(channel)) {
            channels.add(channel);
            return true;
        } else {
            throw new Exception("The channel already exists!");
        }
    }

    public boolean addChannel(String channel, int index) throws Exception{
        if (!isChannelInList(channel)) {
            channels.add(index, channel);
            return true;
        } else {
            throw new Exception("The channel already exists!");
        }
    }

    private boolean isChannelInList(String channel) {
        for (String s : channels) {
            if (channel.equals(s)) {
                return true;
            }
        }

        return false;
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
