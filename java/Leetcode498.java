public class Leetcode498 {
    public static void main(String[] args) {
        int[][] test = {{1, 2, 3}, {4, 5, 6}};
        Solution498 s = new Solution498();
        int[] res = s.findDiagonalOrder(test);
        for(int x: res)
            System.out.print(x + " ");
    }
}

// 核心思想，对角线上的下标之和为一定值
// 因此可以采用 x + y = value（定值）
// 向斜上遍历的时候，x-- (x >= 0)，y++ (y < n) n为列
// 向斜下遍历的时候，y-- (y <= 0)，x++ (x < m) m为行
class Solution498 {
    public int[] findDiagonalOrder(int[][] matrix){
        int m = matrix.length;
        if(m == 0)
            return new int[]{};
        int n = matrix[0].length;
        int[] result = new int[m * n];
        boolean flag = true;  // 当flag为true时，方向为斜向上遍历，当flag为false时候，方向为斜向下遍历
        int sum = 0;  // sum表示每条对角线上的每个元素的下角标x、y之和
        int index = 0;  // index用来往result里面存遍历结果
        int x, y, pm, pn;
        while(sum < m + n - 1){
            // 为了精简步骤，采用pm和pn来统一相同的逻辑运算部分
            pm = flag ? m : n;
            pn = flag ? n : m;
            x = sum < pm ? sum : pm - 1;
            y = sum - x;
            while(x >= 0 && y < pn){
                result[index++] = flag ? matrix[x][y] : matrix[y][x];
                x--;
                y++;
            }
            sum++;
            flag = !flag;
        }
        return result;
    }
}
