
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

final class EditorControl {
  private Zeichnung zeichnung = new Zeichnung();
  private char figurTyp;
  private Point ersterPunkt;



  public void allesNeuZeichnen(Graphics g) {
    zeichnung.zeichneFiguren(g);
  }

  public void setFigurTyp(char figurTyp) {
    this.figurTyp = figurTyp;
  }

  public void setErsterPunkt(Point ersterPunkt) {
    this.ersterPunkt = ersterPunkt;
  }

  public void erzeugeFigurMitZweitemPunkt(Point zweiterPunkt) {

      System.out.println(ersterPunkt);
      System.out.println(zweiterPunkt);



      int durchmesser =  Math.abs(zweiterPunkt.x/ 2);

      if (ersterPunkt.x < zweiterPunkt.x)
      {

      }

      Position p = new Position(ersterPunkt.x, ersterPunkt.y);



     int breite = zweiterPunkt.x - ersterPunkt.x;
    int hohe = zweiterPunkt.y - ersterPunkt.y;

    //zeichnung.hinzufuegen(new Rectangle(p, new Size(breite, hohe)));
    switch (figurTyp)
    {
        case Circle:
            zeichnung.hinzufuegen(new Circle(p, breite / 2));
            break;
        case Line:
            zeichnung.hinzufuegen(new Line(p, new Position(zweiterPunkt.x, zweiterPunkt.y)));
            break;
        case Rectangle:
            zeichnung.hinzufuegen(new Rectangle(p, new Size(breite, hohe)));
            break;


    }

  }



    public final char Circle = 'c';
    public final char Line = 'l';
    public final char Rectangle = 'r';

}
