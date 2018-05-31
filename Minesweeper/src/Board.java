
public class Board {

    private Field[][] fields;
    private int actualGoodMoves = 0;
    private final int targetGoodMoves;

    public Board(Coordinates coordinates)
    {
        targetGoodMoves = coordinates.x * coordinates.y - 1;
    }

    public void initField( )
    {
        fields = FieldGenerator.getRandomField(Observer.boardSize.x, Observer.boardSize.y);
    }

    public void markField(String id)
    {
        getField(id).mark();
    }

    public void showField(String id)
    {
        getField(id).show();
    }

    public void discoverField(String id) {
        getField(id).discover();
    }

    public void increaseGoodMoves()
    {
        actualGoodMoves++;
    }

    public void decreaseGoodMove() { actualGoodMoves--; }


    public Field[][] getFields() {
        return fields;
    }

    public Coordinates getCoordinatesById(String id)
    {
        try {

            System.out.println("sadas");
            for (int i = 0; i < Observer.boardSize.x; i++) {
                System.out.println("sadasasdas");
                for (int j = 0; j < Observer.boardSize.y; j++) {
                    System.out.println(Boolean.toString(fields[0][0] == null));
                    System.out.println(fields[i][j].id);
                    if (fields[i][j].id.equals(id))
                    {
                        return new Coordinates(i, j);
                    }
                }
            }
            throw new Exception();
        }
        catch (Exception s)
        {
            System.out.println("Field Id: "+  id + " does not exist");
            return null;
        }
    }

    public String getFieldId(int x, int y)
    {
        return fields[x][y].id;
    }

    private Field getField(String id) {
        for (Field[] fieldArray: fields) {
            for (Field field : fieldArray)
            {
                if (field.id.equals(id))
                {
                    return field;
                }
            }
        }
        return null;
    }

    public void TestShow(String id)
    {
        getField(id).symbol = 'L';
        Observer.increaseGoodMove();
    }


}
