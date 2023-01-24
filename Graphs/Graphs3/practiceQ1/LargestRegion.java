package Graphs.Graphs3.practiceQ1;

public class LargestRegion {
    // find the size of the largest region in the boolean matrix...
    static int count = 0;

    public static void findSize(int arr[][]) {
        int n = arr.length;
        int m = arr[0].length;

        boolean visit[][] = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visit[i][j] && arr[i][j] == 1) {
                    DFS(i, j, n, m, visit, arr);
                    temp = 0;
                }
            }

        }
    }

    static int temp = 0;

    public static void DFS(int i, int j, int n, int m, boolean visit[][], int arr[][]) {
        temp++;
        visit[i][j] = true;

        // all 8 directions
        int rows[] = { -1, -1, 0, 1, 1, 1, 0, -1 };
        int cols[] = { 0, 1, 1, 1, 0, -1, -1, -1 };

        for (int k = 0; k < cols.length; k++) {
            int x = rows[k];
            int y = cols[k];

            if ( isSafe(i + x, j + y, n, m) && arr[i + x][j + y] == 1 &&!visit[i + x][j + y] ) {
                DFS(i + x, j + y, n, m, visit, arr);
            }
        }

        count = Math.max(temp, count);

    }

    public static boolean isSafe(int x, int y, int n, int m) {
        return (x >= 0 && x < n && y >= 0 && y < m);
    }

    public static void main(String[] args) {
        int arr[][] = { { 0, 0, 1, 1, 0 },
                        { 0, 0, 1, 1, 0 },
                        { 1, 0, 0, 0, 0 },
                        { 1, 1, 1, 1, 1 }

        };

        findSize(arr);
        System.out.println(count);

        
    }
}
