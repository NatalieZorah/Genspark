import java.util.*;


public class main {
    static Scanner scan = new Scanner(System.in);
    static boolean canPlay = false;
    static boolean playAgain = true;
    static ArrayList<Character> foundLetters = new ArrayList<>();
    static int guessCount;
    static String Word;
    static String[] yesTbl = {"yes", "yeah", "y", "yeh", "sure"};
    static String[] noTbl = {"no", "nah", "nope", "newp", "n"};

    public static boolean tblContains(char[] array,char check) {
        for (int d = 0; d < array.length; d++) {
            if (array[d] == (check)) {
                return true;
            }
        }
        return false;
    }

    public static boolean tblContains(String[] array,String check) {
        for (int d = 0; d < array.length; d++) {
            if (array[d].equals(check)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNumber(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }

    static boolean playCheck(String checkVal) {
        if (checkVal != null && checkVal.length() > 0) {
            if (tblContains(yesTbl,checkVal)) {
                System.out.println(
                        "Wonderful! Now what difficulty would you like to play at this time?");
                System.out.println("Easy, up to 6 letters long..." + "\n" +
                        "Medium, between 7 and 12 letters long..." + "\n" +
                        "Hard, between 13 and 18 letters long...");
                return true;
            }else if (tblContains(noTbl,checkVal)) {
                System.out.println(
                        "Aww, very well then, I will just find someone else to play with.\n"+
                                "Nevertheless, I hope you enjoy your day!");
                return false;
            }
        }
        return false;
    }

    private static boolean canPlay() {
        boolean validInput = false;
        while (!validInput) {
            String input = scan.nextLine();
            if (tblContains(yesTbl, input) || tblContains(noTbl, input)) {
                validInput = true;
                return playCheck(input);
            } else {
                System.out.println(
                        "Sorry, perhaps I was a bit unclear?\n" +
                                "I don't entirely know what you were trying to suggest, but I don't know what that answer means.\n" +
                                "'Yes' or 'No' will be sufficient, thanks.");
            }
        }
        return false;
    }

    /**private static String getWord() {
        String[] diffs = {"easy","medium","hard"};
        String input = scan.nextLine().toLowerCase();
        if (!tblContains(diffs,input)) {
            System.out.println("That's");
        }
    }*/

    private static char getGuess() {
            String input = scan.nextLine();
            if (input.length() != 1) {
                System.out.println("You can only guess one letter at a time, try again.");
            }
            return input.charAt(0);
    }

    private static void getName() {
        System.out.println(
                "Hello! What is your name?");

        String input = scan.nextLine();
        if (input.length() > 0){
            System.out.println(
                    "Well, " + input + ", I'm Vega, and I would like to play a game of Hangman.\n" +
                            "Would you like to play?");
        }else {
            System.out.println("Shy are we? 'Enigma' it is then!");
            System.out.println(
                    "Well, Enigma, I'm Vega, and I would like to play a game of Hangman.\n" +
                            "Would you like to play?");
        }
    }


    public static void resetGame(){
        foundLetters = new ArrayList<>();
        guessCount = 0;
        playAgain = true;
        playGame();
    }

    public static void playGame() {

    }

    /**public static void main(String[] arg) {
        getName();
        while (canPlay) {
            playGame();
        }
        System.exit(0);
    }*/

    public static void main(String[] arg) {
        HangmanInterface disp = new HangmanInterface();
        char[] word = {'C','H','A','R','A','C','T','E','R'};
            foundLetters.add('C');
            foundLetters.add('R');
            foundLetters.add('A');
            foundLetters.add('G');
            foundLetters.add('W');
            foundLetters.add('E');
            foundLetters.add('U');
        disp.DisplayHangman(4);
        disp.DisplayGuesses(word,foundLetters);
    }
}
