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

        return words.get((int) (Math.random()*words.size()));
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
}
