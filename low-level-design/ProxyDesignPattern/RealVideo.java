package ProxyDesignPattern;

public class RealVideo implements Video {
    private String filename;

    public RealVideo(String filename) {
        this.filename = filename;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Loading full video from disk: " + filename);
    }

    @Override
    public void play() {
        System.out.println("Playing video: " + filename);
    }

    @Override
    public String getThumbnail() {
        return "Thumbnail for " + filename;
    }
}

