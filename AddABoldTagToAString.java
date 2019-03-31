/*
Add Bold Tag in String
  Go to Discuss
Given a string s and a list of strings dict, you need to add a closed pair of bold tag <b> and </b> to wrap the substrings in s that exist in dict. If two such substrings overlap, you need to wrap them together by only one pair of closed bold tag. Also, if two substrings wrapped by bold tags are consecutive, you need to combine them.
Example 1:
Input:
s = "abcxyz123"
dict = ["abc","123"]
Output:
"<b>abc</b>xyz<b>123</b>"
Example 2:
Input:
s = "aaabbcc"
dict = ["aaa","aab","bc"]
Output:
"<b>aaabbc</b>c"
Note:
The given dict won't contain duplicates, and its length won't exceed 100.
All the strings in input have length in range [1, 1000].
 */

public class AddABoldTagToAString {
        public String addBoldTag(String s, String[] dict) {
            int size = s.length();
            boolean[] bold = new boolean[size];
            for(int i=0, end=0;i<size;i++){
                for(String word: dict){
                    if(s.startsWith(word,i)){
                        end = Math.max(end, i+word.length());
                    }
                }

                bold[i] = end >i;
            }

            StringBuilder result = new StringBuilder();
            for(int i=0;i<bold.length;i++){
                if(!bold[i]){
                    result.append(s.charAt(i));
                    continue;
                }

                int j=i;
                while(j < bold.length && bold[j] )
                    j++; // Second pointer to get the last element which is true.
                result.append("<b>"+s.substring(i,j)+"</b>");
                i=j-1;

            }
            return result.toString();
        }
        public static void main(String[] args){
            String s1="abcxyz123";
            String[] dict1 = {"abc","123"};
            String s2="aaabbcc";
            String[] dict2 = {"aaa","aab","bc"};
            AddABoldTagToAString addABoldTagToAString = new AddABoldTagToAString();
            System.out.println("TESTCASE1: "+addABoldTagToAString.addBoldTag(s1,dict1));
            System.out.println("TESTCASE2: "+addABoldTagToAString.addBoldTag(s2,dict2));

        }
}
