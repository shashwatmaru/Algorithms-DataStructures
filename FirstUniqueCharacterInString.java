import java.util.Map;
import java.util.HashMap;
/*
First Unique Character in a String
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
 */


public class FirstUniqueCharacterInString {
        public int firstUniqChar(String s) {
            if(s == null) return -1;
            if(s.length() == 0) return -1;

            char[] str = s.toCharArray();

            Map<Character,Integer> charMap = new HashMap<Character,Integer>();
            for(int i=0;i<str.length;i++){
                if(!charMap.containsKey(str[i])){
                    charMap.put(str[i],i);
                }
                else{
                    charMap.put(str[i],-1);
                }
            }

            int min = Integer.MAX_VALUE;
            for(char c: charMap.keySet()){
                if(charMap.get(c)<= min && charMap.get(c)> -1){
                    min = charMap.get(c);
                }
            }

            return min == Integer.MAX_VALUE ? -1: min;
        }
        public static void main(String[] args){

            String s1 = "leetcode";
            String s2 = "loveleetcode";
            FirstUniqueCharacterInString firstUniqueCharacterInString = new FirstUniqueCharacterInString();
            System.out.println("TEST CASE1: "+firstUniqueCharacterInString.firstUniqChar(s1));
            System.out.println("TEST CASE2: "+firstUniqueCharacterInString.firstUniqChar(s2));
        }
}
