
public class Field {


    public String id;
    public int state = State.HIDDEN;
    public char symbol;

    public static final char MARKED = 'M';
    public static final char HIDDEN = ' ';

    protected Field()
    {
        //THERE IS NOTHING
    }

    public void mark() {
        //THERE IS NOTHING
    }

    public void show() {
        //THERE IS NOTHING
    }

    public void discover()
    {
        //THERE IS NOTHING
    }

    public void setState(int state)
    {
        this.state = state;
        if (state == State.MARKED) this.symbol = MARKED;
        if (state == State.HIDDEN) this.symbol = HIDDEN;

    }
}
