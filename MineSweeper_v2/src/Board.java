import Field.*;
import Field.Action;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Manages all Bombs and all Input
 */
public class Board {


    private static Random random = new Random();


    public Board(Coordinate coordinate, boolean testmode)
    {
        maximalFieldSize = coordinate;
        TargetMove = coordinate.x * coordinate.y -1; //TODO: Check this

        if (testmode)
        {
            fillFields();
        }
        else
        {
            populateFields();
        }
    }

    @Override
    public String toString()
    {
        StringBuilder s = new StringBuilder();

        List<List<Field>> matrix = getRows();

        if (matrix == null) return "Matrix is null";

        for (List<Field> row : matrix)
        {
           for (Field cell : row)
           {
                s.append(cell.symbol);
                s.append(' ');
           }
           s.append("\n\n");
        }
        return s.toString();
    }

    private int TargetMove;
    private int GoodMove = 0;

    private List<Field> fields = new ArrayList<Field>();

    private Coordinate maximalFieldSize;


    /**
     * Method for test mode
     */
    private void fillFields()
    {
        for (int x = 0; x < maximalFieldSize.x; x++) {
            for (int y = 0; y < maximalFieldSize.y; y++) {

                Field field =  new EmptyField(new Coordinate(x, y), 0);

                fields.add(field);

            }
        }
    }


    /**
     *
     * @return all rows as List of List
     */
    private List<List<Field>> getRows()
    {
        List<List<Field>> matrix = new ArrayList<List<Field>>();

        for (int i = 0; i < maximalFieldSize.y; i++) {
            List<Field> column = new ArrayList<Field>();
            for (Field field : fields)
            {
                if (field.coordinates.y == i)
                {
                    column.add(field);
                }
            }
            matrix.add(column);
        }
        return matrix;
    }


    private void populateFields()
    {
        for (int x = 0; x < maximalFieldSize.x; x++) {
            for (int y = 0; y < maximalFieldSize.y; y++) {

                if (couldThereBeABomb())
                {
                    fields.add(new Bomb(new Coordinate(x, y)));
                }

            }
        }
    }

    /**
     *
     * @return this is for generate the Field matrix
     */
    private boolean couldThereBeABomb()
    {
        int r = random.nextInt(8);
        return (r == 0);
    }

    private int getRandomNumber()
    {
        return random.nextInt(8);
    }


    /**
     * @param coordinate This is the middle coordinate
     */
    private List<Field> getNeighbourFields(Coordinate coordinate)
    {
        List<Field> fields = new ArrayList<Field>();
        for (Coordinate c: getNeighbours(coordinate)) {
            Field f = getField(c);

            f.symbol = 'S';
            fields.add(f);
        }

        //InputOutput.sendMessageNewLine(Integer.toString(fields.size()));
        return fields;
    }


    private void showCoordinates(Coordinate c)
    {
        InputOutput.sendMessageNewLine("x: " + c.x +  " y: " + c.y );
    }

    private List<Coordinate> getNeighbours(Coordinate ownCoordinates)
    {
        //showCoordinates(ownCoordinates);

        List<Coordinate> c = new ArrayList<Coordinate>();

        for (int x = -1; x < 2; x++) {
            for (int y = -1; y < 2; y++) {

                int newX = ownCoordinates.x+x;
                int newY = ownCoordinates.y+y;

                if (newX >= 0 && newY >= 0)
                {
                    if (newX <= maximalFieldSize.x && newY <= maximalFieldSize.y)
                    {
                        c.add(new Coordinate(newX, newY));
                    }
                }
            }
        }
        return c;
    }

    private Field getField(Coordinate c)
    {
        for (Field field: fields) {


            if (field.coordinates.isEqual(c))
            {
                return field;
            }
        }

        return null;
    }


    public void showField(Coordinate c)
    {
        Action a = getField(c).show();
        actionHandling(a);
        Game.nextRound();
    }

    public void markField(Coordinate c)
    {
        Action a = getField(c).mark();
        actionHandling(a);
        Game.nextRound();
    }

    private void ChangeGoodMove(boolean increase)
    {
        if (increase)
        {
            GoodMove++;
            if (GoodMove == TargetMove)
            {
                Game.winGame();
            }
        }
        else
        {
            GoodMove--;
        }
    }

    private void actionHandling(Action action)
    {
        InputOutput.sendMessageNewLine("ActionHandling was called");
        try {
            if (action.endOfGame)
            {
                InputOutput.sendMessageNewLine("Was aborted");
                Game.abortGame();
                return;
            }
            else
            {
                switch (action.doWithGoodMove)
                {
                    case Action.DECREASE:
                        ChangeGoodMove(false);
                        break;
                    case Action.INCREASE:
                        ChangeGoodMove(true);
                        break;
                }
                if (action.discover != null)
                {

                    List<Field> fields = getNeighbourFields(action.discover);

                    InputOutput.sendMessageNewLine(Integer.toString(fields.size()));

                    Object[] fieldArray = fields.toArray();

                    for (int i = 0; i < fields.size(); i++) {

                        InputOutput.sendMessageNewLine("Itteration: " + i);
                        Action c = ((EmptyField)fieldArray[i]).show();
                        actionHandling(c);
                        InputOutput.sendMessageNewLine("YOU WILL NEVER READ THIS MESSAGE");
                    }


                /*
                for (Field field : fields) {

                    InputOutput.sendMessageNewLine("asdas");
                    Action c = ((EmptyField)field).show();
                    actionHandling(c);
                }

                */
                }
            }

        }
        catch (Exception e)
        {
            InputOutput.sendMessageNewLine(e.getMessage());
        }


    }





}
