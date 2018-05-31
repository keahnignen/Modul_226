import java.util.ArrayList;
import java.util.List;

public class Group {

    private List<Figure> subFigures = new ArrayList<>();

    private List<Group> subGroups = new ArrayList<>();

    public void add(Group g)
    {
        subGroups.add(g);
    }

    public Group[] getGroups()
    {
        return subGroups.toArray(new Group[subGroups.size()]);
    }

    public Figure[] getFigures()
    {
        return subFigures.toArray(new Figure[subFigures.size()]);
    }

}
