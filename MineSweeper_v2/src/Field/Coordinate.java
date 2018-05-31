package Field;

public class Coordinate {

    public Coordinate(int x, int y)
    {
        this.x = x; 
        this.y = y;
    }

     public int x;
     public int y;

    public boolean isEqual(Coordinate c)
    {
        return (this.x == c.x && this.y == c.y);
    }

}
