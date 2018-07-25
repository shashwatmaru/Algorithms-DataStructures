
/**
 * @author Shashwat Maru
 *Given an array of elements of length N, ranging from 1 to N. All elements may not be present in the array. If element is not present then there will be -1 present in the array. Rearrange the array such that A[i] = i and if i is not present, display -1 at that place.

Examples:

Input : arr = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1}
Output : [-1, 1, 2, 3, 4, -1, 6, -1, -1, 9]

Input : arr = {19, 7, 0, 3, 18, 15, 12, 6, 1, 8,
              11, 10, 9, 5, 13, 16, 2, 14, 17, 4}
Output : [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 
         11, 12, 13, 14, 15, 16, 17, 18, 19]
 */
public class ProgramForRearrangingArray {
	public static void main(String[] args) {
		int inputArr[]= {1,-1,-1,4,5,6,7,8,2,0};
		rearrangingArray(inputArr);
	}
	/*
	 * This method is use to rearrange input array.
	 */
	private static void rearrangingArray(int[] inputArr) {
		int length=inputArr.length;
		int i,j;
		int outputArr[] = new int[length];
		/*
		 * we will go thru the input array and if the value in a particular index is not -1, then
		 * we will assign that value to the output array at its location's
		 * In this way all non -1 value are rearranged in the output array.
		 */
		for(i=0;i<length;i++) {
			if(inputArr[i]!=-1) {
				j=inputArr[i];
				outputArr[j]=j;
			}

		}
		/*
		 * Here we will loop thru output array and we will check if value != array[value], then we
		 * will assign -1 at that index and printing it.
		 */
		for(i=0;i<length;i++) {
			if(outputArr[i]!=i){
				outputArr[i]=-1;
			}
			System.out.print(outputArr[i]+", ");
		}


	}
}
