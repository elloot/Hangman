/**
 * Class description
 * 2020-01-17
 * Author: Elliot Duchek, Tobias Sandström
 */
public class Hangman {
    public static void main(String[] args) {
        Console c = new Console();
        Word w = new Word();

        System.out.print("Type 1 to play against an advanced AI and type 2 to play against a friend: ");
        int gameSelect = c.getSelection();

        if (gameSelect == 1) {
            String staticWord = w.getWord();
        } else {
            System.out.println("Please input a word to be guessed at: ");

        }


        System.out.print("Please guess either a letter in the word or the entire word: ");



    }
}
