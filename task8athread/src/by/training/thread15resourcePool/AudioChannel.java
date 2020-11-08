package by.training.thread15resourcePool;

import java.util.concurrent.TimeUnit;

public class AudioChannel {
    private int channelId;

    public AudioChannel(final int id) {
        super();
        this.channelId = id;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(final int id) {
        this.channelId = id;
    }

    public void using() {
        try {
            TimeUnit.MILLISECONDS.sleep(new java.util.Random().nextInt(500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
