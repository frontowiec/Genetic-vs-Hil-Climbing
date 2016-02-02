package share;

import java.awt.geom.Point2D;

public class City extends Point2D.Double{

    // Constructs a city at chosen x, y location
    public City(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return getX()+", "+getY();
    }
}