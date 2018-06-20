package Figures;

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

    public Rectangle(Point p, Point p2)
    {
        super(p);
    }

    @Override
    public void draw(Graphics g)
    {


        g.drawRect(getStartPosition().x, getStartPosition().y, getSize().width, getSize().height);
    }

    @Override
    public String toString() {
        return "Rectangle: " + super.toString() + size.toString();
    }

}
