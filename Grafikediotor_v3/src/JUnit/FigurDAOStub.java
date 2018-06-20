package JUnit;

public class FigurDAOStub implements FigurDAO {

    private String[] testFigures  = {
            "Rechteck\t12\t23\t39\t23",
            "Kreis\t67 251\t23",
            "Linie\t150\t140\t35\t50"
    };


    private int counter = 0;

    @Override
    public String[] readNextFigurData() {
        if (counter >= testFigures.length) return null;
        String line = testFigures[counter];
        counter++;
        return line.split("\\s");
    }
}
