import java.util.PriorityQueue;

public class KthLargestElementInArrayUsingMinHeap {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i: nums){
            minHeap.add(i);
            if(minHeap.size()>k){
                minHeap.remove();
            }
        }
        return minHeap.remove();
    }
    public static void main(String[] args){
        int[] num = {3,2,1,5,6,4};

        KthLargestElementInArrayUsingMinHeap kthLargestElementInArrayUsingMinHeap = new KthLargestElementInArrayUsingMinHeap();
        System.out.println(kthLargestElementInArrayUsingMinHeap.findKthLargest(num,2));
    }
}
