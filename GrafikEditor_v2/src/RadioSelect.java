import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class RadioSelect extends JFrame {
    public RadioSelect() {
        JRadioButton circle = new JRadioButton("Circle");
        JRadioButton rectangle = new JRadioButton("Rectangle");
        JRadioButton line = new JRadioButton("Line");
        JRadioButton lines = new JRadioButton("Lines");
        ButtonGroup bG = new ButtonGroup();


        bG.add(circle);
        bG.add(line);
        bG.add(lines);
        bG.add(rectangle);

        this.setSize(100, 200);
        this.setLayout(new FlowLayout());

        this.add(circle);
        this.add(line);
        this.add(lines);
        this.add(rectangle);

        circle.setSelected(true);
        this.setVisible(true);


    }

    public enum Types {
        circle,
        line,
        lines,
        rectangle
    }

    public static Types TypesSelected;


    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            // Your selected code here.
        }
        else if (e.getStateChange() == ItemEvent.DESELECTED) {
            // Your deselected code here.
        }
    }

}
