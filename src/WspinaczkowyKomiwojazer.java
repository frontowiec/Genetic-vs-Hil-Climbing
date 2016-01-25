
import java.util.Collections;

/**
 * Created by marcin on 25.01.16.
 */
public class WspinaczkowyKomiwojazer {

    private RoutesMatrix routesMatrix = new RoutesMatrix();


    public void search() {

        double totalDistance = 0;
        double tempDistance = 0;

        routesMatrix.displayCurrentMatrix();//wyświetl domyślną macierz
        System.out.println( routesMatrix.getTotalDistance());//policz dla niej dystans


        for (int i = 1; i <  routesMatrix.getCoordinatesList().size(); i++) {//każdy element w tablicy

            for (int j = 1; j < routesMatrix.getCoordinatesList().size(); j++) {//przestaw po jedną pozycję w dół z wyjątkiem pierwszej i ostatniej

                if (j < routesMatrix.getCoordinatesList().size()-2) { //ogranicz się do przedostatniej pozycji w liście
                    Collections.swap(routesMatrix.getCoordinatesList(), j, j + 1);
                }

                routesMatrix.displayCurrentMatrix();//wyświetl macierz tras po przestawieniu

                totalDistance = routesMatrix.getTotalDistance(); //obicz całkowitą długość trasy dla przetransformowanej macierzy

                System.out.println(totalDistance); //wyświetl długość trasy

                if (tempDistance <= totalDistance && tempDistance != 0){ //jeśli jest ona krótsza od poprzedniej
                    totalDistance = tempDistance; //ustaw ją jako bierzącą
                }

                tempDistance = totalDistance; //ustaw zmienną tymczasową
            }

        }

        System.out.println("Najkrótsza droga to: " + totalDistance);

    }



    public static void main(String[] args) {
        WspinaczkowyKomiwojazer wspinaczkowyKomiwojazer = new WspinaczkowyKomiwojazer();
        long startTime = System.nanoTime();

        wspinaczkowyKomiwojazer.search();

        long endTime = System.nanoTime();
        System.out.println("Wyszukana w czasie " + (endTime - startTime) + " ns");


    }


}
