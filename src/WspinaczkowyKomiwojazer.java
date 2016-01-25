
import java.util.Collections;

/**
 * Created by Marcin Sirocki
 * marcinsirocki@gmail.com
 *
 * Klasa implementująca algorytm wspinaczkowy dla problemy komiwojażera.
 *
 */
public class WspinaczkowyKomiwojazer {

    /**
     * Instancja klasy dostarczającej macierzy danych oraz funkcji obiczania długości tras.
     */
    private RoutesMatrix routesMatrix = new RoutesMatrix();

    /**
     * Funkcja szukająca najkrótszej trasy pomiędzy punktami zdefiniowanymi w macierzy.
     * Algorytm szuka w przestrzeni stanów (w tym wypadku jest nią miacierz z wyznaczonymi trasami) podobieństw
     * rozwiązań (uzyskano je jako zmiany kolejności punktów w macierzy) - sąsiedztwa rozwiązań.
     * Wybierany jest ten sąsiad który ma najmniejszą wartość.
     */
    public void search() {

        double totalDistance = 0;
        double tempDistance = 0;

        routesMatrix.displayCurrentMatrix();//wyświetl domyślną macierz
        System.out.println( routesMatrix.getTotalDistance());//policz dla niej dystans


        for (int i = 1; i <  routesMatrix.getCoordinatesList().size(); i++) {//każdy element w tablicy

            for (int j = 1; j < routesMatrix.getCoordinatesList().size(); j++) {//przestaw o jedną pozycję w dół z wyjątkiem pierwszej

                if (j < routesMatrix.getCoordinatesList().size()-2) { //i ostatniej
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
