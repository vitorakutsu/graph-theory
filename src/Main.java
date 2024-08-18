import DataStructure.List.ArrayList;
import DataStructure.Matrix.Matrix;
import File.File;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/vitoreyki/Library/Mobile Documents/com~apple~CloudDocs/VITOR EYKI/BCC/Termo_6A/Teoria dos Grafos/Code/Matriz/src/Assets/file.txt");
        Matrix m = new Matrix(file);
        m.showMatrix();

//        m.analyzeMatrix();

        System.out.println();
        System.out.println();
        System.out.println();


        ArrayList arrayList = new ArrayList(m.rows - 1);
        arrayList.insertOnArrayList(m);

        arrayList.showArrayList();
    }
}