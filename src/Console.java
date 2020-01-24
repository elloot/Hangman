import java.util.ArrayList;
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

    //draws a certain stage of the hanged man based on
    //how many guesses are left and shows how many guesses are left
    void drawMan(int numGuesses, ArrayList<Character> underscores) {
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

        System.out.print(underscores);
    }

    int getSelection() {
        //asks user for wanted gamemode
        int gameSelect;
        do {
            //saves the program from crashing if input is NaN
            try {
                gameSelect = in.nextInt();
            } catch (InputMismatchException e) {
                gameSelect = 0;
            }
            //"clears" the scanner
            in = new Scanner(System.in);

            if (gameSelect != 1 && gameSelect != 2) {
                System.out.print("That's not the right input! ");
            }

        } while (gameSelect != 1 && gameSelect != 2);

        //"clears" the scanner again"
        in = new Scanner(System.in);

        return gameSelect;
    }

    //gets a word to be guessed at from the player
    String getPlayerWord() {
        Word w = new Word(this);
        String inWord;
        do {
            in = new Scanner(System.in);

            inWord = in.nextLine();

        } while (!(w.isValid(inWord)));
        return inWord.toUpperCase();
    }

    String getPlayerGuess() {
        Word w = new Word(this);
        String guess;
        do {
            in = new Scanner(System.in);

            guess = in.nextLine();

        } while (!(w.isValid(guess)));
        return guess;
    }
    static void drawWin() {
        System.out.println("  _____ _    _ ______  _____ _____ ______ _____    __          _______ _   _  _____");
        System.out.println("  / ____| |  | |  ____|/ ____/ ____|  ____|  __ \\   \\ \\        / /_   _| \\ | |/ ____|");
        System.out.println(" | |  __| |  | | |__  | (___| (___ | |__  | |__) |   \\ \\  /\\  / /  | | |  \\| | (___");
        System.out.println(" | | |_ | |  | |  __|  \\___ \\\\___ \\|  __| |  _  /     \\ \\/  \\/ /   | | | . ` |\\___ \\");
        System.out.println(" | |__| | |__| | |____ ____) |___) | |____| | \\ \\      \\  /\\  /   _| |_| |\\  |____) |");
        System.out.println("  \\_____|\\____/|______|_____/_____/|______|_|  \\_\\      \\/  \\/   |_____|_| \\_|_____/");
    }

    static void clearConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
