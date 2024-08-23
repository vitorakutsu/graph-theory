import DataStructure.List.ArrayList;
import DataStructure.Matrix.Matrix;
import File.File;
import Menu.Menu;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Pedro Filitto\\Desktop\\6 Termo\\TG\\graph-theory\\src\\Assets\\file.txt");

        Matrix m = new Matrix(file);
        ArrayList arrayList = new ArrayList(m.rows - 1);

        Menu menu = new Menu(m, arrayList);

        menu.showMenu();
    }
}