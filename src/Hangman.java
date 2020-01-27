import java.util.ArrayList;

/**
 * Class description
 * 2020-01-17
 * Author: Elliot Duchek, Tobias Sandström
 */
class Hangman {
    public static void main(String[] args) {
        //initialises variables of Console and Word datatypes
        // the program's methods are split up in different class-files for easier readability
        Console c = new Console();
        Word w = new Word(c);
        int numGuesses = 6;
        ArrayList<Character> wrongGuesses = new ArrayList<>();
        ArrayList<String> guesses = new ArrayList<>();

        //gamemode selection
        System.out.print("Type 1 to play against an advanced AI and type 2 to play against a friend: ");
        int gameSelect = c.getSelection();

        //gets random word if player wants to play against AI
        //gets player input word if player wants to play against a friend
        String staticWord;
        if (gameSelect == 1) {
            staticWord = w.getWord();
        } else {
            System.out.print("Please input a word to be guessed at: ");
            staticWord = c.getPlayerWord();
        }

        //fills an array with underscores equal to the amount of letters
        //in the chosen word
        ArrayList<Character> visibleWord = new ArrayList<>();
        for (int i= 0; i < staticWord.length(); i++) {
            visibleWord.add('_');
        }

        //shows the guesser how long the word is
        drawGameStatus(c, numGuesses, wrongGuesses, visibleWord);

        //loop that lets the guesser guess multiple times
        while (true) {
            //asks the player to guess the word
            System.out.print("\n\nPlease guess either a letter in the word or the entire word: ");
            String guess = c.getPlayerGuess(guesses);
            guesses.add(guess);

            //determines if the guesser is guessing a letter
            //or a word
            String guessType = w.isLetterOrWord(guess, staticWord);

            //checks the guess differently depending on what type of guess it is
            if (guessType.equalsIgnoreCase("letter")) {
                //makes guess into character as it is a letter
                char cGuess = guess.charAt(0);
                //updates number of guesses and checks if guess is correct
                numGuesses = w.checkGuessLetter(staticWord, visibleWord, cGuess, numGuesses, wrongGuesses);
                drawGameStatus(c, numGuesses, wrongGuesses, visibleWord);
            } else if (guessType.equalsIgnoreCase("word")) {
                //updates number of guesses and checks if guess is correct
                numGuesses = w.checkGuessWord(staticWord, guess, numGuesses);
                drawGameStatus(c, numGuesses, wrongGuesses, visibleWord);
            } else {
                System.out.println("This guess is invalid");
            }

            //checks if there are no guesses left, if so picker wins
            if (pickerWin(numGuesses, staticWord, visibleWord)) {
                c.drawWord(visibleWord, wrongGuesses);
                System.exit(1337);
            }

            //checks if the guesser has guessed the word correctly, if so the guesser wins
             if (guesserWin(staticWord, visibleWord)) {
                 Console.drawWin();
             }


        }
    }

    private static void drawGameStatus(Console c, int numGuesses, ArrayList<Character> wrongGuesses, ArrayList<Character> visibleWord) {
        Console.clearConsole();
        c.drawMan(numGuesses);
        c.drawWord(visibleWord, wrongGuesses);
    }

    private static boolean pickerWin(int numGuesses, String staticWord, ArrayList<Character> visibleWord) {
        if (numGuesses == 0) {
            for (int i = 0; i < staticWord.length(); i++) {
                visibleWord.add(i, staticWord.charAt(i));
            }

            return true;
        }

        return false;
    }

    private static boolean guesserWin(String staticWord, ArrayList<Character> visibleWord) {
        for (int i = 0; i < staticWord.length(); i++) {
            if (!visibleWord.get(i).equals(staticWord.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
