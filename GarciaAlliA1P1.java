import java.util.Random;
import java.util.*;


public class GarciaAlliA1P1 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        boolean continueInput = true;
        int[] randomArray = new int[100];
        for (int i = 0; i < 100; i++){
            randomArray[i] = random.nextInt(1000);
        }
        System.out.println("Enter an integer between 0-99.");
        do {
            try {
                int index = scanner.nextInt();
                if (index >= 0 && index < 100) {
                    int element = randomArray[index];
                    System.out.println("The element at index " + index + " is " + element);
                    continueInput = false;
                } else {
                    System.out.println("Try again. (Incorrect input: an integer is required)");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Try again. (Incorrect input: an integer is required)");
                scanner.nextLine();
            }
        } while (continueInput);
        scanner.close();
    }


}


