public class DiagonalMatrixPrint {
    public void printDiagonalElements(int[][] input){
        int k;
        for(k=0;k<input.length;k++){
            int i=k;
            int j=0;
            while(i>=0 && j<input[0].length){
                System.out.print(input[i][j]+" ");
                i-=1;
                j+=1;
            }
        }

        for(k=1;k<input[0].length;k++){
            int i=input.length-1;
            int j=k;
            while(i>=0 && j<input[0].length){
                System.out.print(input[i][j]+" ");
                i-=1;
                j+=1;
            }
        }


    }

    public static void main(String [] args){
        DiagonalMatrixPrint diagonalMatrixPrint = new DiagonalMatrixPrint();
        int[][] input = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        diagonalMatrixPrint.printDiagonalElements(input);
    }
}
