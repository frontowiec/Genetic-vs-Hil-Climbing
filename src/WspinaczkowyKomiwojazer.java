import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by marcin on 25.01.16.
 */
public class WspinaczkowyKomiwojazer {


    public static void main(String[] args) {

        RoutesMatrix matrix = new RoutesMatrix();
        System.out.println("Dla trasy: ");
        matrix.displayCurrentMatrix();
        System.out.println("Długość trasy wynosi: " + matrix.getTotalDistance());
        System.out.println("");
        matrix.swap();
        matrix.displayCurrentMatrix();
        System.out.println("Długość trasy wynosi: " + matrix.getTotalDistance());

    }


}
