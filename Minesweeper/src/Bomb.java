public class Bomb extends Field {

    @Override
    public void mark() {
        if (state != State.MARKED)
        {
            this.setState(State.MARKED);
            Observer.increaseGoodMove();
        }
        else {
            this.setState(State.HIDDEN);
            Observer.decreaseGoodMove();
        }
    }

    @Override
    public void show()
    {
        Observer.sendMessage("This was a Bomb!");
        Observer.abortGame();
    }
}
