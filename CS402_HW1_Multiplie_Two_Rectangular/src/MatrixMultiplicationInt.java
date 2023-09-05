import java.util.Random;

public class MatrixMultiplicationInt {
    public static void main(String[] args) {
        int numRowsA = 300;
        int numColsA = 400;
        int numRowsB = 400;
        int numColsB = 300;
        int numRuns = 10;

        long totalTime = 0;
        System.out.println("Integers Matrix:");

        for (int run = 0; run < numRuns; run++) {
            int[][] matrixA = generateRandomMatrix(numRowsA, numColsA);
            int[][] matrixB = generateRandomMatrix(numRowsB, numColsB);

            long startTime = System.nanoTime();
            int[][] resultMatrix = multiplyMatrices(matrixA, matrixB);
            long endTime = System.nanoTime();

            long duration = (endTime - startTime) / 1000000; // Convert to milliseconds
            totalTime += duration;

            System.out.println("time for round " + run + ": " + duration + " ms");
            //printMatrix(resultMatrix);
        }

        long averageTime = totalTime / numRuns;
        System.out.println("Average Execution Time (Integer): " + averageTime + " ms");

    }

    public static int[][] generateRandomMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        Random rand = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = rand.nextInt(100); // Generate random integers between 0 and 99
            }
        }
        return matrix;
    }

    public static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int rowsA = A.length;
        int colsA = A[0].length;
        int colsB = B[0].length;

        int[][] result = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }
    }
}

