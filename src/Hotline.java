import java.util.*;
import java.util.List;

public class Hotline extends ArrayList {
    static Scanner sc = new Scanner(System.in);

    public static char[] initializer(char[] letters){
        boolean greenlightraw = true;
        List<Character> initialized = new ArrayList<>();
        ArrayList<Character> raw = new ArrayList<>();
        for (int i = 0; i < letters.length; i++) {
            raw.add(letters[i]);
        }
        char[] finalarr = new char[8];

        for (int i = 0; i < raw.size(); i++) {
            if (raw.get(i) == ' '){
                raw.remove(i);
            }
        }

        if (raw.size()>7) {
            initialized = raw.subList(0, 8);
            finalarr = makeNumbers(initialized);
            greenlightraw = false;
        }
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
        if (greenlightraw) {
            finalarr = makeNumbers(raw);
        }
        return finalarr;
    }

    private static char[] makeNumbers(List<Character> lettersInput) {

        char[] outputArray = new char[8];

        for (int i = 0; i < 7; i++) {

            if (lettersInput.get(i) == '0') {
                outputArray[i] = '0';
            }
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

        char[] finaloutputArray= new char[8];
        System.arraycopy(outputArray, 0, finaloutputArray, 0, 1);
        System.arraycopy(outputArray, 1, finaloutputArray, 1, 1);
        System.arraycopy(outputArray, 2, finaloutputArray, 2, 1);
        finaloutputArray[3] = '-';
        System.arraycopy(outputArray, 3, finaloutputArray, 4, 1);
        System.arraycopy(outputArray, 4, finaloutputArray, 5, 1);
        System.arraycopy(outputArray, 5, finaloutputArray, 6, 1);
        System.arraycopy(outputArray, 6, finaloutputArray, 7, 1);



        return finaloutputArray;

    }

    public static void main(String[] args) {
        System.out.print("Enter a phrase: ");
        String userInput = sc.nextLine();
        userInput = userInput.toUpperCase();
        char[] userInputArray = userInput.toCharArray();


        System.out.print("1-800-");
        System.out.println(initializer(userInputArray));
    }
}


