import java.util.Arrays;
import java.util.Scanner;

public class Hotline {
    String base;
    char[] basechars = new char[0];
    char[] refinedchars = new char[0];
    char[] checkedchars = new char[0];
    char[] numchars = new char[0];

    Scanner sc = new Scanner(System.in);

    public void getNumbers(){
        System.out.print("Enter word: ");
        base = sc.nextLine();

        base = base.toUpperCase();
        basechars = base.toCharArray();
        refinedchars = charChecks(basechars);
        numchars = converter(refinedchars);

    }
    
    public char[] charChecks(char[] toCheck){
        char[] workingarr;

        if (toCheck.length > 7 ) {

            workingarr = Arrays.copyOfRange(toCheck, 0, 8);

            for (int i = 0; i < workingarr.length; i++) {


                if (workingarr[i] == ' ') {
                    checkedchars = removeChars(workingarr, i);
                }

            }
        }

        if (toCheck.length <= 7){
            for (int i = 0; i < toCheck.length; i++) {


                if (toCheck[i] == ' ') {
                    checkedchars = removeChars(toCheck, i);
                }

            }
        }

        return checkedchars;
    }

    public char[] removeChars(char[] arr, int index){

        if (arr == null
                || index < 0
                || index >= arr.length) {

            return arr;
        }

        char[] tempHolding = new char[arr.length - 1];

        for (int i = 0, k = 0; i < arr.length; i++) {

            if (i == index) {
                continue;
            }

            tempHolding[k++] = arr[i];
        }

        return tempHolding;

    }

    public char[] converter(char[] finalchars){

        for (int i=0; i < finalchars.length; i++){

            if (finalchars[i] == 'A' || finalchars[i] == 'B'|| finalchars[i] == 'C'){
                numchars[i] = '2';
            }
            if (finalchars[i] == 'D'||finalchars[i] == 'E' || finalchars[i] == 'F' ){
                numchars[i] = '3';
            }
            if (finalchars[i] == 'G'||finalchars[i] == 'H' || finalchars[i] == 'I' ){
                numchars[i] = '4';
            }
            if (finalchars[i] == 'J'||finalchars[i] == 'K' || finalchars[i] == 'L' ){
                numchars[i] = '5';
            }
            if (finalchars[i] == 'M'||finalchars[i] == 'N' || finalchars[i] == 'O' ){
                numchars[i] = '6';
            }
            if (finalchars[i] == 'P'||finalchars[i] == 'Q' || finalchars[i] == 'R'|| finalchars[i] == 'S' ){
                numchars[i] = '7';
            }
            if (finalchars[i] == 'T'||finalchars[i] == 'U' || finalchars[i] == 'V' ){
                numchars[i] = '8';
            }
            if (finalchars[i] == 'W'||finalchars[i] == 'X' || finalchars[i] == 'Y'|| finalchars[i] == 'Z' ){
                numchars[i] = '9';
            }

        }

        return numchars;

    }

    public Hotline(){

        getNumbers();
        System.out.println(Arrays.toString(numchars));

    }

    public static void main(String[] args) {
        new Hotline();
    }

}
