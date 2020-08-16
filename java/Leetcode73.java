import java.util.Arrays;

public class Leetcode73 {
    public static void main(String[] args) {
        int[][] test1 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] test2 = {{1, 0, 3}};
        int[][] test = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};

        Solution73 s = new Solution73();
        s.setZeros(test);
        for(int i = 0; i < test.length; ++i){
            for(int j = 0; j < test[0].length; ++j){
                System.out.print(test[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class Solution73{
    public void setZeros(int[][] matrix){
        // 判断第一行第一列是否有0元素
        boolean row_flag = false;
        boolean col_flag = false;
        for(int i = 0; i < matrix.length; ++i){
            if(matrix[i][0] == 0){
                col_flag = true;
                break;
            }
        }
        for(int j = 0; j < matrix[0].length; ++j){
            if(matrix[0][j] == 0){
                row_flag = true;
                break;
            }
        }
        // 判断除第一行第一列外剩下的元素中是否有0元素，有的话标记在第一行和第一列中对应的位置上
        for(int i = 1; i < matrix.length; ++i){
            for(int j = 1; j < matrix[0].length; ++j){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // 置0操作
        for(int i = 1; i < matrix.length; ++i){
            for(int j = 1; j < matrix[0].length; ++j){
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }
        // 判断第一列第一行是否需要置0
        if(row_flag){
            Arrays.fill(matrix[0], 0);
        }
        if(col_flag){
            for(int i = 0; i < matrix.length; ++i)
                matrix[i][0] = 0;
        }
    }
}
