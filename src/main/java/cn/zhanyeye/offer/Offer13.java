package cn.zhanyeye.offer;

/**
 * @Author zhanyeye
 * @Description 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，
 * 机器人能够进入方格 [35, 37] ，因为 3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * @Date 19/06/2021
 **/
public class Offer13 {
    int m, n, k;
    boolean[][] visited;

    public int movingCount(int m, int n, int k) {
        this.m = m; this.n = n; this.k = k;
        this.visited = new boolean[m][n];
        return dfs(0, 0);
    }

    // 因为不会往回走，所以只用考虑向右，向下两种方向
    public int dfs(int x, int y) {
        if (x >= m || y >= n || visited[x][y] || !isValid(x, y)) {
            return 0;
        }
        visited[x][y] = true;
        return 1 + dfs(x + 1, y) + dfs(x, y + 1);
    }

    public int digitSum(int x) {
        int sum = 0;
        while (x != 0) {
            sum += x % 10;
            x = x / 10;
        }
        return sum;
    }

    public boolean isValid(int x, int y) {
        return digitSum(x) + digitSum(y) <= this.k;
    }

    public static void main(String[] args) {
        int ans = new Offer13().movingCount(3, 2, 17);
        System.out.println(ans);
    }

}
