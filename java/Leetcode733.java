public class Leetcode733 {
}

class Solution733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length;
        int n = image[0].length;
        int target = image[sr][sc];
        if (target == newColor)
            return image;
        bfs(image, sr, sc, newColor, target);
        return image;
    }

    public void bfs(int[][] image, int sr, int sc, int newColor, int target) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length)
            return;
        if (image[sr][sc] == target) {
            image[sr][sc] = newColor;
        } else {
            return;
        }
        bfs(image, sr - 1, sc, newColor, target);
        bfs(image, sr, sc + 1, newColor, target);
        bfs(image, sr + 1, sc, newColor, target);
        bfs(image, sr, sc - 1, newColor, target);
    }
}
