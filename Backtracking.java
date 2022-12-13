import javax.swing.event.AncestorEvent;

import org.w3c.dom.stylesheets.DocumentStyle;

public class Backtracking {
    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void changeArr(int arr[], int i, int val) {
        // base
        if (i == arr.length) {
            printArr(arr);
            System.out.println();
            return;
        }

        // recursion(kaam)
        arr[i] = val;
        changeArr(arr, i + 1, val + 1);
        arr[i] = arr[i] - 2;
    }

    // find substrings
    public static void findSubset(String str, String ans, int i) {
        if (i == str.length()) {
            if (ans.length() == 0) {
                System.out.println("null");
            } else {

                System.out.println(ans);
            }
            return;
        }

        // yes
        findSubset(str, ans + str.charAt(i), i + 1);

        // no
        findSubset(str, ans, i + 1);
    }

    // find permutations
    public static void findPermutation(String str, String ans) {
        // base
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            // "abcde" => "ab" + "de"
            String newStr = str.substring(0, i) + str.substring(i + 1);

            findPermutation(newStr, ans + curr);
        }
    }

    // nQueens.....
    public static void printBoard(char arr[][]) {
        System.out.println("-----------Print Board---------");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    // static int count = 0;
    public static void nQueens(char board[][], int row) {
        // public static boolean nQueens(char board[][], int row) { //for print one
        // solution.......
        // base
        if (row == board.length) {
            printBoard(board);
            // count++;
            return;
            // return true; //for print one solutino.....
        }

        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {

                board[row][j] = 'Q';
                nQueens(board, row + 1); // recursion
                // if(nQueens(board, row + 1)){ // for print one solution.............
                // return true;
                // }
                board[row][j] = 'X'; // backtraking

            }

        }

        // return false; //for print one solution.............
    }

    public static boolean isSafe(char board[][], int row, int col) {
        // vertical up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }

        }

        // diag left up
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // diag right up
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }

        }

        return true;
    }

    // gridways..
    public static int gridWays(int i, int j, int n, int m) {
        // base
        if (i == n - 1 && j == m - 1) { // coundition for last cell
            return 1;
        } else if (i == n || j == m) { // boundary cross condition
            return 0;
        }

        int rightWays = gridWays(i, j + 1, n, m);
        int downWays = gridWays(i + 1, j, n, m);

        return rightWays + downWays;
    }

    // sudoku...

    // print sudoku
    public static void printSudoku(int arr[][]) {
        System.out.println("------------sudoku------------");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static boolean sudokuSolver(int sudoku[][], int row, int col) {
        // base
        if (row == 9) {
            return true;
        }

        int nextRow = row, nextCol = col + 1;
        if (nextCol == 9) {
            nextCol = 0;
            nextRow++;
        }

        if (sudoku[row][col] != 0) { // if there is a number..
            return sudokuSolver(sudoku, nextRow, nextCol);
        }

        for (int digit = 1; digit <= 9; digit++) {
            if (isSafe(sudoku, row, col, digit)) {

                sudoku[row][col] = digit;
                if (sudokuSolver(sudoku, nextRow, nextCol)) {
                    return true;
                }

                sudoku[row][col] = 0;
            }

        }

        return false;

    }

    public static boolean isSafe(int sudoku[][], int row, int col, int digit) {
        // check in col
        for (int i = 0; i <= 8; i++) {
            if (sudoku[i][col] == digit) {
                return false;
            }
        }

        // check in row
        for (int j = 0; j <= 8; j++) {
            if (sudoku[row][j] == digit) {
                return false;
            }
        }

        // check in its grid
        int sr = (row / 3) * 3; // its grids starting row
        int sc = (col / 3) * 3; // its grids starting col

        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (sudoku[i][j] == digit) {
                    return false;
                }
            }

        }

        return true;

    }

    // practice questions....
    // 1.
    public static void ratInMaze(int maze[][], int i, int j, int newSol[][]) {
        // base
        if (i == maze.length - 1 && j == maze.length - 1) {
            if (maze[i][j] == 1) {

                newSol[i][j] = 1;
                printSudoku(newSol);
                return;
            } else {
                System.out.println("no solution exist");
            }
        }

        if (isSafeRat(maze, i, j)) {
            newSol[i][j] = 1;
            ratInMaze(maze, i, j + 1, newSol); // right
            ratInMaze(maze, i + 1, j, newSol); // down
            newSol[i][j] = 0;
        }

        return;

    }

    public static boolean isSafeRat(int maze[][], int i, int j) {
        return (i >= 0 && i < maze.length && j >= 0 && j < maze.length && maze[i][j] != 0);
    }

    // 2....keypad combinations
    static char[][] L = { {}, {}, { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' },
            { 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };

    public static void keypadCombinations(String nums) {
        if (nums.length() == 0) {
            System.out.println("");
            return;
        }

        findcombi(0, new StringBuilder(), nums);
    }

    public static void findcombi(int pos, StringBuilder ans, String nums) {
        // base
        if (pos == nums.length()) {
            System.out.print(ans.toString() + " ");
            return;
        }

        char lettersArr[] = L[Character.getNumericValue(nums.charAt(pos))];
        for (int i = 0; i < lettersArr.length; i++) {
            char curr = lettersArr[i];

            findcombi(pos + 1, ans.append(curr), nums);
            ans.deleteCharAt(ans.length() - 1);
        }

    }

    // 3.. knight tour
    public static boolean knightTour(int i, int j, int ans[][], int move) {
        // System.out.println("sfd");
        if (move == 64) {
            printSudoku(ans);
            return true;
        }

        
        int XMoves[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int YMoves[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

        // intial
        ans[0][0] = 0;

        for (int k = 0; k < 8; k++) { // 8 ways to go
            int nextI = i + XMoves[k];
            int nextJ = j + YMoves[k];

            if (isSafeKnight(nextI, nextJ, ans)) {
                ans[nextI][nextJ] = move;
                if(knightTour(nextI, nextJ, ans, move + 1)){
                    return true;
                }

                ans[nextI][nextJ] = -1;

            }

        }
        return false;

    }

    public static boolean isSafeKnight(int i, int j, int ans[][]) {
        return (i >= 0 && i < ans.length && j >= 0 && j < ans.length && ans[i][j] == -1);
    }

    public static void main(String[] args) {
        // int n = 4;
        // char board[][] = new char[n][n];
        // for (int i = 0; i < board.length; i++) {
        // for (int j = 0; j < board.length; j++) {
        // board[i][j] = 'X';
        // }
        // }

        // sudoku..
        // int sudoku[][] = { { 0, 0, 8, 0, 0, 0, 0, 0, 0 },
        // { 4, 9, 0, 1, 5, 7, 0, 0, 2 },
        // { 0, 0, 3, 0, 0, 4, 1, 9, 0 },
        // { 1, 8, 5, 0, 6, 0, 0, 2, 0 },
        // { 0, 0, 0, 0, 2, 0, 0, 6, 0 },
        // { 9, 6, 0, 4, 0, 5, 3, 0, 0 },
        // { 0, 3, 0, 0, 7, 2, 0, 0, 4 },
        // { 0, 4, 9, 0, 3, 0, 0, 5, 7 },
        // { 8, 2, 7, 0, 0, 9, 0, 1, 3 } };

        // if(sudokuSolver(sudoku, 0, 0)){
        // printSudoku(sudoku);
        // }
        // else{
        // System.out.println("that sudoku dosent have solution");
        // }

        // int maze[][] = { { 1, 1, 1, 1 },
        // { 0, 0, 0, 1 },
        // { 0, 0, 0, 1 },
        // { 0, 0, 0, 1 } };
        // int newSol[][] = new int[maze.length][maze.length];
        // ratInMaze(maze, 0, 0, newSol);

        // keypadCombinations("234");

        // chess board in ans
        int ans[][] = new int[8][8];
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans.length; j++) {
                ans[i][j] = -1;
            }
        }

        knightTour(0, 0, ans, 1);
    }

}
