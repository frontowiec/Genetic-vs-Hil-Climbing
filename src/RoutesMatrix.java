import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by marcin on 25.01.16.
 */
public class RoutesMatrix {

    private List<Point2D.Double> coordinatesList = new ArrayList<>();
    private int NUMBER_OF_CITIES = 6;
    private double totalDistnace = 0;

    public RoutesMatrix() {

        coordinatesList.add(new Point2D.Double(0,0));
        coordinatesList.add(new Point2D.Double(1,2));
        coordinatesList.add(new Point2D.Double(0,2));
        coordinatesList.add(new Point2D.Double(0,1));
        coordinatesList.add(new Point2D.Double(2,1));
        coordinatesList.add(new Point2D.Double(1,0));

    }

    public void displayCurrentMatrix() {

        for (int i = 0; i < coordinatesList.size(); i++) {
            System.out.println(coordinatesList.get(i).getX() + " ; " + coordinatesList.get(i).getY());
        }

    }

    public double getTotalDistance () {
        for (int i = 0; i < coordinatesList.size(); i++) {
            if(i < 5){
                double distance = coordinatesList.get(i).distance(coordinatesList.get(i+1));

                totalDistnace = totalDistnace + distance;

            }
        }

        return totalDistnace;
    }

    public void swap () {
        for (int i = 0; i < coordinatesList.size(); i++) {
            Collections.swap(coordinatesList, coordinatesList.size() - 1, i);
        }
    }


}
