import java.util.ArrayList;
import java.util.List;
/*
Word Search II

Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

Example:

Input:
words = ["oath","pea","eat","rain"] and board =
[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]

Output: ["eat","oath"]
Note:
You may assume that all inputs are consist of lowercase letters a-z.


 */
class WordSearchUsingTrie {
    public class TrieNode{
        TrieNode[] children;
        String word;
        public TrieNode(){
            children = new TrieNode[26];
            word = null;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        if(board == null || board.length == 0) return null;
        List<String> result = new ArrayList<>();


        TrieNode root = new TrieNode();
        buildTrie(root, words);

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                char c= board[i][j];
                if(root.children[c-'a'] != null){
                    dfs(board,result, i,j,root);
                }
            }
        }

        return result;
    }

    private void dfs(char[][] board, List<String> result, int i,int j, TrieNode cur){
        if(i<0 || j<0 || i>=board.length || j>= board[0].length) return;

        if(board[i][j]=='#') return ;

        char c =board[i][j];

        if(cur.children[c-'a'] == null) return;

        cur = cur.children[c-'a'];

        if(cur.word != null){
            result.add(cur.word);
            cur.word = null;
        }

        board[i][j]='#';
        dfs(board, result, i+1,j, cur);
        dfs(board, result, i-1,j, cur);
        dfs(board, result, i,j+1, cur);
        dfs(board, result,i,j-1, cur);

        board[i][j]=c;


    }

    private void buildTrie(TrieNode root, String[] words){
        if(words.length ==0) return;

        for(String s: words){
            TrieNode cur = root;
            for(char c: s.toCharArray()){
                int i=(int)(c-'a');
                if(cur.children[i] == null){
                    cur.children[i] = new TrieNode();
                }
                cur = cur.children[i];
            }
            cur.word = s;
        }
    }


    public static void main(String[] args){
        String[] words = {"oath","pea","eat","rain"};
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        WordSearchUsingTrie search = new WordSearchUsingTrie();
        List result = search.findWords(board,words);
        System.out.print("[");
        for(int i=0;i<result.size();i++){
            if(i<result.size()-1)
                System.out.print("\""+result.get(i)+"\", ");
            if(i== result.size()-1){
                System.out.print("\""+result.get(i)+"\"" );
            }
        }
        System.out.print("]");

    }

}