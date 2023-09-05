import java.util.Random;

public class MatrixMultiplicationDouble {
    public static void main(String[] args) {
        int numRowsA = 300;  // Adjust the matrix size as needed
        int numColsA = 400;
        int numRowsB = 400;
        int numColsB = 300;
        int numRuns = 10;

        long totalTime = 0;
        System.out.println("Double Matrix:");

        for (int run = 0; run < numRuns; run++) {
            double[][] matrixA = generateRandomMatrix(numRowsA, numColsA);
            double[][] matrixB = generateRandomMatrix(numRowsB, numColsB);

            long startTime = System.nanoTime();
            double[][] resultMatrix = multiplyMatrices(matrixA, matrixB);
            long endTime = System.nanoTime();

            long duration = (endTime - startTime) / 1000000; // Convert to milliseconds
            totalTime += duration;

            System.out.println("time for round " + run + ": " + duration + " ms");
            // printMatrix(resultMatrix);
        }

        long averageTime = totalTime / numRuns;
        System.out.println("Average Execution Time (Double): " + averageTime + " ms");
    }

    public static double[][] generateRandomMatrix(int rows, int cols) {
        double[][] matrix = new double[rows][cols];
        Random rand = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = rand.nextDouble() * 100.0; // Generate random doubles between 0 and 100
            }
        }
        return matrix;
    }

    public static double[][] multiplyMatrices(double[][] A, double[][] B) {
        int rowsA = A.length;
        int colsA = A[0].length;
        int colsB = B[0].length;

        double[][] result = new double[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }

    public static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double num : row) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }
    }
}
