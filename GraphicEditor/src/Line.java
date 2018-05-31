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
    public void Move(Position p)
    {
        endPoint.Add(p);
        super.Move(p);
    }

    @Override
    public void draw(Graphics g) {
        g.drawLine(GetStartPosition().x, GetStartPosition().y, getEndPoint().x, getEndPoint().y);
    }

}
