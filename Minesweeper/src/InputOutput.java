import java.util.Scanner;

public class InputOutput {


    private Scanner scanner = new Scanner(System.in);

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


    public void refresh()
    {
        Field[][] matrix = Observer.getFields();
        //StringBuilder s = new StringBuilder();

        for (int i = -1; i < Observer.boardSize.x; i++) {
            for (int j = -1; j < Observer.boardSize.y; j++) {

                if (j == -1) //First Vertical
                {
                    System.out.print(i);
                    //s.append(i);
                }
                else {

                    if (i == -1) //First Horizotnal
                    {
                        System.out.print(j);
                        //s.append(j);
                    }
                    else
                    {
                        System.out.print(matrix[i][j].symbol);
                        /*
                        if (matrix[i][j].state != State.HIDDEN) //TODO: THIS IS WRONG
                        {
                            s.append(matrix[i][j].symbol);
                        }
                        else
                        {
                            s.append(' ');
                        }
                        */
                    }
                }

            }

            System.out.println("");
            //s.append("\n");
        }
        //sendMessage(s.toString());
    }


    public void sendMessage(String message)
    {
        System.out.println(message);
    }

    public void askForPlayingContinue()
    {
        sendMessage(CONTINUE_PLAY);

        if (isAnswerYes())
        {
            Observer.startGame();
        }
        else
        {
            Observer.finishGame();
        }
    }

    public boolean isAnswerYes()
    {
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

    //TODO: Make field size Adjustable
    public Coordinates getFieldSize()
    {
        return new Coordinates(8, 8);
    }

    public void read()
    {
        String s = scanner.nextLine();
        analyseString(s);
    }

    private void analyseString(String commandString) {

        if (commandString.length() == COMMAND_LENGTH)
        {

            if(Character.isDigit(commandString.charAt(INDEX_OF_X)) && Character.isDigit(commandString.charAt(INDEX_OF_Y)))
            {
                int x = Character.getNumericValue(commandString.charAt(INDEX_OF_X));
                int y = Character.getNumericValue(commandString.charAt(INDEX_OF_Y));

                switch (Character.toUpperCase(commandString.charAt(INDEX_OF_FUNCTION)))
                {
                    case MARK:
                        Observer.markField(Observer.getFieldId(x, y));
                        break;
                    case SHOW:
                        Observer.showField(Observer.getFieldId(x, y));
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
                    Observer.startGame();
                    break;
                case EXIT:
                    Observer.finishGame();
                default:
                    explainHelp();
                    break;
            }
        }

    }


    public void nextRound()
    {
        refresh();
        read();
    }

    private void explainHelp() {
        sendMessage(ERROR_STRING);
        read();
    }

    private void showHelp()
    {
        sendMessage(HELP_STRING);
        read();
    }


}
