
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class WordAbbreviationUsingTrie {
    public class TrieNode{
        TrieNode[] childrens;
        int count;
        public TrieNode(){
            childrens = new TrieNode[26];
            count=0;
        }
    }

    public class IndexedWord{
        String name;
        int value;
       public IndexedWord(String name,int value){
            this.name = name;
            this.value = value;
        }
    }

    public List<String> wordsAbbreviation(List<String> words) {
        int size = words.size();
        String[] ans = new String[size];
        Map<String,List<IndexedWord>> groups = new HashMap<>();

        int i=0;
        for(String word: words){
            String ab=abbreviate(word,0);
            if(!groups.containsKey(ab)){
                groups.put(ab,new ArrayList<IndexedWord>());
            }
            groups.get(ab).add(new IndexedWord(word,i));
            i++;
        }

        for(List<IndexedWord> group :groups.values()){
            TrieNode trie = new TrieNode();
            for(IndexedWord iw: group){
                TrieNode cur = trie;
                for(char letter : iw.name.substring(1).toCharArray()){
                    if(cur.childrens[letter-'a']==null){
                        cur.childrens[letter-'a'] = new TrieNode();
                    }
                    cur.count++;
                    cur = cur.childrens[letter-'a'];
                }
            }

            for(IndexedWord iw: group){
                TrieNode cur = trie;
                int j=1;
                for(char letter: iw.name.substring(1).toCharArray()){
                        if(cur.count == 1) break;
                         cur = cur.childrens[letter-'a'];
                         j++;
                }
                ans[iw.value] = abbreviate(iw.name,j-1);
            }
        }



        return Arrays.asList(ans);
    }

    public static String abbreviate(String word, int i){
        if(word.length()-i<= 3) return  word;
        else{
            return word.substring(0,i+1)+(word.length()-i-2)+word.charAt(word.length()-1);
        }

    }

    public static void main(String [] args){
        String s1 = "google";
        String s2 = "goggle";
        List<String> words = new ArrayList<>();
        words.add(s1);
        words.add(s2);
        WordAbbreviationUsingTrie wordAbbreviationUsingTrie = new WordAbbreviationUsingTrie();
        words = wordAbbreviationUsingTrie.wordsAbbreviation(words);
        for(String word: words){
            System.out.println(word);
        }
    }
}