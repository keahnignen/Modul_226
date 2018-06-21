
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FigurParser {
  private grafikeditor.FigurDAO dao;

  public FigurParser(grafikeditor.FigurDAO dao) {
    this.dao = dao;
  }

  public List<Figure> parse() {
    List<Figure> figuren = new ArrayList<Figure>();
    String[] figurData = dao.readNextFigurData();
    System.out.println(Arrays.toString(figurData));
    System.out.println(figurData[0]);
    while (figurData != null) {
      String figurTyp = figurData[0];
      int x = Integer.valueOf(figurData[1]);
      int y = Integer.valueOf(figurData[2]);
      switch (figurTyp) {
      case "Rechteck":
        int breite = Integer.valueOf(figurData[3]);
        int hoehe = Integer.valueOf(figurData[4]);
        figuren.add(new Rechteck(x, y, breite, hoehe));
        break;
      case "Kreis":
        int radius = Integer.valueOf(figurData[3]);
        figuren.add(new Kreis(x, y, radius));
        break;
      case "Linie":
        int endx = Integer.valueOf(figurData[3]);
        int endy = Integer.valueOf(figurData[4]);
        figuren.add(new Linie(x, y, endx, endy));
        break;
      }
      figurData = dao.readNextFigurData();
    }
    return figuren;
  }
}
