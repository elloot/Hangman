/**
 * Class description
 * 2020-01-17
 * Author: Elliot Duchek, Tobias Sandström
 */
public class console {
    public void drawMan(int numGuesses) {
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
}
