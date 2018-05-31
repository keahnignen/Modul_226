import javax.swing.*;

public class Main {

    public static void main(String[] args) {
	// write your code here


        Figure f = new Circle(new Position(10, 10), 233);

        f.Move(new Position(103,102));

        display.hinzufuegen(new Line(new Position(0, 0), new Position(50, 50)));
        display.hinzufuegen(f);
        JOptionPane.showMessageDialog(null, "Sick", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
        RadioSelect rs = new RadioSelect();

    }

    public static final Display display = new Display();
}