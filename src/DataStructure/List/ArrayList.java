package DataStructure.List;

import DataStructure.Matrix.Matrix;

import java.util.Arrays;

public class ArrayList {
    private List[] array;
    private int time = 0;

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
        System.out.println("+---+-------------------------+");
        System.out.println("| # |  Lista de Adjacência    |");
        System.out.println("+---+-------------------------+");

        for (int i = 0; i < array.length; i++) {
            System.out.printf("| %d | ", i);
            this.array[i].showList();
            System.out.println("+---+-------------------------+");
        }
    }

    public Matrix convertListToMatrix() {
        Matrix matrix = new Matrix(this.array.length + 1, this.array.length);

        for (int i = 0; i < array.length; i++) {
            List list = this.array[i];
            matrix.insertOnMatrix(i + 1, list);
        }

        return matrix;
    }

    public void findArticulationPoints() {
        boolean[] visited = new boolean[array.length];
        int[] disc = new int[array.length];
        int[] low = new int[array.length];
        int[] parent = new int[array.length];
        boolean[] articulationPoints = new boolean[array.length];

        Arrays.fill(parent, -1);

        for (int i = 0; i < array.length; i++) {
            if (!visited[i]) {
                dfs(i, visited, disc, low, parent, articulationPoints);
            }
        }

        System.out.println("Pontos de Articulação:");
        for (int i = 0; i < articulationPoints.length; i++) {
            if (articulationPoints[i]) {
                System.out.println(i);
            }
        }
    }

    private void dfs(int u, boolean[] visited, int[] disc, int[] low, int[] parent, boolean[] articulationPoints) {
        int children = 0;
        visited[u] = true;

        disc[u] = low[u] = ++time;

        Node node = array[u].node;
        while (node != null) {
            int v = node.getInfo();

            if (!visited[v]) {
                children++;
                parent[v] = u;

                dfs(v, visited, disc, low, parent, articulationPoints);

                low[u] = Math.min(low[u], low[v]);

                if (parent[u] == -1 && children > 1) {
                    articulationPoints[u] = true;
                }

                if (parent[u] != -1 && low[v] >= disc[u]) {
                    articulationPoints[u] = true;
                }
            } else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }

            node = node.getNext();
        }
    }
}
