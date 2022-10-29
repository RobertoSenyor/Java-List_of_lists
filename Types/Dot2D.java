package Types;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Comparator;

public class Dot2D implements UserType
{
    private Point2D point;

    public Dot2D() {point = new Point(0,0);}

    public Dot2D(int _axis_x, int _axis_y)
    {
        point = new Point(0,0);
        point.setLocation(_axis_x, _axis_y);
    }

    @Override
    public String type_name() {
        return "Dot2D";
    }

    @Override
    public Object create() {
        return null;
    }

    @Override
    public Object clone() {
        return this;
    }

    @Override
    public Object read_value() {
        return point;
    }

    @Override
    public Object parse_value(String ss) {

        String[] point2d = ss.split(";");

        point.setLocation(Integer.parseInt(point2d[0]), Integer.parseInt(point2d[1]));
        return this;
    }

    @Override
    public Comparator get_type_Comparator() {
        return this;
    }

    @Override
    public String toString() { return (int)point.getX() + ";" + (int)point.getY(); }

    @Override
    public int compare(Object o1, Object o2) {

        if(((Dot2D)o1).point.distance(0,0)==((Dot2D)o2).point.distance(0,0)) {
//            System.out.println(((Dot2D) o1).point.distance(0,0) + " " + ((Dot2D) o2).point.distance(0,0));
            return 0;
        }
        if(((Dot2D)o1).point.distance(0,0)>((Dot2D)o2).point.distance(0,0)) {
//            System.out.println(((Dot2D) o1).point.distance(0,0) + " " + ((Dot2D) o2).point.distance(0,0));
            return 1;
        }
        else {
//            System.out.println(((Dot2D) o1).point.distance(0,0) + " " + ((Dot2D) o2).point.distance(0,0));
            return -1;
        }
    }
}
