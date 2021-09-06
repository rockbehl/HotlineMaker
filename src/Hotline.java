import java.util.*;
import java.util.List;

public class Hotline {

    //scanner obj. and restart boolean
    static Scanner sc = new Scanner(System.in);
    static boolean restart = true;

    //makes sure array meets all initial requirements
    public static char[] verifyAndConvert(char[] letters){
        //boolean to indicate user input was perfect(ish)
        boolean greenlightraw = true;
        //List to be converted
        List<Character> initialized = new ArrayList<>();
        //input list and for loop to make array into list
        ArrayList<Character> raw = new ArrayList<>();
        for (char letter : letters) {
            raw.add(letter);
        }
        //final array initialized
        char[] finalarr = new char[8];

        if (raw.size() == 0){
            for (int i = 0; i < 8; i++) {
               raw.add(i,'0');
            }
            greenlightraw = true;
        }

        //removes spaces from char list
        for (int i = 0; i < raw.size(); i++) {
            if (raw.get(i) == ' '){
                raw.remove(i);
            }
        }

        //corrects code if over 7 chars
        if (raw.size()>7) {
            initialized = raw.subList(0, 8);
            finalarr = makeNumbers(initialized);
            greenlightraw = false;
        }

        //corrects code if under 7 chars
        if (raw.size()<7){
            for (int i = 0; i < raw.size(); i++) {
                initialized.add(i,raw.get(i));
                int zerosNeeded = 8 - initialized.size();
                System.out.println(zerosNeeded);
                for (int j = initialized.size(); j < zerosNeeded; j++) {
                    initialized.add(j, '0');
                }
            }
            finalarr = makeNumbers(initialized);
            greenlightraw = false;
        }

        //userinput needs no changing
        if (greenlightraw) {
            finalarr = makeNumbers(raw);
        }

        //returns suitable array that just needs to be converted to numbers
        return finalarr;
    }

    //coverts checked array into final form
    private static char[] makeNumbers(List<Character> lettersInput) {
        //array to iterate into
        char[] finaloutputchar = new char[8];

        for (int i = 0; i < 7; i++) {
            //if's from here are to keep numbers as they are
            if (lettersInput.get(i) >= '0' && lettersInput.get(i) <= '9') {
                lettersInput.set(i,lettersInput.get(i));
            }
            //makes special chars = 0
            if (32 < lettersInput.get(i) && lettersInput.get(i) < 48 || 57 < lettersInput.get(i) && lettersInput.get(i) < 65 ||
                    90 < lettersInput.get(i) && lettersInput.get(i) < 97 || 122 < lettersInput.get(i) && lettersInput.get(i) < 127){
                lettersInput.set(i,'0');
            }

            //compares and assigns values
            switch (lettersInput.get(i)) {
                case 'A', 'B', 'C' -> lettersInput.set(i, '2');
                case 'D', 'E', 'F' -> lettersInput.set(i, '3');
                case 'G', 'H', 'I' -> lettersInput.set(i, '4');
                case 'J', 'K', 'L' -> lettersInput.set(i, '5');
                case 'M', 'N', 'O' -> lettersInput.set(i, '6');
                case 'P', 'Q', 'R', 'S' -> lettersInput.set(i, '7');
                case 'T', 'U', 'V' -> lettersInput.set(i, '8');
                case 'W', 'X', 'Y', 'Z' -> lettersInput.set(i, '9');
            }


        }

        lettersInput.add(3,'-');
        for (int i = 0; i < 8; i++) {
            finaloutputchar[i] = lettersInput.get(i);
        }

        //returns final values
        return finaloutputchar;

    }

    //psvm function
    public static void main(String[] args) {

        while (restart) {
            //asks for user input
            System.out.print("Enter a phrase: ");
            String userInput = sc.nextLine();
            //forces user input to one case
            userInput = userInput.toUpperCase();
            //initializing base array
            char[] userInputArray = userInput.toCharArray();

            //adding final touches
            System.out.print("1-800-");
            //printing the function that has all the code
            System.out.println(verifyAndConvert(userInputArray));

            //restart process
            System.out.println("Restart? ");
            String restartInput = sc.nextLine();
            if (restartInput.equals("no") || restartInput.equals("No")){
                restart = false;
            }
        }
    }
}