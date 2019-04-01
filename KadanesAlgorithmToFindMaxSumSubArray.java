public class KadanesAlgorithmToFindMaxSumSubArray {
    public class SubArray{
        int start;
        int end;
        int maxSoFar;
        public SubArray(){
            start=0; end=0; maxSoFar=0;
        }
    }

    public SubArray findMaxSumInSubArray(int[] nums) {
        SubArray subArray = new SubArray();
        subArray.maxSoFar = nums[0];
        int maxEnding = 0;
        int s=0;
        for (int i = 0; i < nums.length; i++) {
            maxEnding = maxEnding + nums[i];
            if (subArray.maxSoFar < maxEnding) {
                subArray.maxSoFar = maxEnding;
                subArray.start = s;
                subArray.end = i;
            }
            if (maxEnding < 0) {
                maxEnding = 0;
                s = i + 1;
            }
        }
        return subArray;
    }
    public static void main(String [] args){
        int[] nums = {4,-3,-2,2,3,1,-2,-3,4,2,-6,-3,-1,3,1,2};
        KadanesAlgorithmToFindMaxSumSubArray kadanesAlgorithmToFindMaxSumSubArray= new KadanesAlgorithmToFindMaxSumSubArray();
        SubArray result = kadanesAlgorithmToFindMaxSumSubArray.findMaxSumInSubArray(nums);
        System.out.println("MaxSum: "+result.maxSoFar+" Start Index: "+result.start+" End: "+result.end);
    }

}
