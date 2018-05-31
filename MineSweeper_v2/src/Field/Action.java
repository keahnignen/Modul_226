package Field;

/**
 * This is the return value of all fields.
 * Here is the description, what the Board have to do.
 */

public class Action {

    public Action()
    {
        this.endOfGame = false;
        this.doWithGoodMove = Action.INCREASE;
        this.discover = null;
    }

    public Action(int doWithGoodMove, boolean endOfGame, Coordinate discover)
    {
        this.endOfGame = endOfGame;
        this.doWithGoodMove = doWithGoodMove;
        this.discover = discover;
    }

    public int doWithGoodMove;
    public boolean endOfGame;
    public Coordinate discover;


    public final static int WITH_OUT_CHANGE = 0;
    public final static int INCREASE = 1;
    public final static int DECREASE = -1;

}
