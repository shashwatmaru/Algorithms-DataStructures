public class DutchNationalFlagProblem {
    public int[] segregateNumber(int[] nums){
        int low =0, mid=0, i=0;
        int high = nums.length -1;
        while(mid<=high){
            switch(nums[mid]){
                case 0:
                    i = nums[low];
                    nums[low]=nums[mid];
                    nums[mid] = i;
                    low++; mid++;
                    break;

                case 1:
                    mid++;
                    break;

                case 2:
                    i = nums[mid];
                    nums[mid]=nums[high];
                    nums[high] = i;
                    high --;
                    break;
            }
        }
        return nums;
    }
    public  static void main(String[] args){
        int[] nums = {0,1,1,0,1,2,1,2,0,0,0,1};
        DutchNationalFlagProblem dutchNationalFlagProblem = new DutchNationalFlagProblem();
        nums =dutchNationalFlagProblem.segregateNumber(nums);
        System.out.print("[ ");
        for(int i: nums){
            System.out.print(i+" ");
        }
        System.out.print("]");
    }
}
