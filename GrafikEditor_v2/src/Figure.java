import java.awt.*;

 public  abstract class Figure {

    private Position startPoint;


    public Figure(Position p)
    {
        startPoint = p;
    }

    public Position getStartPosition()
    {
        return startPoint;
    }

    protected void move(Position p)
    {
        startPoint.Add(p);
    }

    protected Group group;

    public abstract void draw(Graphics g);

}
