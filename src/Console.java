import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class description
 * 2020-01-17
 * Author: Elliot Duchek, Tobias Sandström
 */
class Console {
    //initialises scanner for all methods to use
    private Scanner in = new Scanner(System.in);

    void drawMan(int numGuesses) {
        switch (numGuesses) {
            case 0:
                System.out.println("      _______");
                System.out.println("     |/      |");
                System.out.println("     |      \\O/");
                System.out.println("     |       |");
                System.out.println("     |      / \\ ");
                System.out.println("     |              Picker wins!");
                System.out.println("    _|___");
                break;
            case 1:
                System.out.println("      _______");
                System.out.println("     |/      |");
                System.out.println("     |      \\O/");
                System.out.println("     |       |");
                System.out.println("     |      / ");
                System.out.println("     |              Guesses remaining: " + numGuesses);
                System.out.println("    _|___");
                break;
            case 2:
                System.out.println("      _______");
                System.out.println("     |/      |");
                System.out.println("     |      \\O/");
                System.out.println("     |       |");
                System.out.println("     |");
                System.out.println("     |              Guesses remaining: " + numGuesses);
                System.out.println("    _|___");
                break;
            case 3:
                System.out.println("      _______");
                System.out.println("     |/      |");
                System.out.println("     |      \\O");
                System.out.println("     |       |");
                System.out.println("     |");
                System.out.println("     |              Guesses remaining: " + numGuesses);
                System.out.println("    _|___");
                break;
            case 4:
                System.out.println("      _______");
                System.out.println("     |/      |");
                System.out.println("     |       O");
                System.out.println("     |       |");
                System.out.println("     |");
                System.out.println("     |              Guesses remaining: " + numGuesses);
                System.out.println("    _|___");
                break;
            case 5:
                System.out.println("      _______");
                System.out.println("     |/      |");
                System.out.println("     |       O");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |              Guesses remaining: " + numGuesses);
                System.out.println("    _|___");
                break;
            case 6:
                System.out.println("      _______");
                System.out.println("     |/      |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |              Guesses remaining: " + numGuesses);
                System.out.println("    _|___");
                break;
        }
    }

    int getSelection() {
        //asks user for wanted gamemode
        int gameSelect;
        do {
            try {
                gameSelect = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("That's not a number, please input either 1 or 2");
                gameSelect = 0;
            }

        } while (gameSelect != 1 && gameSelect != 2);

        in.nextLine();

        return gameSelect;
    }

    String getPlayerWord() {
        String inWord;
        do {
            inWord = in.nextLine();

            for (int i = 0; i < inWord.length(); i++) {
                if (!(Character.isLetter(inWord.charAt(i)))) {
                    System.out.println("\"" + inWord + "\"" + " is not a valid word, please try again");
                    inWord = null;
                    break;
                }
            }

        } while (inWord == null);

        return inWord;
    }
}
