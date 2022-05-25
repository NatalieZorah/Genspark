import java.util.*;


public class main extends hangmanInterface {


    private static char sysInput() {
        Scanner scan = new Scanner(System.in);
            String input = scan.nextLine();
            if (input.length() != 1) {
                System.out.println("You can only guess one letter at a time, try again.");
            }
            return input.charAt(0);
    }

    public static void main(String[] arg) {
        char[] word = {'C','H','A','R','A','C','T','E','R'};
        ArrayList<Character> foundLetters = new ArrayList<>();
            foundLetters.add('C');
            foundLetters.add('R');
            foundLetters.add('A');
        DisplayHangman(4);
        DisplayGuesses(word,foundLetters);
    }
}
