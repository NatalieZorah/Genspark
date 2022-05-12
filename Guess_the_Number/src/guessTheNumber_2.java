/**import java.util.*;

public class guessTheNumber_2 {
    // declaration of the variables used within the game
    static boolean canPlay = false;
    static int myGuess;
    static int correctAnswer;
    static int guessCount;
    static String myName;

    // method for determining if an entry exists within a supplied array
    public static boolean tblContains(String[] array,String check) {
        for (int d = 0; d < array.length; d++) {
            if (array[d].equals(check)) {
                return true;
            }
        }
        return false;
    }

    static boolean playCheck(String checkVal) {
        String[] yes = {"yes", "yeah", "y", "yeh", "sure"};
        String[] no = {"no", "nah", "nope", "newp", "n"};

        if (checkVal != null && checkVal.length() > 0) {
            if (tblContains(yes,checkVal)) {
                System.out.println(
                        "Wonderful! then go ahead and take a guess!");
                return true;
            }else if (tblContains(no,checkVal)) {
                System.out.println(
                        "Aww, very well then, I will just find someone else to play with.\n"+
                                "Nonetheless, I hope you enjoy your day!");
                return false;
            }else {
                System.out.println(
                        "Sorry, perhaps I was a bit unclear?\n" +
                                "I don't entirely know what you were trying to suggest, but I don't know what that answer means.\n" +
                                "'Yes' or 'No' will be sufficient, thanks.");
                return false;
            }
        }
        return false;
    }

    public static Object sysInput(String kind) {
        Scanner scan = new Scanner(System.in);

        if (kind.equals("string")) {
            String input = scan.nextLine();
            return input;
        }
        else if (kind.equals("num")) {
            int input = 0;
            try {
                input = scan.nextInt();
            } catch (NumberFormatException e) {
                System.out.println("That's not a number, hun, but I appreciate the effort, try again?");
            }
            return input;
        }
        else if (kind.equals("bool")) {
            String input;
            input = scan.nextLine();
                return playCheck(input);
        } else {
            System.out.println(
                    "Invalid kind, this one's on my programmer and not me, yell at her!");
        }return null;
    }

    public static String checkNumber() {
        if (myGuess > correctAnswer) {
            return "Your guess is too high.\n";
        }else if (myGuess < correctAnswer) {
            return "Your guess is too low.\n";
        }else {
            return "Well done, " + myName + "! You guessed my number in " + guessCount + " guesses!";
        }
    }

    public static void resetGame(){
        canPlay = false;
        correctAnswer = (int) (Math.random() * 20) + 1;
        myGuess = 0;
        guessCount = 0;
        playGame();
    }

    public static void playGame() {
        while (canPlay) {
            try {
                myGuess = (int) sysInput("num");
            } catch (NumberFormatException e) {
                System.out.println("Invalid String");
            }
            guessCount++;
            while (guessCount <= 6) {
                if (checkNumber().contains("high") || checkNumber().contains("low")) {
                    System.out.println(checkNumber() + "\nTake a guess.");
                    guessCount++;
                    try {
                        myGuess = (int)sysInput("num");
                    } catch (NumberFormatException e) {
                        System.out.println("Number Expected");
                    }
                } else if (checkNumber().contains("Well done")) {
                    System.out.println(checkNumber() +
                            "\nWould you like to play again?");
                    if ((boolean)sysInput("bool")) {
                        System.exit(0);
                    }
                }
            }
            if (guessCount > 6) {
                System.out.println(
                        "I'm sorry, " + myName + ", but you did not guess my number in even 6 tries...\n" +
                                "Maybe you are just bad at this, or perhaps you think the numbers are squiggles. Hrm...\n" +
                                "Nevermind, would you like to try again?");
                if ((boolean)sysInput("bool")) {
                    resetGame();
                }else {
                    System.exit(0);
                }
            }
        }
    }

    public static void main(String[] arg) {
        resetGame();
        System.out.println(
                "Hello! What is your name?");

        myName = (String)sysInput("string");

        System.out.println(
                "Well, " + myName + ", I'm Vega, and I am thinking of a number between 1 and 20.\n" +
                        "Would you like to play?");
        canPlay = (boolean)sysInput("bool");
        while (canPlay) {
            playGame();
        }
        System.exit(0);
    }
}
*/