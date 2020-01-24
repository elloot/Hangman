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
        Word w = new Word();
        int numGuesses = 6;

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

        ArrayList<Character> visibleWord = new ArrayList<>();
        for (int i= 0; i < staticWord.length(); i++) {
            visibleWord.add('_');
        }

        //asks the player to guess the word
        System.out.print("Please guess either a letter in the word or the entire word: ");
        String guess = c.getPlayerGuess();

        String guessType = w.isLetterOrWord(guess, staticWord);

        if (guessType.equalsIgnoreCase("letter")) {

        } else if (guessType.equalsIgnoreCase("word")) {

        } else {
            System.out.println("This guess is invalid");
        }

    }
}
