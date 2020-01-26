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

    void drawWord(ArrayList<Character> visibleWord, ArrayList<Character> wrongGuesses) {
        //shows the guesser what letters have been guessed in the word
        System.out.println();
        System.out.print("    ");
        for (int i = 0; i < visibleWord.size(); i++) {
            System.out.print(visibleWord.get(i) + " ");
        }

        //shows the guesser which letters they've guessed wrong
        System.out.println("\n\n    Incorrect letters:");
        System.out.print("    ");
        for (int i = 0; i < wrongGuesses.size(); i++) {
            System.out.print(wrongGuesses.get(i) + ", ");
        }
    }

    //allows the user to select gamemode
    int getSelection() {
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

    //gets the players guess, checks if it is valid
    //if not, wait for valid guess
    String getPlayerGuess(ArrayList<String> guesses) {
        Word w = new Word(this);
        String guess;

        do {
            in = new Scanner(System.in);

            guess = in.nextLine().toUpperCase();

        } while (!(w.notPreviousGuess(guess, guesses)) || !(w.isValid(guess)));

        return guess;
    }

    //tells the players the the guesser has won, exits the program
    static void drawWin() {
        System.out.println("   _____ _    _ ______  _____ _____ ______ _____    __          _______ _   _  _____");
        System.out.println("  / ____| |  | |  ____|/ ____/ ____|  ____|  __ \\   \\ \\        / /_   _| \\ | |/ ____|");
        System.out.println(" | |  __| |  | | |__  | (___| (___ | |__  | |__) |   \\ \\  /\\  / /  | | |  \\| | (___");
        System.out.println(" | | |_ | |  | |  __|  \\___ \\\\___ \\|  __| |  _  /     \\ \\/  \\/ /   | | | . ` |\\___ \\");
        System.out.println(" | |__| | |__| | |____ ____) |___) | |____| | \\ \\      \\  /\\  /   _| |_| |\\  |____) |");
        System.out.println("  \\_____|\\____/|______|_____/_____/|______|_|  \\_\\      \\/  \\/   |_____|_| \\_|_____/");

        System.exit(1338);
    }

    //"clears" the console by printing 50 empty lines
    static void clearConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
