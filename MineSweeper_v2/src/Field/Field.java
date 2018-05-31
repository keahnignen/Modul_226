package Field;

/**
 * The parent class of
 * @see Bomb
 * @see EmptyField
 */
public class Field {

    protected Field(Coordinate coordinates)
    {
        this.coordinates = coordinates;
    }

    public Coordinate coordinates;

    public char symbol;
    public int state;

    public static final char MARKED = 'M';
    public static final char HIDDEN = '_';

    protected Field()
    {
        //THERE IS NOTHING
    }

    public Action mark() {
        //THERE IS NOTHING
        return new Action();
    }

    public Action show() {
        //THERE IS NOTHING
        return new Action();
    }


    public void setState(int state)
    {
        this.state = state;
        switch (state)
        {
            case State.HIDDEN:
                symbol = HIDDEN;
                break;
            case State.MARKED:
                symbol = MARKED;
                break;

        }
    }

}
