import java.util.Arrays;
import java.util.Random;

public class NotStatic {

    public NotStatic()
    {
        aufgabeOne();
        aufgabeTwo();
    }

    private void aufgabeTwo() {
    }

    private void aufgabeOne() {

        int numberOfNumbers = 30;

        int[] arrayOfNumber = new int[numberOfNumbers];

        for (int i = 0; i < numberOfNumbers; i++) {
            arrayOfNumber[i] = getRandomNumber();
        }

        printAnArray(arrayOfNumber);

        for (int i = 0; i < numberOfNumbers; i++) {
            for (int j = 0; j < numberOfNumbers; j++) {
                if (arrayOfNumber[i] < arrayOfNumber[j])
                {
                    int temp = arrayOfNumber[j];
                    arrayOfNumber[j] = arrayOfNumber[i];
                    arrayOfNumber[i] = temp;
                }
            }
        }

        System.out.println("\n and now the soreted array");
        printAnArray(arrayOfNumber);

    }

    private Random random = new Random();

    private int getRandomNumber() {
        return random.nextInt(50);
    }

    private void printAnArray(int[] array)
    {
        for (int i:array
             ) {
            System.out.println(i);
        }
    }
}
