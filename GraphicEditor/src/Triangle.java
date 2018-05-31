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
        g.drawLine(GetStartPosition().x, GetStartPosition().y, p2.x, p2.y);
        g.drawLine(p2.x, p2.y, p3.x, p3.y);
        g.drawLine( p3.x, p3.y, GetStartPosition().x, GetStartPosition().y);
    }
}
