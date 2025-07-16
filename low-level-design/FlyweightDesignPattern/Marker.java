package FlyweightDesignPattern;

public class Marker {
    private MarkerType markerType;
    String location;

    public Marker(MarkerType markerType, String location) {
        this.markerType = markerType;
        this.location = location;
    }

    public void display() {
        System.out.println("Marker: " + this.location);
    }
}
