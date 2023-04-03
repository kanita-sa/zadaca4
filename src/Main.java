
import java.lang.reflect.Array;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {


        //Zadatak 1: aa
        int total = 34;
        while (total != 0 && total > 0){
            System.out.println("Please insert a number. To stop the loop, insert negative number. ");
            Scanner insertNumber = new Scanner(System.in);
            total = insertNumber.nextInt();
        }

        //Zadatak 1: b
        int total1 = 0;
        Scanner canInsetExceptMinusThousand = new Scanner(System.in);

        while (total1 != -1000) {
            System.out.println("Please insert any integer. To stop the loop, insert -1000. ");
            total1 = canInsetExceptMinusThousand.nextInt();
            if(total1 == -1000){
                break;
            }
        }
        System.out.println("Number -1000 is detected.");


        //Zadatak 1: c
        int firstNumber = 0;
        int secondNumber = 0;
        Scanner theSecondNumber = new Scanner(System.in);

        while(secondNumber != -1000){
            System.out.println("Insert the number: ");
            secondNumber = theSecondNumber.nextInt();
            if(secondNumber == -1000){
                break;
            }

            int theSum = firstNumber + secondNumber;
            System.out.println("Total of " + firstNumber + " and " + secondNumber + " is: " + theSum);
            firstNumber = theSum;
        }


        //Zadatak 1: d + e
        int numberA = 0;
        int numberB = 0;
        int difference = 0;
        do {
            Scanner operation = new Scanner(System.in);
            Scanner firstNumWeInsert = new Scanner(System.in);
            Scanner secondNumWeInsert = new Scanner(System.in);

            System.out.println("Please chose an operation. Type '+' for plus, '-' for minus, '*' for multiply and '/' for division.");
            char insertOperation = operation.next().charAt(0);
            System.out.println("Insert num A: ");
            numberA = firstNumWeInsert.nextInt();
            System.out.println("Insert num B: ");
            numberB = secondNumWeInsert.nextInt();

            int result = 0;
            if (insertOperation == '+'){
                result = sum(numberA, numberB);
            }
            else if (insertOperation == '-'){
                result = substract(numberA, numberB);
            }
            else if (insertOperation == '/'){
                result = divide(numberA, numberB);
            }
            else if (insertOperation == '*'){
                result = multiply(numberA, numberB);
            }
            System.out.println("The total of " + numberA + " and " + numberB + " is " + result);
            difference = numberA - numberB;

            System.out.println("The difference of " + numberA + " and " + numberB + " is " + difference);

        } while (numberA != -1000 || numberB != -1000);


        //Zadatak 1: f
        System.out.println("Please enter integer: ");
        char insertOperation;
        Scanner firstNumWeInsert = new Scanner(System.in);
        int numberAA = firstNumWeInsert.nextInt();
        int result = 0;
        boolean shouldContinue = true;

        while(shouldContinue){
            Scanner operation = new Scanner(System.in);
            Scanner secondNumWeInsert = new Scanner(System.in);

            System.out.println("Please chose an operation. Type '+' for plus, '-' for minus, '*' for multiply and '/' for division." +'\n' + "If you want to end, type '='" );
            insertOperation = operation.next().charAt(0);

            if(insertOperation == '='){
                shouldContinue = false;
                break;
            }

            System.out.println("Please enter integer: ");
            int numberBB = secondNumWeInsert.nextInt();

            if (insertOperation == '+'){
                result = sum(numberAA, numberBB);
            }
            else if (insertOperation == '-'){
                result = substract(numberAA, numberBB);
            }
            else if (insertOperation == '/'){
                result = divide(numberAA, numberBB);
            }
            else if (insertOperation == '*'){
                result = multiply(numberAA, numberBB);
            }
            numberAA = result;
        }
        System.out.println("The calculator result is: " + result);

        //Zadatak 2
        Scanner numberInArray = new Scanner(System.in);
        int[] arrayWeMake = new int[100];
        int counter = 0;

        while(true){
            System.out.println("Please enter a number. If you want to stop, type -10.");
            int inputTheNumber = numberInArray.nextInt();

            if (inputTheNumber == -10){
                break;
            }
            else{
                arrayWeMake[counter] = inputTheNumber;
                counter = counter + 1;
            }
        }

        boolean doYouWantToExpand = true;
        while (doYouWantToExpand){
            Scanner inputChar = new Scanner(System.in);
            System.out.println("Do you want to expand the array?");
            String inputYesOrNo = inputChar.nextLine();
            char wantToExpand = inputYesOrNo.charAt(0);

            if (wantToExpand == 'y'){
                while(true){
                    System.out.println("Please enter a number. If you want to stop, type -10.");
                    int inputTheNumber = numberInArray.nextInt();

                    if (inputTheNumber == -10){
                        break;
                    }
                    else{
                        arrayWeMake[counter] = inputTheNumber;
                        counter = counter + 1;
                    }
                }
            }
            else{
                doYouWantToExpand = false;
            }
        }

        System.out.print("Your array is: ");
        for(int k=0; k<counter; k++){
            System.out.print(arrayWeMake[k] + " ");
        }


        //Zadatak 3
        Scanner miniGame = new Scanner(System.in);
        System.out.println("Welcome to the mini-game. If you want to check if a word is a palindrome, type 1. " +
                "If you want to check if a number is divisible by 2, type 2. If you want to make an array and" +
                "remove numbers from it, type 3.");
        int chooseNumber = miniGame.nextInt();

        if(chooseNumber == 1){
            Scanner insertPalindrom = new Scanner(System.in);
            System.out.println("Please insert a word you want to check: ");
            String insertWord = insertPalindrom.nextLine();
            String palindromeResult = checksIfPalindrome(insertWord);
            System.out.println(palindromeResult);
        }

        if(chooseNumber == 2){
            System.out.println("Insert a number you want to check: ");
            Scanner askForANumber = new Scanner(System.in);
            int insertANumberYouWantToCheck = askForANumber.nextInt();
            String isItOddOrEven = checksIfOdd(insertANumberYouWantToCheck);
            System.out.println(isItOddOrEven);
        }

        if(chooseNumber == 3) {
            Scanner asksLength = new Scanner(System.in);
            System.out.println("What is the length of your array?");
            int length = asksLength.nextInt();
            int[] firstArray = makeAnArray(length);

            Scanner asksNumberOfEliminatedElements = new Scanner(System.in);
            System.out.println("What is the number of elements you want to remove?");
            int lengthOfArrayWithRemovedNumbers = asksNumberOfEliminatedElements.nextInt();
            int[] arrayWithNumbersWeWantToEliminate = makeAnArrayWithEliminatedNumbers(lengthOfArrayWithRemovedNumbers);

            System.out.println("Your Modified array is: ");
            int[] thatArray = arrayWithRemovedNumbers(firstArray, arrayWithNumbersWeWantToEliminate);
        }



    }
    ///////////////metode
    //Zadatak 1: a
    public static int sum(int num1, int num2) {
        return num1 + num2;
    }
    public static int substract(int num1, int num2) {
        return num1 - num2;
    }
    public static int multiply(int num1, int num2) {
        return num1 * num2;
    }
    public static int divide(int num1, int num2) {
        return num1/num2;
    }


    //Zadatak 3
    //Palindrom
    public static String checksIfPalindrome(String Palindrome){
        String myPalindrome = Palindrome;
        char[] charPalindrome = myPalindrome.toCharArray();
        char[] flipMyPalindrome = new char[charPalindrome.length];
        char[] storeGuesses = new char[charPalindrome.length];

        int d = 0;
        for(int i=myPalindrome.length()-1; i>=0; i--){
            flipMyPalindrome[d] = charPalindrome[i];
            d = d + 1;
        }

        int flag = 0;
        for(int i=0; i<=myPalindrome.length()-1; i++){
            if (charPalindrome[i] == flipMyPalindrome[i]) {
                storeGuesses[i] = 'y';
            }
            else {
                storeGuesses[i] = 'n';
                flag = flag+1;
            };
        }

        if(flag>=1){
            return "It is not a palindrome.";
        }
        else {
            return "It is a palindrome.";
        }
    }

    //Checks if odd
    public static String checksIfOdd(int number){
        if (number % 2 == 0){
            return "It is an even number.";
        }
        else{
            return "It is an odd number.";
        }
    }

    //Make Array
    public static int[] makeAnArray(int size){
        Scanner forAddingNumber = new Scanner(System.in);
        int[] arrayWeMake = new int[size];
        for(int i=0; i<size; i++) {
            System.out.println("Enter your number: ");
            int insertNumbers = forAddingNumber.nextInt();
            arrayWeMake[i] = insertNumbers;
        }
        return arrayWeMake;
    }

    //Make array of removed numbers
    public static int[] makeAnArrayWithEliminatedNumbers(int size){
        Scanner forAddingNumber = new Scanner(System.in);
        int[] arrayWithNumbersToBeRemoved = new int[size];
        for(int i=0; i<size; i++) {
            System.out.println("Enter the numbers you want to remove: ");
            int insertNumbers = forAddingNumber.nextInt();
            arrayWithNumbersToBeRemoved[i] = insertNumbers;
        }
        return arrayWithNumbersToBeRemoved;
    }

    //Filtered Array
    public static int[] arrayWithRemovedNumbers(int[] originalArray, int[]arrayWithNumbersWeWantToRemove) {
    int length = originalArray.length - arrayWithNumbersWeWantToRemove.length;
    int[] modifiedArray = new int[length];

    int counter = 0;
    for(int i=0; i<originalArray.length; i++){
        boolean ifMatch = false;
        for (int j=0; j<arrayWithNumbersWeWantToRemove.length; j++){
            if(originalArray[i] == arrayWithNumbersWeWantToRemove[j]){
                ifMatch = true;
                break;
            }
        }
        if(ifMatch == false){
            modifiedArray[counter] = originalArray[i];
            counter = counter + 1;
        }
    }
    for(int i=0; i<counter; i++){
    System.out.print(modifiedArray[i] + " ");
    }
    return modifiedArray;
    }
}