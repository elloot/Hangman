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

        try {
            in = new Scanner(new File("./resources/words.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            in = new Scanner(System.in);
            System.out.println("File not found");
        }

        ArrayList<String> words = new ArrayList<>();
        while (in.hasNextLine()) {
            words.add(in.nextLine());
        }

        return words.get((int) (Math.random()*words.size())).toUpperCase();
    }

    //checks if the input word is valid
    Boolean isValid(String word) {
        do {
            //checks if the word contains characters that aren't letters
            //and disallows such words
            assert word != null;
            for (int i = 0; i < word.length(); i++) {
                if (!(Character.isLetter(word.charAt(i)))) {
                    System.out.println("\"" + word + "\"" + " is not a valid, please try again");
                    word= null;
                    break;
                }
            }

        } while (word == null);

        return true;
    }

    String isLetterOrWord(String guess, String staticWord) {
        if (guess.length() == 1) {
            return "letter";
        } else if (guess.length() == staticWord.length()) {
            return "word";
        } else {
            return "invalid";
        }
    }

    int checkGuessLetter(String staticWord, ArrayList<Character> visibleWord, Character guess, int numGuesses) {
        int correct = 0;
        //checks if the guessed letter is in the given word, if it is,
        // replace the underscore at that letters position
        for (int i = 0; i < staticWord.length(); i++) {
            if (guess.equals(staticWord.charAt(i))) {
                visibleWord.set(i, guess);
                correct++;
            }
        }

        if (correct < 1) {
            numGuesses--;
        }

        c.drawMan(numGuesses, visibleWord);

        return numGuesses;
    }
    //Method that tests if the guessed word is equal to the set word
    void checkGuessWord(String staticWord, String guess, int numGuesses) {
        if (guess.equals(staticWord)) {
        Console.drawWin();
        } else {
        numGuesses--
        return;
        }
    }

}
