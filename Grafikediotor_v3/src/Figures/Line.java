package Figures;

import Figures.Figure;
import Figures.Position;

import java.awt.*;

public class Line extends Figure {

    private Position endPoint;

    public Position getEndPoint() {
        return endPoint;
    }

    public Line(Position position, Position endPoint)
    {
        super(position);
        this.endPoint = endPoint;

    }

    @Override
    public void move(Position p)
    {
        endPoint.Add(p);
        super.move(p);
    }

    @Override
    public void draw(Graphics g) {
        g.drawLine(getStartPosition().x, getStartPosition().y, getEndPoint().x, getEndPoint().y);
    }

    @Override
    public String toString() {
        return "Linie: " + super.toString() + "End Position: " + endPoint.toString();
    }

}
