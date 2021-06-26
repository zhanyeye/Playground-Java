package cn.zhanyeye.offer;

/**
 * @Author zhanyeye
 * @Description
 * @Date 19/06/2021
 **/
public class Offer12 {
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        char[] arr = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, arr, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int i, int j, char[] word, int cnt) {
        // 递归退出条件
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word[cnt]) {
            return false;
        } else if (cnt == word.length - 1) {
            return true;
        }
        char tmp = board[i][j];
        board[i][j] = '0';
        boolean res = false;
        for (int k = 0; k < 4; k++) {
            int tx = i + dir[k][0];
            int ty = j + dir[k][1];
            res = res || dfs(board, tx, ty, word, cnt + 1);
        }
        board[i][j] = tmp;
        return res;
    }
}
