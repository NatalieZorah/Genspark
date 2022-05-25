import java.util.*;


public class hangmanInterface {
    public static String BraceBar = "<<0>>-<<0>>-<<0>>-<<0>>-<<0>>-<<0>>-<<0>>-<<0>>";
    public static String BarGaps = " |=|                                       |=| " + "\n" +
                                   " |=|                                       |=| ";
    public static String NooseArm = " |=|        [=][=][=][=][=][=][=]{|}       |=| " + "\n" +
                            " |=|        [=]         {|}      {|}       |=| " + "\n" +
                            " |=|         V            {|}    {|}       |=| " + "\n" +
                            " |=|         |              {|}  {|}       |=| " + "\n" +
                                     " |=|         ^                {|}{|}       |=| ";
    public static String NooseBase = " |=|                             {|}       |=| " + "\n" +
                            " |=|                             {|}       |=| " + "\n" +
                            " |=|  [=][=][=][=][=][=][=][=][=]{|}[=]    |=| ";
    public static String[] Line1 = {
                            " |=|                             {|}       |=| " + "\n" +
                            " |=|                             {|}       |=| ",
                            " |=|       (X X)                 {|}       |=| " + "\n" +
                            " |=|        (*)                  {|}       |=| "
                               };
    public static String[] Line2 = {
                            " |=|                             {|}       |=| " + "\n" +
                            " |=|                             {|}       |=| " + "\n" +
                            " |=|                             {|}       |=| ",
                            " |=|        |||                  {|}       |=|" + "\n" +
                            " |=|        |||                  {|}       |=|" + "\n" +
                            " |=|        |||                  {|}       |=|",
                            " |=|      //|||                  {|}       |=|" + "\n" +
                            " |=|     // |||                  {|}       |=|" + "\n" +
                            " |=|        |||                  {|}       |=|",
                            " |=|      //|||\\\\                {|}       |=|" + "\n" +
                            " |=|     // ||| \\\\               {|}       |=|" + "\n" +
                            " |=|        |||                  {|}       |=|",
    };
    public static String[] Line3 = {
                            " |=|                             {|}       |=|" + "\n" +
                            " |=|                             {|}       |=|" + "\n" +
                            " |=|                             {|}       |=|",
                            " |=|      //|||                  {|}       |=|" + "\n" +
                            " |=|     //                      {|}       |=|" + "\n" +
                            " |=|    //                       {|}       |=|",
                            " |=|      //|||\\\\                {|}       |=|" + "\n" +
                            " |=|     //     \\\\               {|}       |=|" + "\n" +
                            " |=|    //       \\\\              {|}       |=|",
    };

    public static void DisplayHangman(int state) {
        String line1;
        String line2;
        String line3;

        switch (state){
            case 1:
                line1 = Line1[1];
                line2 = Line2[0];
                line3 = Line3[0];
                break;
            case 2:
                line1 = Line1[1];
                line2 = Line2[1];
                line3 = Line3[0];
                break;
            case 3:
                line1 = Line1[1];
                line2 = Line2[2];
                line3 = Line3[0];
                break;
            case 4:
                line1 = Line1[1];
                line2 = Line2[3];
                line3 = Line3[0];
                break;
            case 5:
                line1 = Line1[1];
                line2 = Line2[3];
                line3 = Line3[1];
                break;
            case 6:
                line1 = Line1[1];
                line2 = Line2[3];
                line3 = Line3[2];
                break;
            default:
                line1 = Line1[0];
                line2 = Line2[0];
                line3 = Line3[0];
        }

        System.out.println(BraceBar);
        System.out.println(BarGaps);
        System.out.println(NooseArm);
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);
        System.out.println(NooseBase);
        System.out.println(BarGaps);
        System.out.println(BraceBar);
    }

    // method for determining if an entry exists within a supplied array
    public static boolean tblContains(char[] array,char check) {
        for (int d = 0; d < array.length; d++) {
            if (array[d] == (check)) {
                return true;
            }
        }
        return false;
    }

    // method for displaying the blanks and correct guesses
    public static void DisplayGuesses(char[] word,ArrayList<Character> foundLetters) {
        ArrayList<Boolean> letters = new ArrayList<>();         // establishes a new arrayList for internal tracking

        for (int i = 0; i < word.length; i++) {                 // for every entry in the word[]
            letters.add(i,false);                        // add a boolean value to our arrayList for every char
            for (char found: foundLetters) {                    // for every letter on the list of found letters
                if (tblContains(word,found)) {                  // if that letter is found within the word[]
                    for (int j = 0; j < word.length; j++) {     // then parse through the word[]
                        if (found == word[j]) {                 // then every time that letter appears in our word[]
                            try {
                                letters.set(j, true);            // set the arrayList value to true
                            }catch (IndexOutOfBoundsException e) {
                            }
                        }
                    }
                }
            }
        }

        String spacer = " ";                                    // used in conjunction with String.repeat to build gaps
        String wordLine = "";                                   // declaring the string that will become the printed word
        int wordGapL = (38-(letters.size()*2))/2;               // setting the length of the gaps between the bracing and the word
        int wordGapR = 0;

        if (letters.size()%2 == 0) {
            wordGapR = ((38-(letters.size()*2))/2);
        }else {
            wordGapR = (37-(letters.size()*2))/2;
        }

        for (int k = 0; k < letters.size(); k++) {              // for every entry on the letters ArrayList do the following
            if (!letters.get(k)) {                              // if the entry is false then add a "_"
                wordLine += "_";
                if (k != letters.size()) {                      // if the entry is not the last on the ArrayList then also
                    wordLine += " ";                            // add a " " to the end
                }
            }else if (letters.get(k)) {                         // if the entry is true then add the letter
                wordLine += word[k];
                if (k != letters.size()) {                      // if the entry is not the last on the ArrayList then also
                    wordLine += " ";                            // add a " " to the end
                }
            }
        }

        String wordOutput = String.format(" |=| %s%s%s |=| ",   // the string formatting for the word line
                spacer.repeat(wordGapL),                        // the first and third %s are for the spacer we established
                wordLine,                                       // this is the word line that we built above
                spacer.repeat(wordGapR)
                );

        System.out.println(BarGaps);                            // print out a gap
        System.out.println(wordOutput);                         // print out the constructed word line
        System.out.println(BarGaps);                            // print out yet one more gap
        System.out.println(BraceBar);                           // prints the bracing bar for the bottom
    }
}
