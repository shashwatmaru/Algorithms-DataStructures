/*
Image Smoother
  Go to Discuss
Given a 2D integer matrix M representing the gray scale of an image, you need to design a smoother to make the gray scale of each cell becomes the average gray scale (rounding down) of all the 8 surrounding cells and itself. If a cell has less than 8 surrounding cells, then use as many as you can.

Example 1:
Input:
[[1,1,1],
 [1,0,1],
 [1,1,1]]
Output:
[[0, 0, 0],
 [0, 0, 0],
 [0, 0, 0]]
Explanation:
For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
For the point (1,1): floor(8/9) = floor(0.88888889) = 0
Note:
The value in the given matrix is in the range of [0, 255].
The length and width of the given matrix are in the range of [1, 150].
 */

public class ImageSmoother {
        public int[][] imageSmoother(int[][] M) {
            int row = M.length;
            int col = M[0].length;
            if(M == null ) return null;
            if(row == 0) return new int[0][];


            int[][] result= new int[row][col];



            for(int i=0;i<row;i++){
                for(int j=0;j<col;j++){
                    int count=0;
                    int sum =0;
                    for(int k=-1;k<=1;k++){
                        for(int l=-1;l<=1;l++){
                            if(isValid(i+k,j+l,row,col)){
                                count++;
                                sum += M[i+k][j+l];
                            }
                        }
                    }
                    result[i][j]=sum/count;
                }
            }

            return result;

        }

        private boolean isValid(int newRow, int newCol, int row, int col){

            return newRow>=0 && newCol>=0 && newRow < row && newCol < col;
        }

        public static void main(String[] args){
            int[][] M1 = {{1,1,1},{1,0,1},{1,1,1}};
            ImageSmoother imageSmoother = new ImageSmoother();
            int[][] M = imageSmoother.imageSmoother(M1);
            for(int[] res: M){
                System.out.print("[");
                for(int i=0;i<res.length;i++){
                    if(i<res.length-2) System.out.print(res[i]);
                    if(i<res.length-1) System.out.print(", "+res[i]);
                }
                System.out.print("]");
                System.out.println();
            }
        }
}
