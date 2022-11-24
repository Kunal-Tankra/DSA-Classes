import java.util.*;

import javax.swing.border.StrokeBorder;

public class Matrices {

    public static boolean search(int matrix[][], int key) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == key) {
                    System.out.println("found at cell (" + i + "," + j + ")");
                    return true;

                }
            }
        }
        System.out.println("key not found");
        return false;
    }

    public static void smallest(int matrix[][]) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                }
            }
        }

        System.out.println("min in matrix :" + min);
    }

    public static void bigest(int matrix[][]) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }

        System.out.println("max in matrix :" + max);
    }

    // spiral print..
    public static void printSpiral(int matrix[][]) {
        int startRow = 0, endRow = matrix.length - 1;
        int startCol = 0, endCol = matrix[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {
            // top
            for (int j = startCol; j <= endCol; j++) {
                System.out.print(matrix[startRow][j] + " ");
            }

            // right
            for (int i = startRow + 1; i <= endRow; i++) {
                System.out.print(matrix[i][endCol] + " ");

            }

            // bottom
            for (int j = endCol - 1; j >= startCol; j--) {
                if (startRow == endRow) {
                    break;
                }
                System.out.print(matrix[endRow][j] + " ");

            }

            // left
            for (int i = endRow - 1; i >= startRow + 1; i--) {
                if (startCol == endCol) {
                    break;
                }
                System.out.print(matrix[i][startCol] + " ");

            }

            startRow++;
            endRow--;
            startCol++;
            endCol--;

        }
        System.out.println();
    }

    // diagonal sum...
    public static void diagonalSum(int matrix[][]) {
        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            // 1. method 1.....
            // for (int j = 0; j < matrix[0].length; j++) {
            // if(i==j){
            // sum += matrix[i][j];
            // }
            // else if(j == matrix.length -1-i){
            // sum += matrix[i][j];
            // }
            // }

            // 2. method 2.....
            sum += matrix[i][i];

            if (i != matrix.length - 1 - i) {

                sum += matrix[i][matrix.length - 1 - i];
            }
        }

        System.out.println(sum);
    }

    // staircase search...
    public static void staircaseSearch( int matrix[][], int key) {
        int row = 0;
        int col = matrix[0].length -1;

        while (row <= matrix.length-1 && col >= 0) {
            if(key == matrix[row][col]){
                System.out.println("("+row+ ","+col+ ")");
                break;
            }
            else if(key < matrix[row][col]){
                col--;
            }
            else{
                row++;
            }
            
        }
        System.out.println("The key is not in matrix");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // int matrix[][] = new int[3][3];
        // int n = matrix.length, m = matrix[0].length;

        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < m; j++) {
        // matrix[i][j] = sc.nextInt();
        // }
        // }

        // // output..
        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < m; j++) {
        // System.out.print(matrix[i][j] + " ");
        // }
        // System.out.println();
        // }

        // // search(matrix, 5);
        // smallest(matrix);
        // bigest(matrix);

        int matrix[][] = { { 10, 20, 30, 40 },
                { 15, 25, 35, 45 },
                { 27, 29, 37, 48 },
                { 32, 33, 39, 50 },

        };

        // printSpiral(matrix);
        // diagonalSum(matrix);
        staircaseSearch(matrix, 5);
    }
}