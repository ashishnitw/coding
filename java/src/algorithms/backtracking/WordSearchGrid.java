package algorithms.backtracking;

public class WordSearchGrid {
    public static boolean exist(char[][] board, String word) {
        if (board == null || word == null)
            return false;
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(dfs(board, visited, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, boolean[][] visited, String word, int idx, int i, int j) {
        if (idx == word.length())
            return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j] || word.charAt(idx) != board[i][j])
            return false;
        visited[i][j] = true;
        boolean found = dfs(board, visited, word, idx + 1, i + 1, j)
                    || dfs(board, visited, word, idx + 1, i, j + 1)
                    || dfs(board, visited, word, idx + 1, i - 1, j)
                    || dfs(board, visited, word, idx + 1, i, j - 1);
        visited[i][j] = false;
        return found;
    }

    public static void main(String[] args) {
        char[][] grid1 = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println("Exist: " + exist(grid1, "ABCCED")); // true
    }
}
