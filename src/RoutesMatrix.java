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
    private double tempDistance = 0;

    public RoutesMatrix() {

        coordinatesList.add(new Point2D.Double(0, 0));//zawsze startuje z punktu A
        coordinatesList.add(new Point2D.Double(1, 2));
        coordinatesList.add(new Point2D.Double(0, 2));
        coordinatesList.add(new Point2D.Double(0, 1));
        coordinatesList.add(new Point2D.Double(2, 1));
        coordinatesList.add(new Point2D.Double(1, 0));
        coordinatesList.add(new Point2D.Double(0, 0));//zawsze konczy w punkcie A

    }


    public List<Point2D.Double> getCoordinatesList() {
        return coordinatesList;
    }

    public void displayCurrentMatrix() {

        for (int i = 0; i < coordinatesList.size(); i++) {
            System.out.println(coordinatesList.get(i).getX() + " ; " + coordinatesList.get(i).getY());
        }

    }

    public double getTotalDistance() {
        for (int i = 0; i < coordinatesList.size(); i++) {
            if (i < NUMBER_OF_CITIES) {
                double distance = coordinatesList.get(i).distance(coordinatesList.get(i + 1));

                totalDistnace = totalDistnace + distance;

            }
        }

        return totalDistnace;
    }

    public void search() {

        displayCurrentMatrix();
        System.out.println(getTotalDistance());
        System.out.println("");

        for (int i = 1; i < coordinatesList.size(); i++) {

            for (int j = 1; j < coordinatesList.size(); j++) {

                totalDistnace = 0;

                if (j < NUMBER_OF_CITIES-1) {
                    Collections.swap(coordinatesList, j, j + 1);
                }

                displayCurrentMatrix();
                System.out.println(getTotalDistance());
                System.out.println(" ");

                if (tempDistance <= totalDistnace && tempDistance != 0){
                    totalDistnace = tempDistance;
                }

                tempDistance = totalDistnace;
            }

        }

        System.out.println("Najkrótsza droga to: " + totalDistnace);

    }


}
