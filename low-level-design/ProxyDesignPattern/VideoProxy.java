package ProxyDesignPattern;

public class VideoProxy implements Video {
    private String filename;
    private RealVideo realVideo;
    private boolean isPremiumUser;

    public VideoProxy(String filename, boolean isPremiumUser) {
        this.filename = filename;
        this.isPremiumUser = isPremiumUser;
    }

    @Override
    public void play() {
        if (!isPremiumUser) {
            System.out.println("Access denied. Upgrade to Premium to watch: " + filename);
            return;
        }

        if (realVideo == null) {
            realVideo = new RealVideo(filename);
        }
        realVideo.play();
    }

    @Override
    public String getThumbnail() {
        return "Proxy thumbnail for " + filename;
    }
}

