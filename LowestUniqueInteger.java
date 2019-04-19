import java.util.HashMap;
import java.util.Map;


public class LowestUniqueInteger {

    public void findLowestNum(int[] input){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i:input){
            if(!map.containsKey(i)) map.put(i,1);
            else map.put(i, map.get(i)+1);
        }

        int[] temp = new int[map.size()];
        int min = Integer.MAX_VALUE,j=0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue()<= min){
                min = entry.getValue();
            }
        }

        int minKey = Integer.MAX_VALUE;
        for(int i: map.keySet()){
            if(min == map.get(i)){
                temp[j]=i;
                if(minKey>temp[j]){
                    minKey=temp[j];
                }
                j++;
            }
        }
        for(int i=0;i<input.length;i++){
            if(minKey== input[i]){
                System.out.println("Lowest Unique number is at position:"+i);
            }
        }

    }

    public static void main(String[] args){
        LowestUniqueInteger lowestUniqueInteger = new LowestUniqueInteger();
        lowestUniqueInteger.findLowestNum(new int[]{1,8,2,5,2,1,6,9,7,8});
    }
}
