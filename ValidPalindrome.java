/*
125. Valid Palindrome

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
Note: For the purpose of this problem, we define empty string as valid palindrome.
Example 1:
Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:
Input: "race a car"
Output: false
 */
public class ValidPalindrome {
        public boolean isPalindrome(String s) {
            if(s == null) return true;
            if(s.length() == 0 ) return true;

            int size = s.length()-1;
            char[] c = s.toLowerCase().toCharArray();
            int j=size;
            int i=0;
            while(i<j){
                while(i<j && !Character.isLetterOrDigit(c[i])){
                    i++;
                }
                while(i<j && !Character.isLetterOrDigit(c[j])){
                    j--;
                }
                if(i<j && c[i++] != c[j--]){
                    return false;
                }


            }

            return true;
        }

        public  static void main(String[] args){
            String s1 ="A man, a plan, a canal: Panama";
            String s2 ="race a car";

            ValidPalindrome validPalindrome = new ValidPalindrome();
            System.out.println("TESTCASE1: "+validPalindrome.isPalindrome(s1));
            System.out.println("TESTCASE2: "+validPalindrome.isPalindrome(s2));
        }
}
