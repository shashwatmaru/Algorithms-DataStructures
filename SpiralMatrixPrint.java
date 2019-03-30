import java.util.ArrayList;
import java.util.List;
/*
Spiral Matrix
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralMatrixPrint {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> result = new ArrayList<>();

            int rowLen = matrix.length;
            if(rowLen == 0) return result;

            int colLen = matrix[0].length;
            if(matrix == null) return result;

            result = spiral(matrix,rowLen,colLen);

            return result;

        }

        private List<Integer> spiral(int[][] matrix, int rowL, int colL){
            List<Integer> result = new ArrayList<>();
            int lastRow = rowL-1;
            int lastCol = colL-1;
            int i,k=0,l=0;
            // k for rows and l for cols
            while(k<=lastRow && l<=lastCol){
                for(i=l;i<=lastCol;i++){
                    result.add(matrix[k][i]);
                }
                k++;

                for(i=k;i<=lastRow;i++){
                    result.add(matrix[i][lastCol]);
                }
                lastCol--;

                if(k<=lastRow ){
                    for(i=lastCol;i>=l;i--){
                        result.add(matrix[lastRow][i]);
                    }
                    lastRow--;
                }
                if(l<=lastCol){
                    for(i=lastRow;i>=k;i--){
                        result.add(matrix[i][l]);
                    }
                    l++;
                }

            }

            return result;
        }


        public static void main(String [] args){
            SpiralMatrixPrint spiralMatrix = new SpiralMatrixPrint();
            int[][] M = {{ 1, 2, 3 },{ 4, 5, 6 },{7, 8, 9 }};
            int[][] M1 = {{ 1, 2, 3,4 },{5, 6,7,8 },{9,10,11,12 }};

            List<Integer> result = spiralMatrix.spiralOrder(M);
            List<Integer> result1 = spiralMatrix.spiralOrder(M1);
            System.out.print("TESTCASE1: ");
            for(int i: result){
                System.out.print(i+" ");
            }

            System.out.println();
            System.out.print("TESTCASE2: ");

            for(int i: result1){
                System.out.print(i+" ");
            }
        }

}
