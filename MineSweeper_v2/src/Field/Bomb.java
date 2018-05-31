package Field;

/**
 * The field with a Bomb
 */
public class Bomb extends Field {


    public Bomb(Coordinate c)
    {
        this.coordinates = c;
        symbol = HIDDEN;
    }

    @Override
    public Action mark() {
        if (state != State.MARKED)
        {
            this.setState(State.MARKED);
            return new Action();
        }
        else {
            this.setState(State.HIDDEN);

            return new Action(Action.DECREASE, false, null);
        }

    }

    @Override
    public Action show()
    {
         return new Action(Action.DECREASE, true, null);
    }
}
