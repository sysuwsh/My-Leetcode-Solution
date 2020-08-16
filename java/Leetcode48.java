import java.util.Collections;

public class Leetcode48 {
    public static void main(String[] args) {
        int[][] test = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] test1 = {{5, 1, 9, 11},
                        {2, 4, 8, 10},
                        {13, 3, 6, 7},
                        {15, 14, 12, 16}};
        Solution48 s = new Solution48();
        s.rotate(test1);
        for(int[] x: test1) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }
}

class Solution48{
    public void rotate(int[][] matrix) {
        int tmp = 0;
        int n = matrix.length;
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < (n + 1) / 2; ++j) {
                // 此处因为懒得实现swap交换函数了，因此采用逆时针倒推的方式进行交换
                tmp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = tmp;
            }
        }
    }
}