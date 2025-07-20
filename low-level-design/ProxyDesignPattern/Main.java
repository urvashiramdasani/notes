package ProxyDesignPattern;

public class Main {
    public static void main(String[] args) {
        Video video1 = new VideoProxy("funny_cats.mp4", false);  // Free user
        Video video2 = new VideoProxy("documentary.mp4", true);  // Premium user

        System.out.println(video1.getThumbnail());  // Quick thumbnail
        video1.play();  // Should deny access

        System.out.println(video2.getThumbnail());
        video2.play();  // Loads and plays video
        video2.play();  // Plays without reloading
    }
}

