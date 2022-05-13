import java.util.*;

public class Caves {

    public static boolean isNumber(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }

    public static Object sysInput() {
        Scanner scan = new Scanner(System.in);
        while (true){
            String input = scan.nextLine();
            if (!isNumber(input)) {
                System.out.println("That's not a valid guess, hun, but I appreciate the effort, try again?");
            }else if (isNumber(input)) {
                if ((int) Math.round(Double.parseDouble(input)) == 1 || (int) Math.round(Double.parseDouble(input)) == 2) {
                    return (int) Math.round(Double.parseDouble(input));
                }else {
                    System.out.println("I'm sorry, but I can only accept '1' or '2' for your answer.\n" +
                            "I'll already do the rounding for you, but you gotta at least be close.");
                }
            }
        }
    }

    public static void main(String[] arg) {
        int choice = 0;
        System.out.println(
                "You are in a land full of dragons. \n" +
                        "In front of you, you see two caves. \n" +
                        "In one cave, the dragon is friendly and will share his treasure with you. \n" +
                        "The other dragon is greedy and hungry and will eat you on sight. \n" +
                        "Which cave will you go into? (1 or 2) ");

        try {
            choice = (int) sysInput();
        }catch (NullPointerException e) {
            System.out.println("Well that's embarrassing, not really sure what we done there but try again.\n" +
                    "Just.. maybe don't repeat whatever it was you did to break it in the first place.");
        }

        System.out.println(
                "You approach the cave...\n" +
                        "It is dark and spooky...\n" +
                        "A large dragon jumps out in front of you!");

        if (choice == 1) {
            System.out.println("He opens his jaws and gobbles you down in one bite!");
        }else if (choice == 2) {
            System.out.println("Thankfully, I think at least, you are able to seduce him with your wits and survive!\n" +
                    "Now let's get out of here before that fact becomes fiction.");
        }
    }
}
