import DataStructure.List.ArrayList;
import DataStructure.Matrix.Matrix;
import File.File;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/vitoreyki/Library/Mobile Documents/com~apple~CloudDocs/VITOR EYKI/BCC/Termo_6A/Teoria dos Grafos/Code/Matriz/src/Assets/file.txt");
        Matrix m = new Matrix(file);
        m.showMatrix();
//
//        System.out.println();
//
//        simulateLoading("Analisando a matriz");
//
//        System.out.println(isComplete(m));
//        System.out.println(m.isDirected() ? isRegularGraphy(m) : isRegularDigraphy(m));
//        System.out.println(isSimple(m));
//        System.out.println(isDirected(m));

        ArrayList arrayList = new ArrayList(m.rows - 1);
        arrayList.insertOnArrayList(m);

        arrayList.showArrayList();
    }

    private static String renderMessage(boolean compare, String success, String failed) {
        return compare ? GREEN + success : RED + failed;
    }

    private static String isComplete(Matrix m) {
        return renderMessage(m.isComplete(), "Completo", "Não é Completo");
    }

    private static String isRegularGraphy(Matrix m) {
        return renderMessage(m.isRegular(), "Regular", "Não é Regular");
    }

    private static String isRegularDigraphy(Matrix m) {
        String inDegreeMessage = renderMessage(m.isInDegreeRegular(), "É Regular por Destino", "Não é Regular por Destino");
        String outDegreeMessage = renderMessage(m.isOutDegreeRegular(), "É Regular por Origem", "Não é Regular por Origem");
    
        return inDegreeMessage + "\n" + outDegreeMessage;
    }

    private static String isSimple(Matrix m) {
        return renderMessage(m.isSimple(), "Simples", "Não é Simples");
    }

    private static String isDirected(Matrix m) {
        return renderMessage(m.isDirected(), "Orientado", "Não é Orientado");
    }

    private static void simulateLoading(String message) {
        System.out.print(message);
        String loadingSymbols = "|/-\\";
        for (int i = 0; i < 10; i++) {
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

    public static final String RED = "\033[0;31m";
    public static final String GREEN = "\033[0;32m";
}