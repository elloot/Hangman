import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class description
 * 2020-01-17
 * Author: Elliot Duchek, Tobias Sandström
 */
class Word {
    private Console c;

    public Word(Console c) {
        this.c = c;
    }

    //gets a random word from a file
    String getWord() {
        Scanner in;

        in = new Scanner(getClass().getResourceAsStream("resources/words.txt"));

        //reds content of word file
        ArrayList<String> words = new ArrayList<>();
        while (in.hasNextLine()) {
            words.add(in.nextLine());
        }

        //gets a random place in the array and returns that word
        return words.get((int) (Math.random() * words.size())).toUpperCase();
    }

    //checks if the input word is valid
    boolean isValid(String word) {
        //checks if the word contains characters that aren't letters
        //and disallows such words
        assert word != null;

        //checks each letter in the input word, if it's not a letter it isn't valid
        for (int i = 0; i < word.length(); i++) {
            if (!(Character.isLetter(word.charAt(i)))) {
                System.out.print("\"" + word + "\"" + " is not valid, please try again: ");
                return false;
            }
        }

        return true;
    }

    //checks if the letter that's being guessed has been guessed before
    boolean notPreviousGuess(String guess, ArrayList<String> guesses) {
        boolean allowed = true;

        //checks the current guess against each previous guess
        for (int i = 0; i < guesses.size(); i++) {
            if (guess.equals(guesses.get(i))) {
                allowed = false;
                System.out.print("You've already guessed this letter, please guess another one: ");
                break;
            }
        }

        return allowed;
    }

    //checks what the player is guessing
    String isLetterOrWord(String guess, String staticWord) {
        if (guess.length() == 1) {
            return "letter";
        } else if (guess.length() == staticWord.length()) {
            return "word";
        } else {
            return "invalid";
        }
    }

    //checks if the guessed letter is in the picked word
    int checkGuessLetter(String staticWord, ArrayList<Character> visibleWord, Character guess, int numGuesses, ArrayList<Character> wrongGuesses) {
        boolean correct = false;
        //checks if the guessed letter is in the given word, if it is,
        // replace the underscore at that letters position
        for (int i = 0; i < staticWord.length(); i++) {
            if (guess.equals(staticWord.charAt(i))) {
                visibleWord.set(i, guess);
                correct = true;
            }
        }

        if (!correct) {
            numGuesses--;
            wrongGuesses.add(guess);
        }

        return numGuesses;
    }

    //method that checks if the guessed word is equal to the picked word
    int checkGuessWord(String staticWord, String guess, int numGuesses) {
        if (guess.equals(staticWord)) {
            Console.clearConsole();
            Console.drawWin();
            return numGuesses;
        } else {
            return --numGuesses;
        }
    }

}
