
public class EmptyField extends Field {

    public int bombsArround = 0;

    @Override
    public void mark() {
        if (state == State.VISIBLE)
        {
            return;
        }
        if (state != State.MARKED)
        {
            this.setState(State.MARKED);
        }
        else {
            this.setState(State.HIDDEN);
        }
    }

    @Override
    public void discover()
    {
        show();
        symbol = 'D';
        if (bombsArround == 0)
        {
            Observer.discoverNotBombsArround(id);
        }
    }

    @Override
    public void show()
    {
        if (state != State.VISIBLE)
        {
            state = State.VISIBLE;
            symbol = Integer.toString(bombsArround).charAt(0);
            discover();
            //
            symbol = 'S';
            Observer.increaseGoodMove();
        }

    }

    public void addNumberOfBombsArround(Field[][] matrix, Coordinates c)
    {
        int bombsArround = 0;
        for (int i = -1; i <= 2; i++) {
            for (int j = -1; j <= 2; j++) {
                if (isThereABomb(matrix, c.x+i, c.y+j))
                {
                    bombsArround++;
                }
            }
        }
        ((EmptyField)matrix[c.x][c.y]).bombsArround = bombsArround;
        matrix[c.x][c.y].symbol = Integer.toString(bombsArround).charAt(0);
    }

    private boolean isThereABomb(Field[][] matrix, int x, int y)
    {
        if (x < 0) return false;
        if (x > Observer.boardSize.x-1) return false;
        if (y < 0) return false;
        if (y > Observer.boardSize.y-1) return false;

        return (matrix[x][y].getClass() == Bomb.class);
    }
}
