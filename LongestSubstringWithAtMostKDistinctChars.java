import java.util.Map;
import java.util.HashMap;

public class LongestSubstringWithAtMostKDistinctChars {
        public int lengthOfLongestSubstringKDistinct(String s, int k) {
            if(s == null) return 0;
            if(s.length() == 0) return 0;
            int size = s.length();
            int maxLen =0;
            int start =0;
            int end =0;
            Map<Character,Integer> map = new HashMap<>();
            char[] ch = s.toCharArray();
//            System.out.println("MAX, END, STR, MAP");
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
  //              System.out.println(maxLen+" , "+end+" , "+start+" ,"+map.size());
                end++;

            }

            return maxLen;
        }

        public static void main(String [] args){
            String s = "ccaabbb";
            LongestSubstringWithAtMostKDistinctChars longestSubstringWithAtMostKDistinctChars = new LongestSubstringWithAtMostKDistinctChars();
            System.out.println(longestSubstringWithAtMostKDistinctChars.lengthOfLongestSubstringKDistinct(s,2));
        }

}
