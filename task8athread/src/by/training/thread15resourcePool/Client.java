package by.training.thread15resourcePool;

public class Client extends Thread {
    private boolean reading = false;
    private ChannelPool<AudioChannel> pool;
    public Client(final ChannelPool<AudioChannel> poolNew) {
        this.pool = poolNew;
    }

    public void run() {
        AudioChannel channel = null;
        try {
            channel = pool.getResource(100); // изменить на 100
            reading = true;
            System.out.println("Channel Client #" + this.getId()
                    + " took channel #" + channel.getChannelId());
            channel.using();
        } catch (ResourceException e) {
            System.out.println("Client #" + this.getId() + " lost ->"
                    + e.getMessage());
        } finally {
            if (channel != null) {
                reading = false;
                System.out.println("Channel Client #" + this.getId() + " : "
                        + channel.getChannelId() + " channel released");
                pool.returnResource(channel);
            }
        }
    }

    public boolean isReading() {
        return reading;
    }
}
