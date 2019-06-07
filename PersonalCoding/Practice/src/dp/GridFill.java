package dp;


import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GridFill {

    // Complete the crosswordPuzzle function below.
    static String[] crosswordPuzzle(String[] crossword, String words) {
        for (String str: crossword) {
            System.out.println(str);
        }

        List<String> wordList = Arrays.asList(words.split(";"));
        
        
        return null;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] crossword = new String[10];

        for (int i = 0; i < 10; i++) {
            String crosswordItem = scanner.nextLine();
            crossword[i] = crosswordItem;
        }

        String words = scanner.nextLine();

        String[] result = crosswordPuzzle(crossword, words);

        for (int i = 0; i < result.length; i++) {
            System.out.println((result[i]));

            if (i != result.length - 1) {
            	System.out.println("\n");
            }
        }

        System.out.println();


        scanner.close();
    }
}
