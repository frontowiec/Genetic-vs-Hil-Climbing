import share.GA;
import share.Population;
import share.TourManager;

import java.awt.geom.Point2D;

/**
 * Created by Marcin Sirocki
 * marcinsirocki@gmail.com
 */
public class GenetycznyKomiwojazer {

    public static void main(String[] args) {
//        WspinaczkowyKomiwojazer wspinaczkowyKomiwojazer = new WspinaczkowyKomiwojazer();
        System.out.println("Szukanie trasy metodą genetyczną");
        long startTime = System.nanoTime();


        // Create and add our cities
        Point2D.Double city = new Point2D.Double(0, 0);
        TourManager.addCity(city);

        Point2D.Double city1 = new Point2D.Double(1, 2);
        TourManager.addCity(city1);

        Point2D.Double city2 = new Point2D.Double(0, 2);
        TourManager.addCity(city2);

        Point2D.Double city3 = new Point2D.Double(0, 1);
        TourManager.addCity(city3);

        Point2D.Double city4 = new Point2D.Double(2, 1);
        TourManager.addCity(city4);

        Point2D.Double city5 = new Point2D.Double(1, 0);
        TourManager.addCity(city5);


        // Initialize population
        Population pop = new Population(50, true);
        System.out.println("Initial distance: " + pop.getFittest().getDistance());

        // Evolve population for 100 generations
        pop = GA.evolvePopulation(pop);
        for (int i = 0; i < 100; i++) {
            pop = GA.evolvePopulation(pop);
        }

        // Print final results
        System.out.println("Finished");
        System.out.println("Final distance: " + pop.getFittest().getDistance());
        System.out.println("Solution:");
        System.out.println(pop.getFittest());

        long endTime = System.nanoTime();
        System.out.println("Wyszukana w czasie " + (endTime - startTime) + " ns");
    }

}

