
public class Patterns {

    public static void hollow_rectangle(int totRows, int totCols) {
        for (int i = 1; i <= totRows; i++) {

            for (int j = 1; j <= totCols; j++) {

                // cell - (i,j)
                if (i == 1 || i == totRows || j == 1 || j == totCols) {

                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }

    }

    public static void inverted_rotated_halfPyramid(int totRows) {
        for (int i = 1; i <= totRows; i++) {
            // for spaces
            for (int j = 1; j <= (totRows - i); j++) {
                System.out.print(" ");
            }

            // for stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    public static void inverted_half_pyramid_withNumbers(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= (n - i + 1); j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void floyds_triangle(int n) {
        int cont = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(cont + " ");
                cont++;
            }
            System.out.println();
        }
    }

    public static void zero_one_triangle(int n) {

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= i; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print(1 + " ");

                } else {
                    System.out.print(0 + " ");

                }

            }
            System.out.println();
        }
    }

    public static void butterfly(int n) {
        // 1st half
        for (int i = 1; i <= n; i++) {
            if (i <= n) {
                // starts
                for (int j = 1; j <= i; j++) {
                    System.out.print("*");
                }

                // spaces
                for (int j = 1; j <= 2 * (n - i); j++) {
                    System.out.print(" ");
                }

                // stars
                for (int j = 1; j <= i; j++) {
                    System.out.print("*");
                }
            }

            System.out.println();
        }

        // 2nd half
        for (int i = n; i >= 1; i--) {
            if (i <= n) {
                // starts
                for (int j = 1; j <= i; j++) {
                    System.out.print("*");
                }

                // spaces
                for (int j = 1; j <= 2 * (n - i); j++) {
                    System.out.print(" ");
                }

                // stars
                for (int j = 1; j <= i; j++) {
                    System.out.print("*");
                }
            }

            System.out.println();
        }
    }

    public static void solid_rhombus(int n) {
        for (int i = 1; i <= n; i++) {
            // space
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            // stars
            for (int j = 1; j <= n; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    public static void hollow_rhombus(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= n; j++) {
                if (i == 1 || i == n || j == 1 || j == n) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void diamond(int n) {
        // first half
        for (int i = 1; i <= n; i++) {
            // space
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            // stars
            for (int j = 1; j <= i * 2 - 1; j++) {
                System.out.print("*");
            }

            System.out.println();
        }

        // second half
        for (int i = n; i >= 1; i--) {
            // space
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            // stars
            for (int j = 1; j <= i * 2 - 1; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        inverted_rotated_halfPyramid(6);
    }
}