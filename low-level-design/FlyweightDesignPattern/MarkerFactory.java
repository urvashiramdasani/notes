package FlyweightDesignPattern;

import java.util.HashMap;
import java.util.Map;

public class MarkerFactory {
    private final Map<String, MarkerType> markerCache = new HashMap<>();

    public Marker getMarker(String input ,String location) {
        MarkerType markerType;
        if (!markerCache.containsKey(input)) {
            markerType = new MarkerType("icon", "color", "shape");
            markerCache.put(input, markerType);
        } else {
            markerType = markerCache.get(input);
        }

        return new Marker(markerType, location);
    }
}
