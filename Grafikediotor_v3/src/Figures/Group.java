package Figures;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Group extends Figure {


    public Group(Position p)
    {
        super(p);
    }

    private List<Figure> figures = new ArrayList<>();

    private List<Group> groups = new ArrayList<>();

    public void add(Group g)
    {
        groups.add(g);
    }

    public Group[] getGroups()
    {
        return groups.toArray(new Group[groups.size()]);
    }

    public Figure[] getFigures()
    {
        return figures.toArray(new Figure[figures.size()]);
    }

    @Override
    public void draw(Graphics g) {
        for (Figure f : figures)
        {
            f.draw(g);
        }
    }

    @Override
    public String toString() {
        return null;
    }
}
