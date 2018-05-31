import javax.swing.*;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException, InterruptedException {
	// write your code here


        Figure f = new Circle(new Position(10, 10), 233);

        f.move(new Position(103,102));

        display.hinzufuegen(new Line(new Position(0, 0), new Position(50, 50)));
        display.hinzufuegen(f);


        Figure figure = new Triangle(new Position(230, 120), new Position(0, 0), new Position(150, 230));
        figure.move(new Position(100, 100));

        display.hinzufuegen(figure);

        /*

        JOptionPane.showMessageDialog(null, "Sick", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
        RadioSelect rs = new RadioSelect();

        */


        String bla = "sd";



        String code = "System.out.println();";

        Process pro = Runtime.getRuntime().exec(code);
        pro.waitFor();

        Position p = new Position(2, 1);


        System.out.println(p.toString());

        /*
        String className = "Line";
        Class o = Class.forName(className);
        Constructor constructor = o.getConstructor(Position.class, Position.class);
        Object x = constructor.newInstance(p, p);
        */

    }

    public static final Display display = new Display();
}