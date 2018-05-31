import java.awt.*;

public class Circle extends Figure {

    private int radius;

    public int getRadius() {
        return radius;
    }

    public Circle(Position position, int radius)
    {
        super(position);
        this.radius = radius;
    }

    @Override
    public void draw(Graphics g) {
        g.drawOval(getStartPosition().x, getStartPosition().y, getRadius() * 2, getRadius() * 2);
    }
}
