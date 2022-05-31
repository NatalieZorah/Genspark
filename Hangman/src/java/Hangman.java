import java.util.*;
import java.io.*;
import java.util.regex.*;



public class Hangman {
    static Scanner scan = new Scanner(System.in);
    static boolean canPlay = false;
    static boolean playAgain = true;
    static ArrayList<Character> foundLetters = new ArrayList<>();
    static int guessCount;
    static String Word;
    static String[] yesTbl = {"yes", "yeah", "y", "yeh", "sure"};
    static String[] noTbl = {"no", "nah", "nope", "newp", "n"};

    private static boolean tblContains(char[] array,char check) {
        for (char character:array) {
            if (character == check) {
                return true;
            }
        }
        return false;
    }

    private static boolean tblContains(String[] array,String check) {
        for (String word:array) {
            if (word.equals(check)) {
                return true;
            }
        }
        return false;
    }

    private static boolean tblContains(ArrayList<Character> array,char check) {
        for (char character:array) {
            if (character == check) {
                return true;
            }
        }
        return false;
    }

    private static boolean isValidGuess(String guess) {
        Pattern pattern = Pattern.compile("[^A-Za-z ]");
        Matcher matcher = pattern.matcher(guess);

        if (guess.isBlank() || matcher.find()) {
            return false;
        }
        return true;
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
        canPlay = canPlay();
    }

    private static boolean canPlay() {
        while (true) {
            String input = scan.nextLine();
            if (tblContains(yesTbl,input)) {
                foundLetters.clear();
                guessCount = 0;
                playAgain = true;
                Word = "";
                System.out.println(
                        "Wonderful! Now what difficulty would you like to play at this time?");
                System.out.println("Easy, up to 6 letters long..." + "\n" +
                        "Medium, between 7 and 12 letters long..." + "\n" +
                        "Hard, between 13 and 18 letters long...");
                chooseDifficulty();
                return true;
            }else if (tblContains(noTbl,input)) {
                System.out.println(
                        "Aww, very well then, I will just find someone else to play with.\n"+
                                "Nevertheless, I hope you enjoy your day!");
                return false;
            } else {
                System.out.println(
                        "Sorry, perhaps I was a bit unclear?\n" +
                                "I don't entirely know what you were trying to suggest, but I don't know what that answer means.\n" +
                                "'Yes' or 'No' will be sufficient, thanks.");
            }
        }
    }

    private static void getWord(int min,int max) throws IOException {
        boolean run = true;
        BufferedReader reader = new BufferedReader(new FileReader("src/wordsList"));
        ArrayList<String> wordList = new ArrayList<>();

        for (String currentWord = reader.readLine();currentWord != null; currentWord = reader.readLine()) {
            wordList.add(currentWord);
        }

        while (run) {
            int randIndex = (int) (Math.random() * wordList.size());
            if (wordList.get(randIndex).length() >= min && wordList.get(randIndex).length() <= max) {
                Word = wordList.get(randIndex).toUpperCase();
                run = false;
            }
        }
    }

    private static void chooseDifficulty() {
        String[] diffs = {"easy","medium","hard"};

        String input = scan.nextLine().toLowerCase();
        if (!tblContains(diffs,input)) {
            System.out.println("That's not a difficulty I recognize, hun, I can give you an 'Easy', 'Medium', or 'Hard' word to find.");
        } else {
            if (input.equals("easy")) {
                try {
                    getWord(1,6);
                } catch (IOException e) {
                }
                System.out.println("Alright then, let's just take it easy for the moment, your word is " + Word.length() + " letters long.");
                System.out.println("\n" + Word + "\n");
                System.out.println("Go ahead and guess a letter!");
                playGame();
            }else if (input.equals("medium")) {
                try {
                    getWord(7,12);
                } catch (IOException e) {
                }
                System.out.println("Alright, let's try something a little more difficult then, your word is " + Word.length() + " letters long.");
                System.out.println("\n" + Word + "\n");
                System.out.println("Go ahead and guess a letter!");
                playGame();
            }else if (input.equals("hard")) {
                try {
                    getWord(13,18);
                } catch (IOException e) {
                }
                System.out.println("Excellent, now we're really playing the game. Your word is " + Word.length() + " letters long.");
                System.out.println("\n" + Word + "\n");
                System.out.println("Go ahead and guess a letter!");
                playGame();
            }
        }

    }

    private static boolean gameLost() {
       /** for (int i = 0;i < foundLetters.size();i++) {
            if (!tblContains(Word.toCharArray(),foundLetters.get(i))) {
                guessCount++;
            }
        }*/

        if (guessCount > 6) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean gameWon() {
        for (int i = 0;i < Word.length();i++) {
            if (!tblContains(foundLetters, Word.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static void getGuess() {
            String input = scan.nextLine().toUpperCase();
            if (input.length() != 1) {
                System.out.println("You can only guess one letter at a time, try again.");
            }
            if (isValidGuess(input)) {
                foundLetters.add(input.charAt(0));
                if (!tblContains(Word.toCharArray(),input.charAt(0))) {
                    guessCount++;
                }
            } else {
                System.out.println("Your guess has to be a letter, honey, not a number or special character, and certainly not a blank.");
            }
    }

    private static void resetGame() {
        foundLetters.clear();
        guessCount = 0;
        playAgain = true;
        Word = "";
        playGame();
    }

    private static void playGame() {
        HangmanInterface disp = new HangmanInterface();
        if (canPlay) {
            if (playAgain && !gameLost()) {
                try {
                    getGuess();
                    disp.DisplayHangman(guessCount);
                    disp.DisplayGuesses(Word.toCharArray(),foundLetters);
                } catch (NullPointerException e) {
                }
            }
            while (!gameLost()) {
                if (gameWon()) {
                    disp.DisplayHangman(guessCount);
                    disp.DisplayGuesses(Word.toCharArray(), foundLetters);
                    System.out.println("Woot!! Ya won the game and saved the man! I am sure he is all too happy for that." + "\n" +
                            "Care to try saving another?");

                    canPlay = canPlay();
                    if (canPlay) {
                        resetGame();
                    } else {
                        System.exit(0);
                    }
                } else if (!gameLost()){
                    try {
                        getGuess();
                        disp.DisplayHangman(guessCount);
                        disp.DisplayGuesses(Word.toCharArray(),foundLetters);
                    } catch (NullPointerException e) {
                    }
                }
            }
            if (gameLost() && !gameWon()) {
                disp.DisplayHangman(guessCount);
                disp.DisplayGuesses(Word.toCharArray(),foundLetters);
                System.out.println("Welp, ya lost, and that poor man is now dead because of you. Tch Tch." + "\n" +
                        "Care to try again?");

                canPlay = canPlay();
                if (canPlay) {
                    resetGame();
                } else {
                    System.exit(0);
                }
            }
        }
    }

    public static void main(String[] arg) {
        getName();
        while (canPlay) {
            playGame();
        }
        System.exit(0);
    }
}