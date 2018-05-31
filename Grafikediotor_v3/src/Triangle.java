import java.awt.*;

public class Triangle extends Figure {

    public Position p2;
    public Position p3;


    public Triangle(Position p, Position p2, Position p3) {
        super(p);
        this.p2 = p2;
        this.p3 = p3;

    }

    @Override
    public void draw(Graphics g) {
        g.drawLine(getStartPosition().x, getStartPosition().y, p2.x, p2.y);
        g.drawLine(p2.x, p2.y, p3.x, p3.y);
        g.drawLine( p3.x, p3.y, getStartPosition().x, getStartPosition().y);
    }

    @Override
    public void move(Position p)
    {
        super.move(p);
        p2.Add(p);
        p3.Add(p);
    }
}
