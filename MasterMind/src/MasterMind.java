import java.util.Random;
import java.util.Scanner;

public class MasterMind {

    private static final char restartKey = 'y';
    private static final char[] possibleChars = {'r', 'g', 'b', 'y', 's', 'w'};
    private static final int numberOfColors = 4;

    private static final String introduction = "\nGeben Sie einen Versuchscode mit vier Burchstaben aus der Menge {r, g , b, y, s und w} ein:";
    private static final String itIsAtCorrectPlace = " und befindet Sich am Richtigen Platz";
    private static final String itExist = " kommt vor";
    private static final String error = "\nAlle oder mindestens eine Farbe ist falsch.\n\n";
    private static final String congratulation = "\nGratulation!\n\nDer Geheimcode war: ";
    private static final String restart = "\nGeben Sie " + restartKey +  " ein um neu zu starten.\n";
    private static final String aColor = "Eine Farbe davon";

    private final Random randomGenerator = new Random();
    private final Scanner scanner = new Scanner(System.in);
    private String colorList = "";
    private int loops  = 0;

    public void startGame() {
        while (true)
        {
            fillColorList();
            System.out.println(introduction);
            sendMessage(colorList, ' '); //Just for Debug
            evaluateUserInput();
            if (playerWantToConntinue())
            {
                break;
            }
            loops = 0;
        }
    }

    private void evaluateUserInput()
    {
        while (true)
        {
            loops++;
            String input = scanner.next();
            if (!input.equals(colorList))
            {
                System.out.print(error);
            }
            else
            {
                break;
            }

            for (int j = 0; j < input.length(); j++) {
                isItInUse(input.charAt(j), j);
            }

            System.out.println(introduction);
        }
    }

    private boolean playerWantToConntinue()
    {
        System.out.print(congratulation);
        sendMessage(colorList, ' ');
        System.out.print("Sie haben " + Integer.toString(loops) + " versuch(e) gebraucht");
        System.out.print(restart);
        return !scanner.next().equals(Character.toString(restartKey));
    }

    private void fillColorList()
    {
        colorList = "";
        while (true){
            boolean isNew = true;
            char randomChar = getRandomChar();
            if (colorList.isEmpty())
            {
                isNew = true;
            }
            else
            {
                for (int j = 0; j < colorList.length(); j++) {
                    if (colorList.charAt(j) == randomChar)
                    {
                        isNew = false;
                        break;
                    }
                }
            }
            if (isNew)
            {
                colorList += randomChar;
            }
            if (colorList.length() == numberOfColors)
            {
                break;
            }
        }
    }

    private char getRandomChar() {
        return possibleChars[randomGenerator.nextInt(5+1)];
    }

    private void isItInUse(char c, int index)
    {
        for (int j = 0; j < colorList.length(); j++) {
            if (colorList.charAt(j) == c)
            {
                if (j == index)
                {
                    //sendMessage(itExist + itIsAtCorrectPlace, c);
                    System.out.println("Eine Farbe davon" + itExist + itIsAtCorrectPlace);
                    return;
                }
                //sendMessage(itExist, c);
                System.out.println("Eine Farbe davon" + itExist);
            }
        }
    }

    private void sendMessage(String s, char c)
    {
        System.out.println(c + s);
    }

}
