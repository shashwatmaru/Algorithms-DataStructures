import java.util.Map;
import java.util.HashMap;
/*
340. Longest Substring with At Most K Distinct Characters
Given a string, find the length of the longest substring T that contains at most k distinct characters.
Example 1:
Input: s = "eceba", k = 2
Output: 3
Explanation: T is "ece" which its length is 3.
Example 2:
Input: s = "aa", k = 1
Output: 2
Explanation: T is "aa" which its length is 2.
 */
public class LongestSubstringWithAtMostKDistinctChars {
    public int lengthOfLongestSubstringKDistinctWithIntArray(String s, int k) {
        int size = s.length();
        char[] ch = s.toCharArray();
        int[] array = new int[256]; //Total 256 ASCII value is there.
        int i=0;
        int num=0;
        int result=0;
        //ccaabbb
        for(int j=0;j<size;j++){
            if(array[ch[j]]==0){
                num++;
            }
            array[ch[j]] += 1;

            while(num>k && i<size){ //sliding window
                array[ch[i]] -= 1;
                if(array[ch[i]]== 0){
                    num--;
                }
                i++;
            }

            result = Math.max(result, j-i+1);
        }
        return result;

    }

        public int lengthOfLongestSubstringKDistinctWithHashMap(String s, int k) {
            if(s == null) return 0;
            if(s.length() == 0) return 0;
            int size = s.length();
            int maxLen =0;
            int start =0;
            int end =0;
            Map<Character,Integer> map = new HashMap<>();
            char[] ch = s.toCharArray();
         //   System.out.println("MAX, END, STR, MAP");
            while(end < size){ //ccaabbb
                if(map.containsKey(ch[end])){
                    map.put(ch[end],map.get(ch[end])+1);
                }
                else{
                    map.put(ch[end],1);
                }
                while(map.size()>k){
                    map.put(ch[start], map.get(ch[start])-1);
                    if( map.get(ch[start]) == 0){
                        map.remove(ch[start]);
                    }
                    start++;
                }

                maxLen = Math.max(maxLen, end-start+1);
           //     System.out.println(maxLen+" , "+end+" , "+start+" ,"+map.size());
                end++;

            }

            return maxLen;
        }

        public static void main(String [] args){
            String s = "ccaabbb";
            LongestSubstringWithAtMostKDistinctChars longestSubstringWithAtMostKDistinctChars = new LongestSubstringWithAtMostKDistinctChars();
            System.out.println("HASHMAP SOLUTION: "+longestSubstringWithAtMostKDistinctChars.lengthOfLongestSubstringKDistinctWithHashMap(s,2));
            System.out.println("INT ARRAY SOLUTION: "+longestSubstringWithAtMostKDistinctChars.lengthOfLongestSubstringKDistinctWithIntArray(s,2));

        }

}
