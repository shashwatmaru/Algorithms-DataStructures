import java.util.HashSet;
import java.util.Set;
/*
41. First Missing Positive

Given an unsorted integer array, find the smallest missing positive integer.
Example 1:
Input: [1,2,0]
Output: 3
Example 2:
Input: [3,4,-1,1]
Output: 2
Example 3:
Input: [7,8,9,11,12]
Output: 1
Note:
Your algorithm should run in O(n) time and uses constant extra space.
 */
public class FirstMissingPositive {
        public int firstMissingPositive(int[] nums) {
            if(nums == null) return 1;
            if(nums.length == 0) return 1;
            if(nums.length == 1){
                if(nums[0]==1) return 2;
                else
                    return 1;

            }
            int min=0;
            int max=0;
            //if(nums[0]>-1 && nums[1]>-1){
            if(nums[0]<nums[1]){
                min = nums[0];
                max = nums[1];
            }
            else{
                min = nums[1];
                max = nums[0];
            }
            //}

            Set<Integer> set = new HashSet<Integer>();
            set.add(nums[0]);
            set.add(nums[1]);
            for(int i=2;i<nums.length;i++){
                if(nums[i]< min && nums[i]>-1) min = nums[i];
                if(nums[i]> max) max = nums[i];
                set.add(nums[i]);
            }
            System.out.print("min: "+min+" max:"+max);
            if((min <0 && max <0) || (min-1)>0) return 1;
            for(int i=min+1;i<max;i++){
                if((!set.contains(i)) && i>0){
                    return i;
                }
            }
            return max+1;
        }

        public static void main(String[] args){
            int[] input1= {1,2,0};
            int[] input2= {3,4,-1,1};
            int[] input3= {7,8,9,11,12};
            FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
            System.out.println("TEST CASE1: "+ firstMissingPositive.firstMissingPositive(input1));
            System.out.println("TEST CASE2: "+ firstMissingPositive.firstMissingPositive(input2));
            System.out.println("TEST CASE3: "+ firstMissingPositive.firstMissingPositive(input3));
        }
}
