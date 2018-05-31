//package lektion2;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

/**
 * Die Klasse Display stellt ein Fenster auf dem Bildschirm zur Verfügung, in welchem
 * Figure-Objekte dargestellt werden können.
 * Siehe auch Java-Grundkurs Abschnitt 10.2 und 10.3.
 * 
 * @author Andres Scheidegger
 */
@SuppressWarnings("serial")
public class Display extends JFrame {
  /** Die Liste der dargestellten Figure-Objekte */
  private List<Figure> figures = new ArrayList<>();

  /**
   * Konstruktor. Initialisiert das Fenster in der Mitte des Bildschirms und erzeugt ein
   * JFrame-Objekt, auf welchem die Figuren gezeichnet werden.
   */
  public Display() {
    Dimension windowSize = new Dimension(800, 600);
    setSize(windowSize);
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int windowPositionX = (screenSize.width - windowSize.width) / 2;
    int windowPositionY = (screenSize.height - windowSize.height) / 2;
    Point windowPosition = new Point(windowPositionX, windowPositionY);
    setLocation(windowPosition);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    createAndAddDrawingPanel();
    setVisible(true);


  }

  private void createAndAddDrawingPanel() {
    // Das JPanel-Objekt ist ein Objekt einer anonymen Unterklasse von JPanel
    // Siehe Java-Grundkurs Abschnitt 3.9
    add(new JPanel() {
      // Die paintComponent()-Methode wird automatisch aufgerufen, wenn irgendwer die repaint()-
      // Methode beim Dsiplay aufruft.
      @Override
      protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        zeichneFiguren(g);
          addMouseListener(new MouseListener() {
              public void mousePressed(MouseEvent me) { }
              public void mouseReleased(MouseEvent me) { }
              public void mouseEntered(MouseEvent me) { }
              public void mouseExited(MouseEvent me) { }
              public void mouseClicked(MouseEvent me) {
                  if(me.getButton() == MouseEvent.BUTTON1) {
                    MouseClick(me.getPoint());
                  }
                  if(me.getButton() == MouseEvent.BUTTON2) {
                      //label.setText("Middle Click!");
                  }
                  if(me.getButton() == MouseEvent.BUTTON3) {
                      //label.setText("Right Click!");
                  }
              }
          });
      }
    });
  }

  /**
   * Zeichnet alle Figuren.
   * @param g Referenz auf das Graphics-Objekt zum zeichnen.
   */


  private boolean newLine = false;

  private Position p = new Position(0, 0);




  private void MouseClick(Point p)
  {

      Position newP = new Position(p.x, p.y);


      if (newLine)
      {
          this.p = newP;
      }
      else
      {
          hinzufuegen(new Line(this.p, newP));
      }

      this.p = newP;
      //newLine = !newLine;
  }



  private void zeichneFiguren(Graphics g) {
      for (Figure f : figures) {
          f.draw(g);
      }
  }

  /**
   * Fügt eine weitere Figure hinzu und löst die Auffrischung des Fensterinhaltes aus.
   * @param figure Referenz auf das weitere Figure-Objekt.
   */
  public void hinzufuegen(Figure figure) {
    figures.add(figure);
    repaint();
  }

  /**
   * Löscht alle Figuren und löst die Auffrischung des Fensterinhaltes aus.
   */
  public void allesLoeschen() {
    figures.clear();
    repaint();
  }
}

