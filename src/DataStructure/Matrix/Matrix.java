package DataStructure.Matrix;

import File.File;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Matrix {
    private final String[][] matrix;
    public final int rows;
    public final int cols;

    public Matrix(File file) throws IOException {
        this.rows = file.getNumberOfLines();
        this.cols = file.getNumberOfColumns();
        this.matrix = new String[rows][cols];

        this.readMatrix(file);
    }

    private void readMatrix(File file) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(file.pathFile, "r")) {
            String line;
            int i = 0;
            while ((line = raf.readLine()) != null) {
                this.matrix[i] = line.split(",");
                i++;
            }
        }
    }

    public void showMatrix() {
        for (int i = 0; i < this.matrix[0].length; i++) {
            System.out.print(this.matrix[0][i] + "\t");
        }
        System.out.println();

        for (int j = 1; j < this.matrix.length; j++) {
            System.out.print(this.matrix[j][0] + "\t");
            for (int i = 1; i < this.matrix[j].length; i++) {
                System.out.print(this.matrix[j][i] + "\t");
            }
            System.out.println();
        }
    }

    public boolean isRegular() {
        return isOutDegreeRegular() && isInDegreeRegular();
    }

    public boolean isOutDegreeRegular() {
        int sum = 0, comparison = -1;
        for (int row = 1; row < rows; row++) {
            sum = 0;
            for (int col = 0; col < cols; col++) {
                sum += Integer.parseInt(matrix[row][col]);
            }
            if (comparison == -1) {
                comparison = sum;
            } else if (sum != comparison) {
                return false;
            }
        }
        return true;
    }

    public boolean isInDegreeRegular() {
        int sum = 0, comparison = -1;
        for (int col = 0; col < cols; col++) {
            sum = 0;
            for (int row = 1; row < rows; row++) {
                sum += Integer.parseInt(matrix[row][col]);
            }
            if (comparison == -1) {
                comparison = sum;
            } else if (sum != comparison) {
                return false;
            }
        }
        return true;
    }

    public boolean isSimple() {
        for (int i = 1; i < rows; i++) {
            if (matrix[i][i - 1].equals("1")) {
                return false;
            }
        }
        return true;
    }

    public boolean isComplete() {
        for (int row = 1; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (row - 1 == col) {
                    if (matrix[row][col].equals("1")) {
                        return false;
                    }
                } else if (!matrix[row][col].equals("1")) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isDirected() {
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j].equals("1")) {
                    if (matrix[j][i - 1].equals("0"))
                        return false;
                }
            }
        }
        return false;
    }

    public String[][] getMatrix() {
        return matrix;
    }
}

