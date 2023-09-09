import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.util.*;

public class GarciaAlliA1P2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of input file(src/filename): ");
        String filename = scanner.nextLine();
        scanner.close();
        File file = new File(filename);
        int sum = 0;
        int validLines = 0;
        int invalidLines = 0;

        try (Scanner fileScanner = new Scanner(file);) {

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();

                String[] tokens = line.split(" ");
                if (tokens.length >= 2) {
                    String studentName = tokens[0];
                    String scoreToken = tokens[1];
                    try {
                        int score = Integer.parseInt(scoreToken);
                        sum += score;
                        validLines++;
                        /*System.out.print(studentName + " ");
                        System.out.println(score);*/
                    } catch (NumberFormatException ex) {
                        invalidLines++;
                        System.out.println("Cannot parse " + scoreToken + " as an integer");
                    }
                } else {
                    invalidLines++;
                    System.out.println("Line does not have two items: " + line + "\n");
                }
            }
        } catch (FileNotFoundException ex) {
                System.out.println("Source file " + filename + " doesn't exists: " + ex.getMessage());
                System.exit(1);
            }
            if (validLines > 0) {
                double avg = (double) sum / validLines;
                System.out.println("Average of grades is " + Math.round(avg));
            } else {
                System.out.println("Average of grades can't be calculated, there are no grades.");

            }
            System.out.println("Number of parsable lines: " + validLines);
            System.out.println("Number of unparsable lines: " + invalidLines);

        }
    }