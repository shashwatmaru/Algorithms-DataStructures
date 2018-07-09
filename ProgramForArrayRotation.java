
public class ProgramForArrayRotation {
	public static void main(String[] args) {
		int[] arr= {0,1,2,3,4,5,6,7,8,9};
		int rotateBy=2;
		int size=arr.length;
		//	rotate(arr,rotateBy,size);
		//	rotateOneByOne(arr,rotateBy,size);
		jugglingRotation(arr,rotateBy,size);
		utility(arr,size);
	}

	private static void jugglingRotation(int[] arr, int rotateBy, int size) {
		greatestCommonDivisior(rotateBy, size);
		
	}

	private static int greatestCommonDivisior(int rotateBy, int size){
		if(size==0) {
			return rotateBy;
		}
		else {
			return greatestCommonDivisior(size, rotateBy%size);
		}
		
	}

	private static void utility(int[] arr, int size) {
		int j;
		for(j=0;j<size;j++) {
			System.out.print(arr[j]+" ");
		}
	}

	private static void rotateOneByOne(int[] arr, int rotateBy, int size) {
		int i;
		for(i=0;i<rotateBy;i++) {
			leftRotate(arr, size);

		}

	}

	private static void leftRotate(int[] arr, int size) {
		int i, tempArr=0;

		tempArr=arr[0];	

		for(i=1;i<size;i++) {
			arr[i-1]=arr[i];
		}	
		arr[size-1]=tempArr;

	}

	public static void rotate(int[] arr, int rotateBy, int size) {
		int[] arrTemp= new int[size];	
		int i,j;
		for(i=size-1;i>=0;i--) {
			if(i>=rotateBy) {
				arrTemp[i-rotateBy]=arr[i];	
			}
			else {
				arrTemp[size+i-rotateBy]=arr[i];
			}
		}
		for(j=0;j<size;j++) {
			if(j+1<size)
				System.out.print(arrTemp[j]+", ");
			if(j+1==size)
				System.out.print(arrTemp[j]);
		}
	}
}
