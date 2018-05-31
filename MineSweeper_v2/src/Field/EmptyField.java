package Field;


/**
 * The Field without a Bomb
 */
public class EmptyField extends Field {

    private int bombsArround = 0;

    public EmptyField(Coordinate c, int bombsArround)
    {
        this.coordinates = c;
        this.bombsArround = bombsArround;
        this.symbol = HIDDEN;
    }

    @Override
    public Action mark() {

        if (state != State.VISIBLE)
        {
            if (state != State.MARKED)
            {
                this.setState(State.MARKED);
            }
            else {
                this.setState(State.HIDDEN);
            }

        }
        return new Action(Action.WITH_OUT_CHANGE, false, null);
    }

    @Override
    public Action show()
    {
        if (state != State.VISIBLE)
        {
            makeVisible();
            Coordinate c = null;
            if (bombsArround == 0) {
                c = this.coordinates;
            }
            return new Action(Action.INCREASE, false, c);
        }
        return new Action(Action.WITH_OUT_CHANGE, false, null);
    }


    public void makeVisible()
    {
        state = State.VISIBLE;
        symbol = Integer.toString(bombsArround).charAt(0);
    }


}
