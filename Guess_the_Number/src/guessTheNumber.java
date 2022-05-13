import java.util.*;



public class guessTheNumber {
    // declaration of the variables used within the game
    static boolean canPlay = false;
    static boolean playAgain = true;
    static int myGuess;
    static int correctAnswer = (int) (Math.random() * 20) + 1;
    static int guessCount;
    static String myName;
    static String[] yesTbl = {"yes", "yeah", "y", "yeh", "sure"};
    static String[] noTbl = {"no", "nah", "nope", "newp", "n"};

    // method for determining if an entry exists within a supplied array
    public static boolean tblContains(String[] array,String check) {
        for (int d = 0; d < array.length; d++) {
            if (array[d].equals(check)) {
                return true;
            }
        }
        return false;
    }

    // method for determining if a value is a number
    public static boolean isNumber(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }

    // method for checking if we are going to play or not

    static boolean playCheck(String checkVal) {
        if (checkVal != null && checkVal.length() > 0) {
            if (tblContains(yesTbl,checkVal)) {
                System.out.println(
                        "Wonderful! then go ahead and take a guess!");
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

    public static Object sysInput(String kind) {
        Scanner scan = new Scanner(System.in);

        if (kind.equals("string")) {
            String input = scan.nextLine();
            if (input.length() > 0){
                return input;
            }else {
                System.out.println("Shy then, are we? 'Enigma' it is then!");
                return "Enigma";
            }
        }
        else if (kind.equals("num")) {
            while (true){
                String input = scan.nextLine();
                if (!isNumber(input)) {
                    System.out.println("That's not a valid guess, hun, but I appreciate the effort, try again?");
                }else if (isNumber(input)) {
                    return (int) Math.round(Double.parseDouble(input));
                }
            }
        }
        else if (kind.equals("bool")) {
            boolean validInput = false;
            while (!validInput){
                String input = scan.nextLine();
                if (tblContains(yesTbl,input) || tblContains(noTbl,input)) {
                    validInput = true;
                    return playCheck(input);
                }else{
                    System.out.println(
                            "Sorry, perhaps I was a bit unclear?\n" +
                                    "I don't entirely know what you were trying to suggest, but I don't know what that answer means.\n" +
                                    "'Yes' or 'No' will be sufficient, thanks.");
                }
            }

        } else {
            System.out.println(
                    "Invalid kind, this one's on my programmer and not me, yell at her!");
        }return null;
    }

    public static String checkNumber() {
        if (myGuess > 20) {
            return "Your guess is WAY too high there, hun. I said between 1 and 20, not all real numbers.\nGo ahead and guess again, but keep that in mind, okay?";
        }else if (myGuess < 1) {
            return "Your guess is far too low, darlin'. I'm looking for numbers between 1 and 20.\nGo ahead and guess again, this'll still count, but try to keep to the range please.";
        }else if (myGuess > correctAnswer) {
            return "Your guess is too high.\n";
        }else if (myGuess < correctAnswer) {
            return "Your guess is too low.\n";
        }else {
            return "Well done, " + myName + "! You guessed my number in " + guessCount + " guesses!";
        }
    }

    public static void resetGame(){
        correctAnswer = (int) (Math.random() * 20) + 1;
        myGuess = 0;
        guessCount = 0;
        playAgain = true;
        playGame();
    }

    public static void getName() {
        System.out.println(
                "Hello! What is your name?");

        myName = (String)sysInput("string");

        System.out.println(
                "Well, " + myName + ", I'm Vega, and I am thinking of a number between 1 and 20.\n" +
                        "Would you like to play?");
        canPlay = (boolean)sysInput("bool");
    }

    public static void playGame() {
        if (canPlay) {
            if (playAgain) {
                try {
                    myGuess = (int) sysInput("num");
                    guessCount++;
                } catch (NullPointerException e) {
                }
            }
            while (guessCount <= 6 && guessCount != 0) {
                if (checkNumber().contains("high") || checkNumber().contains("low")) {
                    System.out.println(checkNumber() + "\nTake a guess.");
                    try {
                        myGuess = (int)sysInput("num");
                    } catch (NullPointerException e) {
                    }guessCount++;
                } else if (checkNumber().contains("Well done")) {
                    System.out.println(checkNumber() +
                            "\nWould you like to play again?");
                    canPlay = (boolean)sysInput("bool");
                    if (canPlay) {
                        resetGame();
                    }else {
                        System.exit(0);
                    }
                }
            }
            if (guessCount > 6) {
                System.out.println(
                        "I'm sorry, " + myName + ", but you did not guess my number in even 6 tries...\n" +
                                "Maybe you are just bad at this, or perhaps you think the numbers are squiggles. Hrm...\n" +
                                "Nevermind, would you like to try again?");
                canPlay = (boolean)sysInput("bool");
                if (canPlay) {
                    resetGame();
                }else {
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
