package share;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcin Sirocki
 * marcinsirocki@gmail.com
 *
 * Klasa definiująca macierz danych oraz funkcję obiczania długości tras.
 */
public class RoutesMatrix {

    private List<Point2D.Double> coordinatesList = new ArrayList<>();

    public RoutesMatrix() {

        coordinatesList.add(new Point2D.Double(0, 0));//zawsze startuje z punktu A
        coordinatesList.add(new Point2D.Double(1, 2));
        coordinatesList.add(new Point2D.Double(0, 2));
        coordinatesList.add(new Point2D.Double(0, 1));
        coordinatesList.add(new Point2D.Double(2, 1));
        coordinatesList.add(new Point2D.Double(1, 0));
        coordinatesList.add(new Point2D.Double(0, 0));//zawsze konczy w punkcie A

    }

    /**
     * Zwraca liczbę miast
     * @return integer
     */
    public int getNumberOfCities(){
        return coordinatesList.size()-1;
    }


    /**
     * Geter dla listy z trasami
     * @return List<Point2D.Double>
     */
    public List<Point2D.Double> getCoordinatesList() {
        return coordinatesList;
    }

    /**
     * seter dla listy z trasami
     * @param coordinatesList
     */
    public void setCoordinatesList(List<Point2D.Double> coordinatesList) {
        this.coordinatesList = coordinatesList;
    }

    /**
     * Wyświetla macierz na standardowe wyjście
     */
    public void displayCurrentMatrix() {

        System.out.println("");

        for (int i = 0; i < coordinatesList.size(); i++) {
            System.out.print(coordinatesList.get(i).getX() + " , " + coordinatesList.get(i).getY() + " | ");
        }


    }

    /**
     * Funkcja licząca odległości pomiędzy dwoma punktami ( zob. Point2D.distance() )
     * @return double
     */
    public double getTotalDistance() {

        double totalDistance = 0;

        for (int i = 0; i < coordinatesList.size(); i++) {
            if (i < getNumberOfCities()) {
                double distance = coordinatesList.get(i).distance(coordinatesList.get(i + 1));

                totalDistance = totalDistance + distance;

            }
        }

        return totalDistance;
    }

    public Point2D.Double getCity(int index){
        return (Point2D.Double) coordinatesList.get(index);
    }



}
