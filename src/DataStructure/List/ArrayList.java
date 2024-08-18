package DataStructure.List;

import DataStructure.Matrix.Matrix;

public class ArrayList {
    private List[] array;

    public ArrayList(int size) {
        this.array = new List[size];
        for (int i = 0; i < size; i++) {
            this.array[i] = new List();
        }
    }

    public void setArrayList(int index, List list) {
        this.array[index] = list;
    }

    public void insertOnArrayList(Matrix matrix) {
        for(int row = 1; row < matrix.rows; row++) {
            this.array[row - 1].insertOnList(matrix, row);
        }
    }

    public void showArrayList() {
        for(int i = 0; i < array.length; i++) {
            this.array[i].showList();
        }
    }
}
