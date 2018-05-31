import java.awt.*;

 public  abstract class Figure {

    private Position startPoint;


    public Figure(Position p)
    {
        startPoint = p;
    }

    public Position GetStartPosition()
    {
        return startPoint;
    }

    protected void Move(Position p)
    {
        startPoint.Add(p);
    }

    protected void Swag() {

    }


    public abstract void draw(Graphics g);
}
