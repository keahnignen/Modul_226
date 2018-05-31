public final class Observer {

    private static Board board;
    private static InputOutput inputOutput = new InputOutput();

    public static Coordinates boardSize;

    public static void startGame(){
        boardSize = inputOutput.getFieldSize();
        board = new Board(boardSize);
        board.initField();
        inputOutput.nextRound();
    }

    public static void markField(String id) { board.markField(id); }
    public static void showField(String id) {

        //board.showField(id);
        board.TestShow(id);
    }

    public static void abortGame(){
        inputOutput.askForPlayingContinue();
    }
    public static void finishGame(){System.exit(0);}

    public static void increaseGoodMove(){
        board.increaseGoodMoves();
        inputOutput.nextRound();
    }

    public static void decreaseGoodMove() {
        board.decreaseGoodMove();
        board.initField();
        inputOutput.nextRound();
    }

    public static Field[][] getFields()
    {
        return board.getFields();
    }

    public static String getFieldId(int x, int y)
    {
        return board.getFieldId(x, y);
    }

    public static void sendMessage(String message)
    {
        inputOutput.sendMessage(message);
    }

    public static Coordinates getCoordinatesById(String id) {
        sendMessage(id);
        Coordinates c = board.getCoordinatesById(id);
        return c;
    }

    public static void discoverNotBombsArround(String id)
    {
        board.discoverField(id);
    }


}
