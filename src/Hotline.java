import java.util.*;
import java.util.List;

public class Hotline extends ArrayList {

    //scanner obj.
    static Scanner sc = new Scanner(System.in);

    //makes sure array meets all initial requirements
    public static char[] initializer(char[] letters){
        //boolean to indicate user input was perfect(ish)
        boolean greenlightraw = true;
        //List to be converted
        List<Character> initialized = new ArrayList<>();
        //input list and for loop to make array into list
        ArrayList<Character> raw = new ArrayList<>();
        for (int i = 0; i < letters.length; i++) {
            raw.add(letters[i]);
        }
        //final array initialized
        char[] finalarr = new char[8];

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
                int zerosNeeded = 7 - initialized.size();
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
        char[] outputArray = new char[8];

        for (int i = 0; i < 7; i++) {
            //keep 0 as 0
            if (lettersInput.get(i) == '0') {
                outputArray[i] = '0';
            }
            //if's from here are to keep numbers as they are
            if (lettersInput.get(i) >= '1' && lettersInput.get(i) <= '9'){
                outputArray[i] = lettersInput.get(i);
            }
            if (lettersInput.get(i) >= '1' && lettersInput.get(i) <= '9' && lettersInput.get(i+1) == '0'){
                outputArray[i] = lettersInput.get(i);
                outputArray[i+1] = lettersInput.get(i+1);
            }
            if (lettersInput.get(i) >= '1' && lettersInput.get(i) <= '9' && lettersInput.get(i+1) >='1' && lettersInput.get(i) <= '9'){
                outputArray[i] = lettersInput.get(i);
                outputArray[i+1] = lettersInput.get(i+1);
            }
            //if's from here are to convert alphabets to keypad numbers
            if (lettersInput.get(i) == 'A' || lettersInput.get(i) == 'B' || lettersInput.get(i) == 'C') {
                outputArray[i] = '2';
            }
            if (lettersInput.get(i) == 'D' || lettersInput.get(i) == 'E' || lettersInput.get(i) == 'F') {
                outputArray[i] = '3';
            }
            if (lettersInput.get(i) == 'G' || lettersInput.get(i) == 'H' || lettersInput.get(i) == 'I') {
                outputArray[i] = '4';
            }
            if (lettersInput.get(i) == 'J' || lettersInput.get(i) == 'K' || lettersInput.get(i) == 'L') {
                outputArray[i] = '5';
            }
            if (lettersInput.get(i) == 'M' || lettersInput.get(i) == 'N' || lettersInput.get(i) == 'O') {
                outputArray[i] = '6';
            }
            if (lettersInput.get(i) == 'P' || lettersInput.get(i) == 'Q' || lettersInput.get(i) == 'R' || lettersInput.get(i) == 'S') {
                outputArray[i] = '7';
            }
            if (lettersInput.get(i) == 'T' || lettersInput.get(i) == 'U' || lettersInput.get(i) == 'V') {
                outputArray[i] = '8';
            }
            if (lettersInput.get(i) == 'W' || lettersInput.get(i) == 'X' || lettersInput.get(i) == 'Y' || lettersInput.get(i) == 'Z') {
                outputArray[i] = '9';
            }
        }
        //setting up the final array that will be printed (finalising by adding '-')
        char[] finaloutputArray= new char[8];
        System.arraycopy(outputArray, 0, finaloutputArray, 0, 1);
        System.arraycopy(outputArray, 1, finaloutputArray, 1, 1);
        System.arraycopy(outputArray, 2, finaloutputArray, 2, 1);
        finaloutputArray[3] = '-';
        System.arraycopy(outputArray, 3, finaloutputArray, 4, 1);
        System.arraycopy(outputArray, 4, finaloutputArray, 5, 1);
        System.arraycopy(outputArray, 5, finaloutputArray, 6, 1);
        System.arraycopy(outputArray, 6, finaloutputArray, 7, 1);


        //returns final values
        return finaloutputArray;

    }

    //psvm function
    public static void main(String[] args) {
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
        System.out.println(initializer(userInputArray));
    }
}


