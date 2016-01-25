/*
 * HillClimbing.java
 *
 * $LastChangedDate$
 * $LastChangedRevision$
 * Vicente J. Ferrer Dalmau
 * < vicente@jdalmau.es >
 *
 * Implementation of the Hill Climbing algorithm (simple version).
 *
 * http://code.google.com/p/tspuib/source/browse/trunk/TravelingSalesMan/src/travelingsalesman/HillClimbing.java?r=12
 */

import java.util.ArrayList;

/**
 *
 * @author Vicente J. Ferrer Dalmau
 */
public class WspinaczkowyKomiwojazer {

    RoutesMatrix distances;

    int sourceCity;

    String result = new String();

    ArrayList followedRoute; //zbiór rozwiązań
    int nodes = 0;
    int routeCost = 0;

    int HEURISTICCONSTANT = 15;

    /**
     * Gets the heuristic value for a given depth
     * The level 0 has the maximum value.
     */
    private int getHeuristicValue (int level) {

        return HEURISTICCONSTANT * (distances.getCitiesCount() - level);
    }

    /** Creates a new instance of WspinaczkowyKomiwojazer */
    public WspinaczkowyKomiwojazer(RoutesMatrix matrix, int sourceCity) {

        distances = matrix;
        this.sourceCity = sourceCity;
    }

    /**
     * @param from node where we start the search.
     *
     * startujemy z losowego punktu, przeglądamy jego sąsiadów, wybieramy tego sąsiada,
     * który ma największą wartość ("idziemy w górę"), czynności powtarzamy do osiągnięcia maksimum lokalnego.
     *
     */
    public void search (int from) {

        int currentTown = from;

        while (nodes != distances.getCitiesCount()) {//dopóki ilość mist jest różna od zera
            // choose the closest town
            int lowestDistance = Integer.MAX_VALUE; //najbliżej położone miasto
            int chosen = -1;//tymczasowa zmienna dodawana do zbioru rozwiązań
            for (int i=0; i < distances.getCitiesCount(); i++) { //po wszystkich mistach
                if (!followedRoute.contains(i)) { //następna trasa zawiera i w zbiorze rozwiązań
                    int tempDistance = routeCost + getHeuristicValue(nodes-1); // f = g + h
                    if (tempDistance < lowestDistance) { //wybieramy tego sąsiada, który ma największą wartość
                        lowestDistance = tempDistance;
                        chosen = i;
                    }
                }
            }
            routeCost += distances.getCost(currentTown, chosen);
            followedRoute.add(chosen);
            currentTown = chosen;
            nodes++;
        }
        // add the last town
        routeCost += distances.getCost(currentTown, sourceCity);
        followedRoute.add(sourceCity);
        nodes++;
    }

    /**
     * executes the algorithm
     */
    public String execute () {

        followedRoute = new ArrayList();
        followedRoute.add(sourceCity);
        nodes++;

        result =  "HILL CLIMBING SEARCH\n\n";

        long startTime = System.currentTimeMillis();
        search(sourceCity);
        long endTime = System.currentTimeMillis();

        result += "\nBetter solution: "+followedRoute.toString() + "// Cost: "+routeCost+"\n";
        result += "Visited Nodes: "+nodes+"\n";
        result += "Elapsed Time: "+(endTime-startTime)+" ms\n";

        return result;
    }

    public static void main(String[] args) {
        RoutesMatrix routesMatrix = new RoutesMatrix(19);
        WspinaczkowyKomiwojazer wspinaczkowyKomiwojazer = new WspinaczkowyKomiwojazer(routesMatrix, 2);

        System.out.println(wspinaczkowyKomiwojazer.execute());
    }

}
