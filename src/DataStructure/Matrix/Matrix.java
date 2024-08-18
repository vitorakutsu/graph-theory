package DataStructure.Matrix;

import File.File;

import javax.swing.border.Border;
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

    public String[][] getMatrix() {
        return matrix;
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
        int cellWidth = 4;

        final String BORDER_COLOR = "\033[37m";
        final String ZERO_COLOR = "\033[31m";
        final String ONE_COLOR = "\033[32m";

        System.out.print(BORDER_COLOR + "+-----+");
        for (int i = 0; i < cols; i++) {
            System.out.printf(BORDER_COLOR + "%" + cellWidth + "s+", "-----");
        }
        System.out.println();

        System.out.printf("| %-" + cellWidth + "s", " ");
        for (int i = 0; i < cols; i++) {
            char columnLabel = (char) ('A' + i);
            System.out.printf("| %" + (cellWidth - 1) + "s ", columnLabel);
        }
        System.out.println("|");

        System.out.print("+-----+");
        for (int i = 0; i < cols; i++) {
            System.out.printf("%" + cellWidth + "s+", "-----");
        }
        System.out.println();

        for (int j = 1; j < rows; j++) {
            char rowLabel = (char) ('A' + j - 1);
            System.out.printf("| %-" + cellWidth + "s", rowLabel);
            for (int i = 0; i < cols; i++) {
                String value = this.matrix[j][i].equals("0") ? ZERO_COLOR + this.matrix[j][i] + BORDER_COLOR :
                        ONE_COLOR + this.matrix[j][i] + BORDER_COLOR;
                System.out.printf("| %" + (cellWidth - 1) + "s   ", value);
            }
            System.out.println("|");

            System.out.print("+-----+");
            for (int i = 0; i < cols; i++) {
                System.out.printf("%" + cellWidth + "s+", "-----");
            }
            System.out.println();
        }
    }

    private boolean isRegular() {
        return isOutDegreeRegular() && isInDegreeRegular();
    }

    private boolean isOutDegreeRegular() {
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

    private boolean isInDegreeRegular() {
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

    private boolean isSimple() {
        for (int i = 1; i < rows; i++) {
            if (matrix[i][i - 1].equals("1")) {
                return false;
            }
        }
        return true;
    }

    private boolean isComplete() {
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

    private boolean isDirected() {
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

    private static String renderMessage(boolean compare, String success, String failed) {
        return compare ? "\033[0;32m" + success : "\033[0;31m" + failed;
    }

    private static void simulateLoading(String message) {
        System.out.print(message);
        String loadingSymbols = "|/-\\";
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < loadingSymbols.length(); j++) {
                System.out.print("\r" + message + " " + loadingSymbols.charAt(j));
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        System.out.println("\r" + message + " Concluído!");
    }

    public void analyzeMatrix() {
        simulateLoading("Analisando a matriz!");

        String isComplete = renderMessage(this.isComplete(), "Completo", "Não é Completo");
        String isSimple = renderMessage(this.isSimple(), "Simples", "Não é Simples");
        String isDirected = renderMessage(this.isDirected(), "Orientado", "Não é Orientado");
        String isRegular = renderMessage(isRegular(), "Regular", "Não é Regular");
        String inDegreeRegular = renderMessage(isInDegreeRegular(), "É Regular por Destino", "Não é Regular por " +
                "Destino");
        String outDegreeRegular = renderMessage(isOutDegreeRegular(), "É Regular por Origem", "Não é Regular por Origem");

        System.out.println();
        System.out.println(isComplete);
        System.out.println(this.isDirected() ? isRegular : inDegreeRegular + "\n" + outDegreeRegular);
        System.out.println(isSimple);
        System.out.println(isDirected);
    }
}

