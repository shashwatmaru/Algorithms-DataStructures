import java.util.Scanner;
/*
@Author Shashwat Maru
Given a string with a mix of comma separated words and numbers, print out two strings
 which contain only words in one and numbers in the other separated by commas.
 */
public class SeparateStringWithNumbers {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Kindly enter a string value with character and digit with comma separated.");
        String input = sc.nextLine();
        input = input.replaceAll(",","").trim();
        char[] ch = input.toCharArray();
        StringBuilder digit = new StringBuilder();
        StringBuilder alphabet = new StringBuilder();
        for(char c: ch){
            if(Character.isDigit(c)) digit.append(c);
            else alphabet.append(c);
        }

        System.out.println("Digit in input String: "+digit.toString());
        System.out.println("Alphabet in input String: "+alphabet.toString());


    }
}
