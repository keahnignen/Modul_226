

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
final class EditorFrame extends JFrame implements KeyListener {
  private EditorControl editorControl = new EditorControl();
  
  public EditorFrame(int breite, int hoehe) {
    erzeugeUndSetzeEditorPanel();
    fensterEinmitten(breite, hoehe);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
    addKeyListener(this);
  }

  private void erzeugeUndSetzeEditorPanel() {
    JPanel panel = new EditorPanel(editorControl);
    setContentPane(panel);
  }

  private void fensterEinmitten(int breite, int hoehe) {
    Dimension bildschirmGroesse = Toolkit.getDefaultToolkit().getScreenSize();
    Rectangle fensterAusschnitt = new Rectangle();
    fensterAusschnitt.width = breite;
    fensterAusschnitt.height = hoehe;
    fensterAusschnitt.x = (bildschirmGroesse.width - fensterAusschnitt.width) / 2;
    fensterAusschnitt.y = (bildschirmGroesse.height - fensterAusschnitt.height) / 2;
    setBounds(fensterAusschnitt);
  }


  @Override
  public void keyTyped(KeyEvent e) {

  }

  @Override
  public void keyPressed(KeyEvent e) {

    if (e.getKeyChar() == editorControl.Circle || e.getKeyChar() == editorControl.Line || e.getKeyChar() == editorControl.Rectangle) editorControl.setFigurTyp(e.getKeyChar());

  }

  @Override
  public void keyReleased(KeyEvent e) {

  }
}
