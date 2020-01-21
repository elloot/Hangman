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

        //gamemode selection
        System.out.print("Type 1 to play against an advanced AI and type 2 to play against a friend: ");
        int gameSelect = c.getSelection();

        //gets random word if player wants to play against AI
        //gets player input word if player wants to play against a friend
        if (gameSelect == 1) {
            String staticWord = w.getWord();
        } else {
            System.out.print("Please input a word to be guessed at: ");
            String staticWord = c.getPlayerWord();
        }

        //asks the player to guess the word
        System.out.print("Please guess either a letter in the word or the entire word: ");



    }
}
