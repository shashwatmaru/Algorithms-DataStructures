/*
One Edit Distance
  Go to Discuss
Given two strings s and t, determine if they are both one edit distance apart.

Note:

There are 3 possiblities to satisify one edit distance apart:

Insert a character into s to get t
Delete a character from s to get t
Replace a character of s to get t
Example 1:

Input: s = "ab", t = "acb"
Output: true
Explanation: We can insert 'c' into s to get t.
Example 2:

Input: s = "cab", t = "ad"
Output: false
Explanation: We cannot get t from s by only one step.
Example 3:

Input: s = "1203", t = "1213"
Output: true
Explanation: We can replace '0' with '1' to get t.
 */


public class OneEditDistanceProblem {
        public boolean isOneEditDistance(String s1, String t1) {

            if(s1== null && t1==null){
                return false;
            }
            char[] s = s1.toCharArray();
            char[] t = t1.toCharArray();
            int len1 = t.length;
            int len2 = s.length;

            if((len1 == 1 && len2 == 0) || (len1==0 && len2==1)){
                return true;
            }

            if(len1 == 0 && len2 == 0){
                return false;
            }

            int[][] result = new int[s.length+1][t.length+1];

            result[0][0]=0;
            for(int i=1;i<=len1;i++){
                result[0][i]=result[0][i-1]+1;
            }
            for(int j=1;j<=len2;j++){
                result[j][0]=result[j-1][0]+1;
            }

            for(int k=1;k<=len2;k++){
                for(int l=1;l<=len1;l++){
//                String s1 = s.substring(k-1,k);
//                String t1 = t.substring(l-1,l);
                    if(s[k-1]==t[l-1]){
                        result[k][l]=result[k-1][l-1];
                    }
                    else{
                        int min = min(result[k][l-1], result[k-1][l-1], result[k-1][l]);
                        result[k][l] = min+1;
                    }
                }
            }

            if(result[s.length][t.length] == 1){
                return true;
            }
            return false;
        }


        private int min(int i,int j, int k){
            if(i<j){
                return Math.min(i,k);
            }
            else{
                return Math.min(j,k);
            }
        }

        public static void main(String[] args){
            OneEditDistanceProblem edit = new OneEditDistanceProblem();
            String s = "ab";
            String t = "acb";
            String s1 = "cab", t1 = "ad";
            String s2 = "1203", t2 = "1213";
            System.out.println("TESTCASE1: "+edit.isOneEditDistance(s,t));
            System.out.println("TESTCASE2: "+edit.isOneEditDistance(s1,t1));
            System.out.println("TESTCASE3: "+edit.isOneEditDistance(s2,t2));

        }

}
