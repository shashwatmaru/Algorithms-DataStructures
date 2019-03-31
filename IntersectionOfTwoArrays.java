import java.util.HashSet;
import java.util.Set;
/*
Intersection of Two Arrays

Given two arrays, write a function to compute their intersection.

Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Note:
Each element in the result must be unique.
The result can be in any order.

 */
public class IntersectionOfTwoArrays {
        public int[] intersection(int[] nums1, int[] nums2) {
            if(nums1 == null  || nums2 == null) return new int[0];
            if(nums1.length==0 || nums2.length==0) return new int[0];

            Set<Integer> set = new HashSet<Integer>();

            for(int i: nums1){
                set.add(i);
            }

            Set<Integer> result = new HashSet<Integer>();
            for(int i:nums2){
                if(set.contains(i)){
                    result.add(i);
                }
            }
            int[] resultArr = new int[result.size()];
            int index=0;
            for(int i: result){
                resultArr[index++]=i;
            }

            return resultArr;
        }
        public static void main(String[] args){
            int[] num11 = {1,2,2,1};
            int[] num12 = {2,2};

            int[] num21 = {4,9,5};
            int[] num22 = {9,4,9,8,4};

            IntersectionOfTwoArrays intersectionOfTwoArrays = new IntersectionOfTwoArrays();
            System.out.print("TESTCASE1: ");
            for(int i: intersectionOfTwoArrays.intersection(num11,num12)){
                System.out.print(i+" , ");
            }
            System.out.println();
            System.out.print("TESTCASE2: ");
            for(int i: intersectionOfTwoArrays.intersection(num21,num22)){
                System.out.print(i+" , ");
            }

        }
}
