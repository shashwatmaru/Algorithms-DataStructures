
import java.util.HashMap;
import java.util.Map;

/*
A sequence of n numbers (n < 3000) is called Jolly Jumper if the absolute values of the differences
 between the successive elements take on all possible values from 1 through n-1.
 The definition implies that any sequence of a single integer is a jolly jumper.
 */
public class JollyJumpers {

    /*
    In this, we have a map to store the boolean flag associated with all the successive element difference.

    A for loop to iterate thru the array to find the absolute difference of successive numbers and
    then checking if the difference is ==0 or >n-1
    or
    if the map contains the key and if it is true, then return false, ( If the difference of any 2 successive element is same then
    we have to return false.
     */
    public boolean isJollyAJumpers(int[] input){
        int temp1;
        Map<Integer,Boolean> flag = new HashMap<>();

        for(int i=0;i<input.length-1;i++){
            temp1 = Math.abs(input[i]-input[i+1]);
            if(temp1==0 || temp1>input.length-1){
                return false;
            }
            if(flag.containsKey(temp1) && flag.get(temp1)){
                return false;
            }
            flag.put(temp1,true);
        }
        return true;
    }

    public static void main(String [] args){
        JollyJumpers jollyJumpers = new JollyJumpers();
        System.out.println("Test case1: "+jollyJumpers.isJollyAJumpers(new int[]{1,4,2,3}));
        System.out.println("Test case2: "+jollyJumpers.isJollyAJumpers(new int[]{1,4,2,-1,6}));
        System.out.println("Test case3: "+jollyJumpers.isJollyAJumpers(new int[]{11,7,4,2,1,6}));

    }
}
