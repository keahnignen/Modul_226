import Field.Coordinate;

/**
 * Start, restart and finishs the game
 */
public final class Game {

    public static Board board;

    public static void abortGame()
    {

    }

    public static void winGame()
    {

    }

    public static void exit(){

    }

    public static void startGame() {

        board = new Board(new Coordinate(10, 5), InputOutput.askForTestmode());
        nextRound();

    }

    public static void nextRound()
    {
        InputOutput.sendMessageNewLine(board.toString());
        InputOutput.read();
    }

}
