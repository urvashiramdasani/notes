package FlyweightDesignPattern;

public class Main {
    public static void main(String[] args) {
        MarkerFactory markerFactory = new MarkerFactory();
        Marker marker = markerFactory.getMarker("GasStation", "north");
        marker.display();

        Marker marker1 = markerFactory.getMarker("GasStation", "south");
        marker1.display();

        Marker marker2 = markerFactory.getMarker("Restaurant", "east");
        marker2.display();
    }
}
