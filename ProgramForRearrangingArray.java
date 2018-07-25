
public class ProgramForRearrangingArray {
	public static void main(String[] args) {
		int inputArr[]= {1,-1,-1,4,5,6,7,8,2,0};
		rearrangingArray(inputArr);
	}

	private static void rearrangingArray(int[] inputArr) {
		int length=inputArr.length;
		int i,j;
		int outputArr[] = new int[length];
		for(i=0;i<length;i++) {
			if(inputArr[i]!=-1) {
				j=inputArr[i];
				outputArr[j]=j;
			}

		}
		for(i=0;i<length;i++) {
			if(outputArr[i]!=i){
				outputArr[i]=-1;
			}
			System.out.print(outputArr[i]+", ");
		}


	}
}
