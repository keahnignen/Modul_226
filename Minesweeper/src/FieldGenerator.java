import java.util.Random;

public final class FieldGenerator {


    private static Random random = new Random();

    public static Coordinates size;


    public static Field[][] getRandomField(int width, int height)
    {
        size = new Coordinates(width, height);
        Field[][] fieldMatrix = getMatrixWithBombs();

        for (int i = 0; i < Observer.boardSize.x; i++) {
            for (int j = 0; j < Observer.boardSize.y; j++) {
                if (fieldMatrix[i][j].getClass() == EmptyField.class)
                {
                    ((EmptyField)fieldMatrix[i][j]).addNumberOfBombsArround(fieldMatrix, new Coordinates(i, j));
                }
            }
        }

        return fieldMatrix;
    }

    private static boolean isThereABomb()
    {
        int r = random.nextInt(10);
        return (r == 0);
    }

    private static Field[][] getMatrixWithBombs()
    {
        Field[][] matrix = new Field[size.x][size.y];
        for (int i = 0; i < size.x; i++) {
            for (int j = 0; j < size.y; j++) {

                if (isThereABomb())
                {
                    matrix[i][j] = new Bomb();
                    matrix[i][j].symbol = Field.HIDDEN;
                }
                else
                {
                    matrix[i][j] = new EmptyField();

                }
                matrix[i][j].id = Integer.toString(i) + Integer.toString(j);
            }
        }
        return matrix;
    }





}
