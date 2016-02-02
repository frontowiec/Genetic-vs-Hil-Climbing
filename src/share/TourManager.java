package share;


import java.awt.geom.Point2D;
import java.util.ArrayList;

public class TourManager {

    // Holds our cities
    private static ArrayList destinationCities = new ArrayList<Point2D.Double>();

    // Adds a destination city
    public static void addCity(Point2D.Double city) {
        destinationCities.add(city);
    }

    // Get a city
    public static Point2D.Double getCity(int index) {
        return (Point2D.Double) destinationCities.get(index);
    }

    // Get the number of destination cities
    public static int numberOfCities() {
        return destinationCities.size();
    }
}
