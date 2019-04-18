/*
@Author Shashwat Maru
Map every character to a number using it's ASCII value.
For abcd, its corresponding int values are 0123.
Note on encountering any upper case character or special character, none need to be print.
 */
public class LetterMapNumber {
    public void mapLetterToNum(String input){
        char[] chars = input.toCharArray();
        int[] ans = new int[input.length()];
        int i=0;
        for(char ch:chars){
            if(ch-'a' >= 0 && ch-'a' < 27){
                ans[i]=ch-'a';
                i++;
            }
            else{
                System.out.println("none");
                return;
            }
        }
        for(int j: ans){
            System.out.print(j);
        }
        System.out.println();
    }


    public static void main(String[] args){
        LetterMapNumber letterMapNumber = new LetterMapNumber();
        System.out.println("TESTCASE1: ");
        letterMapNumber.mapLetterToNum("abcdepp");
        System.out.println("TESTCASE2: ");
        letterMapNumber.mapLetterToNum("as@asas");
        System.out.println("TESTCASE3: ");
        letterMapNumber.mapLetterToNum("A123");
    }
}
