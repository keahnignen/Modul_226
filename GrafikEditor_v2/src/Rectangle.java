import java.awt.*;

public class Rectangle extends Figure {

    private Size size;

    public Size getSize() {
        return size;
    }

    public Rectangle(Position position, Size size)
    {
        super(position);
        this.size = size;
    }

    @Override
    public void draw(Graphics g)
    {
        g.drawRect(getStartPosition().x, getStartPosition().y, getSize().width, getSize().height);
    }

}
