/**
 * https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 */
class Solution29 {
    public int[] spiralOrder(int[][] matrix) {
        // 第1步：判断一些边界情况
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }

        // 第2步：初始化矩形4个方向的边界索引，存放结果的数组，和数组的索引
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        int [] res = new int[matrix.length * matrix[0].length];
        int index = 0;

        // 第3步：判断 while 循环的条件
        // 这里为什么可以是等号呢？当遍历到只剩一行还是得遍历啊
        while (top <= bottom && left <= right) {
            // 第6步：遍历上边界
            for (int i = left; i <= right; i++) {
                res[index++] = matrix[top][i];
            }
            // 第7步：遍历右边界
            for (int i = top + 1; i <= bottom; i++) {
                res[index++] = matrix[i][right];
            }
            // 第8步：判断矩形是否出现了边为1的情况
            if (top < bottom && left < right) {
                for (int i = right - 1; i >= left; i--) {
                    res[index++] = matrix[bottom][i];
                }
                for (int i = bottom - 1; i >= top + 1; i--) {
                     res[index++] = matrix[i][left];
                }
            }

            // 第4步：每次循环一周后，四个方向的边界索引更新
            top++;
            bottom--;
            left++;
            right--;
        }
    }
}