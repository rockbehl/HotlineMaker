import java.util.Arrays;
import java.util.Scanner;

public class Hotline {
    static boolean restart = true;
    String base;
    char[] numchars_1 = new char[3];
    char[] numchars_2 = new char[4];


    static Scanner sc = new Scanner(System.in);

    public void getNumbers(){
        System.out.print("Enter word: ");
        base = sc.nextLine();

        base = base.toUpperCase();
        char[] basechars = base.toCharArray();
        char[] refinedchars = charChecks(basechars);

        System.out.print("1-800-");
        System.out.println(splitterandconverter(refinedchars));
    }
    
    public char[] splitterandconverter(char[] workingchars){
        
        char[] splitchars1 = new char[3];
        char[] splitchars2 = new char[4];
        
        for (int i=0; i<3;i++) {
            System.arraycopy(workingchars, i, splitchars1, i, 1);
        }
            System.arraycopy(workingchars, 3, splitchars2, 0, 1);
            System.arraycopy(workingchars, 4, splitchars2, 1, 1);
            System.arraycopy(workingchars, 5, splitchars2, 2, 1);
            System.arraycopy(workingchars, 6, splitchars2, 3, 1);

        return converter(splitchars1,splitchars2);
    }
    
    public char[] charChecks(char[] toCheck){
        char[] workingarr;
        char[] checkedchars = new char[7];



        if (toCheck.length > 7 ) {

            workingarr = Arrays.copyOfRange(toCheck, 0, 8);

            for (int i = 0; i < workingarr.length; i++) {
                if (workingarr[i] == ' ') {
                    checkedchars = removeChars(workingarr, i);
                }
            }
        }
        char[] tempholding = {'0','0','0','0','0','0','0'};

        if (toCheck.length < 7) {
            int arrval = toCheck.length;
            for (int i = 0; i < arrval; i++) {
                System.arraycopy(toCheck, i, tempholding, i, 1);
            }
            checkedchars = tempholding;
            System.out.println(checkedchars);

        }
        if (toCheck.length < 8){


            for (int i = 0; i < tempholding.length; i++) {

                if (tempholding[i] == ' ') {
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

    public char[] converter(char[] finalchars_1,char[] finalchars_2){

        for (int i=0; i < 3; i++){

            if (finalchars_1[i] == '0'){
                numchars_1[i] = '0';
            }
            if (finalchars_1[i] == 'A' || finalchars_1[i] == 'B'|| finalchars_1[i] == 'C'){
                numchars_1[i] = '2';
            }
            if (finalchars_1[i] == 'D'||finalchars_1[i] == 'E' || finalchars_1[i] == 'F' ){
                numchars_1[i] = '3';
            }
            if (finalchars_1[i] == 'G'||finalchars_1[i] == 'H' || finalchars_1[i] == 'I' ){
                numchars_1[i] = '4';
            }
            if (finalchars_1[i] == 'J'||finalchars_1[i] == 'K' || finalchars_1[i] == 'L' ){
                numchars_1[i] = '5';
            }
            if (finalchars_1[i] == 'M'||finalchars_1[i] == 'N' || finalchars_1[i] == 'O' ){
                numchars_1[i] = '6';
            }
            if (finalchars_1[i] == 'P'||finalchars_1[i] == 'Q' || finalchars_1[i] == 'R'|| finalchars_1[i] == 'S' ){
                numchars_1[i] = '7';
            }
            if (finalchars_1[i] == 'T'||finalchars_1[i] == 'U' || finalchars_1[i] == 'V' ){
                numchars_1[i] = '8';
            }
            if (finalchars_1[i] == 'W'||finalchars_1[i] == 'X' || finalchars_1[i] == 'Y'|| finalchars_1[i] == 'Z' ){
                numchars_1[i] = '9';
            }

        }

        for (int i=0; i < 4; i++){

            if (finalchars_2[i] == '0'){
                numchars_2[i] = '0';
            }
            if (finalchars_2[i] == 'A' || finalchars_2[i] == 'B'|| finalchars_2[i] == 'C'){
                numchars_2[i] = '2';
            }
            if (finalchars_2[i] == 'D'||finalchars_2[i] == 'E' || finalchars_2[i] == 'F' ){
                numchars_2[i] = '3';
            }
            if (finalchars_2[i] == 'G'||finalchars_2[i] == 'H' || finalchars_2[i] == 'I' ){
                numchars_2[i] = '4';
            }
            if (finalchars_2[i] == 'J'||finalchars_2[i] == 'K' || finalchars_2[i] == 'L' ){
                numchars_2[i] = '5';
            }
            if (finalchars_2[i] == 'M'||finalchars_2[i] == 'N' || finalchars_2[i] == 'O' ){
                numchars_2[i] = '6';
            }
            if (finalchars_2[i] == 'P'||finalchars_2[i] == 'Q' || finalchars_2[i] == 'R'|| finalchars_2[i] == 'S' ){
                numchars_2[i] = '7';
            }
            if (finalchars_2[i] == 'T'||finalchars_2[i] == 'U' || finalchars_2[i] == 'V' ){
                numchars_2[i] = '8';
            }
            if (finalchars_2[i] == 'W'||finalchars_2[i] == 'X' || finalchars_2[i] == 'Y'|| finalchars_2[i] == 'Z' ){
                numchars_2[i] = '9';
            }

        }

        char[] finalnums = new char[8];
        System.arraycopy(numchars_1, 0, finalnums, 0, 1);
        System.arraycopy(numchars_1, 1, finalnums, 1, 1);
        System.arraycopy(numchars_1, 2, finalnums, 2, 1);
        finalnums[3] = '-';
        System.arraycopy(numchars_2, 0, finalnums, 4, 1);
        System.arraycopy(numchars_2, 1, finalnums, 5, 1);
        System.arraycopy(numchars_2, 2, finalnums, 6, 1);
        System.arraycopy(numchars_2, 3, finalnums, 7, 1);

        return finalnums;

    }

    public Hotline(){

        getNumbers();
    }

    public static void main(String[] args) {

        while (restart) {
            new Hotline();
            System.out.println("Restart? ");
            String userrestart = sc.nextLine();

            if (userrestart.equals("no") || userrestart.equals("No")){
                restart = false;
            }

        }
    }

}
