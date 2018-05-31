import Field.Coordinate;

import java.util.Scanner;

public final class InputOutput {

    private static Scanner scanner = new Scanner(System.in);

    private static final String HELP_COMMAND = "--help";
    private static final char MARK = 'M';
    private static final char SHOW = 'S';


    private static final int INDEX_OF_FUNCTION = 0;
    private static final int INDEX_OF_X = 1;
    private static final int INDEX_OF_Y = 2;

    private static final int COMMAND_LENGTH = 3;

    private static final String TABULATOR = "      ";


    private static final String RESTART = "RESTART";
    private static final String EXIT = "EXIT";

    private static final String HELP_STRING =
            RESTART +":" + TABULATOR + "Restart Game"+ "\n"+
                    EXIT +"Exit:" + TABULATOR + "Exit Game"+ "\n"+
                    "[Option][Coordinate X][Coordinate Y]:" + "\n"+
                    TABULATOR + "Option:"+ "\n"+
                    TABULATOR + TABULATOR + MARK + TABULATOR + "Mark Field"+ "\n"+
                    TABULATOR + TABULATOR + SHOW + TABULATOR + "Show Field"+ "\n"+
                    TABULATOR + "Example:"+ "\n"+
                    TABULATOR + TABULATOR + "M12" + TABULATOR + "Mark Field 1, 2"+ "\n"+
                    TABULATOR + TABULATOR + "S23"+ TABULATOR + "Show Field 2, 3"+ "\n";

    private static final String ERROR_STRING = "Command Error. Type '" + HELP_COMMAND + "' in.";

    private static final String Y_OR_N = "Y or N";

    private static final String CONTINUE_PLAY = "Wonna continue to play?";


    public static boolean askForTestmode()
    {
        sendMessageNewLine("Wonna start in Testmode");
        return isAnswerYes();
    }


    public static void sendMessage(String message) {
        System.out.print(message);
    }

    public static void sendMessageNewLine(String message) {
        System.out.println(message);
    }

    public static void read()
    {
        String s = scanner.nextLine();
        analyseString(s);
    }

    public static void askForPlayingContinue()
    {
        sendMessage(CONTINUE_PLAY);

        if (isAnswerYes())
        {
            Game.startGame();
        }
        else
        {
            Game.exit();
        }
    }

    private static boolean isAnswerYes() {
        while(true)
        {
            String s = scanner.nextLine();
            switch (s.toUpperCase().charAt(0))
            {
                case 'Y':
                    return true;
                case 'N':
                    return false;
                default:
                    sendMessage(Y_OR_N);
            }
        }

    }

    private static void analyseString(String commandString) {

        if (commandString.length() == COMMAND_LENGTH)
        {

            if(Character.isDigit(commandString.charAt(INDEX_OF_X)) && Character.isDigit(commandString.charAt(INDEX_OF_Y)))
            {
                int x = Character.getNumericValue(commandString.charAt(INDEX_OF_X));
                int y = Character.getNumericValue(commandString.charAt(INDEX_OF_Y));

                switch (Character.toUpperCase(commandString.charAt(INDEX_OF_FUNCTION)))
                {
                    case MARK:
                        Game.board.markField(new Coordinate(x, y));
                        break;
                    case SHOW:
                        Game.board.showField(new Coordinate(x, y));
                        break;
                    default:
                        explainHelp();
                        break;
                }

            }
            else
            {
                explainHelp();
            }

        }
        else
        {
            switch (commandString.toUpperCase())
            {
                case HELP_COMMAND:
                    showHelp();
                    break;
                case "?":
                    showHelp();
                    break;
                case RESTART:
                    Game.startGame();
                    break;
                case EXIT:
                    Game.exit();
                default:
                    explainHelp();
                    break;
            }
        }

    }

    private static void explainHelp() {
        sendMessageNewLine(ERROR_STRING);
        read();
    }

    private static void showHelp() {
        sendMessageNewLine(HELP_STRING);
        read();
    }

}
