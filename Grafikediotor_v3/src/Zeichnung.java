import Figures.Figure;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Zeichnung {

    private List<Figure> figures = new ArrayList<>();


    public void zeichneFiguren(Graphics g) {

        for (Figure f : figures) {
            f.draw(g);
        }
    }

    /**
     * F?gt eine weitere Figures.Figure hinzu und l?st die Auffrischung des Fensterinhaltes aus.
     * @param figure Referenz auf das weitere Figures.Figure-Objekt.
     */
    public void hinzufuegen(Figure figure) {
        figures.add(figure);

    }

    /**
     * L?scht alle Figuren und l?st die Auffrischung des Fensterinhaltes aus.
     */
    public void allesLoeschen() {
        figures.clear();
    }
}
