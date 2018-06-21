package JUnit;

import Figures.Figure;
import org.junit.Assert;
import org.junit.*;

import java.util.List;

public class JUnit {


    private FigurDAO figurFileDAO;
    private FigurParser figurParser;

    @Before
    public void setup()
    {
        figurFileDAO = new FigurDAOStub();
        figurParser = new FigurParser(figurFileDAO);

    }

    @Test
    public void test()
    {
        Object[] figureList = figurParser.parse().toArray();

        Assert.assertEquals( 3, figureList.length);
        Assert.assertEquals(figureList[0].toString(), "Rectangle: Start position: x:12 y: 23 width: 39 height: 23 ");
        Assert.assertEquals(figureList[1].toString(), "Circle: Start position: x:67 y: 251 Circumference: 23");
        Assert.assertEquals(figureList[2].toString(), "Linie: Start position: x:150 y: 140 End Position: x:35 y: 50 ");

    }
}
